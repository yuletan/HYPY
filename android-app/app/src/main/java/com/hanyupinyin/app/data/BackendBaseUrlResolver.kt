package com.hanyupinyin.app.data

import android.os.Build
import com.hanyupinyin.BuildConfig

object BackendBaseUrlResolver {
    fun defaultBaseUrl(): String {
        return if (isProbablyEmulator()) {
            BuildConfig.EMULATOR_BACKEND_BASE_URL
        } else {
            BuildConfig.DEVICE_BACKEND_BASE_URL.ifBlank { BuildConfig.EMULATOR_BACKEND_BASE_URL }
        }
    }

    fun deviceLabel(): String = if (isProbablyEmulator()) "Android emulator" else "Physical device"

    fun hasPhysicalDeviceBaseUrl(): Boolean = BuildConfig.DEVICE_BACKEND_BASE_URL.isNotBlank()

    fun physicalDeviceBaseUrl(): String = BuildConfig.DEVICE_BACKEND_BASE_URL

    fun emulatorBaseUrl(): String = BuildConfig.EMULATOR_BACKEND_BASE_URL

    fun shouldUpgradeLegacyEmulatorUrl(savedBaseUrl: String): Boolean {
        return !isProbablyEmulator() &&
            hasPhysicalDeviceBaseUrl() &&
            savedBaseUrl == BuildConfig.EMULATOR_BACKEND_BASE_URL
    }

    private fun isProbablyEmulator(): Boolean {
        return Build.FINGERPRINT.startsWith("generic") ||
            Build.FINGERPRINT.lowercase().contains("emulator") ||
            Build.MODEL.contains("Emulator") ||
            Build.MODEL.contains("Android SDK built for") ||
            Build.MANUFACTURER.contains("Genymotion") ||
            (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) ||
            Build.PRODUCT == "google_sdk"
    }
}
