package springboot.kotlin.example


import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ExampleApp {

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(ExampleApp::class.java, *args)
        }
    }

}

