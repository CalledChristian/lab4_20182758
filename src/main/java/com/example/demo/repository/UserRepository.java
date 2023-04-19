package com.example.demo.repository;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(nativeQuery = true,value = "select * from user where email=?1 and password=?2 ")
    User buscarUsuario(String email,String password);

}
