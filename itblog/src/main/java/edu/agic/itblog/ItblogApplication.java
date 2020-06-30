package edu.agic.itblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.agic.itblog.dao")
public class ItblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItblogApplication.class, args);
    }

}
