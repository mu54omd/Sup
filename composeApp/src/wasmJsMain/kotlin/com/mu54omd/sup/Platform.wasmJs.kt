package com.mu54omd.sup

import kotlinx.browser.window
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class Platform actual constructor() {
    actual val osName: String
        get() = window.navigator.platform
    actual val osVersion: String
        get() = window.navigator.appVersion
    actual val deviceModel: String
        get() = window.navigator.appCodeName
    actual val density: Int
        get() = window.devicePixelRatio.toInt() * 96
}

