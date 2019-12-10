package fylder.bookshop.demo.bean


import com.fasterxml.jackson.databind.annotation.JsonSerialize
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@ApiModel(value = "Book", description = "书籍")
class Book {

    @ApiModelProperty("id")
    var id: Int = 0
    @ApiModelProperty("书籍名字")
    var name: String? = null

    @ApiModelProperty("价格")
    var price: Double = 0.toDouble()

    @ApiModelProperty("类型")
    var type: String? = null

    constructor() {}

    constructor(id: Int, name: String, price: Double) {
        this.id = id
        this.name = name
        this.price = price
    }
}
