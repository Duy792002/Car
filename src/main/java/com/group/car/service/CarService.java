package com.group.car.service;

import com.group.car.models.Car;
import com.group.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class CarService implements ICarService{

    @Autowired
    private CarRepository carRepository;


    @Override
    public Car addCar(Car car) {
        return null;
    }

    @Override
    public Car updateCar(long id, Car car) {
        return null;
    }

    @Override
    public boolean deleteCar(long id) {
        return false;
    }

    @Override
    public List<Car> getAll(Sort sort) {
        return carRepository.findAll(sort);
    }

    @Override
    public void saveCar(Car car, MultipartFile image) throws IOException {
        if (image != null && !image.isEmpty()) {
            String base64Image = Base64.getEncoder().encodeToString(image.getBytes());
            car.setImages(base64Image);
        }
        carRepository.save(car);
    }
}
