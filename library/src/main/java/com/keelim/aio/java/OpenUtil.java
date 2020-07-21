package com.keelim.aio.java;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public  class OpenUtil {

        @SafeVarargs
        public static List<OpenItem> plusArray(List<OpenItem>... arrays) {
            List<OpenItem> total = new ArrayList<>();
            if (arrays == null) return null;

            for (List<OpenItem> temp : arrays) {
                total.addAll(temp);
            }

            OpenItem meta = new OpenItem("Library Version", "1.0");
            total.add(meta);


            return total;
        }

    @Nullable
    public static List<OpenItem> makingStringArray(Open open) { //open.SYStem, wifi, Build
        List<OpenItem> list = new ArrayList<>();

        if (open.SYSTEM_RELEASE != null)
            list.add(new OpenItem("System", open.SYSTEM_RELEASE));

        if (open.SYSTEM_SDK_INT != null)
            list.add(new OpenItem("System", open.SYSTEM_SDK_INT));


        if (open.SYSTEM_VERSION_CODENAME != null)
            list.add(new OpenItem("System", open.SYSTEM_VERSION_CODENAME));

        if (open.SYSTEM_VERSION_INCREMENTAL != null)
            list.add(new OpenItem("System", open.SYSTEM_VERSION_INCREMENTAL));

        if (open.SYSTEM_BOARD != null)
            list.add(new OpenItem("System", open.SYSTEM_BOARD));

        if (open.SYSTEM_BOOTLOADER != null)
            list.add(new OpenItem("System", open.SYSTEM_BOOTLOADER));

        if (open.SYSTEM_DEVICE != null)
            list.add(new OpenItem("System", open.SYSTEM_DEVICE));

        if (open.SYSTEM_HARDWARE != null)
            list.add(new OpenItem("System", open.SYSTEM_HARDWARE));

        if (open.SYSTEM_MANUFACTURER != null)
            list.add(new OpenItem("System", open.SYSTEM_MANUFACTURER));

        if (open.WIFI_CONNECTION_INFO != null)
            list.add(new OpenItem("WIFI", open.WIFI_CONNECTION_INFO));

        if (open.WIFI_STATE != null)
            list.add(new OpenItem("WIFI", open.WIFI_STATE));

        if (open.WIFI_DHCP_INFO != null)
            list.add(new OpenItem("WIFI", open.WIFI_DHCP_INFO));

        return list;
    }
}