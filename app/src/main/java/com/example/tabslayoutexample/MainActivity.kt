package com.example.tabslayoutexample

import android.widget.TextView
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.ImageView
import com.example.tabslayoutexample.utils.LocalManageUtils

/**
 * 主页面
 *
 * @author llw
 */
class MainActivity : BaseActivity(), View.OnClickListener {
    private var tvSystemLanguage //系统语言
            : TextView? = null
    private var tvCurrentLanguage //当前语言
            : TextView? = null
    private var tv_other_pages
            : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView = findViewById<ImageView>(R.id.iv_setting)
        val tvOtherPage = findViewById<TextView>(R.id.tv_other_pages)
        tvSystemLanguage = findViewById(R.id.tv_sys_language)
        tvCurrentLanguage = findViewById(R.id.tv_cur_language)
        tv_other_pages = findViewById(R.id.tv_other_pages)
        imageView.setOnClickListener(this)
        tvOtherPage.setOnClickListener(this)

    }

    override fun onResume() {
        super.onResume()

        LocalManageUtils.setAppLanguage(App.appContext!!)

        //系统语言
        tvSystemLanguage!!.setText(
            getString(R.string.system_language) +
                    LocalManageUtils.getSystemLocal(this).displayLanguage
        )

        //当前应用语言
        tvCurrentLanguage!!.setText(
            getString(R.string.current_language) +
                    LocalManageUtils.getSelectLanguage(this)
        )

        tv_other_pages!!.setText(getString(R.string.other_pages))

    }

    override fun onClick(v: View) {
        when (v.id) {
//            R.id.iv_setting -> goToActivity(SettingActivity::class.java)
            R.id.tv_other_pages -> goToActivity(TabsMainActivity::class.java)
            else -> {
            }
        }
    }

    /**
     * 跳转页面
     *
     * @param clazz 目标Activity
     */
    private fun goToActivity(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
    }
}