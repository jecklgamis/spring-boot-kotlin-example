package springboot.kotlin.example.controller

import com.google.common.collect.ImmutableMap
import io.micrometer.core.annotation.Timed
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class RootController {
    @Value("\${application.name}")
    private val appName: String? = null

    @RequestMapping(path = ["/"], method = [GET], produces = ["application/json"])
    @Timed
    fun root(): Map<String, Any> {
        return ImmutableMap.builder<String, Any>()
                .put("name", appName)
                .put("java.version", System.getProperty("java.version"))
                .put("now", LocalDateTime.now())
                .build()
    }
}
