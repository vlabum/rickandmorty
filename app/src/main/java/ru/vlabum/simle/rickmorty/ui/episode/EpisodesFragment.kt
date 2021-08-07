package ru.vlabum.simle.rickmorty.ui.location

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import ru.vlabum.simle.rickmorty.R
import ru.vlabum.simle.rickmorty.data.entity.CharacterRM
import ru.vlabum.simle.rickmorty.viewmodels.character.CharacterState
import ru.vlabum.simle.rickmorty.viewmodels.character.CharacterViewModel

class EpisodesFragment : Fragment() {

    private val model: CharacterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? = inflater.inflate(R.layout.fragment_episodes, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun render(state: CharacterState) {
    }

    private fun processListCharacters(characters: List<CharacterRM>) {
    }
}