package fylder.bookshop.demo.bean

class User {

    var username: String? = null

    var password: String? = null

    var roles: String? = null

    constructor() {}

    constructor(username: String, password: String) {
        this.username = username
        this.password = password
    }
}
