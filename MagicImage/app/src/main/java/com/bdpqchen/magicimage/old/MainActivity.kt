package com.bdpqchen.magicimage.old

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.bdpqchen.magicimage.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val panorama = findViewById<Button>(R.id.panorama)
        panorama.setOnClickListener({ startAction(PanoramaActivity::class.java) })
        val filter = findViewById<Button>(R.id.filter)
        filter.setOnClickListener({ startAction(FilterActivity::class.java) })



    }


    private fun startAction(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
    }


}
