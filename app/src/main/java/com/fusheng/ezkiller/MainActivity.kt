package com.fusheng.ezkiller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.widget_main_navigation_bar.*

class MainActivity : AppCompatActivity() {

    private val fragmentTransaction by lazy {
        supportFragmentManager.beginTransaction()
    }

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
        loadFirstFragment()
//        initListener()
    }

    private fun loadFirstFragment() {
        fragmentTransaction.add(R.id.fl_fragment_container, HomeFragment(), HOME_FRAGMENT_TAG)
            .commit()
    }

    private fun initListener() {
        cl_home.setOnClickListener {
            fragmentTransaction.add(R.id.fl_fragment_container, HomeFragment(), HOME_FRAGMENT_TAG)
                .commit()
        }
        cl_system.setOnClickListener {
            fragmentTransaction.add(
                R.id.fl_fragment_container,
                SystemFragment(),
                SYSTEM_FRAGMENT_TAG
            )
                .commit()
        }
        cl_project.setOnClickListener {
            fragmentTransaction.add(
                R.id.fl_fragment_container,
                ProjectFragment(),
                PROJECT_FRAGMENT_TAG
            )
                .commit()
        }
        cl_personal.setOnClickListener {
            fragmentTransaction.add(
                R.id.fl_fragment_container,
                PersonalFragment(),
                PERSONAL_FRAGMENT_TAG
            )
                .commit()
        }

    }


}