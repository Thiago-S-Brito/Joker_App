package co.tiagoaguiar.tutorial.jokerappdev.presentation

import co.tiagoaguiar.tutorial.jokerappdev.data.JokeCallback
import co.tiagoaguiar.tutorial.jokerappdev.data.JokeRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.modeel.Joke
import co.tiagoaguiar.tutorial.jokerappdev.view.JokeFragment
import okhttp3.internal.notify

class JokePresenter(
        private val view: JokeFragment,
        private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()

) : JokeCallback {

    fun findBy(categoryName: String) {
        view.showProgress()
        dataSource.findBy(categoryName, this)
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