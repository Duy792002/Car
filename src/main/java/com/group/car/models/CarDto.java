package com.group.car.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class CarDto {

    @NotEmpty(message = "The name is required")
    private String name;

    @NotEmpty(message = "The name is required")
    private String licensePlate;

    @NotEmpty(message = "The name is required")
    private String brand;

    @NotEmpty(message = "The name is required")
    private String model;

    @NotEmpty(message = "The name is required")
    private String color;

    @Min(1)
    private int numbersOfSeats;

    //@NotNull(message = "The name is required")
    private String productionYears;

    @NotEmpty(message = "The name is required")
    private String transmissionType;

    @NotEmpty(message = "The name is required")
    private String fuelType;

    @NotEmpty(message = "The name is required")
    private String mileage;

    @NotEmpty(message = "The name is required")
    private String fuelConsumption;

    @Min(0)
    private double basicPrice;

    @Min(0)
    private double deposit;

    @NotEmpty(message = "The name is required")
    private String address;


    @Size(min = 10,message = "The description should be at leat 10 characters")
    @Size(max = 2000,message = "The description cannot exceed 2000 characters")
    private String description;

    @Size(min = 10,message = "The description should be at leat 10 characters")
    @Size(max = 2000,message = "The description cannot exceed 2000 characters")
    private String additionalFunction;

    @NotEmpty(message = "The name is required")
    @Size(min = 10,message = "The description should be at leat 10 characters")
    @Size(max = 2000,message = "The description cannot exceed 2000 characters")
    private String termsOfUse;

    private MultipartFile images;




    public @NotEmpty(message ="The name is required")
    String getName(){
        return name;
    }
    public @NotEmpty(message ="The name is required")
    String getLicensePlate(){
        return licensePlate;
    }
    public @NotEmpty(message ="The name is required")
    String getBrand(){
        return brand;
    }
    public @NotEmpty(message ="The name is required")
    String getModel(){
        return model;
    }
    public @NotEmpty(message ="The name is required")
    String getColor(){
        return color;
    }
    @Min(1)
    public int getNumbersOfSeats(){
        return numbersOfSeats;
    }
    public String getProductionYears(){
        return productionYears ;
    }
    public @NotEmpty(message ="The name is required")
    String getTransmissionType(){
        return transmissionType;
    }
    public @NotEmpty(message ="The name is required")
    String getFuelType(){
        return fuelType;
    }
    public @NotEmpty(message ="The name is required")
    String getMileage(){
        return mileage;
    }
    public @NotEmpty(message ="The name is required")
    String getFuelConsumption(){
        return fuelConsumption;
    }
    public @NotEmpty(message ="The name is required")
    String getAddress(){
        return address;
    }
    @Min(0)
    public double getBasicPrice(){
        return basicPrice;
    }
    @Min(0)
    public double getDeposit(){
        return deposit;
    }
    public @Size(min = 10, message = "The description should be at leat 10 characters")
    @Size(max = 2000, message = "The description cannot exceed 2000 characters")
    String getDescription() {
        return description;
    }
    public @Size(min = 10, message = "The description should be at leat 10 characters")
    @Size(max = 2000, message = "The description cannot exceed 2000 characters")
    String getAdditionalFunction() {
        return additionalFunction;
    }
    public @Size(min = 10, message = "The description should be at leat 10 characters")
    @Size(max = 2000, message = "The description cannot exceed 2000 characters")
    String getTermsOfUse() {
        return termsOfUse;
    }
    public MultipartFile getImages() {
        return images;
    }


    public void setName(@NotEmpty(message = "The name is required")String name){
        this.name = name;
    }
    public void setBrand(@NotEmpty(message = "The name is required")String brand){
        this.brand = brand;
    }
    public void setModel(@NotEmpty(message = "The name is required")String model){
        this.model= model;
    }
    public void setColor(@NotEmpty(message = "The name is required")String color){
        this.color = color;
    }
    public void setLicensePlate(@NotEmpty(message = "The name is required")String licensePlate){
        this.licensePlate = licensePlate;
    }
    public void setNumbersOfSeats(@Min(1) int numbersOfSeats){
        this.numbersOfSeats = numbersOfSeats;
    }
    public void setProductionYears(String productionYears){
        this.productionYears = productionYears;
    }
    public void setTransmissionType(@NotEmpty(message = "The name is required")String transmissionType){
        this.transmissionType = transmissionType;
    }
    public void setFuelType(@NotEmpty(message = "The name is required")String fuelType){
        this.fuelType = fuelType;
    }
    public void setMileage(@NotEmpty(message = "The name is required")String mileage){
        this.mileage = mileage;
    }
    public void setFuelConsumption(@NotEmpty(message = "The name is required")String fuelConsumption){
        this.fuelConsumption = fuelConsumption;
    }
    public void setBasicPrice(@Min(0) double basicPrice){
        this.basicPrice = basicPrice;
    }
    public void setDeposit(@Min(0) double deposit){
        this.deposit = deposit;
    }
    public void setAddress(@NotEmpty(message = "The name is required")String address){
        this.address = address;
    }
    public void setDescription(@Size(min = 10, message = "The description should be at leat 10 characters")
                               @Size(max = 2000, message = "The description cannot exceed 2000 characters")
                               String description) {
        this.description = description;
    }
    public void setAdditionalFunction(@Size(min = 10, message = "The description should be at leat 10 characters")
                               @Size(max = 2000, message = "The description cannot exceed 2000 characters")
                               String additionalFunction) {
        this.additionalFunction = additionalFunction;
    }
    public void setTermsOfUse(@Size(min = 10, message = "The description should be at leat 10 characters")
                                      @Size(max = 2000, message = "The description cannot exceed 2000 characters")
                                      String termsOfUse) {
        this.termsOfUse = termsOfUse;
    }
    public void setImages(MultipartFile images) {

        this.images = images;
    }


}
