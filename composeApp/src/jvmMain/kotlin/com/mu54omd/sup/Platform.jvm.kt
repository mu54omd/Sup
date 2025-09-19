package com.mu54omd.sup

import java.awt.Toolkit

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class Platform actual constructor() {
    actual val osName: String
        get() = "${System.getProperty("os.name")} "
    actual val osVersion: String
        get() = "${System.getProperty("os.version")}"
    actual val deviceModel: String
        get() = "${System.getProperty("os.arch")}"
    actual val density: Int
        get() = Toolkit.getDefaultToolkit().screenResolution

}