package ru.vlabum.simle.rickmorty.ui.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ru.vlabum.simle.rickmorty.R
import ru.vlabum.simle.rickmorty.repo.data.entity.CharacterRM
import ru.vlabum.simle.rickmorty.viewmodels.character.CharacterState
import ru.vlabum.simle.rickmorty.viewmodels.character.CharacterViewModel

class LocationsFragment : Fragment() {

    private val model: CharacterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? = inflater.inflate(R.layout.fragment_locations, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun render(state: CharacterState) {
    }

    private fun processListCharacters(characters: List<CharacterRM>) {
    }
}