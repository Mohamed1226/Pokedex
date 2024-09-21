package com.example.pokedex.DI

import com.example.pokedex.core.Constants.BASE_URL
import com.example.pokedex.data.remote.PokemonApi
import com.example.pokedex.data.repository.pokemon.PokemonRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun providePokemonRepo(pokemonApi: PokemonApi) = PokemonRepo(pokemonApi)

    @Singleton
    @Provides
    fun providePokemonApi(): PokemonApi {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL)
            .build().create(PokemonApi::class.java)
    }

}