package com.upscale.e2e

import geb.Page

/**
 * Author: Michael Yu
 * Dept: CAAS
 * Team: Mooncake
 */
class BasePage extends Page {
    // fake click over an unclickable element
    def fake_click(element) {
        interact {
            moveToElement element
            click()
        }
    }
}
