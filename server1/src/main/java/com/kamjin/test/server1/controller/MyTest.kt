package com.kamjin.test.server1.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/server1/")
@RestController
class MyTest {

    @GetMapping("hello")
    fun hello(@RequestParam("str") str: String): String {
        println(str)
        return "$str test12121211"
    }
}