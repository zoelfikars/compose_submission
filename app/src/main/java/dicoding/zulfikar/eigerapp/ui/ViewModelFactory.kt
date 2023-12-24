package dicoding.zulfikar.eigerapp.ui

import dicoding.zulfikar.eigerapp.data.EigerProductRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dicoding.zulfikar.eigerapp.ui.screen.cart.CartViewModel
import dicoding.zulfikar.eigerapp.ui.screen.detail.DetailViewModel
import dicoding.zulfikar.eigerapp.ui.screen.home.HomeViewModel


class ViewModelFactory(private val repository: EigerProductRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
            return CartViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}