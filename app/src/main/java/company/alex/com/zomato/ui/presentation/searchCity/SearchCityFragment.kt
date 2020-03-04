package company.alex.com.zomato.ui.presentation.searchCity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import company.alex.com.zomato.BR
import company.alex.com.zomato.R
import company.alex.com.zomato.databinding.FragmentSearchCityBinding
import company.alex.com.zomato.models.restaurant.CategoryDto
import company.alex.com.zomato.di.components.DaggerAppComponents
import company.alex.com.zomato.ui.presentation.common.BaseFragment

class SearchCityFragment : BaseFragment<SearchCityViewModel, FragmentSearchCityBinding>() {

    override var layoutId = R.layout.fragment_search_city
    override var bindingVariable = BR.viewModel
    override var viewModelClass = SearchCityViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DaggerAppComponents.create().inject(this)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.restaurantCaregory = (arguments!!["nav"] as CategoryDto).categories.name
    }
}
