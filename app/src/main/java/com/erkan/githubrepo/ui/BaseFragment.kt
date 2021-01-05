package com.erkan.githubrepo.ui

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.erkan.githubrepo.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import timber.log.Timber


/**
 * Created by umiterkan on 1/2/2021
 */
abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    abstract fun initUI()
    abstract fun observe()
    abstract fun fetch()
    abstract fun listener()
    abstract fun initialize()

    abstract val layoutId: Int

    open var binding: T? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView")
        binding = DataBindingUtil.inflate(inflater, layoutId, container!!, false)
        initialize()
        binding?.lifecycleOwner=viewLifecycleOwner
        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Timber.d("onActivityCreated")
        super.onActivityCreated(savedInstanceState)
        initUI()
        listener()
        observe()
        fetch()
    }



    open fun hideKeyboard(view: View?) {
        activity?.let { activity ->
            view?.let { view ->
                val imm =
                    activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }
}