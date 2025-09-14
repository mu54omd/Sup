package com.mu54omd.sup

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform