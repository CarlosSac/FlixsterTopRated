package com.example.flixster

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide




class DetailActivity : AppCompatActivity() {
    private lateinit var posterIv: ImageView
    private lateinit var titleTv: TextView
    private lateinit var dateTv: TextView
    private lateinit var ratingTv: TextView
    private lateinit var overviewTv: TextView
    private var poster = ""
    private var title = ""
    var date = ""
    var rating = ""
    var overview = ""
    var posterUrl = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent = intent
        poster = intent.getStringExtra("img").toString()
        title = intent.getStringExtra("title").toString()
        date = intent.getStringExtra("date").toString()
        rating = intent.getStringExtra("vote").toString()
        overview = intent.getStringExtra("description").toString()
        val url = "https://image.tmdb.org/t/p/w500/"
        posterUrl = url + poster


        startDetailsAct()


    }

    private fun startDetailsAct() {
        posterIv = findViewById(R.id.backdropIv)
        titleTv = findViewById(R.id.detailedTitleTv)
        dateTv = findViewById(R.id.dateTv)
        ratingTv = findViewById(R.id.detailedRateTv)
        overviewTv = findViewById(R.id.overviewTv)


        titleTv.text = title

        dateTv.text = "Released: " + date
        ratingTv.text = "Rating: " + rating
        overviewTv.text = "About\n\n" +overview



        Glide.with(posterIv.context)
            .load(posterUrl)
            .centerInside()
            .into(posterIv)


//        dateTv.setText("Released: " + intent.getStringExtra("date").toString())
//        avgView.setText("Avg Rating: " + intent.getStringExtra("avg").toString())
//        countView.setText("Votes: " + intent.getStringExtra("count").toString())
    }
}