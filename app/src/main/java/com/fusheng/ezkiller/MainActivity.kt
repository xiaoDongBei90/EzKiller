package com.fusheng.ezkiller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.widget_main_navigation_bar.*

class MainActivity : AppCompatActivity() {
    private var homeFragment: HomeFragment? = null
    private var systemFragment: SystemFragment? = null
    private var projectFragment: ProjectFragment? = null
    private var personalFragment: PersonalFragment? = null

    companion object {
        const val HOME_FRAGMENT_TAG = "home_fragment_tag"
        const val SYSTEM_FRAGMENT_TAG = "system_fragment_tag"
        const val PROJECT_FRAGMENT_TAG = "project_fragment_tag"
        const val PERSONAL_FRAGMENT_TAG = "personal_fragment_tag"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //首页、体系、项目、我的
        //home system  project personal
        switchFragment(HOME_FRAGMENT_TAG)
        initListener()
    }

    private fun initListener() {
        cl_home.setOnClickListener {
            switchFragment(HOME_FRAGMENT_TAG)
        }
        cl_system.setOnClickListener {
            switchFragment(SYSTEM_FRAGMENT_TAG)
        }
        cl_project.setOnClickListener {
            switchFragment(PROJECT_FRAGMENT_TAG)
        }
        cl_personal.setOnClickListener {
            switchFragment(PERSONAL_FRAGMENT_TAG)
        }
    }

    private fun switchFragment(tag: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        hideFragments(fragmentTransaction)
        navTvColorReset()
        navIvReset()
        when (tag) {
            HOME_FRAGMENT_TAG -> {
                if (homeFragment == null) {
                    homeFragment = HomeFragment()
                    fragmentTransaction.add(
                        R.id.fl_fragment_container,
                        homeFragment!!,
                        HOME_FRAGMENT_TAG
                    )
                } else {
                    fragmentTransaction.show(homeFragment!!)
                }
                tv_home.isSelected = true
                iv_home.isSelected = true
            }
            SYSTEM_FRAGMENT_TAG -> {
                if (systemFragment == null) {
                    systemFragment = SystemFragment()
                    fragmentTransaction.add(
                        R.id.fl_fragment_container,
                        systemFragment!!,
                        SYSTEM_FRAGMENT_TAG
                    )
                } else {
                    fragmentTransaction.show(systemFragment!!)
                }
                tv_system.isSelected = true
                iv_system.isSelected = true
            }
            PROJECT_FRAGMENT_TAG -> {
                if (projectFragment == null) {
                    projectFragment = ProjectFragment()
                    fragmentTransaction.add(
                        R.id.fl_fragment_container,
                        projectFragment!!,
                        PROJECT_FRAGMENT_TAG
                    )
                } else {
                    fragmentTransaction.show(projectFragment!!)
                }
                tv_project.isSelected = true
                iv_project.isSelected = true
            }
            PERSONAL_FRAGMENT_TAG -> {
                if (personalFragment == null) {
                    personalFragment = PersonalFragment()
                    fragmentTransaction.add(
                        R.id.fl_fragment_container,
                        personalFragment!!,
                        PERSONAL_FRAGMENT_TAG
                    )
                } else {
                    fragmentTransaction.show(personalFragment!!)
                }
                tv_personal.isSelected = true
                iv_personal.isSelected = true
            }
        }
        fragmentTransaction.commitAllowingStateLoss()
    }

    private fun hideFragments(t: FragmentTransaction) {
        homeFragment?.let { t.hide(it) }
        systemFragment?.let { t.hide(it) }
        projectFragment?.let { t.hide(it) }
        personalFragment?.let { t.hide(it) }
    }

    private fun navTvColorReset() {
        tv_home.isSelected = false
        tv_system.isSelected = false
        tv_project.isSelected = false
        tv_personal.isSelected = false
    }

    private fun navIvReset() {
        iv_home.isSelected = false
        iv_system.isSelected = false
        iv_project.isSelected = false
        iv_personal.isSelected = false
    }
}