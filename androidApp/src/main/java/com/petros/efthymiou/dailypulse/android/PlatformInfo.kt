package com.petros.efthymiou.dailypulse.android

import com.petros.efthymiou.dailypulse.Platform

object PlatformInfo {
    private val platform = Platform()

    fun operatingSystem() = Pair("Operating System", "${platform.osName} ${platform.osVersion}")
    fun device() = Pair("Device", platform.deviceModel)
    fun density() = Pair("Density", "${platform.density} dots per inch (dpi)")

    fun platformItems():List<Pair<String,String>>{
        return listOf(
            operatingSystem(),
            device(),
            density(),
        )
    }
}