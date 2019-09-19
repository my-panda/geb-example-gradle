package com.upscale.e2e.pwa.page

/**
 * Author: Michael Yu
 * Dept: CAAS
 * Team: Mooncake
 */
class HomePage extends PwaPage {
//    static at = { title == 'Upscale Commerce Web Application' }
    static at = { search }
    static url = 'http://localhost:4200/' //'https://jlee-test.cfapps.us10.hana.ondemand.com/'
    static content = {
//        account { $("a[href='/account']") }
        search(wait: 30) { $('a', text: contains('Search')) }
    }
}
