package com.app.builduikt

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Log.d(TAG, "onCreate: ")
    }


    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
        Log.d(Companion.TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
        Log.d(Companion.TAG, "onResume: ")
        createFragment()
    }

    private fun createFragment() {
        val ft = supportFragmentManager.beginTransaction();
        ft.add(R.id.fl_fr_container, SecondFragment(), SecondFragment.javaClass.canonicalName)
        ft.addToBackStack(SecondFragment.javaClass.canonicalName)
        ft.commit()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
        Log.d(Companion.TAG, "onPause: ")

    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
        Log.d(Companion.TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
        Log.d(Companion.TAG, "onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()
        Log.d(Companion.TAG, "onRestart: ")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d(Companion.TAG, "onSaveInstanceState: ")
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        Log.d(Companion.TAG, "onRestoreInstanceState: ")
    }

    companion object {
        private const val TAG = "MainActivity2"
    }
}