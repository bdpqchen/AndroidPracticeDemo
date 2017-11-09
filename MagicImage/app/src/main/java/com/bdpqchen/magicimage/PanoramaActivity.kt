package com.bdpqchen.magicimage

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

import com.bumptech.glide.Glide
import com.gjiazhe.panoramaimageview.GyroscopeObserver
import com.gjiazhe.panoramaimageview.PanoramaImageView

/**
 * Created by bdpqchen on 17-11-9.
 */

class PanoramaActivity : AppCompatActivity() {
    private lateinit var gyroscopeObserver: GyroscopeObserver

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_panorama)
        gyroscopeObserver = GyroscopeObserver()
        // Set the maximum radian the device should rotate to show image's bounds.
        // It should be set between 0 and π/2.
        // The default value is π/9.
        gyroscopeObserver.setMaxRotateRadian(Math.PI / 9)

        val panoramaImageView = findViewById<PanoramaImageView>(R.id.panorama_image_view)
        Glide.with(this).load(R.drawable.img1).into(panoramaImageView)
        // Set GyroscopeObserver for PanoramaImageView.
        panoramaImageView.setGyroscopeObserver(gyroscopeObserver)

    }

    override fun onResume() {
        super.onResume()
        // Register GyroscopeObserver.
        gyroscopeObserver.register(this)
    }

    override fun onPause() {
        super.onPause()
        // Unregister GyroscopeObserver.
        gyroscopeObserver.unregister()
    }


}