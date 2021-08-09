package ru.vlabum.simle.rickmorty.ui.baserv

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import ru.vlabum.simle.rickmorty.ui.character.DiffCallback

abstract class BaseAdapterPager<VT : ViewTyped>(
    internal val holderFactory: HolderFactory,
    diffCallback: DiffUtil.ItemCallback<VT>,
) :
    PagingDataAdapter<VT, BaseViewHolder<ViewTyped>>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ViewTyped> {
        return holderFactory(parent, viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position)?.viewType ?: 0
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ViewTyped>, position: Int) {
        val item = getItem(position) as ViewTyped
        holder.bind(item)
    }
}