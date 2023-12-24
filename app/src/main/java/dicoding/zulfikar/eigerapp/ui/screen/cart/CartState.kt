package dicoding.zulfikar.eigerapp.ui.screen.cart

import dicoding.zulfikar.eigerapp.model.OrderEigerProduct

data class CartState(
    val orderEigerProduct: List<OrderEigerProduct>,
    val totalRequiredPrice: Int
)