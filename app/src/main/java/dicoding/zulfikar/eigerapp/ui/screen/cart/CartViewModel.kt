package dicoding.zulfikar.eigerapp.ui.screen.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dicoding.zulfikar.eigerapp.data.EigerProductRepository
import dicoding.zulfikar.eigerapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class CartViewModel(
    private val repository: EigerProductRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<CartState>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<CartState>>
        get() = _uiState

    fun getAddedOrderRewards() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.getAddedOrderEigerProduct()
                .collect { orderEigerProduct ->
                    val totalRequiredPrice =
                        orderEigerProduct.sumOf { it.eigerProduct.requiredPrice * it.count }
                    _uiState.value = UiState.Success(CartState(orderEigerProduct, totalRequiredPrice))
                }
        }
    }

    fun updateOrderReward(eigerProductId: Long, count: Int) {
        viewModelScope.launch {
            repository.updateOrderEigerProduct(eigerProductId, count)
                .collect { isUpdated ->
                    if (isUpdated) {
                        getAddedOrderRewards()
                    }
                }
        }
    }
}