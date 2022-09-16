package com.zkqueen.hmscore

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.huawei.hms.aaid.HmsInstanceId

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.getToken).setOnClickListener {

            getToken()
        }
    }


    private fun getToken() {
        // 创建一个新线程
        object : Thread() {
            override fun run() {
                try {
                    // 从agconnect-services.json文件中读取APP_ID
                    val appId = "107058391"
                    // 输入token标识"HCM"
                    val tokenScope = "HCM"
                    val token =
                        HmsInstanceId.getInstance(this@MainActivity).getToken(appId, tokenScope)

                    // 判断token是否为空
                    if (!TextUtils.isEmpty(token)) {
                        Log.e(MainActivity.TAG, "run: $token")
                    }
                } catch (e: Exception) {
                    Log.d(TAG, "run: ${e.toString()}")

                }
            }
        }.start()
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}