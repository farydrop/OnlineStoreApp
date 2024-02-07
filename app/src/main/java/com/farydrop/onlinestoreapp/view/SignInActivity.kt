package com.farydrop.onlinestoreapp.view

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.text.method.DigitsKeyListener
import com.farydrop.onlinestoreapp.R
import com.farydrop.onlinestoreapp.databinding.ActivitySignInBinding
import com.google.android.material.textfield.TextInputEditText

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val clearIcon = getDrawable(R.drawable.ic_big_close)
        clearIcon?.setBounds(0, 0, clearIcon.intrinsicWidth, clearIcon.intrinsicHeight)
        //binding.tietFirstName.setCompoundDrawables(null, null, clearIcon, null)

        val setClearIcon = { editText: TextInputEditText ->
            editText.setOnTouchListener { _, event ->
                if (event.action == android.view.MotionEvent.ACTION_UP) {
                    if (event.rawX >= editText.right - (editText.compoundDrawables[2]?.bounds?.width()
                            ?: 0)
                    ) {
                        editText.text?.clear()
                        return@setOnTouchListener true
                    }
                }
                false
            }

            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    clearIcon?.let {
                        if (s.isNullOrEmpty()) {
                            // Скрываем крестик, если поле ввода пустое
                            editText.setCompoundDrawables(null, null, null, null)
                        } else {
                            // Показываем крестик, если поле ввода не пустое
                            editText.setCompoundDrawables(null, null, clearIcon, null)
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
                        editText.background.clearColorFilter()
                    } else {
                        editText.background.setColorFilter(
                            Color.parseColor("#ffb3b3"),
                            PorterDuff.Mode.SRC_ATOP
                        )
                    }
                }
            })
        }

        setClearIcon(binding.tietFirstName)
        setClearIcon(binding.tietLastName)

        binding.tietPhoneNumber.setOnTouchListener { _, event ->
            if (event.action == android.view.MotionEvent.ACTION_UP) {
                if (event.rawX >= binding.tietPhoneNumber.right - (binding.tietPhoneNumber.compoundDrawables[2]?.bounds?.width()
                        ?: 0)
                ) {
                    binding.tietPhoneNumber.text?.clear()
                    return@setOnTouchListener true
                }
            }
            false
        }

        binding.tietPhoneNumber.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus && binding.tietPhoneNumber.text?.isEmpty() == true) {
                binding.tietPhoneNumber.setText("+7")
            }
        }

        binding.tietPhoneNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                clearIcon?.let {
                    if (s.isNullOrEmpty()) {
                        // Скрываем крестик, если поле ввода пустое
                        binding.tietPhoneNumber.setCompoundDrawables(null, null, null, null)
                    } else {
                        // Показываем крестик, если поле ввода не пустое
                        binding.tietPhoneNumber.setCompoundDrawables(null, null, clearIcon, null)
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {
                val inputText = s.toString()
            }
        })
        binding.tietPhoneNumber.addTextChangedListener(PhoneNumberFormattingTextWatcher())

        binding.btPostOffer.setOnClickListener{
            startActivity(Intent(this@SignInActivity,HomeActivity::class.java))
            finish()
        }

    }

}