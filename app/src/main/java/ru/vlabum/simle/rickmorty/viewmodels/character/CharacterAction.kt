package ru.vlabum.simle.rickmorty.viewmodels.character

import ru.vlabum.simle.rickmorty.viewmodels.ViewAction

sealed class CharacterAction : ViewAction {
    data class SearchCharacters(val name: String) : CharacterAction()
    object AllCharacters : CharacterAction()
}
