package ru.vlabum.simle.rickmorty.ui.character

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import ru.vlabum.simle.rickmorty.ui.baserv.BaseAdapter
import ru.vlabum.simle.rickmorty.ui.baserv.BaseAdapterPager
import ru.vlabum.simle.rickmorty.ui.baserv.HolderFactory
import ru.vlabum.simle.rickmorty.ui.baserv.ViewTyped

class CharacterAdapterPager<VT : ViewTyped>(holderFactory: HolderFactory)
    : BaseAdapterPager<VT>(holderFactory, DiffCallbackPager()) {

}

class DiffCallbackPager<VT : ViewTyped> : DiffUtil.ItemCallback<VT>() {
    override fun areItemsTheSame(oldItem: VT, newItem: VT): Boolean {
        return oldItem.uid == newItem.uid
    }

    override fun areContentsTheSame(oldItem: VT, newItem: VT): Boolean {
        return oldItem == newItem
    }
}