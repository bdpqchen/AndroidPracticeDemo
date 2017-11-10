package com.bdpqchen.magicimage

import android.graphics.*
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.ImageView

/**
 * Created by bdpqchen on 17-11-10.
 *
 */
class HomeActivity : AppCompatActivity() {

    private lateinit var mImage: ImageView

    private lateinit var mApply: Button
    private lateinit var mReset: Button
    private lateinit var mGrid: GridLayout
    private var mEtWidth = 0
    private var mEtHeight = 0
    private var mEts = arrayOfNulls<EditText>(20)
    private lateinit var mColorMatrix: FloatArray
    private lateinit var mBitmap: Bitmap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mImage = findViewById(R.id.img)
        mApply = findViewById(R.id.apply)
        mReset = findViewById(R.id.reset)
        mGrid = findViewById(R.id.grid)
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.cover)
        mImage.setImageBitmap(mBitmap)

        mGrid.post({
            kotlin.run {
                mEtWidth = mGrid.width / 5
                mEtHeight = mGrid.height / 4
                addEdit()
                initMatrix()
            }
        })


    }

    private fun setImageMatrix(){
        var bitmap = Bitmap.createBitmap(
                mBitmap.width,
                mBitmap.height,
                Bitmap.Config.ARGB_8888)
        var colorMatrix = ColorMatrix()
        colorMatrix.set(mColorMatrix)
        var canvas = Canvas(bitmap)
        var paint = Paint()
        paint.colorFilter = ColorMatrixColorFilter(colorMatrix)
        canvas.drawBitmap(mBitmap, 0, 0, paint)
    }

    private fun getMatrix() {
        for (i in 0 until 20) {
            mColorMatrix[i] = mEts[i]?.text.toString().toFloat()
        }
    }


    private fun initMatrix() {
        for (i in 0 until 20) {
            if (i % 6 == 0) {
                mEts[i]?.setText(1.toString())
            } else {
                mEts[i]?.setText(0.toString())
            }
        }
    }

    private fun addEdit() {
        for (i in 0 until 20) {
            val edit = EditText(this)
            mEts[i] = edit
            mGrid.addView(edit, mEtWidth, mEtHeight)
        }
    }


}