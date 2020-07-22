package com.keelim.aio.kotlin

import java.util.*

object OpenUtil {
    @SafeVarargs
    fun plusArray(vararg arrays: List<Open.OpenItem>): List<Open.OpenItem>? {
        val total: MutableList<Open.OpenItem> = ArrayList()
        for (temp in arrays) {
            total.addAll(temp)
        }
        return total
    }

    fun addLicenseCode(open: MutableList<Open.OpenItem?>): List<Open.OpenItem?> {
        val meta =
            Open.OpenItem("Library Version", "1.0")
        open.add(meta)
        return open
    }

    fun makingStringArray(open: Open): List<Open.OpenItem>? { //open.SYStem, wifi, Build
        val list: MutableList<Open.OpenItem> =
            ArrayList()
        if (open.SYSTEM_RELEASE != null) list.add(
            Open.OpenItem("System", open.SYSTEM_RELEASE)
        )
        if (open.SYSTEM_SDK_INT != null) list.add(
            Open.OpenItem(
                "System",
                open.SYSTEM_SDK_INT
            )
        )
        if (open.SYSTEM_VERSION_CODENAME != null) list.add(
            Open.OpenItem(
                "System",
                open.SYSTEM_VERSION_CODENAME
            )
        )
        if (open.SYSTEM_VERSION_INCREMENTAL != null) list.add(
            Open.OpenItem(
                "System",
                open.SYSTEM_VERSION_INCREMENTAL
            )
        )
        if (open.SYSTEM_BOARD != null) list.add(
            Open.OpenItem(
                "System",
                open.SYSTEM_BOARD
            )
        )
        if (open.SYSTEM_BOOTLOADER != null) list.add(
            Open.OpenItem(
                "System",
                open.SYSTEM_BOOTLOADER
            )
        )
        if (open.SYSTEM_DEVICE != null) list.add(
            Open.OpenItem(
                "System",
                open.SYSTEM_DEVICE
            )
        )
        if (open.SYSTEM_HARDWARE != null) list.add(
            Open.OpenItem(
                "System",
                open.SYSTEM_HARDWARE
            )
        )
        if (open.SYSTEM_MANUFACTURER != null) list.add(
            Open.OpenItem(
                "System",
                open.SYSTEM_MANUFACTURER
            )
        )
        if (open.WIFI_CONNECTION_INFO != null) list.add(
            Open.OpenItem(
                "WIFI",
                open.WIFI_CONNECTION_INFO
            )
        )
        if (open.WIFI_STATE != null) list.add(
            Open.OpenItem(
                "WIFI",
                open.WIFI_STATE
            )
        )
        if (open.WIFI_DHCP_INFO != null) list.add(
            Open.OpenItem(
                "WIFI",
                open.WIFI_DHCP_INFO
            )
        )
        return list
    }
}