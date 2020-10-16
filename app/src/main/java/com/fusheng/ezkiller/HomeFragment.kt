package com.fusheng.ezkiller

import com.fusheng.ezkiller.util.EzLog

class HomeFragment : BaseFragment() {

    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun onUserVisible() {
        super.onUserVisible()
        EzLog.d("Visible")
    }

    override fun onUserInvisible() {
        super.onUserInvisible()
        EzLog.d("Invisible")
    }

    override fun onFirstUserVisible() {
        super.onFirstUserVisible()
        EzLog.d("FirstUserVisible")
    }


    override fun onFirstUserInvisible() {
        super.onFirstUserInvisible()
        EzLog.d("onFirstUserInvisible")
    }
}