package com.hanyupinyin.feature.upload

import android.content.Context
import android.net.wifi.WifiManager
import android.os.PowerManager
import android.util.Log

private const val LOG_TAG = "HanYuPinYinUpload"
private const val PARTIAL_WAKE_LOCK_TAG = "HanYuPinYin:AnalyzeImage"
private const val WIFI_LOCK_TAG = "HanYuPinYin:AnalyzeImageWifi"
private const val ANALYZE_WAKE_TIMEOUT_MS = 5 * 60 * 1000L

class AnalysisSleepGuard(
    context: Context,
) {
    private val appContext = context.applicationContext

    suspend fun <T> runKeepingDeviceAwake(block: suspend () -> T): T {
        val lockBundle = acquireLockBundle()
        return try {
            block()
        } finally {
            lockBundle.release()
        }
    }

    private fun acquireLockBundle(): LockBundle {
        val wakeLock = runCatching {
            val powerManager = appContext.getSystemService(Context.POWER_SERVICE) as? PowerManager
            powerManager
                ?.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, PARTIAL_WAKE_LOCK_TAG)
                ?.apply {
                    setReferenceCounted(false)
                    acquire(ANALYZE_WAKE_TIMEOUT_MS)
                }
        }.onFailure { error ->
            Log.w(LOG_TAG, "Could not acquire analyze wake lock.", error)
        }.getOrNull()

        val wifiLock = runCatching {
            val wifiManager = appContext.getSystemService(Context.WIFI_SERVICE) as? WifiManager
            wifiManager
                ?.createWifiLock(WifiManager.WIFI_MODE_FULL_HIGH_PERF, WIFI_LOCK_TAG)
                ?.apply {
                    setReferenceCounted(false)
                    acquire()
                }
        }.onFailure { error ->
            Log.w(LOG_TAG, "Could not acquire analyze Wi-Fi lock.", error)
        }.getOrNull()

        return LockBundle(
            wakeLock = wakeLock,
            wifiLock = wifiLock,
        )
    }
}

private data class LockBundle(
    val wakeLock: PowerManager.WakeLock?,
    val wifiLock: WifiManager.WifiLock?,
) {
    fun release() {
        runCatching {
            if (wifiLock?.isHeld == true) {
                wifiLock.release()
            }
        }.onFailure { error ->
            Log.w(LOG_TAG, "Could not release analyze Wi-Fi lock.", error)
        }

        runCatching {
            if (wakeLock?.isHeld == true) {
                wakeLock.release()
            }
        }.onFailure { error ->
            Log.w(LOG_TAG, "Could not release analyze wake lock.", error)
        }
    }
}
