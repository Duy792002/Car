package com.group.car.service;

import com.group.car.models.Car;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ICarService {
    public Car addCar(Car car);
    public Car updateCar(long id,Car car);
    public boolean deleteCar(long id);
    public List<Car> getAll(Sort sort);
    public void saveCar(Car car, MultipartFile image) throws IOException;

}
