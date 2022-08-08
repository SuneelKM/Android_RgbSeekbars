package com.example.rgbseekbars

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.slider.Slider

@BindingAdapter("colorSlider")
fun bindSlider(slider: Slider, color: TextView) {
    slider.addOnChangeListener { _, value, _ ->
        color.text = value.toInt().toString()
        val context = color.context
        (context as MainActivity).setViewColor()
    }
}
