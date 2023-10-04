package ua.hillel.springsecurityapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"ua.hillel.springsecurityapp.repo"})
public class SpringDataConfig {
}
