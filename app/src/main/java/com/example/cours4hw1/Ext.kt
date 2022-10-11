package com.example.cours4hw1

import android.widget.ImageView
import com.bumptech.glide.Glide

    fun ImageView.loadImage(url: String?){
    Glide.with(this).load(url).into(this)
}