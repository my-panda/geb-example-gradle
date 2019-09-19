package com.upscale.e2e.specs.multibrowser

import com.upscale.e2e.pwa.page.HomePage
import com.upscale.e2e.wb.page.LoginPage

/**
 * Author: Michael Yu
 * Dept: CAAS
 * Team: Mooncake
 *
 * Note: some potential bugs with MultiBrowserReportingGebSpec, not in use!
 */
class WbPwaMultiBrowserGebSpec extends MultiBrowserReportingGebSpec {
    def 'both workbench and pwa'() {
        given: 'open workbench and pwa'
        withBrowserSession wb, {
            to LoginPage
        }
        withBrowserSession pwa, {
            to HomePage
        }

        when: '''workbench: input username'''
        withBrowserSession wb, {
            at LoginPage
            username = 'michael'
            sleep 5000
        }
        then: '''pass'''
        true

        when: '''pwa: search'''
        withBrowserSession pwa, {
            at HomePage
            search.click()
            sleep 5000
        }
        then: '''pass'''
        true
    }
}
