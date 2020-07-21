package com.keelim.aio.kotlin

import android.content.Context
import android.net.wifi.WifiManager
import android.os.Build
import java.util.*

class Open {
    // Builder 패턴으로 구성을 할 것 일단은 시스템 정보만
    private val context: Context

    //SYSTEM
    var SYSTEM_RELEASE: String? = null
    var SYSTEM_SDK_INT: String? = null
    var SYSTEM_VERSION_CODENAME: String? = null
    var SYSTEM_VERSION_INCREMENTAL: String? = null
    var SYSTEM_BOARD: String? = null
    var SYSTEM_BOOTLOADER: String? = null
    var SYSTEM_DEVICE: String? = null
    var SYSTEM_HARDWARE: String? = null
    var SYSTEM_MANUFACTURER: String? = null
    var WIFI_CONNECTION_INFO: String? = null
    var WIFI_STATE: String? = null
    var WIFI_DHCP_INFO: String? = null

    constructor(openWifiBuilder: OpenWifiBuilder) {
        context = openWifiBuilder.context
    }

    constructor(openSystemBuilder: OpenSystemBuilder) {
        context = openSystemBuilder.context
    }

    //Builder Class
    class OpenSystemBuilder(val context: Context) {

        // required parameters
        private var SYSTEM_RELEASE = false
        private var SYSTEM_SDK_INT = false
        private var SYSTEM_VERSION_CODENAME = false
        private var SYSTEM_VERSION_INCREMENTAL = false
        private var SYSTEM_BOARD = false
        private var SYSTEM_BOOTLOADER = false
        private var SYSTEM_DEVICE = false
        private var SYSTEM_HARDWARE = false
        private var SYSTEM_MANUFACTURER = false
        fun setSYSTEM_RELEASE(SYSTEM_RELEASE: Boolean): OpenSystemBuilder {
            this.SYSTEM_RELEASE = SYSTEM_RELEASE
            return this
        }

        fun setSYSTEM_SDK_INT(SYSTEM_SDK_INT: Boolean): OpenSystemBuilder {
            this.SYSTEM_SDK_INT = SYSTEM_SDK_INT
            return this
        }

        fun setSYSTEM_VERSION_CODENAME(SYSTEM_VERSION_CODENAME: Boolean): OpenSystemBuilder {
            this.SYSTEM_VERSION_CODENAME = SYSTEM_VERSION_CODENAME
            return this
        }

        fun setSYSTEM_VERSION_INCREMENTAL(SYSTEM_VERSION_INCREMENTAL: Boolean): OpenSystemBuilder {
            this.SYSTEM_VERSION_INCREMENTAL = SYSTEM_VERSION_INCREMENTAL
            return this
        }

        fun setSYSTEM_BOARD(SYSTEM_BOARD: Boolean): OpenSystemBuilder {
            this.SYSTEM_BOARD = SYSTEM_BOARD
            return this
        }

        fun setSYSTEM_BOOTLOADER(SYSTEM_BOOTLOADER: Boolean): OpenSystemBuilder {
            this.SYSTEM_BOOTLOADER = SYSTEM_BOOTLOADER
            return this
        }

        fun setSYSTEM_DEVICE(SYSTEM_DEVICE: Boolean): OpenSystemBuilder {
            this.SYSTEM_DEVICE = SYSTEM_DEVICE
            return this
        }

        fun setSYSTEM_HARDWARE(SYSTEM_HARDWARE: Boolean): OpenSystemBuilder {
            this.SYSTEM_HARDWARE = SYSTEM_HARDWARE
            return this
        }

        fun setSYSTEM_MANUFACTURER(SYSTEM_MANUFACTURER: Boolean): OpenSystemBuilder {
            this.SYSTEM_MANUFACTURER = SYSTEM_MANUFACTURER
            return this
        }

        fun build(): Open {
            return Open(this)
        }

    }

    class OpenWifiBuilder(val context: Context) {
        private var WIFI_CONNECTION_INFO = false
        private var WIFI_LINK_SPEED_UNITS = false
        private var WIFI_SSID = false
        fun setWIFI_CONNECTION_INFO(WIFI_CONNECTION_INFO: Boolean): OpenWifiBuilder {
            this.WIFI_CONNECTION_INFO = WIFI_CONNECTION_INFO
            return this
        }

        fun setWIFI_LINK_SPEED_UNITS(WIFI_LINK_SPEED_UNITS: Boolean): OpenWifiBuilder {
            this.WIFI_LINK_SPEED_UNITS = WIFI_LINK_SPEED_UNITS
            return this
        }

        fun setWIFI_SSID(WIFI_SSID: Boolean): OpenWifiBuilder {
            this.WIFI_SSID = WIFI_SSID
            return this
        }

        fun build(): Open {
            return Open(this)
        }

    }

    object OpenUtil {
        @SafeVarargs
        fun plusArray(vararg arrays: List<OpenItem>): List<OpenItem>? {
            val total = ArrayList<OpenItem>()

            for (temp in arrays) {
                total.addAll(temp)
            }
            val meta = OpenItem("Library Version", "1.0")
            total.add(meta)
            return total
        }

        fun makingStringArray(context: Context, open: Open, s: String): List<OpenItem>? { //open.SYStem, wifi, Build
            val list = ArrayList<OpenItem>()
            return when (s) {
                "System" -> {
                    if (open.SYSTEM_RELEASE != null) list.add(OpenItem("System", Build.VERSION.RELEASE))
                    if (open.SYSTEM_SDK_INT != null) list.add(OpenItem("System", Build.VERSION.SDK_INT.toString()))
                    if (open.SYSTEM_VERSION_CODENAME != null) list.add(OpenItem("System", Build.VERSION.CODENAME))
                    if (open.SYSTEM_VERSION_INCREMENTAL != null) list.add(OpenItem("System", Build.VERSION.INCREMENTAL))
                    if (open.SYSTEM_BOARD != null) list.add(OpenItem("System", Build.BOARD))
                    if (open.SYSTEM_BOOTLOADER != null) list.add(OpenItem("System", Build.BOOTLOADER))
                    if (open.SYSTEM_DEVICE != null) list.add(OpenItem("System", Build.DEVICE))
                    if (open.SYSTEM_HARDWARE != null) list.add(OpenItem("System", Build.HARDWARE))
                    if (open.SYSTEM_MANUFACTURER != null) list.add(OpenItem("System", Build.MANUFACTURER))

                    return list
                }
                "WIFI" -> {
                    val wifi = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
                    if (open.WIFI_CONNECTION_INFO != null) list.add(OpenItem("WIFI", wifi.connectionInfo.toString()))
                    if (open.WIFI_STATE != null) list.add(OpenItem("WIFI", wifi.wifiState.toString()))
                    if (open.WIFI_DHCP_INFO != null) list.add(OpenItem("WIFI", wifi.dhcpInfo.toString()))

                    return list
                }
                else -> return emptyList()
            }
        }
    }
}