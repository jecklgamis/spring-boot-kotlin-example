package springboot.kotlin.example.controller

import com.google.common.collect.ImmutableMap
import io.micrometer.core.annotation.Timed
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping(path = ["/"])
class RootController {

    @RequestMapping(path = ["/"], method = [GET], produces = ["application/json"])
    @Timed
    fun example(): Map<String, Any> {
        return ImmutableMap.builder<String, Any>()
                .put("message", "It works!")
                .put("today", LocalDateTime.now())
                .build();
    }
}
