package dicoding.zulfikar.eigerapp.data

import dicoding.zulfikar.eigerapp.model.FakeEigerProductDataSource
import dicoding.zulfikar.eigerapp.model.OrderEigerProduct
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class EigerProductRepository {
    private val orderEigerProduct = mutableListOf<OrderEigerProduct>()

    init {
        if (orderEigerProduct.isEmpty()) {
            FakeEigerProductDataSource.dummyEigerProduct.forEach {
                orderEigerProduct.add(OrderEigerProduct(it, 0))
            }
        }
    }

    fun getAllEigerProduct(): Flow<List<OrderEigerProduct>> {
        return flowOf(orderEigerProduct)
    }

    fun getOrderEigerProductById(eigerProductId: Long): OrderEigerProduct {
        return orderEigerProduct.first {
            it.eigerProduct.id == eigerProductId
        }
    }

    fun updateOrderEigerProduct(eigerProductId: Long, newCountValue: Int): Flow<Boolean> {
        val index = orderEigerProduct.indexOfFirst { it.eigerProduct.id == eigerProductId }
        val result = if (index >= 0) {
            val orderEigerProduct_ = orderEigerProduct[index]
            orderEigerProduct[index] =
                orderEigerProduct_.copy(eigerProduct = orderEigerProduct_.eigerProduct, count = newCountValue)
            true
        } else {
            false
        }
        return flowOf(result)
    }

    fun getAddedOrderEigerProduct(): Flow<List<OrderEigerProduct>> {
        return getAllEigerProduct()
            .map { orderEigerProduct ->
                orderEigerProduct.filter { orderEigerProduct ->
                    orderEigerProduct.count != 0
                }
            }
    }

    companion object {
        @Volatile
        private var instance: EigerProductRepository? = null

        fun getInstance(): EigerProductRepository =
            instance ?: synchronized(this) {
                EigerProductRepository().apply {
                    instance = this
                }
            }
    }
}