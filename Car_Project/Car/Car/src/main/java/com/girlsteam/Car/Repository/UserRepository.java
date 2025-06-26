package com.girlsteam.Car.Repository;

import com.girlsteam.Car.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    boolean existsByUsername(String username);

    @Transactional
    void deleteByUsername(String username);
}
