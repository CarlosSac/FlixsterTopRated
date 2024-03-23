package com.example.flixster

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(private val movies : List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        val title: TextView
        val rating: TextView
        val poster: ImageView


        init {

            title = itemView.findViewById(R.id.titleTv)
            rating = itemView.findViewById(R.id.rateTv)
            poster = itemView.findViewById(R.id.posterIv)
            itemView.setOnClickListener(this)


        }

        override fun onClick(v: View?) {
            val movies = movies[adapterPosition]
            val context = itemView.context
            val intent = Intent(context, DetailActivity::class.java)

            intent.putExtra("description", movies.description)
            intent.putExtra("img", movies.backdrop)
            intent.putExtra("title", movies.title)
            intent.putExtra("date", movies.date)
            intent.putExtra("vote", movies.rating)

            context.startActivity(intent)
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.movies_item, parent, false)
        return ViewHolder(contactView)

    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        val url = "https://image.tmdb.org/t/p/w500/"
        var fullUrl = url + movie.posterLink

        holder.title.text = movie.title

        holder.rating.text = movie.rating



        Glide.with(holder.itemView)
            .load(fullUrl)
            .centerInside()
            .into(holder.poster)

    }

}