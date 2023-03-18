package com.hacybeyker.pokeinfo.di

object Constants {
    object Named {
        const val BASE_URL = "base_url"
        const val API_KEY = "api_key"
    }

    object Parameters {
        const val TIMEOUT = 60L
        const val CONTENT_LENGTH = 250_000L
        const val AUTH_TOKEN = "Auth-Token"
        const val BEARER = "Bearer"
    }

    object Http {
        const val RESPONSE_OK = 200
    }

    object Api {
        const val LIMIT = 20
        const val DEFAULT = 0
    }
}
