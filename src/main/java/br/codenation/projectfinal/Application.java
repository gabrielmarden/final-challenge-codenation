package br.codenation.projectfinal;

import br.codenation.projectfinal.service.AuditorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class Application {
    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorService();
    }

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
