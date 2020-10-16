package com.fusheng.ezkiller

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlin.math.log

abstract class BaseFragment : Fragment() {

    private var isVisible: Boolean? = false
    private var isFirstVisible: Boolean? = true
    private var isFirstInvisible: Boolean? = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutRes(), null)
    }

    abstract fun getLayoutRes(): Int

    override fun onResume() {
        super.onResume()
        setVisibleToUser(true)
    }

    override fun onPause() {
        super.onPause()
        setVisibleToUser(false)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        setVisibleToUser(isVisibleToUser)
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        setVisibleToUser(!hidden)
    }

     private fun setVisibleToUser(isVisibleToUser: Boolean) {
        if (isVisibleToUser) {
            if (isVisible == false && checkVisible()) {
                if (isFirstVisible == true) {
                    isFirstVisible = false
                    onFirstUserVisible()
                } else {
                    onUserVisible()
                }
                isVisible = isVisibleToUser
            }
        } else {
            if (isVisible == true) {
                if (isFirstInvisible == true) {
                    isFirstInvisible = false
                    onFirstUserInvisible()
                } else {
                    onUserInvisible()
                }
            }
            isVisible = isVisibleToUser
        }
    }

     private fun checkVisible(): Boolean {
        var fragment = this.parentFragment
        while (fragment != null) {
            if (fragment.isHidden || !fragment.userVisibleHint) {
                return false
            }
            fragment = fragment.parentFragment
        }
        return !this.isHidden && this.userVisibleHint
    }

    /**
     * fragment对用户可见
     */
    open fun onUserVisible() {
    }

    /**
     * fragment对用户不可见
     */
    open fun onUserInvisible() {

    }

    /**
     * fragment对用户第一次可见
     */
    open fun onFirstUserVisible() {
        onUserVisible()
    }


    /**
     * fragment对用户第一次不可见
     */
    open fun onFirstUserInvisible() {
        onUserInvisible()
    }

}