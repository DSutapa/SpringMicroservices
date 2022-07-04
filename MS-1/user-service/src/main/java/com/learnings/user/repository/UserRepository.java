package com.learnings.user.repository;

import com.learnings.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findUserByuserId(long userId);

    @Query("select u from Users u where u.email=?1")
    Optional<Users> findUsersByemail(String email);
}
