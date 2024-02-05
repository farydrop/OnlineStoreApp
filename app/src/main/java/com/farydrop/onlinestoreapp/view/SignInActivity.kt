package com.farydrop.onlinestoreapp.view

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.farydrop.onlinestoreapp.R
import com.farydrop.onlinestoreapp.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val clearIcon = getDrawable(R.drawable.ic_big_close)
        clearIcon?.setBounds(0, 0, clearIcon.intrinsicWidth, clearIcon.intrinsicHeight)

        binding.tietFirstName.setOnTouchListener { _, event ->
            if (event.action == android.view.MotionEvent.ACTION_UP) {
                if (event.rawX >= binding.tietFirstName.right - binding.tietFirstName.compoundDrawables[2].bounds.width()) {
                    binding.tietFirstName.text?.clear()
                    return@setOnTouchListener true
                }
            }
            false
        }

        binding.tietFirstName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                clearIcon?.let {
                    if (s.isNullOrEmpty()) {
                        // Скрываем крестик, если поле ввода пустое
                        binding.tietFirstName.setCompoundDrawables(null, null, null, null)
                    } else {
                        // Показываем крестик, если поле ввода не пустое
                        binding.tietFirstName.setCompoundDrawables(null, null, clearIcon, null)
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {
                val inputText = s.toString()
                var isValid = true

                for (char in inputText) {
                    if (!char.isLetter() || char !in 'А'..'я') {
                        isValid = false
                        break
                    }
                }

                if (isValid) {
                    binding.tietFirstName.background.clearColorFilter()
                } else {
                    binding.tietFirstName.background.setColorFilter(Color.parseColor("#ffb3b3"), PorterDuff.Mode.SRC_ATOP)
                }
            }
        })

        //binding.tietFirstName.setCompoundDrawables(null, null, clearIcon, null)

    }
}