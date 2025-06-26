package com.girlsteam.Car.Repository;

import com.girlsteam.Car.Entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepository extends JpaRepository<Cars, Integer> {
    List<Cars> findByNameContainingIgnoreCase(String name);
}
