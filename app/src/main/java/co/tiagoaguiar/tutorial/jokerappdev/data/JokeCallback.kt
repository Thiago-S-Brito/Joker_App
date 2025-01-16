package co.tiagoaguiar.tutorial.jokerappdev.data

import co.tiagoaguiar.tutorial.jokerappdev.modeel.Joke

interface JokeCallback {

    fun onSuccess(response: Joke)

    fun onError(response: String)

    fun onComplete()
}