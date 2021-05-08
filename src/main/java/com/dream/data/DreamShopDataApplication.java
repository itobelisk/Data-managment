package com.dream.data;

import com.dream.data.building.buildingparts.service.impl.BuildingPartServiceImpl;
import com.dream.data.building.floor.service.impl.FloorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@RequiredArgsConstructor
@EntityScan
@EnableJpaRepositories
@EnableJpaAuditing
@EnableEurekaClient
public class DreamShopDataApplication extends SpringBootServletInitializer implements CommandLineRunner {
    private final BuildingPartServiceImpl buildingPartService;
    private final FloorServiceImpl buildINgFloorServiceImpl;

    public static void main(String[] args) {
        SpringApplication.run(DreamShopDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        buildingPartService.addBuildingPart();
        buildINgFloorServiceImpl.addFloors();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DreamShopDataApplication.class);
    }
}
