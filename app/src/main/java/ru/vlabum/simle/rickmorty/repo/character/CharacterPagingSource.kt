package ru.vlabum.simle.rickmorty.repo.character

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.vlabum.simle.rickmorty.repo.api.RMService
import ru.vlabum.simle.rickmorty.ui.baserv.ViewTyped
import ru.vlabum.simle.rickmorty.ui.mapper.CharacterToUiMapper2

class CharacterPagingSource : RxPagingSource<Int, ViewTyped>() {

    override fun getRefreshKey(state: PagingState<Int, ViewTyped>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPosition = state.closestPageToPosition(anchorPosition)
            anchorPosition?.prevKey?.plus(1) ?: anchorPosition?.nextKey?.minus(1)
        }
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, ViewTyped>> {
        val characterToUI = CharacterToUiMapper2()
        return RMService.rmService
            .getAllCharacters(params.key ?: 1)
            .subscribeOn(Schedulers.io())
            .map<LoadResult<Int, ViewTyped>> { result ->
                LoadResult.Page(
                    data = characterToUI(result.results),
                    prevKey = result.info.prev?.let { it.split("=")[1].toInt() },
                    nextKey = result.info.next?.let { it.split("=")[1].toInt() }
                )
            }
            .onErrorReturn { e ->
                LoadResult.Error(e)
            }
    }
}