package dicoding.zulfikar.eigerapp.ui.screen.home

import dicoding.zulfikar.eigerapp.data.EigerProductRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dicoding.zulfikar.eigerapp.model.OrderEigerProduct
import dicoding.zulfikar.eigerapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch


class HomeViewModel(
    private val repository: EigerProductRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<OrderEigerProduct>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<OrderEigerProduct>>>
        get() = _uiState

    fun getAllEigerProduct() {
        viewModelScope.launch {
            repository.getAllEigerProduct()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderRewards ->
                    _uiState.value = UiState.Success(orderRewards)
                }
        }
    }

}