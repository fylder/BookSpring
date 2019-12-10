package fylder.bookshop.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import springfox.documentation.annotations.ApiIgnore

@ApiIgnore
@Controller
class HomeController {

    @GetMapping("/")
    fun index(): String {
        return "index"
    }

    @GetMapping("/index")
    fun index2(): String {
        return "index"
    }

    /**
     * 登录页面
     */
    @GetMapping("/login")
    fun loginPage(): String {
        return "login"
    }

    /**
     * 注销页面
     */
    @GetMapping("/logout")
    fun logoutPage(): String {
        return "logout"
    }
}
