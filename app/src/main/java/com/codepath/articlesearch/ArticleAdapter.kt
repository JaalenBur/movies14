package com.codepath.articlesearch

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val ARTICLE_EXTRA = "ARTICLE_EXTRA"
private const val TAG = "ArticleAdapter"

class ArticleAdapter(private val context: Context, private val articles: List<Flix>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
    }

    override fun getItemCount() = articles.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val mediaImageView = itemView.findViewById<ImageView>(R.id.movie_image)
        private val titleTextView = itemView.findViewById<TextView>(R.id.movie_title)
        private val abstractTextView = itemView.findViewById<TextView>(R.id.movie_description)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(article: Flix) {
            titleTextView.text = article.title
            abstractTextView.text = article.description

            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500/" + article.movieImageUrl)
                .centerInside()
                .into(mediaImageView)
        }

        override fun onClick(v: View?) {
            val flix = articles[absoluteAdapterPosition]

            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(ARTICLE_EXTRA, flix)
            context.startActivity(intent)
        }
    }
}