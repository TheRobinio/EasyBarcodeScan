package com.github.therobinio.easybarcodescan.barcode

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class BarcodeView(context: Context): View(context) {

    private val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.style = Paint.Style.FILL
        paint.color = Color.RED
        canvas?.drawRect(width/8F,height/2-3F, width/8F*7F,height/2+3F,paint)
    }
}