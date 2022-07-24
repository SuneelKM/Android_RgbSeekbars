package com.example.myapplicationrgb

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.String

class MainActivity : AppCompatActivity() {
    private lateinit var colorView: TextView
    private lateinit var redColor: TextView
    private lateinit var greenColor: TextView
    private lateinit var blueColor: TextView
    private lateinit var hexCode: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val redSeekbar = findViewById<SeekBar>(R.id.red_seekBar)
        val greenSeekbar = findViewById<SeekBar>(R.id.green_seekBar)
        val blueSeekbar = findViewById<SeekBar>(R.id.blue_seekBar)
        colorView = findViewById(R.id.color_view)
        redColor = findViewById(R.id.red_color)
        greenColor = findViewById(R.id.green_color)
        blueColor = findViewById(R.id.blue_color)
        hexCode = findViewById(R.id.hex_code)


        val obj = object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                val seekbarView = p0?.let { findViewById<SeekBar>(it.id) }
                when (seekbarView) {
                    redSeekbar -> redColor.text = p1.toString()
                    greenSeekbar -> greenColor.text = p1.toString()
                    blueSeekbar -> blueColor.text = p1.toString()
                }
                setViewColor()
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        }

        redSeekbar.setOnSeekBarChangeListener(obj)
        greenSeekbar.setOnSeekBarChangeListener(obj)
        blueSeekbar.setOnSeekBarChangeListener(obj)

    }

    @SuppressLint("SetTextI18n")
    fun setViewColor() {
        val red = redColor.text.toString().toInt()
        val green = greenColor.text.toString().toInt()
        val blue = blueColor.text.toString().toInt()
        colorView.setBackgroundColor(Color.rgb(red, green, blue))
        hexCode.text = "Hex:" + String.format("#%02X%02X%02X", red, green, blue)

    }

}