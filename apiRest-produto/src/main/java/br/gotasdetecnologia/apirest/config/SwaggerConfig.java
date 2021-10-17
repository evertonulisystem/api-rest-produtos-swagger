package br.gotasdetecnologia.apirest.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.gotasdetecnologia.apirest")) //pacote principal
				.paths(PathSelectors.regex("/api.*")) //caminho de acesso a API
				.build()
				.apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
		return new ApiInfoBuilder ()
				.title("EXEMPLO API REST")
				.description("Produtos de Tecnologia")
				.version("1.0")
				.license("Apache TomCat Versao 9.052")
				.licenseUrl("https://www.apache.org/license.html")
				.build();					
	}
}
	
	