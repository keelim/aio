package com.keelim.aio;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class OpenUtil {

    @SafeVarargs
    public static List<OpenItem> plusArray(List<OpenItem>... arrays) {
        ArrayList<OpenItem> total = new ArrayList<>();
        if (arrays == null) return null;

        for (List<OpenItem> temp : arrays) {
            total.addAll(temp);
        }

        OpenItem meta = new OpenItem("Library Version", "1.0");
        total.add(meta);


        return total;
    }

    @Nullable
    public static List<OpenItem> makingStringArray(Context context, Open open, @NotNull String s) { //open.SYStem, wifi, Build
        ArrayList<OpenItem> list = new ArrayList<>();

        switch (s) {
            case "System":
                if (open.SYSTEM_RELEASE != null)
                    list.add(new OpenItem("System", Build.VERSION.RELEASE));

                if (open.SYSTEM_SDK_INT != null)
                    list.add(new OpenItem("System", String.valueOf(Build.VERSION.SDK_INT)));


                if (open.SYSTEM_VERSION_CODENAME != null)
                    list.add(new OpenItem("System", Build.VERSION.CODENAME));

                if (open.SYSTEM_VERSION_INCREMENTAL != null)
                    list.add(new OpenItem("System", Build.VERSION.INCREMENTAL));

                if (open.SYSTEM_BOARD != null) list.add(new OpenItem("System", Build.BOARD));

                if (open.SYSTEM_BOOTLOADER != null)
                    list.add(new OpenItem("System", Build.BOOTLOADER));

                if (open.SYSTEM_DEVICE != null)
                    list.add(new OpenItem("System", Build.DEVICE));

                if (open.SYSTEM_HARDWARE != null)
                    list.add(new OpenItem("System", Build.HARDWARE));

                if (open.SYSTEM_MANUFACTURER != null)
                    list.add(new OpenItem("System", Build.MANUFACTURER));

                return list;

            case "WIFI":
                WifiManager wifi = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                if (open.WIFI_CONNECTION_INFO != null)
                    list.add(new OpenItem("WIFI", wifi.getConnectionInfo().toString()));

                if (open.WIFI_STATE != null)
                    list.add(new OpenItem("WIFI", String.valueOf(wifi.getWifiState())));

                if (open.WIFI_DHCP_INFO != null)
                    list.add(new OpenItem("WIFI", String.valueOf(wifi.getDhcpInfo())));

                return list;

            default:
                return null;
        }


    }


}
