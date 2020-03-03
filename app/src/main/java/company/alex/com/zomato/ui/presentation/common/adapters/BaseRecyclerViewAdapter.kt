package company.alex.com.zomato.ui.presentation.common.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T : RecyclerView.ViewHolder, D : List<*>?> : RecyclerView.Adapter<T>(),
    BindableListAdapter<D> {

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T

    abstract override fun getItemCount(): Int

    abstract override fun onBindViewHolder(holder: T, position: Int)
}