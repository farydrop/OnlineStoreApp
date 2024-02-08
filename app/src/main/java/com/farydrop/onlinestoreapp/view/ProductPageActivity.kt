package com.farydrop.onlinestoreapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.farydrop.onlinestoreapp.R

class ProductPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_page)
        if (savedInstanceState == null) {
            val fragment = ProductPageFragment()
            supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, fragment)
                .commit();

        }
    }
}