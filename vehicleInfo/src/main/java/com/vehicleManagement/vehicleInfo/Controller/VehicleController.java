package com.vehicleManagement.vehicleInfo.Controller;

import com.vehicleManagement.vehicleInfo.BaseResponse.BaseResponse;
import com.vehicleManagement.vehicleInfo.BaseResponse.PageResponse;
import com.vehicleManagement.vehicleInfo.DTO.VehicleDTO;
import com.vehicleManagement.vehicleInfo.Entity.Vehicle;
import com.vehicleManagement.vehicleInfo.ServiceInterface.VehicleInterfce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/vehicle")
@RestController
public class VehicleController {

    @Autowired
    private VehicleInterfce vehicleInterface;

    @PostMapping("/create")
    public BaseResponse<Optional<Vehicle>> addvehicle(@RequestBody VehicleDTO vehicleDTO){
        BaseResponse base;
        base= BaseResponse.builder().Data(vehicleInterface.addvehicle(vehicleDTO)).build();
        return base;
    }

    @PutMapping("/update")
    public BaseResponse<Optional<Vehicle>> updatedetail(@RequestBody VehicleDTO vehicleDTO){
        BaseResponse<Optional<Vehicle>> base ;
        base = BaseResponse.<Optional<Vehicle>>builder().Data(vehicleInterface.updatevehicle(vehicleDTO)).build();
        return base;
    }

    @GetMapping("/page/{offset}/{pageSize}/{vehicleName}")
    private PageResponse<Vehicle> vehiclePagination
            (@PathVariable int offset, @PathVariable int pageSize, @PathVariable String vehicleName){
        return vehicleInterface.vehiclePagination(offset, pageSize, vehicleName);
    }

    @GetMapping("/vehicleId/{id}")
    public BaseResponse<Optional<Vehicle>>findByVehicleId(@PathVariable int id){
        BaseResponse<Optional<Vehicle>> base;
        base = BaseResponse.<Optional<Vehicle>>builder().Data(vehicleInterface.findvehicleById(id)).build();
        return base;
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteLoad(@PathVariable int id){
        BaseResponse base ;
        base = BaseResponse.builder().Data(vehicleInterface.deletevehicle(id)).build();
        return base;
    }

}

