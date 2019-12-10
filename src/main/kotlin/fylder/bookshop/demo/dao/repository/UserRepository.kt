package fylder.bookshop.demo.dao.repository

import fylder.bookshop.demo.dao.bean.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findByUsername(username: String): List<User>

}