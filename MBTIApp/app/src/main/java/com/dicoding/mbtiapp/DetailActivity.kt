package com.dicoding.mbtiapp

import android.content.Intent
import android.content.Intent.EXTRA_SUBJECT
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.ButtonBarLayout
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //val tvObject: TextView = findViewById(R.id.tv_object_received)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detailMbti = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Mbti>("key_mbti")
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key_mbti")
        }

        val photodetail: ImageView = findViewById(R.id.img_detail)
        val namedetail: TextView = findViewById(R.id.detail_name)
        val typedetail: TextView = findViewById(R.id.detail_type)
        val introdetail: TextView = findViewById(R.id.detail_intro)
        val youmaydetail: TextView = findViewById(R.id.detail_you_may)
        val peopledetail: TextView = findViewById(R.id.detail_people)
        val descriptiondetail: TextView = findViewById(R.id.detail_description)

        photodetail.setImageResource(detailMbti?.photo!!)
        namedetail.text = "I'm A/An ${detailMbti.name.toString()}"
        typedetail.text = detailMbti.type
        introdetail.text = "Who Is A/An ${detailMbti?.name.toString()} ?"
        youmaydetail.text = "${detailMbti?.name.toString()}s You May Know"
        peopledetail.text = detailMbti.people
        descriptiondetail.text = detailMbti.description

        supportActionBar?.title = detailMbti.name

        val btnShare:Button = findViewById(R.id.btn_share)
        btnShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT,
                    "${detailMbti?.description.toString()} People that have this personality:\n${detailMbti?.people.toString()}")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}