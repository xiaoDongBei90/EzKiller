package com.fusheng.ezkiller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //首页、体系、项目、我的
        //home system  project personal
        HomeFragment().abc()
    }
}