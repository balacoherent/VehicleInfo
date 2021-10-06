package com.vehicleManagement.vehicleInfo.Controller;

import com.vehicleManagement.vehicleInfo.BaseResponse.BaseResponse;
import com.vehicleManagement.vehicleInfo.BaseResponse.PageResponse;
import com.vehicleManagement.vehicleInfo.DTO.UserDTO;
import com.vehicleManagement.vehicleInfo.DTO.UserRoleDTO;
import com.vehicleManagement.vehicleInfo.Entity.User;
import com.vehicleManagement.vehicleInfo.ServiceInterface.UserInterface;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserInterface userInterface;

    @PostMapping(value="/create")
    public BaseResponse<User> SaveUser(@RequestBody UserDTO userDTO){
        BaseResponse<User> baseResponse;
        baseResponse = BaseResponse.<User>builder().Data(userInterface.adduser(userDTO)).build();
        return baseResponse;
    }

    @GetMapping(value = "/login")
    @ApiOperation(value = "user login ")
    public BaseResponse<UserRoleDTO> tokenGenerate(@RequestBody UserRoleDTO userRoleDTO) {
        BaseResponse<UserRoleDTO> baseResponse;
        baseResponse = BaseResponse.<UserRoleDTO>builder().Data(userInterface.generateToken(userRoleDTO)).build();
        return baseResponse;
    }

    @PutMapping("/update")
    public BaseResponse<Optional<User>> updateUser(@Valid @RequestBody UserDTO userDTO) {
        BaseResponse<Optional<User>> baseResponse;
        baseResponse=BaseResponse.<Optional<User>>builder().Data(userInterface.UpdateUser(userDTO)).build();
        return baseResponse ;
    }

    @GetMapping("/{id}")
    public BaseResponse<Optional<User>> FindById(@PathVariable int id)  {
        BaseResponse<Optional<User>> baseResponse;
        baseResponse =BaseResponse.<Optional<User>>builder().Data(userInterface.getuserById(id)).build();
        return baseResponse;
    }

    @GetMapping("/{offset}/{pageSize}/{name}")
    public PageResponse<User> getPagination(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String name){
        return userInterface.pageUser(offset, pageSize, name);
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        userInterface.deletebyid(id);
        return "Success";
    }

}

