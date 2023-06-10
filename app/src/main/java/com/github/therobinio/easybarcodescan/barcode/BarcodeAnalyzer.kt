package com.github.therobinio.easybarcodescan.barcode

import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.github.therobinio.easybarcodescan.MainActivity
import com.google.android.material.snackbar.Snackbar
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage

class BarcodeAnalyzer(
    private val view: View,
) : ImageAnalysis.Analyzer {


    @SuppressLint("UnsafeOptInUsageError")
    override fun analyze(image: ImageProxy) {
        val img = image.image
        if(img != null) {


            val inputImage = InputImage.fromMediaImage(img, image.imageInfo.rotationDegrees)

            val options = BarcodeScannerOptions.Builder()
                .setBarcodeFormats(Barcode.FORMAT_EAN_8,Barcode.FORMAT_EAN_13)
                .build()

            val scanner = BarcodeScanning.getClient(options)

            scanner.process(inputImage)
                .addOnSuccessListener { barcodse ->
                    for(barcode in barcodse)
                        barcode.rawValue?.let {
                            Snackbar.make(view, it,Snackbar.LENGTH_LONG).show()
                            view.context.startActivity(Intent(view.context, MainActivity::class.java).apply {
                                putExtra("barcode",barcode.rawValue)
                            })
                        }
                }
                .addOnFailureListener {}
        }
        image.close()
    }
}