package com.example.pulsepal

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // TODO: get the recording ID, start and length from the first screen and show them here

        // finish() closes this screen and we are back on the form
        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}
