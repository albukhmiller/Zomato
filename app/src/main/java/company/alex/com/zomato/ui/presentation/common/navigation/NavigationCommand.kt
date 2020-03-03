package company.alex.com.zomato.ui.presentation.common.navigation

sealed class NavigationCommand {
    data class To(val direction: Int) : NavigationCommand()
    data class BackTo(val destinationId: Int) : NavigationCommand()
    data class ToWithData(val direction: Int, val data: Any) : NavigationCommand()

    object Back : NavigationCommand()
    object ToRoot : NavigationCommand()
}