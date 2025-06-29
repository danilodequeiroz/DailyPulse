package com.petros.efthymiou.dailypulse

import platform.Foundation.NSLog
import platform.Foundation.version
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen


actual class Platform {
    actual val osName = UIDevice.currentDevice.systemName
    actual val osVersion = "${UIDevice.currentDevice.systemVersion} ${UIDevice.version()}"
    actual val deviceModel = "Apple ${UIDevice.currentDevice.model}"
    actual val density = UIScreen.mainScreen.scale.toFloat()
    actual val densityRound = UIScreen.mainScreen.scale.toInt()

    actual fun logSystemInfo(){
        NSLog(
            "Daily Pulse App Log -> $osName, $osVersion, $deviceModel, $density $densityRound"
        )
    }
}