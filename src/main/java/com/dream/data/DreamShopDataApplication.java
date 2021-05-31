package com.dream.data;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.constraints.NotNull;

@SpringBootApplication
@EnableEurekaClient
public class DreamShopDataApplication extends SpringBootServletInitializer {
//    private final BuildingPartServiceImpl buildingPartService;
//    private final FloorServiceImpl buildINgFloorServiceImpl;

    public static void main(String[] args) {
        SpringApplication.run(DreamShopDataApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        buildingPartService.addBuildingPart();
//        buildINgFloorServiceImpl.addFloors();
//    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NotNull org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DreamShopDataApplication.class);
    }
}
