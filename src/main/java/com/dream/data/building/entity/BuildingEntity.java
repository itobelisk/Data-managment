package com.dream.data.building.entity;

import com.dream.data.base.BaseEntity;
import com.dream.data.building.buildingparts.entity.BuildingParts;
import com.dream.data.building.floor.entity.Floor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "building_part_id", referencedColumnName = "id")
    private BuildingParts buildingParts;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "building_floor_id", referencedColumnName = "id")
    private Floor floor;


}
