package company.alex.com.zomato.ui.presentation.mainScreen.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import company.alex.com.zomato.R
import company.alex.com.zomato.datasources.models.restaurant.Category
import company.alex.com.zomato.databinding.ItemRestaurantTypeBinding
import company.alex.com.zomato.ui.presentation.common.adapters.BaseRecyclerViewAdapter

class RestaurantTypeAdapter(private val onClickListener: (Category) -> Unit) :
    BaseRecyclerViewAdapter<RestaurantTypeAdapter.RestaurantTypeHolder, List<Category>?>() {

    private var data: List<Category>? = null

    override fun setData(data: List<Category>?) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantTypeHolder {
        var inflater = LayoutInflater.from(parent.context)
        var binding =
            DataBindingUtil.inflate<ItemRestaurantTypeBinding>(inflater, R.layout.item_restaurant_type, parent, false)
        return RestaurantTypeHolder(binding)
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: RestaurantTypeHolder, position: Int) =
        holder.bind(data!![position], onClickListener)

    inner class RestaurantTypeHolder(
        private val binding: ItemRestaurantTypeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Category, listener: (Category) -> Unit) {
            binding.data = item.categories
            itemView.setOnClickListener { listener(item) }
        }
    }
}