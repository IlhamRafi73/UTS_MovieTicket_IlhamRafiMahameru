package com.example.uts_movieticket

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_movieticket.databinding.ActivityLoginPageBinding
import com.example.uts_movieticket.databinding.ActivityMovieDetailsBinding

class MovieDetails : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding

    companion object{
        const val title = "title"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            backButton.setOnClickListener {
                val intentToHomePageActivity =
                    Intent(this@MovieDetails, HomePage::class.java)
                startActivity(intentToHomePageActivity)
            }

        }
        with(binding) {

            val img = intent.getIntExtra("image", 0)

            getTicketButton.setOnClickListener {
                val intentToPayment =
                    Intent(this@MovieDetails, Payment::class.java)
                    intentToPayment.putExtra(MovieDetails.title, movieTitle.text.toString())
                    intentToPayment.putExtra("image", img)
                    startActivity(intentToPayment)
            }
        }
    }
}