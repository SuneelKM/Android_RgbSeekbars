package com.example.rgbseekbars

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rgbseekbars.databinding.ActivityMainBinding
import kotlin.String

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun setViewColor() {
        val red = binding.redColor.text.toString().toInt()
        val green = binding.greenColor.text.toString().toInt()
        val blue = binding.blueColor.text.toString().toInt()
        binding.apply {
            colorView.setBackgroundColor(Color.rgb(red, green, blue))
            hexCode.text =
                resources.getString(R.string.hex, String.format("#%02X%02X%02X", red, green, blue))
        }
    }

}