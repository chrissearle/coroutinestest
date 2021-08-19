package com.itera.coroutinestest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CoroutinesTestApplication

fun main(args: Array<String>) {
	runApplication<CoroutinesTestApplication>(*args)
}
