package com.zkqueen.hmscore.application

import android.app.Application
import com.huawei.hms.ads.HwAds

class AdApplication :Application(){

    override fun onCreate() {
        super.onCreate()
        /* 初始化华为ad的广告能力 */
        HwAds.init(this)
    }

}