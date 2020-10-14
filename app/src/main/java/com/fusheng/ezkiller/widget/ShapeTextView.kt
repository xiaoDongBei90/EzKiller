package com.fusheng.ezkiller.widget

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatTextView
import com.fusheng.ezkiller.R
import java.util.jar.Attributes

/**
 * @Author: lixiaowei
 * @CreateDate: 2020/10/13 6:32 PM
 * @Description:设置shape作为背景给TextView,免除创建很多shape文件的烦恼
 */
class ShapeTextView(context: Context, private val attributes: AttributeSet?, defStyleAttr: Int) :
    AppCompatTextView(context, attributes, defStyleAttr) {

    constructor(context: Context) : this(context, null, 0)

    constructor(context: Context, attributes: AttributeSet?) : this(context, attributes, 0)

    /**
     * gradient填充颜色
     */
    private var solidColor: Int? = null

    /**
     * gradient按压颜色
     */
    private var pressColor: Int? = null

    /**
     * 圆角弧度
     */
    private var cornerRadius: Int? = null

    /**
     * 左上圆角弧度
     */
    private var leftTopRadius: Int? = null

    /**
     * 右上圆角弧度
     */
    private var rightTopRadius: Int? = null

    /**
     * 左下圆角弧度
     */
    private var leftBottomRadius: Int? = null

    /**
     * 右下圆角弧度
     */
    private var rightBottomRadius: Int? = null

    /**
     * 边框宽度
     */
    private var strokeWidth: Int? = null

    /**
     * 边框颜色
     */
    private var strokeColor: Int? = null

    /**
     * shape形状,0-矩形，1-椭圆形
     */
    private var shape: Int? = null
    private var gradientDrawable: GradientDrawable
    private lateinit var pressGradientDrawable: GradientDrawable

    init {
        obtainAttrs()
        gradientDrawable = GradientDrawable()
        if (pressColor != 0) {
            pressGradientDrawable = GradientDrawable()
        }
        //如果需要按压后变色，需要设置isClickable = true
        isClickable = true
    }

    private fun obtainAttrs() {
        val ta = context.obtainStyledAttributes(attributes, R.styleable.ShapeTextView)
        shape = ta.getInteger(R.styleable.ShapeTextView_shape, 0)
        solidColor = ta.getColor(R.styleable.ShapeTextView_solidColor, Color.TRANSPARENT)
        pressColor = ta.getColor(R.styleable.ShapeTextView_pressColor, Color.TRANSPARENT)
        cornerRadius = ta.getDimensionPixelSize(R.styleable.ShapeTextView_cornerRadius, 0)
        leftTopRadius = ta.getDimensionPixelSize(R.styleable.ShapeTextView_leftTopRadius, 0)
        rightTopRadius = ta.getDimensionPixelSize(R.styleable.ShapeTextView_rightTopRadius, 0)
        leftBottomRadius = ta.getDimensionPixelSize(R.styleable.ShapeTextView_leftBottomRadius, 0)
        rightBottomRadius = ta.getDimensionPixelSize(R.styleable.ShapeTextView_rightBottomRadius, 0)
        strokeWidth = ta.getDimensionPixelSize(R.styleable.ShapeTextView_strokeWidth, 0)
        strokeColor = ta.getColor(R.styleable.ShapeTextView_strokeColor, Color.TRANSPARENT)
        ta.recycle()
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        setBgSelector()
    }

    private fun setBgSelector() {
        val bg = StateListDrawable()
        setGradientAttr(gradientDrawable, solidColor!!)
        if (pressColor != 0) {
            setGradientAttr(pressGradientDrawable, pressColor!!)
            bg.addState(intArrayOf(android.R.attr.state_pressed), pressGradientDrawable)
        }
        bg.addState(intArrayOf(), gradientDrawable)
        background = bg
    }

    private fun setGradientAttr(gd: GradientDrawable, sc: Int) {
        gd.shape = shape!!
        gd.setColor(sc)
        if (cornerRadius != 0) {
            //如果同时设置全部圆角和指定某个圆角，优先全部圆角
            gd.cornerRadius = cornerRadius?.toFloat()!!
        } else {
            //依次为左上，右上，右底，左底的x/y值
            gd.cornerRadii = floatArrayOf(
                leftTopRadius?.toFloat()!!, leftTopRadius?.toFloat()!!,
                rightTopRadius?.toFloat()!!, rightTopRadius?.toFloat()!!,
                rightBottomRadius?.toFloat()!!, rightBottomRadius?.toFloat()!!,
                leftBottomRadius?.toFloat()!!, leftBottomRadius?.toFloat()!!
            )
        }
        gd.setStroke(strokeWidth!!, strokeColor!!)
    }
}