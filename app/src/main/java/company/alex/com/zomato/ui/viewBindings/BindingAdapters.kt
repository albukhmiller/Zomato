package company.alex.com.zomato.ui.viewBindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import company.alex.com.zomato.ui.presentation.common.adapters.BindableListAdapter

class BindingAdapters {
    companion object {
        @JvmStatic
        @BindingAdapter("data")
        fun <T> bindRecyclerViewAdapter(rv: RecyclerView, data: T) {
            if (rv.adapter is BindableListAdapter<*>) {
                (rv.adapter as BindableListAdapter<T>).setData(data)
            }
        }
    }
}