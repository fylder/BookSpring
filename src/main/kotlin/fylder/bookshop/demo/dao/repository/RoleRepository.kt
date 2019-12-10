package fylder.bookshop.demo.dao.repository

import fylder.bookshop.demo.dao.bean.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : JpaRepository<Role, Long>