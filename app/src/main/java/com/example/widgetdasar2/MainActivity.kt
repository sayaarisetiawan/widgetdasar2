package com.example.widgetdasar2

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.spinner)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(R.layout.simple_spinner_drop_down)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

        val toggle: ToggleButton = findViewById(R.id.togglebutton)
        toggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(applicationContext, "Hidup", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Mati", Toast.LENGTH_SHORT).show()
            }
        }

        val switchGelap: Switch = findViewById(R.id.switcht_gelap)
        val layar: LinearLayout = findViewById(R.id.layar)
        switchGelap.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                layar.setBackgroundColor(0xff808080.toInt())
            } else {
                layar.setBackgroundColor(0xffffffff.toInt())
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        val selectedItem = parent?.getItemAtPosition(pos).toString()
        val tvPesan = findViewById<TextView>(R.id.tv_pesan)
        tvPesan.text = "Pilihan ke $pos : $selectedItem"
        Toast.makeText(applicationContext, "Pilihan ke $pos : $selectedItem", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        val tvPesan = findViewById<TextView>(R.id.tv_pesan)
        tvPesan.text = "Tidak ada item yang terpilih."
        Toast.makeText(applicationContext, "Tidak ada item yang terpilih.", Toast.LENGTH_SHORT).show()
    }
}
