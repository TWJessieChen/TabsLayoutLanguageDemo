package com.example.tabslayoutexample

import android.app.Application
import android.content.ContentResolver
import android.content.Context
import android.content.res.Configuration
import android.util.Log
import com.example.tabslayoutexample.utils.LocalManageUtils

/**
 * 自定义基础Application
 * @author llw
 */
class App : Application() {
    private val TAG = App::class.java.simpleName

    override fun attachBaseContext(base: Context) {
        //设置系统当前语言
        LocalManageUtils.setSystemCurrentLanguage(base)
        super.attachBaseContext(LocalManageUtils.setLocale(base))
        Log.d(TAG, "attachBaseContext")
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")

        //设置App的语言
        LocalManageUtils.setAppLanguage(this)

        appContentResolver = contentResolver

        appContext = applicationContext

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        //通过全局的上下文参数更改相关资源配置
        LocalManageUtils.onConfigurationChanged(applicationContext)
        Log.d(TAG, "onConfigurationChanged")
    }

    companion object {

        var appContentResolver: ContentResolver? = null
            private set
        var appContext: Context? = null

    }
}