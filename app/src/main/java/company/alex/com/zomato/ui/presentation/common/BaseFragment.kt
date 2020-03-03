package company.alex.com.zomato.ui.presentation.common

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import company.alex.com.zomato.R
import company.alex.com.zomato.di.viewModelProvider.ViewModelFactory
import company.alex.com.zomato.ui.presentation.common.navigation.NavigationCommand
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel, VB : ViewDataBinding> : Fragment() {
    private lateinit var viewDataBinding: VB

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: VM


    abstract var layoutId: Int
    abstract var bindingVariable: Int
    abstract var viewModelClass: Class<VM>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = activity?.run { ViewModelProvider(this, viewModelFactory)[viewModelClass] }!!

        viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        viewDataBinding.setVariable(bindingVariable, viewModel)

        viewDataBinding.lifecycleOwner = this

        lifecycle.addObserver(viewModel)

        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initNavigation()
    }

    private fun initNavigation() {
        viewModel.navigationCommand.observe(this) { command ->
            run {
                when (command) {
                    is NavigationCommand.Back -> findNavController().popBackStack()
                    is NavigationCommand.ToRoot -> findNavController().navigate(R.id.nav_host_fragment)
                    is NavigationCommand.To -> findNavController().navigate(command.direction)
                    is NavigationCommand.BackTo -> findNavController().popBackStack(command.destinationId, false)
                    is NavigationCommand.ToWithData -> {
                        var bundle = Bundle()
                        bundle.putParcelable("nav", command.data as Parcelable)
                        findNavController().navigate(command.direction, bundle)
                    }
                }
            }
        }
    }
}