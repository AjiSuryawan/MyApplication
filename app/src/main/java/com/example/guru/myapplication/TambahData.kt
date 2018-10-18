package com.example.guru.myapplication

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.content.Intent
import com.example.guru.myapplication.Database.MahasiswaHelper
import com.example.guru.myapplication.Model.MahasiswaModel
import kotlinx.android.synthetic.main.activity_tambah_data.*


class TambahData : AppCompatActivity() {
    var loginButton: Button? = null
    internal lateinit var mahasiswaHelper: MahasiswaHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_data)
        mahasiswaHelper = MahasiswaHelper(applicationContext)
        loginButton = findViewById(R.id.btnsimpan) as Button
        loginButton!!.setOnClickListener(View.OnClickListener {

            mahasiswaHelper.open()
            mahasiswaHelper.beginTransaction()

            val m = MahasiswaModel(txtname.text.toString(), txtalamat.text.toString(), txtvisimisi.text.toString())

            mahasiswaHelper.insertTransaction(m)
            mahasiswaHelper.setTransactionSuccess()
            mahasiswaHelper.endTransaction()
            mahasiswaHelper.close()


            val intent = intent
            intent.putExtra("key", "makan")
            setResult(Activity.RESULT_OK, intent)
            finish()
        })
    }
}