package ru.vlabum.simle.rickmorty.ui.baserv

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<VT : ViewTyped>(internal val holderFactory: HolderFactory)
    : RecyclerView.Adapter<BaseViewHolder<ViewTyped>>() {

        abstract var items: List<VT>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ViewTyped> {
        return holderFactory(parent, viewType)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ViewTyped>, position: Int) {
        holder.bind(items[position])
    }
}