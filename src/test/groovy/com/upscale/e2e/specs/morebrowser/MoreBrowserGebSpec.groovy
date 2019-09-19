package com.upscale.e2e.specs.morebrowser

import geb.Browser
import geb.spock.GebReportingSpec
import spock.lang.Stepwise

/**
 * Author: Michael Yu
 * Dept: CAAS
 * Team: Mooncake
 *
 * Currently in use.
 */
abstract class MoreBrowserGebSpec extends GebReportingSpec {
    protected Map<String, Browser> browserMap = [:]
    private Browser overrideBrowser = null

    /**
     * Run Geb commands in a separate browser window, creating it if necessary.
     *
     * @param browserId user-specified identifier string to reference this browser instance. If a browser with this ID
     *                  was used previously in the same test, will re-use it. Otherwise, will create a new browser.
     * @param c Closure with the code you want to execute in the separate browser.
     */
    void withBrowserSession(String browserId, Closure c) {
        if (!browserMap[browserId]) {
            Browser browser = createBrowser()
            // Disable browser caching so it will create another browser
            browser.config.cacheDriver = false

            browserMap[browserId] = browser
        }
        overrideBrowser = browserMap[browserId]
        c.call()
        overrideBrowser = null
    }

    @Override
    Browser getBrowser() {
        overrideBrowser ?: super.getBrowser()
    }

    void resetBrowsers() {
        browserMap.each { k, browser ->
            if (browser.config?.autoClearCookies) {
                browser.clearCookiesQuietly()
            }
            browser.close()
        }
        browserMap = [:]
    }

    private isSpecStepwise() {
        this.class.getAnnotation(Stepwise) != null
    }

    def cleanup() {
        if (!isSpecStepwise()) resetBrowsers()
    }

    def cleanupSpec() {
        if (isSpecStepwise()) resetBrowsers()
    }
}
