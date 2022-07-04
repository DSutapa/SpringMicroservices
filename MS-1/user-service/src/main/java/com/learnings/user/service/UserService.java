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
    @Autowired
    private RestTemplate restTemplate;

    public List<Users> allUsers() {
        return userRepository.findAll();
    }

    public Users addUser(Users users) {
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+users.getDepartmentId(),Department.class);
                if(department.getDepartmentId()!= 0){
                    Optional<Users> findEmail = userRepository.findUsersByemail(users.getEmail());
                    if(findEmail.isPresent()){
                        throw new IllegalStateException("Email "+users.getEmail()+" already taken!");
                    }
                    userRepository.save(users);
                    return userRepository.save(users);
        } else {
                    System.out.println("Department Id "+users.getDepartmentId()+" does not exists!!");
                }

        return null;
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
        //Department userWithDept = new RestTemplate().getForObject("http://localhost:9000/departments/"+user.getDepartmentId(),Department.class);
        //Department userWithDept= new RestTemplate().getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),
         //                                                  Department.class);
        Department userWithDept = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
        vo.setUsers(user);
        vo.setDepartment(userWithDept);
       return vo;
    }
}
