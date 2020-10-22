package com.fusheng.ezkiller

import android.view.Gravity
import com.fusheng.ezkiller.util.EzLog
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {
    override fun initView() {


    }

    override fun initListener() {
        stv.setOnClickListener {
//            showDialog()
        }
    }

    private fun showDialog() {
        val selectionsDialog = SelectionsPopupWindow(requireContext())
        selectionsDialog.showAtLocation(activity?.window?.decorView, Gravity.BOTTOM, 0, 0)
    }

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