package com.girlsteam.Car.service;

import com.girlsteam.Car.Entity.Cars;
import java.util.List;
import java.util.Optional;

public interface CarService {
    Cars add(Cars car);
    List<Cars> getAll();
    Optional<Cars> getById(int id);
    List<Cars> searchByName(String name);
    String update(int id, Cars updated);
    String delete(int id);
}
