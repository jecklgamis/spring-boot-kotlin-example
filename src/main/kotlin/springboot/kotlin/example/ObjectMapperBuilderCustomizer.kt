package springboot.kotlin.example

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.stereotype.Component

@Component
class ObjectMapperBuilderCustomizer : Jackson2ObjectMapperBuilderCustomizer {
    override fun customize(builder: Jackson2ObjectMapperBuilder) {
        builder.modules(JavaTimeModule())
    }
}
