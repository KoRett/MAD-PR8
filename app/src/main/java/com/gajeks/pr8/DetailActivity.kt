package com.gajeks.pr8

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class DetailActivity : AppCompatActivity() {

    private val SELECTED_ITEM = "SELECTED_ITEM"
    private var selectedItem = "Не выбрано"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish()
            return
        }
        setContentView(R.layout.activity_detail)
        val extras = intent.extras
        if (extras != null) selectedItem = extras.getString(SELECTED_ITEM).toString()
    }

    override fun onResume() {
        super.onResume()
        val fragment = supportFragmentManager
            .findFragmentById(R.id.detailFragment) as DetailFragment?
        fragment?.setSelectedItem(selectedItem)
    }

}