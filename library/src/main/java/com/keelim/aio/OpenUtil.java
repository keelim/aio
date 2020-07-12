package com.keelim.aio;

import android.content.Context;
import android.net.wifi.WifiManager;

import java.util.ArrayList;
import java.util.List;

public class OpenUtil {

    private List<String> plusArray(List<String>... arrays) {
        ArrayList<String> total = new ArrayList<>();
        if (arrays == null) return null;

        for (List<String> temp : arrays) {
            total.addAll(temp);
        }

        return total;
    }

    private List<OpenItem> makingStringArray(Context context, Open open, String s) { //open.SYStem, wifi, Build
        ArrayList<OpenItem> list = new ArrayList<>(); //todo 수정을 할 것

        switch (s) {
            case "System":
                if (open.SYSTEM_RELEASE != null)
                    list.add(new OpenItem("open.SYStem", s));

                if (open.SYSTEM_SDK_INT != null)
                    list.add(new OpenItem("open.SYStem", s));


                if (open.SYSTEM_VERSION_CODENAME != null)
                    list.add(new OpenItem("open.SYStem", s));

                if (open.SYSTEM_VERSION_INCREMENTAL != null)
                    list.add(new OpenItem("open.SYStem", s));

                if (open.SYSTEM_BOARD != null) list.add(new OpenItem("open.SYStem", s));

                if (open.SYSTEM_BOOTLOADER != null)
                    list.add(new OpenItem("open.SYStem", s));

                if (open.SYSTEM_DEVICE != null)
                    list.add(new OpenItem("open.SYStem", s));

                if (open.SYSTEM_HARDWARE != null)
                    list.add(new OpenItem("open.SYStem", s));

                if (open.SYSTEM_MANUFACTURER != null)
                    list.add(new OpenItem("open.SYStem", s));

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
