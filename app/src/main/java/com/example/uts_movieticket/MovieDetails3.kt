package com.example.uts_movieticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_movieticket.databinding.ActivityMovieDetails3Binding

class MovieDetails3 : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetails3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetails3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {

            val img = intent.getIntExtra("image", 0)

            backButton2.setOnClickListener {
                val intentToHomePageActivity =
                    Intent(this@MovieDetails3, HomePage::class.java)
                    startActivity(intentToHomePageActivity)

            }
            getTicketButton3.setOnClickListener {
                val intentToPayment =
                    Intent(this@MovieDetails3, Payment::class.java)
                intentToPayment.putExtra(MovieDetails.title, movieTitle3.text.toString())
                intentToPayment.putExtra("image", img)
                startActivity(intentToPayment)
            }
        }
    }
}