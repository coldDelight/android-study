package com.example.mvvm_calculator.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.example.mvvm_calculator.R

class LogDialog(context : Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_dialog)
        window!!.setBackgroundDrawable(ColorDrawable(Color.BLACK))
    }
}