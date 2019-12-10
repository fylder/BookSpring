package fylder.bookshop.demo.security

import fylder.bookshop.demo.dao.UserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class CustomUserDetailsService : UserDetailsService {

    @Autowired
    internal var userDao: UserDao? = null

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails? {

        val user: fylder.bookshop.demo.dao.bean.User? = userDao!!.findByUsername(username)
        return if (user != null) {
            val authorities = ArrayList<SimpleGrantedAuthority>()
            for (role in user.roles) {
                authorities.add(SimpleGrantedAuthority(role.role))// 需要加个前缀ROLE_,否者鉴权无效
            }
            User(user.username, user.password, authorities)
        } else {
            null
        }
    }
}
