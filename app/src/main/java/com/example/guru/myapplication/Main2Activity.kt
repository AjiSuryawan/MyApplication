package com.example.guru.myapplication

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.example.guru.myapplication.Database.MahasiswaHelper
import com.example.guru.myapplication.Model.MahasiswaModel
import net.simplifiedcoding.recyclerviewexample.CustomAdapter
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


class Main2Activity : AppCompatActivity() {

    internal lateinit var mahasiswaHelper: MahasiswaHelper
    var listFilm2: ArrayList<MahasiswaModel> = ArrayList<MahasiswaModel>()
    var rv: RecyclerView? = null
    var linierkosong: LinearLayout? = null
    var tvtambahdata: TextView? = null
    var adapterku:CustomAdapter?=null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                mahasiswaHelper.open()
                listFilm2 = mahasiswaHelper.allData

                if (listFilm2.size>0){
                    linierkosong!!.visibility= View.INVISIBLE
                    rv!!.visibility=View.VISIBLE
                }else{
                    linierkosong!!.visibility= View.VISIBLE
                    rv!!.visibility=View.INVISIBLE
                }

                adapterku = CustomAdapter(listFilm2)
                rv!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayout.VERTICAL, false)
                rv!!.adapter = adapterku
                Toast.makeText(applicationContext,""+data.getStringExtra("key"),Toast.LENGTH_SHORT).show()
            }

        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        rv = findViewById(R.id.recycler_view_list_film) as RecyclerView
        linierkosong = findViewById(R.id.lnkosong) as LinearLayout
        tvtambahdata = findViewById(R.id.tvtambahdata) as TextView
        tvtambahdata!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, TambahData::class.java)
            startActivityForResult(intent, 1)
        })
        mahasiswaHelper = MahasiswaHelper(applicationContext)

        mahasiswaHelper.open()
        listFilm2 = mahasiswaHelper.allData

        if (listFilm2.size>0){
            linierkosong!!.visibility= View.INVISIBLE
            rv!!.visibility=View.VISIBLE
        }else{
            linierkosong!!.visibility= View.VISIBLE
            rv!!.visibility=View.INVISIBLE
        }

        println("lebar film : "+listFilm2.size)


        adapterku = CustomAdapter(listFilm2)
        rv!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayout.VERTICAL, false)
        rv!!.adapter = adapterku


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)

        // return true so that the menu pop up is opened
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.getItemId() === R.id.item1) {
            val intent = Intent(applicationContext, TambahData::class.java)
            startActivityForResult(intent, 1)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)

        builder.setTitle("Confirm")
        builder.setMessage("Are you sure want to exit ?")

        builder.setPositiveButton("YES", DialogInterface.OnClickListener { dialog, which ->
            // Do nothing but close the dialog
            finish()
            dialog.dismiss()
        })

        builder.setNegativeButton("NO", DialogInterface.OnClickListener { dialog, which ->
            // Do nothing
            dialog.dismiss()
        })

        val alert = builder.create()
        alert.show()
    }


}