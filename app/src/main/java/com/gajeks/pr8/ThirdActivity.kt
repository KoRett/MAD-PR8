package com.gajeks.pr8

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class ThirdActivity : AppCompatActivity(), ListFragment.OnFragmentSendDataListener {

    private val SELECTED_ITEM = "SELECTED_ITEM"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
    }

    override fun onSendData(data: String?) {
        val fragment = supportFragmentManager
            .findFragmentById(R.id.detailFragment) as DetailFragment?
        if (fragment != null && fragment.isVisible)
            fragment.setSelectedItem(data)
        else {
            val intent = Intent(
                applicationContext,
                DetailActivity::class.java
            )
            intent.putExtra(SELECTED_ITEM, data)
            startActivity(intent)
        }
    }
}