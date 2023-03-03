package com.cdd.self01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author cdd
 */
@MapperScan("com.cdd.self01.repository.mapper")
@SpringBootApplication
public class DatabaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }
}
