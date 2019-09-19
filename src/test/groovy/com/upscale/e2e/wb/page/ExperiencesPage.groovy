package com.upscale.e2e.wb.page

/**
 * Author: Michael Yu
 * Dept: CAAS
 * Team: Mooncake
 */
class ExperiencesPage extends WbPage {
    static at = { experience_list }
    static url = 'experiences/listing'
    static content = {
        experience_list { $('app-experience-listing') }
    }
}
