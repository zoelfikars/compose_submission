package dicoding.zulfikar.eigerapp.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Cart : Screen("cart")
    object Profile : Screen("profile")
    object DetailEigerProduct : Screen("home/{eigerProductId}") {
        fun createRoute(eigerProductId: Long) = "home/$eigerProductId"
    }

}