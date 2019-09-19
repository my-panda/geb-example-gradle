package com.upscale.e2e.wb.page

import geb.Page

class LoginPage extends WbPage {

    static at = { title == "Login page" }
    static url = 'home'
    static content = {
        username { $("input#email") }
        password { $("input#password") }
        submit(to: EditionsPage, toWait: true) { $("input[type='submit']") }
        forget_password { $("a#forget_password")}
    }

    void login(name, pwd) {
        username = name
        password = pwd
        submit.click()
    }
}
