package com.example.movieappdaggerhilt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load

import com.example.movieappdaggerhilt.databinding.MovieRowBinding
import com.example.movieappdaggerhilt.models.MoviesItem

class MovieAdapter :RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){


    class MovieViewHolder(val binding : MovieRowBinding):RecyclerView.ViewHolder(binding.root) {

    }

    private val diffCallBack = object :DiffUtil.ItemCallback<MoviesItem>(){
        override fun areItemsTheSame(oldItem: MoviesItem, newItem: MoviesItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MoviesItem, newItem: MoviesItem): Boolean {
            return  newItem == oldItem
        }

    }
    private val differ = AsyncListDiffer(this,diffCallBack)
    var movies:List<MoviesItem>
    get() = differ.currentList
    set(value){
        differ.submitList(value)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(MovieRowBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = movies[position]
        holder.binding.apply {
            textView.text=currentMovie.name
            imageView.load(currentMovie.image.original){
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun getItemCount(): Int {
       return movies.size
    }
}
