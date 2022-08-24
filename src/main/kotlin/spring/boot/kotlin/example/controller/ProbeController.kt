package spring.boot.kotlin.example.controller

import io.micrometer.core.annotation.Timed
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/probe"])
class ProbeController {

    @RequestMapping(path = ["/live"], method = [GET], produces = ["application/json"])
    @Timed
    fun live(): Map<String, Any> {
        return mapOf("message" to "I'm alive!")
    }

    @RequestMapping(path = ["/ready"], method = [GET], produces = ["application/json"])
    @Timed
    fun ready(): Map<String, Any> {
        return mapOf("message" to "I'm ready!")
    }
}
