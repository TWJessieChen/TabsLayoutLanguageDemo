package com.example.tabslayoutexample

import android.content.Context
import com.example.tabslayoutexample.utils.LocalManageUtils.setLocale
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar

/**
 * 基类Activity
 *
 * @author llw
 */
open class BaseActivity : AppCompatActivity() {
    private val TAG = BaseActivity::class.java.simpleName

    /**
     * 附加基础上下文
     * @param newBase 上下文参数
     */
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(setLocale(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        super.onCreate(savedInstanceState)
    }

    /**
     * 设置toolbar的左侧图标的点击事件
     *
     * @param toolbar
     */
    protected fun Back(toolbar: Toolbar) {
        toolbar.setNavigationOnClickListener { finish() }
    }
}