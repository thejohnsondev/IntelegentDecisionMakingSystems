package com.thejohnsondev.intelegentdecisionmakingsystems.common.util

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment

fun View.onClick(callback: () -> Unit) {
    this.setOnClickListener {
        callback.invoke()
    }
}

inline fun <reified T> Fragment.openActivity(bundle: Bundle? = null) {
    val intent = Intent(requireActivity(), T::class.java)
    bundle?.let {
        intent.putExtra(ARG_BUNDLE, it)
    }
    startActivity(intent)
}

fun Any.toLog(text: String? = null, errorMode: Boolean = false) {
    if (errorMode) {
        if (this is String) {
            Log.e(DEFAULT_TAG, this)
            return
        }
        text?.let {
            Log.e(DEFAULT_TAG, it)
            return
        }
    }
    if (this is String) {
        Log.d(DEFAULT_TAG, this)
        return
    }
    text?.let {
        Log.d(DEFAULT_TAG, it)
    }
}