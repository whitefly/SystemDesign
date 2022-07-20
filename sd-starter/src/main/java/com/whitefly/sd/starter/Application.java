package com.whitefly.sd.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhouang
 */
@SpringBootApplication(scanBasePackages = {"com.whitefly.sd"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
