package company.alex.com.zomato.ui.utils

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Utils {

    companion object {
        fun setupRecyclerView(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.addItemDecoration(
                DividerItemDecoration(
                    recyclerView.context,
                    LinearLayoutManager(recyclerView.context).orientation
                )
            )
            recyclerView.adapter = adapter
        }
    }
}