package com.girlsteam.Car.Controller;

import com.girlsteam.Car.Entity.Cars;
import com.girlsteam.Car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private UserController userController;

    private boolean check() {
        return userController.isLoggedIn();
    }

    @PostMapping
    public String add(@RequestBody Cars car) {
        return check() ? carService.add(car).getName() + " added" : "Please login";
    }

    @GetMapping
    public Object getAll() {
        return check() ? carService.getAll() : "Please login";
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable int id) {
        if (!check()) return "Please login";
        Optional<Cars> c = carService.getById(id);
        return c.isPresent() ? c.get() : "Car not found";
    }

    @GetMapping("/search")
    public List<Cars> search(@RequestParam String name) {
        return check() ? carService.searchByName(name) : List.of();
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Cars c) {
        return check() ? carService.update(id, c) : "Please login";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return check() ? carService.delete(id) : "Please login";
    }
}
