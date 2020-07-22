package com.keelim.aio.kotlin

import android.content.Context
import android.net.wifi.WifiManager
import android.os.Build

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

    constructor(open: OpenWifiBuilder) {
        context = open.context
        val wifi = context.applicationContext
            .getSystemService(Context.WIFI_SERVICE) as WifiManager
        if (open.WIFI_DHCP_INFO) WIFI_CONNECTION_INFO = wifi.connectionInfo.toString()
        if (open.WIFI_STATE) WIFI_STATE = wifi.wifiState.toString()
        if (open.WIFI_DHCP_INFO) WIFI_DHCP_INFO = wifi.dhcpInfo.toString()
    }

    constructor(open: OpenSystemBuilder) {
        context = open.context
        if (open.SYSTEM_RELEASE) SYSTEM_VERSION_CODENAME = Build.VERSION.RELEASE
        if (open.SYSTEM_SDK_INT) SYSTEM_SDK_INT = Build.VERSION.SDK_INT.toString()
        if (open.SYSTEM_VERSION_CODENAME) SYSTEM_VERSION_CODENAME = Build.VERSION.CODENAME
        if (open.SYSTEM_VERSION_INCREMENTAL) SYSTEM_VERSION_INCREMENTAL =
            Build.VERSION.INCREMENTAL
        if (open.SYSTEM_BOARD) SYSTEM_BOARD = Build.BOARD
        if (open.SYSTEM_BOOTLOADER) SYSTEM_BOOTLOADER = Build.BOOTLOADER
        if (open.SYSTEM_DEVICE) SYSTEM_DEVICE = Build.DEVICE
        if (open.SYSTEM_HARDWARE) SYSTEM_HARDWARE = Build.HARDWARE
        if (open.SYSTEM_MANUFACTURER) SYSTEM_MANUFACTURER = Build.MANUFACTURER
    }

    //Builder Class
    class OpenSystemBuilder(val context: Context) {

        // required parameters
        var SYSTEM_RELEASE = false
        var SYSTEM_SDK_INT = false
        var SYSTEM_VERSION_CODENAME = false
        var SYSTEM_VERSION_INCREMENTAL = false
        var SYSTEM_BOARD = false
        var SYSTEM_BOOTLOADER = false
        var SYSTEM_DEVICE = false
        var SYSTEM_HARDWARE = false
        var SYSTEM_MANUFACTURER = false
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
        var WIFI_STATE = false
        var WIFI_DHCP_INFO = false
        fun setWIFI_CONNECTION_INFO(WIFI_CONNECTION_INFO: Boolean): OpenWifiBuilder {
            this.WIFI_CONNECTION_INFO = WIFI_CONNECTION_INFO
            return this
        }

        fun setWIFI_STATE(WIFI_STATE: Boolean): OpenWifiBuilder {
            this.WIFI_STATE = WIFI_STATE
            return this
        }

        fun setWIFI_SSID(WIFI_SSID: Boolean): OpenWifiBuilder {
            WIFI_DHCP_INFO = WIFI_SSID
            return this
        }

        fun build(): Open {
            return Open(this)
        }

    }

    class OpenItem(// data model
        var sector: String, var desc: String?
    )
}