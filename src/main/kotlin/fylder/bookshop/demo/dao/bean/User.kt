package fylder.bookshop.demo.dao.bean

import fylder.bookshop.demo.dao.bean.Role
import javax.persistence.*
import java.util.ArrayList

@Entity
@Table(name = "users")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @Column(name = "username")
    var username: String? = null
    @Column(name = "password")
    var password: String? = null

    @OneToMany(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var roles: Collection<Role> = ArrayList()

    constructor() {}

    constructor(username: String, password: String) {
        this.username = username
        this.password = password
    }
}
