package com.github.therobinio.easybarcodescan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.github.therobinio.easybarcodescan.barcode.BarcodeScannerActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(intent.hasExtra("barcode")) {
            findViewById<TextView>(R.id.barcode).setText(intent.getStringExtra("barcode" +
                    ""))
        }

        findViewById<Button>(R.id.startCamera).setOnClickListener{
            startActivity(Intent(this, BarcodeScannerActivity::class.java))
        }
    }

}