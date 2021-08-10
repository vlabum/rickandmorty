package ru.vlabum.simle.rickmorty.viewmodels.reducer

import ru.vlabum.simle.rickmorty.repo.data.entity.CharactersResp
import ru.vlabum.simle.rickmorty.repo.data.result.Result
import ru.vlabum.simle.rickmorty.viewmodels.character.CharacterState

fun Result<CharactersResp>.reduce(isSearchMode: Boolean = false): CharacterState {
    return when(this) {
        is Result.Success -> if (isSearchMode) CharacterState.ResultSearch(data) else CharacterState.ResultAllCharacters(data)
        is Result.Error -> CharacterState.Error(message)
        is Result.Loading -> CharacterState.Loading
    }
}