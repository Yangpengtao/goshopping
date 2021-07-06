package com.go.shopping.lib_base.image

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.go.lib_base1.image.interfaces.IImageLoaderProcessor

object GlideProcessor : IImageLoaderProcessor {
    override fun loadNormalImage(imageView: ImageView, uri: Uri) {
        Glide.with(imageView.context)
            .load(uri)
            // .error(R.drawable.error_bitmap)
            //.placeholder(R.drawable.bitmap)
            .into(imageView)
    }

    override fun loadNormalImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
            .load(url)
            // .error(R.drawable.error_bitmap)
            //.placeholder(R.drawable.bitmap)
            .into(imageView)
    }

    override fun loadCircleImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
            .load(url)
//            .error(R.drawable.logo)
//            .placeholder(R.drawable.logo)
            .into(imageView)
    }

    override fun loadRoundImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
            .load(url)
            //                .error(R.drawable.error_bitmap)
//            .placeholder(R.drawable.bitmap)
            .into(imageView)
    }


}