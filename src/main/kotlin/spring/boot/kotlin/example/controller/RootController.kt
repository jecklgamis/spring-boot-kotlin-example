package spring.boot.kotlin.example.controller

import io.micrometer.core.annotation.Timed
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RestController

@RestController
class RootController {
    @Value("\${application.name}")
    private val appName: String? = null

    @RequestMapping(path = ["/"], method = [GET], produces = ["application/json"])
    @Timed
    fun root(): Map<String, Any?> {
        return mapOf("name" to appName, "message" to "It works on my machine!")
    }
}
