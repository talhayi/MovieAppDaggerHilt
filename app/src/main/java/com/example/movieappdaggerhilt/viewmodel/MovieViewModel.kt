package com.example.movieappdaggerhilt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappdaggerhilt.models.Movies
import com.example.movieappdaggerhilt.models.MoviesItem
import com.example.movieappdaggerhilt.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: MovieRepository
):ViewModel() {

    private val _response = MutableLiveData<List<MoviesItem>>()
    val responseMovie: LiveData<List<MoviesItem>>
    get() = _response

    init {
        getAllMovies()
    }

    private fun getAllMovies()= viewModelScope.launch {
        repository.getMovie().let {response ->
            if(response.isSuccessful)
                _response.value
            else{

            }
        }
    }
}

