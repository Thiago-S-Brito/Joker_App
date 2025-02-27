package co.tiagoaguiar.tutorial.jokerappdev.presentation

import co.tiagoaguiar.tutorial.jokerappdev.data.JokeCallback
import co.tiagoaguiar.tutorial.jokerappdev.data.JokeDayRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.data.JokeRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.modeel.Joke
import co.tiagoaguiar.tutorial.jokerappdev.view.JokeDayFragment
import co.tiagoaguiar.tutorial.jokerappdev.view.JokeFragment
import okhttp3.internal.notify

class JokeDayPresenter(
    private val view: JokeDayFragment,
    private val dataSource: JokeDayRemoteDataSource = JokeDayRemoteDataSource()

) : JokeCallback {

    fun findRandom() {
        view.showProgress()
        dataSource.findRandom(this)
    }
        override fun onSuccess(response: Joke) {
            view.showJoke(response)
        }

        override fun onError(response: String) {
            view.showFailure(response)
        }

        override fun onComplete() {
            view.hideProgress()
        }


    }