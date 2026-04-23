package com.hanyupinyin.app.data

import android.os.Build
import com.hanyupinyin.BuildConfig
import java.net.URI

object BackendBaseUrlResolver {
    fun defaultBaseUrl(): String {
        return BuildConfig.DEVICE_BACKEND_BASE_URL.ifBlank {
            BuildConfig.EMULATOR_BACKEND_BASE_URL.ifBlank {
                AppSettings.PRODUCTION_BACKEND_BASE_URL
            }
        }
    }

    fun deviceLabel(): String = if (isProbablyEmulator()) "Android emulator" else "Physical device"

    fun hasPhysicalDeviceBaseUrl(): Boolean = BuildConfig.DEVICE_BACKEND_BASE_URL.isNotBlank()

    fun physicalDeviceBaseUrl(): String = BuildConfig.DEVICE_BACKEND_BASE_URL

    fun emulatorBaseUrl(): String = BuildConfig.EMULATOR_BACKEND_BASE_URL

    fun shouldUseDefaultBaseUrl(savedBaseUrl: String): Boolean {
        val normalizedBaseUrl = savedBaseUrl.trim().trimEnd('/')
        val productionBaseUrl = AppSettings.PRODUCTION_BACKEND_BASE_URL

        return normalizedBaseUrl != productionBaseUrl && isLocalDevelopmentUrl(normalizedBaseUrl)
    }

    private fun isLocalDevelopmentUrl(baseUrl: String): Boolean {
        val host = runCatching { URI(baseUrl).host }.getOrNull()?.lowercase() ?: return false
        val octets = host.split('.').mapNotNull { it.toIntOrNull() }

        return host == "localhost" ||
            host == "10.0.2.2" ||
            host.startsWith("127.") ||
            host.startsWith("10.") ||
            host.startsWith("192.168.") ||
            (octets.size == 4 && octets[0] == 172 && octets[1] in 16..31)
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
