package com.example.rgbseekbars

import android.graphics.Color
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.rgbseekbars.databinding.ActivityMainBinding
import kotlin.String

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val obj = object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                val colorTextView = when (p0?.id) {
                    binding.redSeekBar.id -> binding.redColor
                    binding.greenSeekBar.id -> binding.greenColor
                    else -> binding.blueColor
                }
                colorTextView.text = p1.toString()
                setViewColor()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) = Unit
            override fun onStopTrackingTouch(p0: SeekBar?) = Unit
        }

        binding.redSeekBar.setOnSeekBarChangeListener(obj)
        binding.greenSeekBar.setOnSeekBarChangeListener(obj)
        binding.blueSeekBar.setOnSeekBarChangeListener(obj)

    }

    fun setViewColor() {
        val red = binding.redColor.text.toString().toInt()
        val green = binding.greenColor.text.toString().toInt()
        val blue = binding.blueColor.text.toString().toInt()
        binding.colorView.setBackgroundColor(Color.rgb(red, green, blue))
        binding.hexCode.text =
            resources.getString(R.string.hex, String.format("#%02X%02X%02X", red, green, blue))

    }

}