package dicoding.zulfikar.eigerapp.ui.screen.detail

import dicoding.zulfikar.eigerapp.data.EigerProductRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dicoding.zulfikar.eigerapp.model.EigerProduct
import dicoding.zulfikar.eigerapp.model.OrderEigerProduct
import dicoding.zulfikar.eigerapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class DetailViewModel(
    private val repository: EigerProductRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<OrderEigerProduct>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<OrderEigerProduct>>
        get() = _uiState

    fun getEigerProductById(eigerProductId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getOrderEigerProductById(eigerProductId))
        }
    }

    fun addToCart(eigerProduct: EigerProduct, count: Int) {
        viewModelScope.launch {
            repository.updateOrderEigerProduct(eigerProduct.id, count)
        }
    }

}