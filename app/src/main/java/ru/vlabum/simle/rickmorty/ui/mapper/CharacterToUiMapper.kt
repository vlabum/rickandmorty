package ru.vlabum.simle.rickmorty.ui.mapper

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.vlabum.simle.rickmorty.R
import ru.vlabum.simle.rickmorty.data.entity.CharacterRM
import ru.vlabum.simle.rickmorty.ui.baserv.ViewTyped
import ru.vlabum.simle.rickmorty.ui.character.CharacterUi

class CharacterToUiMapper : (List<CharacterRM>) -> Single<List<ViewTyped>> {

    override fun invoke(characters: List<CharacterRM>): Single<List<ViewTyped>> {
        return Observable.fromArray(characters)
            .concatMapIterable { it }
            .map {
                CharacterUi(it, R.layout.item_character) as ViewTyped
            }.toList()
    }
}

class CharacterToUiMapper2 : (List<CharacterRM>) -> List<ViewTyped> {

    override fun invoke(characters: List<CharacterRM>): List<ViewTyped> {
        return characters
            .map {
                CharacterUi(it, R.layout.item_character) as ViewTyped
            }.toList()
    }
}