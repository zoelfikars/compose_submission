package dicoding.zulfikar.eigerapp.ui.common

import java.text.NumberFormat
import java.util.Locale

fun formatCurrency(value: Int): String {
    val currencyFormat = NumberFormat.getNumberInstance(Locale("id", "ID"))
    return currencyFormat.format(value)
}
