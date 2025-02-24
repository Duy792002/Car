package com.group.car.controller;

import com.group.car.models.Car;
import com.group.car.models.CarDto;
import com.group.car.repository.CarRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/carowner")
public class CarOwnerController {
    @Autowired
    private CarRepository iCarService;

    @GetMapping({"", "/"})
    public  String showAllCar(Model model){
        model.addAttribute("cars",iCarService.findAll(Sort.by(Sort.Direction.DESC,"id")));
        return "car-owner/car";
    }

    @GetMapping("/add")
    public String showCreatCar(Model model){
        CarDto carDto = new CarDto();
        model.addAttribute("carDto", carDto);
        return "car-owner/addCar";
    }

    @PostMapping("/add")
    public String addCar(@Valid @ModelAttribute CarDto carDto, BindingResult result){
        if (carDto.getImages().isEmpty()){
            result.addError(new FieldError("carDto", "images", "The file is required"));
        }
        if (result.hasErrors()){
            return "car-owner/addCar";
        }
        //Save image file:...
        MultipartFile image = carDto.getImages();
        String storageFile = image.getOriginalFilename();

        try{
            String uploadDir = "public/img/";
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)){
                Files.createDirectories(uploadPath);
            }
            try(InputStream inputStream = image.getInputStream()){
                Files.copy(inputStream, Paths.get(uploadDir + storageFile),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }catch (Exception e){
            System.out.println("Exceoption"+e.getMessage());
        }

        Car car = new Car();
        car.setName(carDto.getName());
        car.setLicensePlate(carDto.getLicensePlate());
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setColor(carDto.getColor());
        car.setNumbersOfSeats(carDto.getNumbersOfSeats());
        car.setProductionYears(carDto.getProductionYears());
        car.setTransmissionType(carDto.getTransmissionType());
        car.setFuelType(carDto.getFuelType());
        car.setMileage(carDto.getMileage());
        car.setFuelConsumption(carDto.getFuelConsumption());
        car.setBasicPrice(carDto.getBasicPrice());
        car.setDeposit(carDto.getDeposit());
        car.setAddress(carDto.getAddress());
        car.setDescription(carDto.getDescription());
        car.setAdditionalFunctions(carDto.getAdditionalFunction());
        car.setTermsOfUse(carDto.getTermsOfUse());
        car.setImages(storageFile);
        iCarService.save(car);

        return "redirect:/carowner";
    }

    @GetMapping("/delete")
    public String deleteCar(@RequestParam long id){
        try{
            Car car = iCarService.findById(id).get();
            //Delete image
            Path imagePath = Paths.get("public/img/"+car.getImages());
            try {
                Files.delete(imagePath);
            }catch (Exception e){
                System.out.println("Exceoption"+e.getMessage());
            }
            iCarService.delete(car);
        }catch (Exception e){
            System.out.println("Exceoption"+e.getMessage());
        }
        return "redirect:/carowner";
    }

    @GetMapping("/edit")
    public String showEditCar(Model model, @RequestParam long id){
        try{
            Car car = iCarService.findById(id).get();
            model.addAttribute("car", car);

            CarDto carDto = new CarDto();

            carDto.setName(car.getName());
            carDto.setLicensePlate(car.getLicensePlate());
            carDto.setBrand(car.getBrand());
            carDto.setModel(car.getModel());
            carDto.setColor(car.getColor());
            carDto.setNumbersOfSeats(car.getNumbersOfSeats());
            carDto.setProductionYears(car.getProductionYears());
            carDto.setTransmissionType(car.getTransmissionType());
            carDto.setFuelType(car.getFuelType());
            carDto.setMileage(car.getMileage());
            carDto.setFuelConsumption(car.getFuelConsumption());
            carDto.setBasicPrice(car.getBasicPrice());
            carDto.setDeposit(car.getDeposit());
            carDto.setAddress(car.getAddress());
            carDto.setDescription(car.getDescription());
            carDto.setAdditionalFunction(car.getAdditionalFunctions());
            carDto.setTermsOfUse(car.getTermsOfUse());

            model.addAttribute("carDto", carDto);

        }catch (Exception e){
            System.out.println("Exceoption"+e.getMessage());
            return "redirect:/carowner";
        }
        return "car-owner/edit";
    }

    @PostMapping("/edit")
    public String updateCar(Model model, @RequestParam long id,@Valid @ModelAttribute CarDto carDto, BindingResult result){
        try {
            Car car = iCarService.findById(id).get();
            model.addAttribute("car", car);
            if (result.hasErrors()){
                return "car-owner/edit";
            }
            if (!carDto.getImages().isEmpty()){
                String uploadDir = "public/img/";
                Path oldImagePath = Paths.get(uploadDir + car.getImages());
                try{
                    Files.delete(oldImagePath);
                }catch (Exception e){
                    System.out.println("Exceoption"+e.getMessage());
                }
                ///// Save file..new image
                MultipartFile image = carDto.getImages();
                String storageFileName = image.getOriginalFilename();

                try(InputStream inputStream = image.getInputStream()){
                    Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
                            StandardCopyOption.REPLACE_EXISTING);
                }catch (IOException e) {
                    System.out.println("Exceoption"+e.getMessage());
                }
                car.setImages(storageFileName);
            }

            car.setName(carDto.getName());
            car.setLicensePlate(carDto.getLicensePlate());
            car.setBrand(carDto.getBrand());
            car.setModel(carDto.getModel());
            car.setColor(carDto.getColor());
            car.setNumbersOfSeats(carDto.getNumbersOfSeats());
            car.setProductionYears(carDto.getProductionYears());
            car.setTransmissionType(carDto.getTransmissionType());
            car.setFuelType(carDto.getFuelType());
            car.setMileage(carDto.getMileage());
            car.setFuelConsumption(carDto.getFuelConsumption());
            car.setBasicPrice(carDto.getBasicPrice());
            car.setDeposit(carDto.getDeposit());
            car.setAddress(carDto.getAddress());
            car.setDescription(carDto.getDescription());
            car.setAdditionalFunctions(carDto.getAdditionalFunction());
            car.setTermsOfUse(carDto.getTermsOfUse());

            iCarService.save(car);

        }catch (Exception e){
            System.out.println("Exceoption"+e.getMessage());
        }
        return "redirect:/carowner";
    }

}
