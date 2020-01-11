package com.example.onetoone;

import com.example.onetoone.domain.Address;
import com.example.onetoone.domain.Customer;
import com.example.onetoone.repository.AddressRepository;
import com.example.onetoone.repository.CustomerRepository;
import com.example.onetoone.service.ICreateDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToOneApplication {
    @Autowired
   private ICreateDatabase iCreateDatabase;
    public static void main(String[] args) {
        SpringApplication.run(OneToOneApplication.class, args);
    }
    @Bean
    public CommandLineRunner runner(){
        return args -> {
            iCreateDatabase.createDatabase();

        };
    }

}
