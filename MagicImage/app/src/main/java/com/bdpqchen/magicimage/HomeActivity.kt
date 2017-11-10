package com.bdpqchen.magicimage

import android.graphics.*
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.Gravity
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
    private lateinit var mEts: Array<EditText>
    private val mColorMatrix = FloatArray(20)
    private lateinit var mBitmap: Bitmap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mEts = Array(20, { EditText(this) })
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

        mApply.setOnClickListener({
            getMatrix()
            setImageMatrix()
        })

    }

    private fun setImageMatrix() {
        var bitmap = Bitmap.createBitmap(
                mBitmap.width,
                mBitmap.height,
                Bitmap.Config.ARGB_8888)
        var colorMatrix = ColorMatrix()
        colorMatrix.set(mColorMatrix)
        var canvas = Canvas(bitmap)
        var paint = Paint()
        paint.colorFilter = ColorMatrixColorFilter(colorMatrix)
        canvas.drawBitmap(mBitmap, 0F, 0F, paint)
        mImage.setImageBitmap(bitmap)

    }

    private fun getMatrix() {
        for (i in 0 until 20) {
            with(mEts[i].text.toString()){
                mColorMatrix[i] = if (length > 0) this.toFloat() else 0f
            }
        }
    }


    private fun initMatrix() {
        for (i in 0 until 20) {
            mEts[i].setText(if (i % 6 == 0) 1.toString() else 0.toString())
        }
    }

    private fun addEdit() {
        for (i in 0 until 20) {
            val edit = EditText(this)
            edit.inputType = InputType.TYPE_CLASS_NUMBER
            edit.gravity = Gravity.CENTER
            mEts[i] = edit
            mGrid.addView(edit, mEtWidth, mEtHeight)
        }
    }


}