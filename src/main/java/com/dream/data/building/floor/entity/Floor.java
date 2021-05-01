package com.dream.data.building.floor.entity;

import com.dream.data.base.BaseEntity;
import com.dream.data.building.entity.BuildingEntity;
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
@Table(name = "floor")
public class Floor extends BaseEntity {
    @OneToMany
    private List<BuildingEntity> buildingEntity;

    private Integer floors;

}
