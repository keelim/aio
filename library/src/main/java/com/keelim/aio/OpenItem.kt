package com.keelim.aio

class OpenItem {
    constructor(sector: String?, desc: String?) {
        this.sector = sector
        this.desc = desc

    }

    constructor() {
        sector = null
        desc = null

    }

    var sector: String? = null
    var desc: String? = null

}