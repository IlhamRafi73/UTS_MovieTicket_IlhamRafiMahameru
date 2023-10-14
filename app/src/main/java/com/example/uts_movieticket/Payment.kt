package com.example.uts_movieticket

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AdapterView
import com.example.uts_movieticket.databinding.ActivityPaymentBinding

class Payment : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding
    private lateinit var bioskop: Array<String>
    private lateinit var seat: Array<String>
    private lateinit var paymentMode: Array<String>
    private lateinit var selectBank: Array<String>
    val hargakursi = mapOf(
        "Regular Seat" to 35000,
        "Premium Seat" to 50000,
        "VIP Seat" to 100000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bioskop = resources.getStringArray(R.array.bioskop)
        seat = resources.getStringArray(R.array.seat)
        paymentMode = resources.getStringArray(R.array.transaksi)
        selectBank = resources.getStringArray(R.array.bank)

        with(binding){

            backButton.setOnClickListener{
                val intentToHomePageActivity =
                    Intent(this@Payment, HomePage::class.java)
                startActivity(intentToHomePageActivity)
            }

            val img = intent.getIntExtra("image", 0)

            val getJudul = intent.getStringExtra(MovieDetails.title)
            title.text = getJudul

            val adapterBioskop = ArrayAdapter(this@Payment, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, bioskop)
            adapterBioskop.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerBioskop.adapter = adapterBioskop

            val adapterSeat = ArrayAdapter(this@Payment, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, seat)
            adapterBioskop.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerSeat.adapter = adapterSeat

            val adapterPaymentMethod = ArrayAdapter(this@Payment, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, paymentMode)
            adapterBioskop.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerPaymentMode.adapter = adapterPaymentMethod

            val adapterBank = ArrayAdapter(this@Payment, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, selectBank)
            adapterBioskop.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerBankSelect.adapter = adapterBank

            spinnerSeat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                    val selectedSeat = seat[position]
                    val selectedPrice = hargakursi[selectedSeat]
                    val fee = 3000
                    val sum = fee + selectedPrice!!
                    seatType.text = selectedSeat
                    totalFee.text = "Rp$fee"
                    seatPrice.text = "Rp$selectedPrice"
                    actualPrice.text = "Rp$sum"
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    seatType.text = "Regular Seat"
                    seatPrice.text = "Rp35000"
                    actualPrice.text = "Rp35000"
                }
            }

            spinnerPaymentMode.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                    val selectedPaymentMode = paymentMode[position]
                    if (selectedPaymentMode == "Bank") {
                        bankSection.visibility = android.view.View.VISIBLE
                        spinnerBankSelect.visibility = android.view.View.VISIBLE
                        accNum.visibility = android.view.View.VISIBLE
                        cdBank.visibility = android.view.View.VISIBLE
                    }
                    else {
                        bankSection.visibility = android.view.View.GONE
                        spinnerBankSelect.visibility = android.view.View.GONE
                        accNum.visibility = android.view.View.GONE
                        cdBank.visibility = android.view.View.GONE
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }

                order.setOnClickListener {
                    val intent = Intent(this@Payment, OrderSummary::class.java)
                    val selectedBioskop = spinnerBioskop.selectedItem.toString()
                    val selectedSeat = spinnerSeat.selectedItem.toString()
                    val selectedPrice = hargakursi[selectedSeat]
                    val selectedDate = "${datePicker.dayOfMonth}-${datePicker.month + 1}-${datePicker.year}"
                    val selectedPaymentMode = spinnerPaymentMode.selectedItem.toString()
                    val selectedBank = spinnerBankSelect.selectedItem.toString()
                    val fee = 3000

                    intent.putExtra("judul", getJudul)
                    intent.putExtra("bioskop", selectedBioskop)
                    intent.putExtra("seat", selectedSeat)
                    intent.putExtra("price", selectedPrice)
                    intent.putExtra("date", selectedDate)
                    intent.putExtra("paymentMode", selectedPaymentMode)
                    intent.putExtra("bank", selectedBank)
                    intent.putExtra("image", img)
                    intent.putExtra("fee", fee)
                    startActivity(intent)
                }
            }
        }
    }