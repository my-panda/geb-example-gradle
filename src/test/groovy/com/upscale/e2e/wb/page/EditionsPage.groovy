package com.upscale.e2e.wb.page

import com.upscale.e2e.BasePage
import com.upscale.e2e.wb.module.HeaderModule

/**
 * Author: Michael Yu
 * Dept: CAAS
 * Team: Mooncake
 */
class EditionsPage extends WbPage {
    static at = {
        tree_trigger
//        title = 'Caas Workbench'
//        currentUrl.endsWith(url)
    }
    static url = 'editions/manage'
    static content = {
        header { module(HeaderModule) }
        tree_trigger { $('button.caas-build-tree') }
        view_trigger { $('app-lens-selector div.quick-menu-trigger') }
        entity_trigger { $('app-entity-selector') }
    }
}
