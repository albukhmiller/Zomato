package company.alex.com.zomato.ui.presentation.laptop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import company.alex.com.zomato.BR
import company.alex.com.zomato.R
import company.alex.com.zomato.databinding.FragmentLaptop2Binding
import company.alex.com.zomato.di.components.DaggerAppComponents
import company.alex.com.zomato.ui.presentation.common.BaseFragment

class Laptop2Fragment : BaseFragment<SharedViewModel, FragmentLaptop2Binding>() {

    override var layoutId = R.layout.fragment_laptop2
    override var bindingVariable = BR.viewModel
    override var viewModelClass = SharedViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DaggerAppComponents.create().inject(this)

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
