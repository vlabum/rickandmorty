package ru.vlabum.simle.rickmorty.ui.character

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import ru.vlabum.simle.rickmorty.R
import ru.vlabum.simle.rickmorty.data.entity.CharacterRM
import ru.vlabum.simle.rickmorty.ui.baserv.BaseViewHolder
import ru.vlabum.simle.rickmorty.ui.baserv.ViewTyped

data class CharacterUi(
    val character: CharacterRM,
    override val viewType: Int,
    override val uid: Int = character.id
) : ViewTyped

class CharacterViewHolder(view: View) : BaseViewHolder<CharacterUi>(view) {

    private var id: Int? = null
    private val vAvatar = view.findViewById<ImageView>(R.id.iv_character_avatar)
    private val vName = view.findViewById<TextView>(R.id.tv_character_name)

    override fun bind(item: CharacterUi) {
        id = item.character.id

        Glide.with(itemView)
            .load(item.character.image)
            .into(vAvatar)

        vName.text = item.character.name
    }
}