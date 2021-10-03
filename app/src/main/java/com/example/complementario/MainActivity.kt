package com.example.complementario

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat.getSystemService
import com.example.complementario.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var binding: ActivityMainBinding
    lateinit var view: View
    private var location = ""
    private val options = arrayListOf("San Salvador", "San Miguel", "Santa Ana")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
// View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        view = binding.root
// Inflate the Activity
        setContentView(view)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val spinnerAdapter = ArrayAdapter(
            this,
            R.layout.support_simple_spinner_dropdown_item,
            options,
        )
        binding.spPickerSelected.apply {
            adapter = spinnerAdapter
            setSelection(0, true)
            onItemSelectedListener = this@MainActivity
        }

// Method to add all the Button listeners
        addListeners()

    }

    private fun addListeners() {
        //picker function
        binding.btnName.setOnClickListener {
            hideKeyboard()

            binding.apply {
                var message =
                    "Your name is  ${etNombre.text}, your Lastname is  ${etApellido.text}, " +
                            "your phonenumber is  ${etTelefono.text}, you choose $location"
                if (etNombre.text.isBlank()){
                    message = "Name field is empty"

                }
                Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show()
            }
        }


    }


// Name Button


// Message behaviour

// Show SnackBar


    private fun hideKeyboard() {
        val manager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        manager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        location = options[position]

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
}




