package com.example.uts_movieticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.uts_movieticket.databinding.ActivityHomePageBinding
import com.example.uts_movieticket.databinding.ActivityOrderSummaryBinding
import com.example.uts_movieticket.databinding.ActivityPaymentBinding

class OrderSummary : AppCompatActivity() {

    private lateinit var binding: ActivityOrderSummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderSummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainImageView = findViewById<ImageView>(R.id.moviePosterPlaceholder)
        val img = intent.getIntExtra("image", 0)
        if (img != 0) {
            mainImageView.setImageResource(img)
        }

        with(binding) {
            backButton2.setOnClickListener {
                val intentToHomePageActivity =
                    Intent(this@OrderSummary, HomePage::class.java)
                startActivity(intentToHomePageActivity)
            }
            val title = intent.getStringExtra("judul")
            val date = intent.getStringExtra("date")
            val bioskop = intent.getStringExtra("bioskop")
            val seat = intent.getStringExtra("seat")
            val paymentMode = intent.getStringExtra("paymentMode")
            val bank = intent.getStringExtra("bank")
            val harga = intent.getIntExtra("price", 0)
            val fee = intent.getIntExtra("fee", 0)


            titlePlaceholder.text = title
            datePlaceholder.text = date
            cinemaPlaceholder.text = bioskop
            orderSeatType.text = seat
            orderPaymentType.text = paymentMode
            orderPaymentSeatAmount.text = "Rp" + harga.toString()
            orderPaymentMethod.text =  bank
            orderConvenienceFeeAmount.text = "Rp" + fee.toString()
            orderTotalFeeAmount.text = "Rp" + (harga + fee).toString()
        }
    }
}