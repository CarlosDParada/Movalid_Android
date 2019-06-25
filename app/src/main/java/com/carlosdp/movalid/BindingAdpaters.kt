package com.carlosdp.movalid

import android.util.Log
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.carlosdp.movalid.model.Movie
import com.carlosdp.movalid.screen.home.PhotoGridAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Movie>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("titleSet")
fun  bindTile(textView: TextView , texto:String?){
    if (!texto.isNullOrEmpty()){
        textView.text = texto
    }
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    var imgURlBase = imgUrl
    if (imgURlBase.isNullOrEmpty()){
        Log.i("Movalid", "Image Error")
        imgURlBase = "/w9kR8qbmQ01HwnvK4alvnQ2ca0L.jpg"
    }
    var newUrl = "https://image.tmdb.org/t/p/w600_and_h900_bestv2$imgURlBase"
    Log.i("Movalid", "URL Img $newUrl")
    Log.i("Movalid", "URL view ${imgView.id}")
    newUrl?.let {
        val newUrl = newUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(newUrl)
//            .apply(RequestOptions()
//                .placeholder(R.drawable.loading_animation)
//                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}