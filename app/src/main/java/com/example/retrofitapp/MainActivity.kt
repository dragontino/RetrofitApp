package com.example.retrofitapp

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitapp.adapters.MovieAdapter
import com.example.retrofitapp.databinding.ActivityMainBinding
import com.example.retrofitapp.model.Movie
import com.example.retrofitapp.retrofit.Common
import com.example.retrofitapp.retrofit.RetrofitServices
import dmax.dialog.SpotsDialog
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var service: RetrofitServices
    private var adapter: MovieAdapter? = null
    private lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Superheroes"

        service = Common.retrofitService
        binding.recyclerMovieList.setHasFixedSize(true)
        dialog = SpotsDialog.Builder()
            .setCancelable(true)
            .setContext(this)
            .build()

        getAllMovieList()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getAllMovieList() {
        MainScope().launch {
            dialog.show()
            val movieList: MutableList<Movie>

            withContext(Dispatchers.Default) {
                movieList = service.getMovieList()
            }

            if (adapter == null) {
                adapter = MovieAdapter(this@MainActivity, movieList)
                binding.recyclerMovieList.adapter = adapter
            } else
                adapter?.notifyDataSetChanged()

            dialog.dismiss()
        }
    }
}