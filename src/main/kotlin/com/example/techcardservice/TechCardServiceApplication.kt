package com.example.techcardservice

import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.FeignAutoConfiguration

@EnableFeignClients
@SpringBootApplication
@ImportAutoConfiguration(FeignAutoConfiguration::class)
//@ComponentScan(basePackages = ["com.example.techcardservice"])
class TechCardServiceApplication

fun main(args: Array<String>) {
    runApplication<TechCardServiceApplication>(*args)
}
