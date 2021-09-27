package com.kamjin.test.server2.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/server2/")
@RestController
class MyTest {

    @GetMapping("world")
    fun world(@RequestParam("str") str: String): String {
        println(str)
        return "$str test11111"
    }
}