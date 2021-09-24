package com.kamjin.test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebDeployTestApplication

fun main(args: Array<String>) {
    runApplication<WebDeployTestApplication>(*args)
}
