package com.rare.taskaletdialogwithlistview

import android.app.Dialog
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.rare.taskaletdialogwithlistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnfab.setOnClickListener{
        var dialog = AlertDialog.Builder(this)
            dialog.setTitle("Add Random Name")
            dialog.setMessage("Choose any number to genrate Name")

            dialog.setNeutralButton("3"){_,_ ->
                val length = 3
                var randomString = getRandomString(length)
                binding.tvrandomcstr.setText(randomString.toString())
            }
            dialog.setNegativeButton("4"){_,_ ->
                val length = 4
                var randomString = getRandomString(length)
                binding.tvrandomcstr.setText(randomString.toString())
            }
            dialog.setPositiveButton("5"){_,_ ->
                val length = 5
                var randomString = getRandomString(length)
                binding.tvrandomcstr.setText(randomString.toString())
            }
            dialog.show()
        }
    }

     fun getRandomString(length: Int): String {
         val charset = ('a'..'z') + ('A'..'Z')

         return List(length) { charset.random() }
             .joinToString("")
     }
    }
