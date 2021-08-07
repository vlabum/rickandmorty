package ru.vlabum.simle.rickmorty.ui.baserv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class HolderFactory : (ViewGroup, Int) -> BaseViewHolder<ViewTyped> {

    override fun invoke(viewGroup: ViewGroup, viewType: Int): BaseViewHolder<ViewTyped> {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(viewType, viewGroup, false)
        return checkNotNull(createViewHolder(view, viewType)) {
            "unknown viewType" + viewGroup.resources.getResourceName(viewType)
        } as BaseViewHolder<ViewTyped>
    }

    abstract fun createViewHolder(view: View, viewType: Int): BaseViewHolder<*>?
}