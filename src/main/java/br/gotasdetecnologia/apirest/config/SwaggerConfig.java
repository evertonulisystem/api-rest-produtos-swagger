package br.gotasdetecnologia.apirest.config;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@ComponentScan
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
				.title("API REST")
				.description("Produtos Tecnológicos")
				.version("1.0")
				.license("Aprenda a Fazer")
				.licenseUrl("https://www.youtube.com/channel/UCv68KoK1bo2R44fGmcT1G2g")
				.build();					
	}
}
	
	