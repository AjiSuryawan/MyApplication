package com.example.guru.myapplication
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import kotlinx.android.synthetic.main.activity_detail.*
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.load.engine.DiskCacheStrategy
import android.content.Intent
import android.net.Uri
class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val title:String = intent.getStringExtra("title")
//        val gambar:String = intent.getStringExtra("gambar")
        val deskripsi:String = intent.getStringExtra("deskripsi")
        txtjudul.text=title
//        val options = RequestOptions()
//                .centerCrop()
//                .placeholder(R.drawable.pixel_google)
//                .error(R.drawable.pixel_google)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .priority(Priority.HIGH)
//                .dontAnimate()
//                .dontTransform()
//        Glide.with(applicationContext)
//                .load("https://image.tmdb.org/t/p/w500" + gambar)
//                .apply(options)
//                .into(ivgambar)
        txtdeskripsi.text=deskripsi
        backicon.setOnClickListener(View.OnClickListener {
            this.finish()
        })
        btntrailer.setOnClickListener(View.OnClickListener {
            val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=_B6p9OGma_s"))
            startActivity(appIntent)
        })
    }
}