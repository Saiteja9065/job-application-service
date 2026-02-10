package com.ttbytes.job_application_service.implementation;

import com.ttbytes.job_application_service.model.Users;
import com.ttbytes.job_application_service.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminUserInitializer {

    @Bean
    public CommandLineRunner createAdmnUser(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (usersRepository.findUserByUsername("admin").isEmpty()) {
                Users admin = new Users("admin", "admin123", "ROLE_ADMIN");
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole("ROLE_ADMIN");

                usersRepository.save(admin);
                System.out.println("Default admin created");
            }
        };
    }
}


