package com.dicoding.mbtiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    private lateinit var rvMbti: RecyclerView
    private val list = ArrayList<Mbti>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvMbti = findViewById(R.id.rv_personalities)
        rvMbti.setHasFixedSize(true)

        list.addAll(getListMbti())
        showRecyclerList()
    }

    private fun getListMbti(): ArrayList<Mbti> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataType = resources.getStringArray(R.array.data_type)
        val dataGeneralDesc = resources.getStringArray(R.array.data_generaldesc)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPeople = resources.getStringArray(R.array.data_people)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listMbti = ArrayList<Mbti>()
        for (i in dataName.indices) {
            val mbti = Mbti(dataName[i], dataType[i], dataGeneralDesc[i], dataDescription[i], dataPeople[i], dataPhoto.getResourceId(i, -1))
            listMbti.add(mbti)
        }
        return listMbti
    }

    private fun showRecyclerList() {
        rvMbti.layoutManager = LinearLayoutManager(this)
        val listMbtiAdapter = ListMbtiAdapter(list)
        rvMbti.adapter = listMbtiAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.user, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val moveIntent = Intent(this@HomeActivity, ProfileActivity::class.java)
        startActivity(moveIntent)
        return true
    }
}