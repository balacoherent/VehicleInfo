package com.vehicleManagement.vehicleInfo.ServiceImpl;

import com.vehicleManagement.vehicleInfo.BaseResponse.PageResponse;
import com.vehicleManagement.vehicleInfo.DTO.UserDTO;
import com.vehicleManagement.vehicleInfo.Entity.User;
import com.vehicleManagement.vehicleInfo.Repository.UserRepository;
import com.vehicleManagement.vehicleInfo.ServiceInterface.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addInfo(UserDTO userDTO) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        User user = new User();
        user.setName(userDTO.getName());
        user.setPassword(bcrypt.encode(userDTO.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> getUserbyId(Integer id) {
        Optional<User> user=userRepository.findById(id);
        return user;
    }

    @Override
    public Optional<User>  deletesoft(UserDTO userDTO) {
        Optional<User> existUser = userRepository.findById(userDTO.getId());
        if (existUser.isPresent())
        {
            existUser.get().setIsDelete(1);
        }
        else
        {
            throw new RuntimeException("data not found");
        }
        userRepository.save(existUser.get());
        return existUser;
    }

    @Override
    public Optional<User> updatebyId(UserDTO userDTO) {
        Optional<User> existUser = userRepository.findById(userDTO.getId());
        if (existUser.isPresent())
        {
            existUser.get().setId(userDTO.getId());
            existUser.get().setName(userDTO.getName());
            existUser.get().setPassword(userDTO.getPassword());
        }
        else
        {
            throw new RuntimeException("data not found");
        }
        userRepository.save(existUser.get());

        return existUser;
    }

    @Override
    public PageResponse<User> GetUserWithPagination(int offset, int pageSize, String name) {
        Pageable paging= PageRequest.of(offset,pageSize);
        Page<User> Users = userRepository.searchAllByUserNameLike("%" + name + "%", paging);
        PageResponse pageResponse=new PageResponse();
        pageResponse.setResponse(Users);
        pageResponse.setRecordCount(Users.getTotalPages());
        return pageResponse;
    }


    }