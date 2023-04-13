package com.gajeks.pr8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gajeks.pr8.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)

        binding.codeFragment.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.xmlFragment.setOnClickListener {
            startActivity(Intent(this, MainActivityXML::class.java))
        }

        binding.fragmentInteraction.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        setContentView(binding.root)
    }
}