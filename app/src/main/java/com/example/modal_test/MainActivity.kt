package com.example.modal_test

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.show_dialog_button).setOnClickListener {

            val fragment = ConfirmDeleteDialogFragment()

            fragment.listener = object: ConfirmDeleteDialogFragment.ConfirmDeleteListener {
                override fun onDialogPositiveClick() {
                    Log.i("MainActivity","onPositiveClick")
                }

                override fun onDialogNegativeClick() {
                    Log.i("MainActivity","onNegativeClick")
                }

            }

            fragment.show(this.supportFragmentManager, "confirmDelete")


        }
    }
}