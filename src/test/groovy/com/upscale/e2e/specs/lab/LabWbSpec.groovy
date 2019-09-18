package com.upscale.e2e.specs.lab

import com.upscale.data.SystemProperty

import com.upscale.e2e.wb.page.EditionsPage
import com.upscale.e2e.wb.page.LoginPage
import geb.spock.GebSpec

import static com.upscale.data.User.merchants
import static com.upscale.data.SystemProperty.tenant

/**
 * Author: Michael Yu
 * Dept: CAAS
 * Team: Mooncake
 */
class LabWbSpec extends GebSpec {
    def "log in"() {
        when: '''login'''
        to LoginPage
        login(merchants[(tenant)].username, merchants[(tenant)].password)
        then: '''at editions'''
        at EditionsPage
        when: '''to experiences'''
        tree_trigger.click()
        sleep 5000
//        view_trigger.click()
        entity_trigger.click()
        sleep 3000
        fake_click(entity_trigger)
//        interact {
//            moveToElement entity_trigger
//            click()
//        }
//        entity_trigger.click()
        sleep 1000
        header.experiences.click()
        sleep 5000
        then: ''''''
        true
    }
}
