package fylder.bookshop.demo.security

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
class UserAuthenticationProvider : AuthenticationProvider {

    internal var logger = LoggerFactory.getLogger(UserAuthenticationProvider::class.java)

    @Autowired
    private val detailsService: CustomUserDetailsService? = null

    @Throws(AuthenticationException::class)
    override fun authenticate(authentication: Authentication): Authentication? {
        val username = authentication.principal as String
        val userDetails: UserDetails? = detailsService!!.loadUserByUsername(username)
        return if (userDetails == null) {
            logger.info("登录用户不存在")
            null
        } else {
            if (userDetails.password == authentication.credentials) {
                UsernamePasswordAuthenticationToken(userDetails, authentication.credentials, userDetails.authorities)
            } else {
                logger.info("登录账号密码无效")
                null
            }
        }
    }

    override fun supports(authentication: Class<*>): Boolean {
        return true
    }
}
