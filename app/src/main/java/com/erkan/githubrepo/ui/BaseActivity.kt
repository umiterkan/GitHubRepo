package com.erkan.githubrepo.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.erkan.githubrepo.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/**
 * Created by umiterkan on 1/5/2021
 */

abstract class BaseActivity : AppCompatActivity() {

    @get:LayoutRes
    abstract val layoutId:Int

    abstract fun initUI()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initUI()
    }


    fun alert(message: String?) {
            MaterialAlertDialogBuilder(this, R.style.AlertDialogTheme).apply {
                setMessage(message)
                setTitle(getString(R.string.info))
                setPositiveButton(getString(R.string.alert_info_ok_button), null)
                show()
            }
    }
}