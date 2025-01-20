package br.com.rhssolutions.GDProjetos.domain.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GDProjetosDocumentacao {

    @Bean
    public OpenAPI openAPIGDProjeto() {
        return new OpenAPI()
                .info(new Info()
                        .title("GD Projetos")
                        .description("API para gerenciamento de projetos")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("RHS Solutions - Inovação e qualidade de software")
                                .email("rhssolutions@gmail.com")
                                .url("www.rhssolutions.com.br")))
                .servers(List.of(new Server()
                        .url("http://localhost:8080").description("Local server")
                ));
    }
}
