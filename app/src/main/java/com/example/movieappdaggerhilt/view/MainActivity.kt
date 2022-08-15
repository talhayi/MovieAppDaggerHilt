package com.example.movieappdaggerhilt.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieappdaggerhilt.adapter.MovieAdapter
import com.example.movieappdaggerhilt.databinding.ActivityMainBinding
import com.example.movieappdaggerhilt.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MovieViewModel by viewModels()
    private lateinit var movieAdapter : MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieAdapter = MovieAdapter()
        binding.recylerView.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)
        }

        viewModel.responseMovie.observe(this) { listMovie ->
            movieAdapter.movies = listMovie
        }


    }
}