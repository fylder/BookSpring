package fylder.bookshop.demo.bean

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(value = "BookShop", description = "书店")
class BookShop {

    @ApiModelProperty("id")
    var id: Int = 0

    @ApiModelProperty("书店名字")
    var name: String? = null

    @ApiModelProperty("书店地址")
    var address: String? = null

    constructor() {}

    constructor(id: Int, name: String, address: String) {
        this.id = id
        this.name = name
        this.address = address
    }
}
