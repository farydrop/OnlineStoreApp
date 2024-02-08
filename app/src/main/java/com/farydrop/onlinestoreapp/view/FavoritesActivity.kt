package com.farydrop.onlinestoreapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.farydrop.onlinestoreapp.R

class FavoritesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, FavoritesFragment())
                .commit();

        }
    }
}