package com.bdpqchen.magicimage

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.bdpqchen.magicimage.old.FilterActivity
import com.bdpqchen.magicimage.old.PanoramaActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val panorama = findViewById<Button>(R.id.panorama)
        panorama.setOnClickListener({ startAction(PanoramaActivity::class.java) })
        val filter = findViewById<Button>(R.id.filter)
        filter.setOnClickListener({ startAction(HomeActivity::class.java) })
        val wave = findViewById<Button>(R.id.wave)
        wave.setOnClickListener({ startAction(WaveActivity::class.java) })
        findViewById<Button>(R.id.basicColor).setOnClickListener({
            startAction(BasicColorActivity::class.java)
        })
        findViewById<Button>(R.id.matrixCalculate).setOnClickListener({
            startAction(MatrixActivity::class.java)
        })
    }

    private fun startAction(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
    }


}
