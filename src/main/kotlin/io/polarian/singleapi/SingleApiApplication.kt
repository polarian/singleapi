package io.polarian.singleapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SingleApiApplication

fun main(args: Array<String>) {
    runApplication<SingleApiApplication>(*args)
}
