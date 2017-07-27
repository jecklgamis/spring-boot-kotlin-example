package springboot.kotlin.example.controller

import com.google.common.collect.ImmutableMap
import org.joda.time.LocalDateTime
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = arrayOf("/"))
class RootController {

    @RequestMapping(path = arrayOf("/"), method = arrayOf(GET), produces = arrayOf("application/json"))
    fun example(): Map<String, Any> {
        return ImmutableMap.builder<String, Any>()
                .put("message", "Kotlin rocks!")
                .put("localDateTime", LocalDateTime.now())
                .build();
    }
}
