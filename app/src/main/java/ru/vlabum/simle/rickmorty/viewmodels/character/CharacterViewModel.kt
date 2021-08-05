package ru.vlabum.simle.rickmorty.viewmodels.character

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.vlabum.simle.rickmorty.data.api.RMService
import ru.vlabum.simle.rickmorty.ui.character.CharacterIntent
import ru.vlabum.simle.rickmorty.data.result.Result
import ru.vlabum.simle.rickmorty.viewmodels.BaseViewModel
import ru.vlabum.simle.rickmorty.viewmodels.reducer.reduce

class CharacterViewModel() :
    BaseViewModel<CharacterIntent, CharacterAction, CharacterState>() {

    override fun intentToAction(intent: CharacterIntent): CharacterAction {
        return when (intent) {
            is CharacterIntent.LoadAllCharacters -> CharacterAction.AllCharacters
            is CharacterIntent.ClearSearch -> CharacterAction.AllCharacters
            is CharacterIntent.SearchCharacters -> CharacterAction.SearchCharacters(intent.name)
        }
    }

    override fun handleAction(action: CharacterAction) {
        RMService.rmService.getAllCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { resp -> mState.postValue(Result.Success(resp).reduce()) },
                { thrw -> Log.d("TAG err", thrw.message.toString()) }
            )
    }
}