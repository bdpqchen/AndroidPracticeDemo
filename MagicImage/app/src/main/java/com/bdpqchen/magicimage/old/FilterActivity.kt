package com.bdpqchen.magicimage.old

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import com.bdpqchen.magicimage.R
import com.mukesh.image_processing.ImageProcessor


/**
 * Created by bdpqchen on 17-11-10.
 *
 */
class FilterActivity : AppCompatActivity() {

    private lateinit var filter: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        filter = findViewById(R.id.filter)
        val imageProcessor = ImageProcessor()
//        Glide.with(this).load(bitmap).into(filter)

        findViewById<Button>(R.id.highLight).setOnClickListener({
            val skullBitmap = BitmapFactory.decodeResource(resources, R.drawable.img)
            imageProcessor.doInvert(skullBitmap)
            load(skullBitmap)
        })

        findViewById<Button>(R.id.gamma).setOnClickListener({
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img)

            imageProcessor.doGamma(bitmap, 1.8, 1.8, 1.8)
            load(bitmap)
        })



    }

    private fun load(bitmap: Bitmap) {
        filter.setImageBitmap(bitmap)
//        Glide.with(this).load(bitmap).into(filter)
    }

}