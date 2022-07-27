package com.example.rgbseekbars

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
                when (p0?.id) {
                    redSeekbar.id -> redColor.text = p1.toString()
                    greenSeekbar.id -> greenColor.text = p1.toString()
                    blueSeekbar.id -> blueColor.text = p1.toString()
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

    fun setViewColor() {
        val red = redColor.text.toString().toInt()
        val green = greenColor.text.toString().toInt()
        val blue = blueColor.text.toString().toInt()
        colorView.setBackgroundColor(Color.rgb(red, green, blue))
        hexCode.text = resources.getString(R.string.hex, String.format("#%02X%02X%02X", red, green, blue))

    }

}