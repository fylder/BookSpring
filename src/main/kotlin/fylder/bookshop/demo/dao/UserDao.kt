package fylder.bookshop.demo.dao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import fylder.bookshop.demo.dao.bean.User
import fylder.bookshop.demo.dao.repository.UserRepository

@Service
class UserDao {

    @Autowired
    private val repository: UserRepository? = null

    fun findByUsername(username: String): User? {
        val data: List<User> = repository!!.findByUsername(username)
        return if (data.isNotEmpty()) {
            data[0]
        } else {
            null
        }
    }

    fun hasUser(username: String): Boolean {
        return repository!!.findByUsername(username).isNotEmpty()
    }

}
