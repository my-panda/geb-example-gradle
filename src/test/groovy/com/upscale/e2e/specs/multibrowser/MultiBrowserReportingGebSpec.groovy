package com.upscale.e2e.specs.multibrowser

import geb.report.ReporterSupport
import org.junit.Rule
import org.junit.rules.TestName
import spock.lang.Shared

/**
 * Author: Michael Yu
 * Dept: CAAS
 * Team: Mooncake
 *
 * Note: some potential bugs, not in use!
 */
abstract class MultiBrowserReportingGebSpec extends MultiBrowserGebSpec {
    // Ridiculous name to avoid name clashes
    @Rule TestName _gebReportingSpecTestName
    def _gebReportingPerTestCounter = 1
    @Shared _gebReportingSpecTestCounter = 1
    @Shared haveCleanedReportDir

    def cleanup() {
        report "end"
    }

    void report(String label = "") {
        if(!haveCleanedReportDir) {
            haveCleanedReportDir = true
            browser.cleanReportGroupDir()
        }
        def testClass = getClass()
        def baseReportName = ReporterSupport.toTestReportLabel(_gebReportingSpecTestCounter++, _gebReportingPerTestCounter++, _gebReportingSpecTestName.methodName, label)
        _browsers.each { key, browser ->
            browser.reportGroup testClass
            browser.report(baseReportName + "[$key]")
        }
    }
}
