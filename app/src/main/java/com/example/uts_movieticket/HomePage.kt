package com.example.uts_movieticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_movieticket.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(LoginPage.EXTRA_NAME)

        with(binding){
            fetchUsername.text = name

            movie1.setOnClickListener {
                val intentToMovieDetailsActivity =
                    Intent(this@HomePage, MovieDetails::class.java)
                    intentToMovieDetailsActivity.putExtra("image", R.drawable.thecreator)
                startActivity(intentToMovieDetailsActivity)
            }
            movie2.setOnClickListener {
                val intentToMovieDetails2Activity =
                    Intent(this@HomePage, MovieDetails2::class.java)
                    intentToMovieDetails2Activity.putExtra("image", R.drawable.oppenheimer)
                startActivity(intentToMovieDetails2Activity)
            }
            movie3.setOnClickListener {
                val intentToMovieDetails3Activity =
                    Intent(this@HomePage, MovieDetails3::class.java)
                    intentToMovieDetails3Activity.putExtra("image", R.drawable.topgun)
                startActivity(intentToMovieDetails3Activity)
            }
        }
    }
}