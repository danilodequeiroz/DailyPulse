package com.petros.efthymiou.dailypulse

import android.content.res.Resources
import android.os.Build
import android.util.Log
import kotlin.math.round

actual class Platform {
   actual val osName = "Android"
    actual val osVersion = "API Level: ${Build.VERSION.SDK_INT}"
    actual val deviceModel = "Manufacturer: ${Build.MANUFACTURER} Model: ${Build.MODEL}"
    actual val density = Resources.getSystem().displayMetrics.density
    actual val densityRound = round(Resources.getSystem().displayMetrics.density).toInt()

    actual fun logSystemInfo(){
        Log.d(
             "Daily Pulse App Log",
            "$osName $osVersion $deviceModel $density $densityRound"
        )
    }
}