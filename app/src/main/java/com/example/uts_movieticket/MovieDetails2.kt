package com.example.uts_movieticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_movieticket.databinding.ActivityMovieDetails2Binding
import com.example.uts_movieticket.databinding.ActivityMovieDetailsBinding

class MovieDetails2 : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetails2Binding

    companion object{
        const val title = "title"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetails2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {

            val img = intent.getIntExtra("image", 0)

            backButton2.setOnClickListener {
                val intentToHomePageActivity =
                    Intent(this@MovieDetails2, HomePage::class.java)
                    startActivity(intentToHomePageActivity)
            }
            getTicketButton2.setOnClickListener {
                val intentToPayment =
                    Intent(this@MovieDetails2, Payment::class.java)
                    intentToPayment.putExtra(MovieDetails.title, movieTitle2.text.toString())
                    intentToPayment.putExtra("image", img)
                    startActivity(intentToPayment)
            }
        }
    }
}