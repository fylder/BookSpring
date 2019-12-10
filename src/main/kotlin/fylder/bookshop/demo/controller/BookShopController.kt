package fylder.bookshop.demo.controller

import fylder.bookshop.demo.bean.Book
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.MediaType
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@Api(value = "书店息查询", description = "书店基本信息操作", tags = ["BookShop Api"], consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("bookshop")
@PreAuthorize("hasRole('ADMIN')")
class BookShopController {

    @ApiOperation(value = "get book", notes = "ahh")
    @GetMapping
    fun get(): Book {
        val book = Book()
        book.id = 1
        book.name = "烛龙"
        book.type = "古剑"
        return book
    }

    @ApiOperation(value = "query book", notes = "123")
    @GetMapping(value = ["/{id}"])
    @PreAuthorize("hasAnyRole('USER')")
    fun getById(@PathVariable id: Int): Book {
        val book = Book()
        book.id = id
        book.name = "古剑三"
        return book
    }

    @ApiOperation(value = "add book", notes = "321")
    @PostMapping
    fun post(): String {
        return "fylder"
    }
}
