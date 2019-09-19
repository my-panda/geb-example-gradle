package com.upscale.e2e.specs.morebrowser

import com.upscale.e2e.pwa.page.HomePage
import com.upscale.e2e.wb.page.LoginPage

/**
 * Author: Michael Yu
 * Dept: CAAS
 * Team: Mooncake
 *
 * currently in use.
 */
class WbPwaMoreBrowserGebSpec extends MoreBrowserGebSpec {
    def 'both workbench and pwa'() {
        given: 'open workbench and pwa'
        to LoginPage
        withBrowserSession('pwa'){
            to HomePage
        }

        when: '''workbench: input username'''
        at LoginPage
        username = 'michael'
        sleep 5000
        then: '''pass'''
        true

        when: '''pwa: search'''
        withBrowserSession('pwa') {
            at HomePage
            search.click()
            sleep 5000
        }
        then: '''pass'''
        true
    }
}
