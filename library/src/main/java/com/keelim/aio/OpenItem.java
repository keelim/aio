package com.keelim.aio;

public class OpenItem {
    private String sector;
    private String desc;

    public OpenItem(String sector, String desc) {
        this.sector = sector;
        this.desc = desc;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
