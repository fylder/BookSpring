package fylder.bookshop.demo.dao.repository

import fylder.bookshop.demo.dao.bean.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long>