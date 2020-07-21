package com.keelim.aio.java;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;

import org.jetbrains.annotations.NotNull;

public class Open { // Builder 패턴으로 구성을 할 것 일단은 시스템 정보만
    private final Context context;
    //SYSTEM
    public String SYSTEM_RELEASE = null;
    public String SYSTEM_SDK_INT = null;
    public String SYSTEM_VERSION_CODENAME = null;
    public String SYSTEM_VERSION_INCREMENTAL = null;
    public String SYSTEM_BOARD = null;
    public String SYSTEM_BOOTLOADER = null;
    public String SYSTEM_DEVICE = null;
    public String SYSTEM_HARDWARE = null;
    public String SYSTEM_MANUFACTURER = null;
    public String WIFI_CONNECTION_INFO = null;
    public String WIFI_STATE = null;
    public String WIFI_DHCP_INFO = null;


    public Open(@NotNull OpenWifiBuilder open) {
        context = open.context;
        WifiManager wifi = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (open.WIFI_DHCP_INFO) this.WIFI_CONNECTION_INFO = wifi.getConnectionInfo().toString();
        if (open.WIFI_STATE) this.WIFI_STATE = String.valueOf(wifi.getWifiState());
        if (open.WIFI_DHCP_INFO) this.WIFI_DHCP_INFO = String.valueOf(wifi.getDhcpInfo());
    }

    public Open(@NotNull OpenSystemBuilder open) {
        context = open.context;

        if (open.SYSTEM_RELEASE) this.SYSTEM_VERSION_CODENAME = Build.VERSION.RELEASE;
        if (open.SYSTEM_SDK_INT) this.SYSTEM_SDK_INT = String.valueOf(Build.VERSION.SDK_INT);
        if (open.SYSTEM_VERSION_CODENAME) this.SYSTEM_VERSION_CODENAME = Build.VERSION.CODENAME;
        if (open.SYSTEM_VERSION_INCREMENTAL) this.SYSTEM_VERSION_INCREMENTAL = Build.VERSION.INCREMENTAL;
        if (open.SYSTEM_BOARD) this.SYSTEM_BOARD = Build.BOARD;
        if (open.SYSTEM_BOOTLOADER) this.SYSTEM_BOOTLOADER = Build.BOOTLOADER;
        if (open.SYSTEM_DEVICE) this.SYSTEM_DEVICE = Build.DEVICE;
        if (open.SYSTEM_HARDWARE) this.SYSTEM_HARDWARE = Build.HARDWARE;
        if (open.SYSTEM_MANUFACTURER) this.SYSTEM_MANUFACTURER = Build.MANUFACTURER;
    }


    //Builder Class
    public static class OpenSystemBuilder {
        private final Context context;
        // required parameters
        private boolean SYSTEM_RELEASE;
        private boolean SYSTEM_SDK_INT;
        private boolean SYSTEM_VERSION_CODENAME;
        private boolean SYSTEM_VERSION_INCREMENTAL;
        private boolean SYSTEM_BOARD;
        private boolean SYSTEM_BOOTLOADER;
        private boolean SYSTEM_DEVICE;
        private boolean SYSTEM_HARDWARE;
        private boolean SYSTEM_MANUFACTURER;

        public OpenSystemBuilder(Context context) {
            this.context = context;
        }

        public OpenSystemBuilder setSYSTEM_RELEASE(boolean SYSTEM_RELEASE) {
            this.SYSTEM_RELEASE = SYSTEM_RELEASE;
            return this;
        }

        public OpenSystemBuilder setSYSTEM_SDK_INT(boolean SYSTEM_SDK_INT) {
            this.SYSTEM_SDK_INT = SYSTEM_SDK_INT;
            return this;
        }

        public OpenSystemBuilder setSYSTEM_VERSION_CODENAME(boolean SYSTEM_VERSION_CODENAME) {
            this.SYSTEM_VERSION_CODENAME = SYSTEM_VERSION_CODENAME;
            return this;
        }

        public OpenSystemBuilder setSYSTEM_VERSION_INCREMENTAL(boolean SYSTEM_VERSION_INCREMENTAL) {
            this.SYSTEM_VERSION_INCREMENTAL = SYSTEM_VERSION_INCREMENTAL;
            return this;
        }

        public OpenSystemBuilder setSYSTEM_BOARD(boolean SYSTEM_BOARD) {
            this.SYSTEM_BOARD = SYSTEM_BOARD;
            return this;
        }

        public OpenSystemBuilder setSYSTEM_BOOTLOADER(boolean SYSTEM_BOOTLOADER) {
            this.SYSTEM_BOOTLOADER = SYSTEM_BOOTLOADER;
            return this;
        }

        public OpenSystemBuilder setSYSTEM_DEVICE(boolean SYSTEM_DEVICE) {
            this.SYSTEM_DEVICE = SYSTEM_DEVICE;
            return this;
        }

        public OpenSystemBuilder setSYSTEM_HARDWARE(boolean SYSTEM_HARDWARE) {
            this.SYSTEM_HARDWARE = SYSTEM_HARDWARE;
            return this;
        }

        public OpenSystemBuilder setSYSTEM_MANUFACTURER(boolean SYSTEM_MANUFACTURER) {
            this.SYSTEM_MANUFACTURER = SYSTEM_MANUFACTURER;
            return this;
        }

        public Open build() {
            return new Open(this);
        }

    }

    public static class OpenWifiBuilder {
        private final Context context;
        private boolean WIFI_CONNECTION_INFO;
        private boolean WIFI_STATE;
        private boolean WIFI_DHCP_INFO;

        public OpenWifiBuilder(Context context) {
            this.context = context;
        }

        public OpenWifiBuilder setWIFI_CONNECTION_INFO(boolean WIFI_CONNECTION_INFO) {
            this.WIFI_CONNECTION_INFO = WIFI_CONNECTION_INFO;
            return this;
        }

        public OpenWifiBuilder setWIFI_STATE(boolean WIFI_STATE) {
            this.WIFI_STATE = WIFI_STATE;
            return this;
        }

        public OpenWifiBuilder setWIFI_SSID(boolean WIFI_SSID) {
            this.WIFI_DHCP_INFO = WIFI_SSID;
            return this;
        }

        public Open build() {
            return new Open(this);
        }
    }



}