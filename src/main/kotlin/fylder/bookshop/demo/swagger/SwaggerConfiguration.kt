package fylder.bookshop.demo.swagger

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import springfox.documentation.RequestHandler
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.*
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket
import java.util.*

@Configuration
class SwaggerConfiguration {

    @Bean
    fun createRestApi(): Docket {
        return Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(apiSelector())
                .paths(PathSelectors.any())
                .build()
                .securityContexts(securityContexts())
                .securitySchemes(securitySchemes())
    }

    private fun apiInfo(): ApiInfo? {
        return ApiInfoBuilder()
                .title("bookshop api")
                .description("看看这里有什么")
                .contact(Contact("fylder", "https://www.fylder.me", ""))
                .version("1.0")
                .build()
    }

    //指定包名
    private fun apiSelector(): java.util.function.Predicate<RequestHandler> {
        return RequestHandlerSelectors.basePackage("fylder.bookshop.demo.controller")
    }

    //header: Authorization
    private fun securitySchemes(): List<SecurityScheme> {
        val authorization = ApiKey(HttpHeaders.AUTHORIZATION, "apiKey", "header")
        return arrayListOf(authorization)
    }


    private fun securityContexts(): List<SecurityContext> {
        val securityContext = SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build()
        return arrayListOf(securityContext)
    }

    private fun defaultAuth(): List<SecurityReference> {
        val result: MutableList<SecurityReference> = ArrayList()
        val authorizationScope = AuthorizationScope("global", "accessEverything")
        val authorizationScopes = arrayOfNulls<AuthorizationScope>(1)
        authorizationScopes[0] = authorizationScope
        result.add(SecurityReference("Authorization", authorizationScopes))
        return result
    }

}
