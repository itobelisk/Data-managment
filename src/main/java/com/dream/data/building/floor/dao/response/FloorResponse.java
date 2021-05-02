package com.dream.data.building.floor.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FloorResponse {
    private Long id;
    private Date createdDate;
    private Date updatedDate;
    private Integer floors;
}
