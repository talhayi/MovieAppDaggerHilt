package com.example.movieappdaggerhilt.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.*
import com.example.movieappdaggerhilt.models.MoviesItem
import com.example.movieappdaggerhilt.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    application: Application,
    private val repository: MovieRepository
):AndroidViewModel(application) {

    private val _response = MutableLiveData<List<MoviesItem>>()
    val responseMovie: LiveData<List<MoviesItem>>
    get() = _response

    init {
        getAllMovies()
    }

    private fun getAllMovies()= CoroutineScope(Dispatchers.IO).launch {
        repository.getMovie().let {response ->
            if(response.isSuccessful)
                _response.postValue(response.body())
            else{
                Toast.makeText(getApplication(),"Error: ${response.code()}",Toast.LENGTH_LONG).show()
            }
        }
    }
}

