package com.example.rgbseekbars

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rgbseekbars.databinding.ActivityMainBinding
import com.google.android.material.slider.Slider
import kotlin.String

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.redSlider.addOnChangeListener { slider, value, _ ->
            addColor(slider, value)
        }
        binding.greenSlider.addOnChangeListener { slider, value, _ ->
            addColor(slider, value)
        }
        binding.blueSlider.addOnChangeListener { slider, value, _ ->
            addColor(slider, value)
        }
    }

    private fun addColor(slider: Slider, value: Float) {
        val colorTextView = when (slider.id) {
            binding.redSlider.id -> binding.redColor
            binding.greenSlider.id -> binding.greenColor
            else -> binding.blueColor
        }
        colorTextView.text = value.toInt().toString()
        setViewColor()
    }

    private fun setViewColor() {
        val red = binding.redColor.text.toString().toInt()
        val green = binding.greenColor.text.toString().toInt()
        val blue = binding.blueColor.text.toString().toInt()
        binding.colorView.setBackgroundColor(Color.rgb(red, green, blue))
        binding.hexCode.text =
            resources.getString(R.string.hex, String.format("#%02X%02X%02X", red, green, blue))

    }

}