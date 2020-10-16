package com.fusheng.ezkiller.util

import android.util.Log
import com.fusheng.ezkiller.BuildConfig

/**
 * @Author: lixiaowei
 * @CreateDate: 2020/10/16 5:34 PM
 * @Description:
 */
open class EzLog {

    companion object {
        private const val EZ_LOG_TAG = "ez_log_tag"


        fun d(msg: String) {
            if (BuildConfig.DEBUG) {
                Log.d(EZ_LOG_TAG, msg)
            }
        }

        fun d(tag: String, msg: String) {
            if (BuildConfig.DEBUG) {
                Log.d(tag, msg)
            }
        }

        fun e(msg: String) {
            if (BuildConfig.DEBUG) {
                Log.e(EZ_LOG_TAG, msg)
            }
        }

        fun e(tag: String, msg: String) {
            if (BuildConfig.DEBUG) {
                Log.e(tag, msg)
            }
        }
    }
}