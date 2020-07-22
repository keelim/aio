package com.keelim.aio.java;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class OpenUtil {

    @SafeVarargs
    public static List<Open.OpenItem> plusArray(List<Open.OpenItem>... arrays) {
        List<Open.OpenItem> total = new ArrayList<>();
        if (arrays == null) return null;

        for (List<Open.OpenItem> temp : arrays) {
            total.addAll(temp);
        }

        return total;
    }

    public static List<Open.OpenItem> addLicenseCode(@NotNull List<Open.OpenItem> open) {
        Open.OpenItem meta = new Open.OpenItem("Library Version", "1.0");
        open.add(meta);

        return open;
    }

    @Nullable
    public static List<Open.OpenItem> makingStringArray(@NotNull Open open) { //open.SYStem, wifi, Build
        List<Open.OpenItem> list = new ArrayList<>();

        if (open.SYSTEM_RELEASE != null) list.add(new Open.OpenItem("System", open.SYSTEM_RELEASE));

        if (open.SYSTEM_SDK_INT != null) list.add(new Open.OpenItem("System", open.SYSTEM_SDK_INT));


        if (open.SYSTEM_VERSION_CODENAME != null)
            list.add(new Open.OpenItem("System", open.SYSTEM_VERSION_CODENAME));

        if (open.SYSTEM_VERSION_INCREMENTAL != null)
            list.add(new Open.OpenItem("System", open.SYSTEM_VERSION_INCREMENTAL));

        if (open.SYSTEM_BOARD != null) list.add(new Open.OpenItem("System", open.SYSTEM_BOARD));

        if (open.SYSTEM_BOOTLOADER != null)
            list.add(new Open.OpenItem("System", open.SYSTEM_BOOTLOADER));

        if (open.SYSTEM_DEVICE != null) list.add(new Open.OpenItem("System", open.SYSTEM_DEVICE));

        if (open.SYSTEM_HARDWARE != null)
            list.add(new Open.OpenItem("System", open.SYSTEM_HARDWARE));

        if (open.SYSTEM_MANUFACTURER != null)
            list.add(new Open.OpenItem("System", open.SYSTEM_MANUFACTURER));

        if (open.WIFI_CONNECTION_INFO != null)
            list.add(new Open.OpenItem("WIFI", open.WIFI_CONNECTION_INFO));

        if (open.WIFI_STATE != null) list.add(new Open.OpenItem("WIFI", open.WIFI_STATE));

        if (open.WIFI_DHCP_INFO != null) list.add(new Open.OpenItem("WIFI", open.WIFI_DHCP_INFO));

        return list;
    }
}