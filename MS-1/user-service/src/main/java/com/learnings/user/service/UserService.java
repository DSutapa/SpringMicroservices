package com.learnings.user.service;

import com.learnings.user.VO.Department;
import com.learnings.user.VO.ResponseTemplateVO;
import com.learnings.user.entity.Users;
import com.learnings.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<Users> allUsers() {
        return userRepository.findAll();
    }

    public Users addUser(Users users) {
//        ResponseEntity<Department> existsId= new RestTemplate().getForEntity("http://localhost:9000/api/" +users.getDepartmentId(),Department.class);
//        if(existsId.toString().isEmpty()){
//            throw new IllegalStateException("NO!");
//        }
        Optional<Users> findEmail = userRepository.findUsersByemail(users.getEmail());
        if(findEmail.isPresent()){
            throw new IllegalStateException("Email "+users.getEmail()+" already taken!");
        }
        userRepository.save(users);
        return userRepository.save(users);
    }

    public Users getUser(long userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException("No user with id "+userId);
        }
        return userRepository.findUserByuserId(userId);

    }

    public ResponseTemplateVO getUserWithDepartment(long userId) {

        ResponseTemplateVO vo = new ResponseTemplateVO();
        Users user = userRepository.findUserByuserId(userId);
        Department userWithDept= new RestTemplate().getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),
                                                            Department.class);
        vo.setUsers(user);
        vo.setDepartment(userWithDept);
       return vo;
    }
}
