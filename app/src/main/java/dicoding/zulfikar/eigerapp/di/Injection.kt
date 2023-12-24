package dicoding.zulfikar.eigerapp.di

import dicoding.zulfikar.eigerapp.data.EigerProductRepository

object Injection {
    fun provideRepository(): EigerProductRepository {
        return EigerProductRepository.getInstance()
    }
}