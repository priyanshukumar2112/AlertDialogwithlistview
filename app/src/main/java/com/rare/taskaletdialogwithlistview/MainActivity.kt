package com.rare.taskaletdialogwithlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.rare.taskaletdialogwithlistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var arrayList=ArrayList<String>()
    lateinit var arrayAdapter: ArrayAdapter<String>
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, arrayList)
        binding.lv.adapter = arrayAdapter


        binding.btnfab.setOnClickListener{
        var dialog = AlertDialog.Builder(this)
            dialog.setTitle("Add Random Name")
            dialog.setMessage("Choose any number to genrate Name")

            dialog.setNeutralButton("3"){_,_ ->
                val length = 3
                var randomString = getRandomString(length)
                binding.tvrandomcstr.setText(randomString.toString())
                arrayList.add(binding.tvrandomcstr.text.toString())
                arrayAdapter.notifyDataSetChanged()
            }
            dialog.setNegativeButton("4"){_,_ ->
                val length = 4
                var randomString = getRandomString(length)
                binding.tvrandomcstr.setText(randomString.toString())
                arrayList.add(binding.tvrandomcstr.text.toString())
                arrayAdapter.notifyDataSetChanged()
            }
            dialog.setPositiveButton("5"){_,_ ->
                val length = 5
                var randomString = getRandomString(length)
                binding.tvrandomcstr.setText(randomString.toString())
                arrayList.add(binding.tvrandomcstr.text.toString())
                arrayAdapter.notifyDataSetChanged()
            }
            dialog.show()
        }
        binding.lv.setOnItemClickListener{ adapterView: AdapterView<*>, view2: View, i: Int, l: Long ->
            var dialog = android.app.AlertDialog.Builder(this)
            dialog.setTitle("Delete Alert!!")
            dialog.setMessage("Are you sure ")
            dialog.setPositiveButton("yes") { _, _ ->
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
                arrayList.removeAt(i)
                arrayAdapter.notifyDataSetChanged()
            }
            dialog.setNegativeButton("No") { _, _ ->
                Toast.makeText(this, "Operation Cancelled", Toast.LENGTH_SHORT).show()
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
