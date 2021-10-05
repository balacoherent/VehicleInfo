package com.vehicleManagement.vehicleInfo.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;
import java.util.List;

@Getter
@Setter
public class UserDTO {

    private Integer id;

    private String name;

    private String password;

    private String roleName;

    private List<Role> roles;

}