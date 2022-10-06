package com.codepath.articlesearch

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var mediaImageView: ImageView
    private lateinit var backImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var bylineTextView: TextView
    private lateinit var abstractTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // TODO: Find the views for the screen
        mediaImageView = findViewById(R.id.movie_image)
        backImageView = findViewById(R.id.backdrop_image)
        titleTextView = findViewById(R.id.movie_title)
        bylineTextView = findViewById(R.id.mediaByline)
        abstractTextView = findViewById(R.id.movie_description)

        // TODO: Get the extra from the Intent
        val article = intent.getSerializableExtra(ARTICLE_EXTRA) as Flix

        // TODO: Set the title, byline, and abstract information from the article
        titleTextView.text = article.title
        abstractTextView.text = article.description

        // TODO: Load the media image
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/" + article.backdrop)
            .into(mediaImageView)
    }
}