package springboot.kotlin.example


import org.eclipse.jetty.server.NetworkTrafficServerConnector
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class ExampleApp {

    @Bean
    open fun webServerFactory(@Value("\${server.http.port}") httpPort: Int): ConfigurableServletWebServerFactory {
        val factory = JettyServletWebServerFactory()
        factory.addServerCustomizers(JettyServerCustomizer { server ->
            val connector = NetworkTrafficServerConnector(server)
            connector.port = httpPort
            server.addConnector(connector)
        })
        return factory
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(ExampleApp::class.java, *args)
        }
    }

}

