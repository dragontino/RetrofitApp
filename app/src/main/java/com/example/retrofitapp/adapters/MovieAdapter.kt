package com.example.retrofitapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.R
import com.example.retrofitapp.changeVisibility
import com.example.retrofitapp.databinding.ItemLayoutBinding
import com.example.retrofitapp.model.Movie
import com.example.retrofitapp.showToast
import com.squareup.picasso.Picasso

class MovieAdapter(
    private val context: Context,
    private val movieList: MutableList<Movie>,
) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val itemBinding = ItemLayoutBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return MovieHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val listItem = movieList[position]
        holder.bind(listItem, context)
    }

    override fun getItemCount() = movieList.size



    class MovieHolder(private val itemBinding: ItemLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        init {
            itemView.setOnClickListener {
                itemBinding.bio.changeVisibility()
            }
        }

        fun bind(movie: Movie, context: Context) = itemBinding.run {
            Picasso.get()
                .load(movie.imageUrl)
                .into(imageMovie)

            name.text = movie.name
            realName.text = context.getString(R.string.real_name_text, movie.realName)
            team.text = movie.team
            firstAppearance.text = movie.firstAppearance
            createdBy.text = movie.createdBy
            publisher.text = movie.publisher
            bio.text = movie.bio

            imageMovie.setOnClickListener {
                showToast(it.context, "This is ${name.text}!")
            }
        }
    }
}