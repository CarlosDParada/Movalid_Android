package com.carlosdp.movalid.screen.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.carlosdp.movalid.R
import com.carlosdp.movalid.bindImage
import com.carlosdp.movalid.model.Movie
import kotlinx.android.synthetic.main.list_item_film.view.*

class HomeFilmAdapter  : RecyclerView.Adapter<HomeFilmAdapter.ViewHolder>(){
    var data = listOf<Movie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
//        val res = holder.itemView.context.resources
        holder.bind(item)
    }

    class ViewHolder private  constructor(itemView : View): RecyclerView.ViewHolder(itemView){
        val  titleMovie : TextView = itemView.findViewById(
            R
            .id.textMovieName)
        val  imageMovie : ImageView = itemView.findViewById(R.id.imageViewMovie)

        fun bind(item: Movie) {
            val res = itemView.context.resources
            titleMovie.text =  item.title
            bindImage(imageMovie,item.poster_path)
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item_film, parent, false)
                return ViewHolder(view)
            }
        }

    }
}