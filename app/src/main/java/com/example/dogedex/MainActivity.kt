package com.example.dogedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dogedex.auth.LoginActivity
import com.example.dogedex.databinding.ActivityMainBinding
import com.example.dogedex.databinding.ActivitySettingsBinding
import com.example.dogedex.model.User
import com.example.dogedex.settings.SettingsActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.settingsFab.setOnClickListener {
            openSettingsActivity()
        }
        val user = User.getLoggedInUser(this)
        if (user == null) {
            openLoginActivity()
            return
        }
    }

    private fun openSettingsActivity() {
        startActivity(Intent(this, SettingsActivity::class.java))
    }

    private fun openLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}