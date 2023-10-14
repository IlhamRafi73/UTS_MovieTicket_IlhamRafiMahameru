package com.example.uts_movieticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.uts_movieticket.databinding.ActivityLoginPageBinding
import com.google.android.material.textfield.TextInputEditText

class LoginPage : AppCompatActivity() {

    private lateinit var binding: ActivityLoginPageBinding

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PASS = "extra_pass"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = arrayOf("FeryElas", "CarlJohnson", "Yanto", "YiLongMa")
        val pass = mapOf(
            user[0] to "1234",
            user[1] to "2341",
            user[2] to "3412",
            user[3] to "4123")

        fun isLoginValid(username: String, password: String): Boolean {
            val storedPassword = pass[username]
            return storedPassword != null && storedPassword == password
        }

        with(binding) {
            loginButton.setOnClickListener {
                val username = unameInput.text.toString()
                val password = passwordInput.text.toString()

                if (isLoginValid(username, password)) {
                    val intentToHomePageActivity =
                        Intent( this@LoginPage, HomePage::class.java)
                    intentToHomePageActivity.putExtra(LoginPage.EXTRA_NAME, unameInput.text.toString())
                    startActivity(intentToHomePageActivity)
                }
                else{
                    Toast.makeText(this@LoginPage, "Username atau Password tidak sesuai", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}