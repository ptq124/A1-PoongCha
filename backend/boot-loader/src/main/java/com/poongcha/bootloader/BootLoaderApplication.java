package com.poongcha.bootloader;

import com.poongcha.car.CarApplication;
import com.poongcha.recommend.RecommendApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackages = "com.poongcha.*")
public class BootLoaderApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .parent(BootLoaderApplication.class)
                .child(CarApplication.class, RecommendApplication.class)
                .run(args);
    }

}
