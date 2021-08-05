package ru.vlabum.simle.rickmorty.viewmodels.character

import ru.vlabum.simle.rickmorty.data.entity.CharacterRM
import ru.vlabum.simle.rickmorty.data.entity.CharactersResp
import ru.vlabum.simle.rickmorty.viewmodels.ViewState

sealed class CharacterState : ViewState {
    object Loading : CharacterState()
    data class ResultAllCharacters(val data: CharactersResp) : CharacterState()
    data class ResultSearch(val data: CharactersResp) : CharacterState()
    data class Error(val message: String) : CharacterState()
}
