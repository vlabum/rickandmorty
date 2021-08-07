package ru.vlabum.simle.rickmorty.ui

import android.view.View
import ru.vlabum.simle.rickmorty.R
import ru.vlabum.simle.rickmorty.ui.baserv.BaseViewHolder
import ru.vlabum.simle.rickmorty.ui.baserv.HolderFactory
import ru.vlabum.simle.rickmorty.ui.character.CharacterViewHolder

class RMHolderFactory : HolderFactory() {
    override fun createViewHolder(view: View, viewType: Int): BaseViewHolder<*>? {
        return when (viewType) {
            R.layout.item_character -> CharacterViewHolder(view)
            else -> null
        }
    }
}