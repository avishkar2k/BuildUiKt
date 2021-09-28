package com.app.builduikt

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class RelativeLActivity : AppCompatActivity() {

    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_l)
        editText= findViewById(R.id.tv_fl1)
        editText.addTextChangedListener { text ->
            run {
                Log.d(TAG, "onCreate: lambda")
            }
        }


        findViewById<TextView>(R.id.tv_fl1).addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //TODO("Not yet implemented")
                Log.d(TAG, "beforeTextChanged: object")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //TODO("Not yet implemented")
                Log.d(TAG, "onTextChanged: object")
            }

            override fun afterTextChanged(p0: Editable?) {
                //TODO("Not yet implemented")
                Log.d(TAG, "afterTextChanged: object")
            }

        })

        findViewById<TextView>(R.id.tv_fl2).setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                //TODO("Not yet implemented")
                Log.d(Companion.TAG, "onClick: fl2 object")
            }
        })

        findViewById<TextView>(R.id.tv_fl3).setOnClickListener {
            //TODO("Not yet implemented")
            Log.d(Companion.TAG, "onCreate: fl3 lambda")
            greet()
        }

    }

    fun greet() {
        Log.d(TAG, "greet: Hello Avishkar")
        Toast.makeText(this, editText.text, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val TAG = "RelativeLActivity"
    }
}