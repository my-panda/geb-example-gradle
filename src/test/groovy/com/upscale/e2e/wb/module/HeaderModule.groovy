package com.upscale.e2e.wb.module

import com.upscale.e2e.wb.module.enums.HeaderTab
import geb.Module

/**
 * Author: Michael Yu
 * Dept: CAAS
 * Team: Mooncake
 */
class HeaderModule extends Module {

    static content = {
        tab_container { $("div.navbar-items") }
        tab { name -> tab_container.$('div.navbar-item-name', text: name)}

        experiences { tab(HeaderTab.Experiences.toString()) }
    }
}

