package com.upscale.data

/**
 * Author: Michael Yu
 * Dept: CAAS
 * Team: Mooncake
 */
class User {
    // [tenant: [username: _user_, password: _pwd_], ]
    static Map merchants = [caastestqa: [username: 'li.jian@sap.com', password: 'Bamboo123'],
                            'caas-prod-qa1': [username: 'li.jian@sap.com', password: 'Bamboo1234'],]
    static Map customers = [caastestqa: [username: 'xxx@sap.com', password: 'xxx'],]
}
