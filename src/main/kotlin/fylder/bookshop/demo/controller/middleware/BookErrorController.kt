package fylder.bookshop.demo.controller.middleware

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.ModelAndView

@ControllerAdvice
class AhhErrorController {

    internal var logger = LoggerFactory.getLogger(AhhErrorController::class.java)

    /**
     * 运行时异常
     */
    @ExceptionHandler(RuntimeException::class)
    fun processException(exception: RuntimeException): ModelAndView {
        logger.info("自定义异常处理-RuntimeException:${exception.message}")
        val page = ModelAndView()
        val msg = StringBuffer("error: ")
        if (exception.message.equals("不允许访问")) {
            val authentication = SecurityContextHolder.getContext().authentication
            val roleList = ArrayList<String>()
            authentication.authorities.forEach {
                roleList.add(it.authority)
            }
            msg.append("用户权限$roleList " + exception.message)
            page.status = HttpStatus.FORBIDDEN
        } else {
            msg.append(exception.message)
        }
        page.addObject("msg", msg.toString())
        page.viewName = "error"

        return page

    }

    /**
     * Exception异常
     */
    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.OK)
    fun processException(exception: Exception): ModelAndView {
        logger.info("自定义异常处理-Exception:${exception.message}")
        val page = ModelAndView()
        page.addObject("msg", "error2:" + exception.message)
        page.viewName = "error"
        return page

    }
}