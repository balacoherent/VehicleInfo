package com.vehicleManagement.vehicleInfo.ServiceInterface;

import com.vehicleManagement.vehicleInfo.DTO.UserDTO;
import com.vehicleManagement.vehicleInfo.Entity.User;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserInterface {

    User addInfo(UserDTO userDTO);

    Optional<User> getUserbyId(Integer id);

    Optional<User> deletesoft(UserDTO userDTO);

    Optional<User> updatebyId(UserDTO userDTO);

}
