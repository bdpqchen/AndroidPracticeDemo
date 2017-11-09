package com.bdpqchen.magicimage

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gjiazhe.panoramaimageview.PanoramaImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var panorama = findViewById<PanoramaImageView>(R.id.panorama_image_view)
        panorama.setOnClickListener({ startAction(PanoramaActivity::class.java) })



    }


    private fun startAction(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
    }


}
