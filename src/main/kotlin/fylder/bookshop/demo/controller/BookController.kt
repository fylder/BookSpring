package fylder.bookshop.demo.controller

import fylder.bookshop.demo.bean.Book
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@Api(value = "书信息查询", description = "书籍基本信息操作", tags = ["Book Api"], consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("book")
@PreAuthorize("hasRole('USER') or hasRole('ADMIN')") //有ROLE_USER、ROLE_ADMIN其中一个权限的用户可以访问
class BookController {

    @ApiOperation(value = "get book", notes = "ahh")
    @GetMapping
    fun get(): Book {
        val book = Book()
        book.id = 1
        book.name = "古剑"
        return book
    }

    @ApiOperation(value = "query book", notes = "123")
    @GetMapping(value = ["/{id}"])
    fun getById(@PathVariable id: Int): Book {
        val book = Book()
        book.id = id
        book.name = "古剑三"
        return book
    }

    @Autowired
    @ApiOperation(value = "add book", notes = "321")
    @PostMapping
    fun post(): String {
        return "fylder"
    }

    @ApiOperation(value = "delete book", notes = "321")
    @DeleteMapping
    fun delete(): String {
        return "ahh"
    }
}
