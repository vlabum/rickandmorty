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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.vlabum.simle.rickmorty.R
import ru.vlabum.simle.rickmorty.data.entity.CharacterRM
import ru.vlabum.simle.rickmorty.ui.RMHolderFactory
import ru.vlabum.simle.rickmorty.ui.baserv.ViewTyped
import ru.vlabum.simle.rickmorty.ui.mapper.CharacterToUiMapper
import ru.vlabum.simle.rickmorty.viewmodels.character.CharacterState
import ru.vlabum.simle.rickmorty.viewmodels.character.CharacterViewModel

class CharactersFragment : Fragment() {

    private val model: CharacterViewModel by activityViewModels()
    private val compositeDisposable = CompositeDisposable()

    private val holderFactory: RMHolderFactory = RMHolderFactory()
    private val adapter: CharacterAdapter<ViewTyped> = CharacterAdapter(holderFactory)

    private var navigationView: BottomNavigationView? = null

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

        val rvCharacters = view.findViewById<RecyclerView>(R.id.rv_characters)
        rvCharacters.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
        rvCharacters.adapter = adapter

        navigationView = activity?.findViewById<BottomNavigationView>(R.id.navigation_view)
    }

    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()
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
        toRV(characters)
        characters.forEach {
            Log.d("TAG fragment", it.name)
        }
    }

    private fun toRV(characters: List<CharacterRM>) {
        val characterToUI = CharacterToUiMapper()
        val dispose = characterToUI(characters)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { uiList -> adapter.items = uiList },
                { throwable -> showMessage(throwable.message ?: "error without message")}
            )
        compositeDisposable.add(dispose)
    }

    private fun showMessage(message: String) {
        (navigationView as? View)?.let {
            Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show()
        }
    }
}