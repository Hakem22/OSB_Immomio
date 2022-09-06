package com.example.OSB.configuration;

import com.example.OSB.entities.*;
import com.example.OSB.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CatalogRepository catalogRepository, ServiceRepository serviceRepository,
                                   BindingRepository bindingRepository, UserRepository userRepository) {

        Catalog catalog = new Catalog("mail-free-plan");
        Service service = new Service().setName("mail-service").setCatalog(catalog);
        Binding binding = new Binding("MailApplication", service);
        User user = new User("immomio", "immomio");

        return args -> {
            log.info("Loading user" + userRepository.save(user));
            log.info("Loading catalog" + catalogRepository.save(catalog));
            log.info("Loading a service " + serviceRepository.save(service));
            log.info("Loading a binding " + bindingRepository.save(binding));
        };
    }
}
