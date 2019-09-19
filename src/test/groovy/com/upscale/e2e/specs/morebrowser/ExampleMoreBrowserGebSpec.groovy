package com.upscale.e2e.specs.morebrowser

import com.upscale.e2e.pwa.page.HomePage

/**
 * Author: Michael Yu
 * Dept: CAAS
 * Team: Mooncake
 */
class ExampleMoreBrowserGebSpec extends MoreBrowserGebSpec {
    void 'when submitting status in a separate browser window should appear in both browsers'() {
        given:
        HomePage homePageFirstBrowser = to(HomePage)

        when:
        withBrowserSession('second') {
            HomePage homePageSecondBrowser = to(HomePage)
            homePageSecondBrowser.submitStatus('Second browser')
        }

        then:
        waitFor { homePageFirstBrowser.findStatusFor('Second browser') }

        when:
        homePageFirstBrowser.submitStatus('First browser')

        then:
        withBrowserSession('second') {
            HomePage homePageSecondBrowser = browser.page
            waitFor { homePageSecondBrowser.findStatusFor('First browser') }
        }
    }
}
