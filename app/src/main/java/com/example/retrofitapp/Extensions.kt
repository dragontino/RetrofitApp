package com.example.retrofitapp

import android.content.Context
import android.view.View
import android.widget.Toast

fun showToast(context: Context, message: String, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(context, message, duration).show()


fun View.changeVisibility() = if (visibility == View.VISIBLE) {
    visibility = View.GONE
} else {
    visibility = View.VISIBLE
}