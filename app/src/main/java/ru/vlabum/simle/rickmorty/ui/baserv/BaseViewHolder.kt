package ru.vlabum.simle.rickmorty.ui.baserv

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<VT : ViewTyped>(containerView: View) :
    RecyclerView.ViewHolder(containerView) {

    open fun bind(item: VT) = Unit
}