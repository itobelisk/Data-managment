package com.dream.data.building.buildingparts.entity;

import com.dream.data.base.BaseEntity;
import com.dream.data.building.entity.BuildingEntity;
import com.dream.data.building.floor.entity.Floor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "building_parts")
public class BuildingParts extends BaseEntity {
    @OneToMany
    private List<BuildingEntity> buildingEntity;

    private String buildingPartName;
}
