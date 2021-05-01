package com.dream.data.webusers.request;

import com.dream.data.enums.AuthorizationProvider;
import com.dream.data.role.request.RoleRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebUserRequest {
    private Long id;
    private Date creationDate;
    private Date updatedDate;

    private String firstName;

    private String lastName;

    private String name = "";

    private String email;

    private String imageUrl ="https://";

    private Boolean emailVerified = false;

    private AuthorizationProvider provider;

    private String providerId = "";

    private Boolean phoneNumberVerified = false;

    private String phoneNumber = "";

    private Boolean enable = true;

    private RoleRequest roles;
}
