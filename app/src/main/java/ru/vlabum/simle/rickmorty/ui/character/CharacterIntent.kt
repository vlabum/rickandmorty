package ru.vlabum.simle.rickmorty.ui.character

import ru.vlabum.simle.rickmorty.ui.ViewIntent

sealed class CharacterIntent : ViewIntent {
    object LoadAllCharacters : CharacterIntent()
    data class SearchCharacters(val name: String) : CharacterIntent()
    object ClearSearch : CharacterIntent()
}
