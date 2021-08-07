package ru.vlabum.simle.rickmorty.ui.character

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import ru.vlabum.simle.rickmorty.ui.baserv.BaseAdapter
import ru.vlabum.simle.rickmorty.ui.baserv.HolderFactory
import ru.vlabum.simle.rickmorty.ui.baserv.ViewTyped

class CharacterAdapter<VT : ViewTyped>(holderFactory: HolderFactory) : BaseAdapter<VT>(holderFactory) {

    override var items: List<VT>
        get() = localItems.currentList
        set(value) {
            localItems.submitList(value)
        }

    private val localItems = AsyncListDiffer(this, DiffCallback<VT>())
}

class DiffCallback<VT : ViewTyped> : DiffUtil.ItemCallback<VT>() {
    override fun areItemsTheSame(oldItem: VT, newItem: VT): Boolean {
        return oldItem.uid == newItem.uid
    }

    override fun areContentsTheSame(oldItem: VT, newItem: VT): Boolean {
//        if (oldItem is CharacterUi) {
//            return (oldItem as CharacterUi) == (newItem as CharacterUi)
//        }
        return oldItem == newItem
    }
}