package fylder.bookshop.demo.dao.repository

import fylder.bookshop.demo.dao.bean.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long> {

    @Query(value = "select * from books where name = %:name%", nativeQuery = true)
    fun findByName(name: String): List<Book>
}