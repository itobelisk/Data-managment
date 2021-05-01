package com.dream.data;

import com.dream.data.building.buildingparts.service.impl.BuildingPartServiceImpl;
import com.dream.data.building.floor.service.impl.BuildINgFloorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@RequiredArgsConstructor
@EntityScan
@EnableJpaRepositories
@EnableJpaAuditing
public class DreamShopDataApplication implements CommandLineRunner {
    private final BuildingPartServiceImpl buildingPartService;
    private final BuildINgFloorServiceImpl buildINgFloorServiceImpl;

    public static void main(String[] args) {
        SpringApplication.run(DreamShopDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        buildingPartService.addBuildingPart();
        buildINgFloorServiceImpl.addFloors();
    }
}
