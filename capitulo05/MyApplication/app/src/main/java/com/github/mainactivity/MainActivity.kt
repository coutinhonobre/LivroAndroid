package com.github.mainactivity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var txtFooter: TextView

    // 0=VW;1=GM;2=Fiat;3=Ford
    private val vehicles = mutableListOf(
        Vehicle("Onix", 2018, 1, gasoline = true, ethanol = true),
        Vehicle("Uno", 2007, 2, gasoline = true, ethanol = false),
        Vehicle("Del Rey", 1988, 3, gasoline = false, ethanol = true),
        Vehicle("Gol", 2014, 0, gasoline = true, ethanol = true)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listView = ListView(this)
        setContentView(listView)
        val adapter = VehicleAdapter(this, vehicles)
        listView.adapter = adapter
        initHeaderAndFooter(listView, adapter)

        val io = this.applicationInfo
        Toast.makeText(this, io.sourceDir.toString(), Toast.LENGTH_SHORT).show()

        listView.setOnItemClickListener { parent, _, position, _ ->
            val vehicle = parent.getItemAtPosition(position) as? Vehicle
            if (vehicle != null) {
                val (model, year) = vehicle
                Toast.makeText(this, "$model $year", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initHeaderAndFooter(listView: ListView, adapter: VehicleAdapter) {
        val padding = 8
        val txtHeader = TextView(this)
        txtHeader.setBackgroundColor(Color.GRAY)
        txtHeader.setTextColor(Color.WHITE)
        txtHeader.setText(R.string.header_text)
        txtHeader.setPadding(padding, padding, 0, padding)
        listView.addHeaderView(txtHeader)

        txtFooter = TextView(this)
        txtFooter.text = resources.getQuantityString(
            R.plurals.footer_text, adapter.count, adapter.count
        )
        txtFooter.setBackgroundColor(Color.LTGRAY)
        txtFooter.setPadding(0, padding, padding, padding)
        listView.addFooterView(txtFooter)
    }


}