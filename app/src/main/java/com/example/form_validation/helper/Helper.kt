package com.example.form_validation.helper

import android.text.TextUtils
import android.util.Patterns

class Helper {
    fun isValidEmail(target: CharSequence?): Boolean =
        !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target.toString()).matches()
}