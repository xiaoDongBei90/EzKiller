package com.fusheng.ezkiller

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.PopupWindow

/**
 * @Author: lixiaowei
 * @CreateDate: 2020/10/22 1:06 PM
 * @Description:
 */
class SelectionsPopupWindow(context: Context) : PopupWindow(context) {

    init {
        contentView = LayoutInflater.from(context).inflate(R.layout.dialog_video_selections, null)
        height = ViewGroup.LayoutParams.MATCH_PARENT
        width = ViewGroup.LayoutParams.MATCH_PARENT
    }
}