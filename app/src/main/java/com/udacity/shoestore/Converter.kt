package com.udacity.shoestore

import android.widget.EditText
import androidx.databinding.InverseMethod

object Converter {
    @InverseMethod("stringToDouble")
    @JvmStatic fun doubleTOString(size: Double): String {
        return size.toString()
    }

    @JvmStatic fun stringToDouble(value: String): Double {
        // Converts String to long.
        return value.toDoubleOrNull() ?: 0.0
    }
}