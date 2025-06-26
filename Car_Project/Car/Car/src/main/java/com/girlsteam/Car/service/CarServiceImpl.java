package com.girlsteam.Car.service;

import com.girlsteam.Car.Entity.Cars;
import com.girlsteam.Car.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository repo;

    @Override
    public Cars add(Cars car) {
        return repo.save(car);
    }

    @Override
    public List<Cars> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Cars> getById(int id) {
        return repo.findById(id);
    }

    @Override
    public List<Cars> searchByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    @Override
    public String update(int id, Cars updated) {
        Optional<Cars> opt = repo.findById(id);
        if (opt.isPresent()) {
            Cars c = opt.get();
            c.setName(updated.getName());
            c.setModel(updated.getModel());
            c.setColor(updated.getColor());
            c.setPrice(updated.getPrice());
            repo.save(c);
            return "Updated";
        }
        return "Car not found";
    }

    @Override
    public String delete(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Deleted";
        }
        return "Car not found";
    }
}
