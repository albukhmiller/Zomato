package company.alex.com.zomato.ui.presentation.mainScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import company.alex.com.zomato.BR
import company.alex.com.zomato.R
import company.alex.com.zomato.databinding.FragmentMainBinding
import company.alex.com.zomato.di.components.DaggerAppComponents
import company.alex.com.zomato.ui.presentation.common.BaseFragment
import company.alex.com.zomato.ui.presentation.mainScreen.adapters.RestaurantTypeAdapter
import company.alex.com.zomato.ui.utils.Utils
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment<MainViewModel, FragmentMainBinding>() {
    override var viewModelClass = MainViewModel::class.java
    override var layoutId = R.layout.fragment_main
    override var bindingVariable = BR.viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DaggerAppComponents.create().inject(this)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var adapter = RestaurantTypeAdapter {
            Toast.makeText(activity, it.categories.toString(), Toast.LENGTH_LONG).show()
        }
        Utils.setupRecyclerView(rvRestaurantType, adapter)
    }
}
