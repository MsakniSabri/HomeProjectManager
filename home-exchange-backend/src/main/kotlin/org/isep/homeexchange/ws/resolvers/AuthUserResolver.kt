package org.isep.homeexchange.ws.resolvers

import org.isep.homeexchange.core.auth.JWTUtil
import org.isep.homeexchange.core.dto.UserDto
import org.isep.homeexchange.ws.annotations.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.MethodParameter
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebArgumentResolver.UNRESOLVED
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.util.WebUtils
import javax.servlet.http.HttpServletRequest

@Component
class AuthUserResolver : HandlerMethodArgumentResolver {

    @Autowired
    lateinit var jwtUtil: JWTUtil

    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.getParameterAnnotation(User::class.java) != null
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Any {
        if (parameter.parameterType == UserDto::class.java) {
            val servletRequest = webRequest.nativeRequest as HttpServletRequest

            val token = WebUtils.getCookie(servletRequest, "token")

            if (token?.value.isNullOrBlank()) {
                throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Missing token")
            }

            return jwtUtil.verify(token!!.value)
        }
        return UNRESOLVED
    }
}