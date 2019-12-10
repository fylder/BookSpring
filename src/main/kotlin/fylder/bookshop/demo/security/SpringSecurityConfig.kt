package fylder.bookshop.demo.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SpringSecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    internal var authenticationProvider: UserAuthenticationProvider? = null

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        super.configure(http)

//        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().authorizeRequests()
        http.authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .anyRequest().fullyAuthenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll()

        http.headers().cacheControl()
    }

    @Autowired
    fun ahh(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(authenticationProvider)
    }

}
