package com.bdpqchen.magicimage

import android.graphics.*
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.Gravity
import android.view.WindowManager
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
    private lateinit var mConvert: Button
    private lateinit var mGrey: Button

    private lateinit var mGrid: GridLayout
    private var mEtWidth = 0
    private var mEtHeight = 0
    private lateinit var mEts: Array<EditText>
    private val mColorMatrix = FloatArray(20)
    private lateinit var mBitmap: Bitmap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_home)

        mEts = Array(20, { EditText(this) })
        mImage = findViewById(R.id.img)
        mApply = findViewById(R.id.apply)
        mReset = findViewById(R.id.reset)
        mConvert = findViewById(R.id.convert)
        mGrid = findViewById(R.id.grid)
        mGrey = findViewById(R.id.grey)

        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.ab)
        mImage.setImageBitmap(mBitmap)

        mGrid.post({
            kotlin.run {
                mEtWidth = mGrid.width / 5
                mEtHeight = mGrid.height / 4
                addEdit()
                initMatrix()
            }
        })

        mReset.setOnClickListener({
            initMatrix()
            mApply.callOnClick()
        })

        mApply.setOnClickListener({
            getMatrix()
            setImageMatrix()
        })

        mConvert.setOnClickListener({
            setConvertMatrix()
        })

        findViewById<Button>(R.id.grey).setOnClickListener({
            setGreyMatrix()
        })
        findViewById<Button>(R.id.mirror).setOnClickListener({
            setMirror()
        })

    }

    private fun setGreyMatrix() {
        for (i in 0 until 20) {
            with(mEts[i]) {
                val f = when {
                    i == 18 -> 1f               //except one.
                    i >= 15 -> 0f               //last row.
                    i % 5 == 0 -> 0.33f         //first one of each column.
                    (i - 1) % 5 == 0 -> 0.59f   //second one of each column.
                    (i - 2) % 5 == 0 -> 0.11f   //third one of each column.
                    else -> {
                        0f                      //the other value is.
                    }
                }

                setText(f.toString())
            }
        }
    }

    private fun setConvertMatrix() {
        for (i in 0 until 20) {
            with(mEts[i]) {
                var value = 0
                when {
                    i % 6 == 0 -> value = if (i == 18) 1 else -1
                    (i + 2) % 5 == 0 -> value = 1
                }
                setText(value.toString())
            }
        }
    }

    private fun setImageMatrix() {
        val bitmap = Bitmap.createBitmap(
                mBitmap.width,
                mBitmap.height,
                Bitmap.Config.ARGB_8888)
        val colorMatrix = ColorMatrix()
        colorMatrix.set(mColorMatrix)
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.colorFilter = ColorMatrixColorFilter(colorMatrix)
        canvas.drawBitmap(mBitmap, 0F, 0F, paint)
        mImage.setImageBitmap(bitmap)
    }

    private fun setMirror() {
        val bitmap = Bitmap.createBitmap(
                mBitmap.width,
                mBitmap.height,
                Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val matrix = Matrix()
        matrix.postScale(-1f, 1f)
        val bitmapResult = Bitmap.createBitmap(mBitmap, 0, 0, mBitmap.width, mBitmap.height, matrix, true)
        val paint = Paint()
        canvas.drawBitmap(bitmapResult, 0F, 0F, paint)
        mImage.setImageBitmap(bitmapResult)
    }

    private fun getMatrix() {
        for (i in 0 until 20) {
            with(mEts[i].text.toString()) {
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
            edit.setOnClickListener {
                edit.selectAll()
                edit.setSelection(if (edit.text == null) 0 else edit.text.length)
            }
            mEts[i] = edit
            mGrid.addView(edit, mEtWidth, mEtHeight)
        }
    }


}