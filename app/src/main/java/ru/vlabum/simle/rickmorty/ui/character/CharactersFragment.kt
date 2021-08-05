package ru.vlabum.simle.rickmorty.ui.character

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

class CharactersFragment : Fragment() {

    private val model: CharacterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? = inflater.inflate(R.layout.fragment_characters, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button).setOnClickListener { _ ->
            model.dispatchIntent(CharacterIntent.LoadAllCharacters)
        }

        model.state.observe(viewLifecycleOwner, { characterState ->
            render(characterState)
        })
    }

    private fun render(state: CharacterState) {
        when(state) {
            is CharacterState.ResultAllCharacters -> processListCharacters(state.data.results)
            is CharacterState.ResultSearch -> processListCharacters(state.data.results)
            is CharacterState.Error -> Log.d("TAG fragment ERR", state.message)
            is CharacterState.Loading -> Log.d("TAG fragment", "LOADING")
        }
    }

    private fun processListCharacters(characters: List<CharacterRM>) {
        characters.forEach {
            Log.d("TAG fragment", it.name)
        }
    }
}