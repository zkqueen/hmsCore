package com.zkqueen.hmscore.application

import android.app.Application
import android.text.TextUtils
import android.util.Log
import com.huawei.hms.aaid.HmsInstanceId
import com.huawei.hms.common.ApiException


class AdApplication :Application(){

    override fun onCreate() {
        super.onCreate()
        /* 初始化华为ad的广告能力 */
//        HwAds.init(this)
        getToken()
    }

    private fun getToken() {
        // 创建一个新线程
        object : Thread() {
            override fun run() {
                try {
                    // 从agconnect-services.json文件中读取APP_ID
                    val appId = "your APP_ID"

                    // 输入token标识"HCM"
                    val tokenScope = "HCM"
                    val token =
                        HmsInstanceId.getInstance(this@AdApplication).getToken(appId, tokenScope)

                    // 判断token是否为空
                    if (!TextUtils.isEmpty(token)) {
                        Log.d(Companion.TAG, "run: $token")
                    }
                } catch (e: ApiException) {
                }
            }
        }.start()
    }

    companion object {
        private const val TAG = "AdApplication"
    }

}