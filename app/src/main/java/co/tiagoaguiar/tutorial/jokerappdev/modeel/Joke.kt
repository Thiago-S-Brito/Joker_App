package co.tiagoaguiar.tutorial.jokerappdev.modeel

import com.google.gson.annotations.SerializedName

data class Joke(
        @SerializedName("value") val  text: String,
        @SerializedName("icon_url") val iconUrl: String
    )