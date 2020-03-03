package company.alex.com.zomato.ui.presentation.common

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import company.alex.com.zomato.SingleLiveData
import company.alex.com.zomato.ui.presentation.common.navigation.NavigationCommand

abstract class BaseViewModel : ViewModel(), LifecycleObserver {

    val navigationCommand = SingleLiveData<NavigationCommand>()

    protected fun navigateTo(direction: Int) = navigationCommand.postValue(NavigationCommand.To(direction))
    protected fun navigateTo(direction: Int, data: Any) =
        navigationCommand.postValue(NavigationCommand.ToWithData(direction, data))

    protected fun navigateBackTo(destinationId: Int) =
        navigationCommand.postValue(NavigationCommand.BackTo(destinationId))

    protected fun navigateRoot() = navigationCommand.postValue(NavigationCommand.ToRoot)
    protected fun navigateBack() = navigationCommand.postValue(NavigationCommand.Back)

}