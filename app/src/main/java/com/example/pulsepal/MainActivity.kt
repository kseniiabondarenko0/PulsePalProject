package com.example.pulsepal

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etRecordingId: EditText
    private lateinit var etStartSec: EditText
    private lateinit var etLengthSec: EditText
    private lateinit var btnReview: Button
    private lateinit var btnClear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etRecordingId = findViewById(R.id.etRecordingId)
        etStartSec = findViewById(R.id.etStartSec)
        etLengthSec = findViewById(R.id.etLengthSec)
        btnReview = findViewById(R.id.btnReview)
        btnClear = findViewById(R.id.btnClear)

        btnReview.setOnClickListener {
            val interval = readInterval()
            if (interval != null) {
                // TODO: open the details screen and pass the three numbers to it.
                // I have not learned how to do this yet, to be asked.
                Toast.makeText(this, "Data is correct", Toast.LENGTH_SHORT).show()
            }
        }

        btnClear.setOnClickListener {
            etRecordingId.text.clear()
            etStartSec.text.clear()
            etLengthSec.text.clear()
            etRecordingId.requestFocus()
        }
    }

    private fun readInterval(): EcgInterval? {
        val recordingId = etRecordingId.text.toString().trim().toIntOrNull()
        val startSec = etStartSec.text.toString().trim().toIntOrNull()
        val lengthSec = etLengthSec.text.toString().trim().toIntOrNull()

        if (recordingId == null) {
            showError(R.string.error_numbers, etRecordingId)
            return null
        }
        if (startSec == null) {
            showError(R.string.error_numbers, etStartSec)
            return null
        }
        if (lengthSec == null) {
            showError(R.string.error_numbers, etLengthSec)
            return null
        }

        if (recordingId < 1) {
            showError(R.string.error_recording_id, etRecordingId)
            return null
        }
        if (startSec < 0) {
            showError(R.string.error_start, etStartSec)
            return null
        }
        if (lengthSec < 5 || lengthSec > 60) {
            showError(R.string.error_length, etLengthSec)
            return null
        }

        return EcgInterval(recordingId, startSec, lengthSec)
    }

    private fun showError(messageId: Int, field: EditText) {
        Toast.makeText(this, getString(messageId), Toast.LENGTH_SHORT).show()
        field.requestFocus()
    }
}