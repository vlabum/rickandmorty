package ru.vlabum.simle.rickmorty.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.vlabum.simle.rickmorty.ui.ViewIntent

abstract class BaseViewModel<INTENT : ViewIntent, ACTION : ViewAction, STATE : ViewState>
    : ViewModel(), IModel<STATE, INTENT> {

    protected val mState = MutableLiveData<STATE>()
    override val state: LiveData<STATE>
        get() {
            return mState
        }

    override fun dispatchIntent(intent: INTENT) {
        handleAction(intentToAction(intent))
    }

    abstract fun intentToAction(intent: INTENT): ACTION
    abstract fun handleAction(action: ACTION)
}