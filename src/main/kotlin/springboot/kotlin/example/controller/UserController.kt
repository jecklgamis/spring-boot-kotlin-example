package springboot.kotlin.example.controller

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RequestMethod.POST
import org.springframework.web.bind.annotation.RequestMethod.PUT
import org.springframework.web.bind.annotation.RestController
import springboot.kotlin.example.api.User
import java.util.UUID

@RestController
@RequestMapping(path = arrayOf("/user"))
open class UserController {

    @RequestMapping(path = arrayOf("/{id}"), method = arrayOf(GET), produces = arrayOf("application/json"))
    fun example(): User = User("me", "me@example.com")

    @RequestMapping(path = arrayOf("/{id}"), method = arrayOf(PUT, POST), produces = arrayOf("application/json"))
    fun put(@RequestBody user: User): String {
        println("Received $user");
        return UUID.randomUUID().toString();
    }

}
