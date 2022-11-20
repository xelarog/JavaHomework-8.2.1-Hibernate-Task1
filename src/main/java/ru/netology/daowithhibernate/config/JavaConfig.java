package ru.netology.daowithhibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.daowithhibernate.repository.Repository;
import ru.netology.daowithhibernate.service.Service;

@Configuration
public class JavaConfig {

    @Bean
    public Service service(Repository repository) {
        return new Service(repository);
    }

    @Bean
    public Repository repository() {
        return new Repository();
    }

}
