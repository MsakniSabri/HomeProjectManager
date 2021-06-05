package org.isep.homeexchange.config

import org.isep.homeexchange.ws.resolvers.AuthUserResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
@EnableWebMvc
class WebSecurityConfiguration : WebMvcConfigurer {

    @Bean
    fun authWebArgumentResolverFactory() : HandlerMethodArgumentResolver {
        return AuthUserResolver()
    }

    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        resolvers.add(authWebArgumentResolverFactory())
    }

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000", "http://localhost:8080", "http://localhost:4200")
            .allowCredentials(true)
    }

    @Bean
    fun encoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

}