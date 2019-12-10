package fylder.bookshop.demo.dao.bean

import javax.persistence.*
import java.io.Serializable

@Entity
@Table(name = "books")
class Book : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    @Column(name = "name")
    var name: String? = null
    @Column(name = "price")
    var price: String? = null

    constructor() {}

    constructor(name: String, price: String) {
        this.name = name
        this.price = price
    }
}
