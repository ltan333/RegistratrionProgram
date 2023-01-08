/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.project3;

import com.project3.validation.Input;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Me
 */
public class Car {
    private String carCode;
    private String carType;
    private String carName;
    private String carOwnerName;
    private String frameNum;
    private String machineNum;
    private String color;
    private Date dateOfman;
    private Scanner scan = new Scanner(System.in);

    public Car() {
    }

    public Car(String carCode, String carType, String carName, String carOwnerName, String frameNum, String machineNum, String color, Date dateOfman) {
        this.carCode = carCode;
        this.carType = carType;
        this.carName = carName;
        this.carOwnerName = carOwnerName;
        this.frameNum = frameNum;
        this.machineNum = machineNum;
        this.color = color;
        this.dateOfman = dateOfman;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarOwnerName() {
        return carOwnerName;
    }

    public void setCarOwnerName(String carOwnerName) {
        this.carOwnerName = carOwnerName;
    }

    public String getFrameNum() {
        return frameNum;
    }

    public void setFrameNum(String frameNum) {
        this.frameNum = frameNum;
    }

    public String getMachineNum() {
        return machineNum;
    }

    public void setMachineNum(String machineNum) {
        this.machineNum = machineNum;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getDateOfman() {
        return dateOfman;
    }

    public void setDateOfman(Date dateOfman) {
        this.dateOfman = dateOfman;
    }

    @Override
    public String toString() {
        return "Car{" + "carCode=" + carCode + ", carType=" + carType + ", carName=" + carName + ", registrationBy=" + carOwnerName + ", frameNum=" + frameNum + ", machineNum=" + machineNum + ", color=" + color + ", dateOfman=" + dateOfman + '}';
    }
    
    /**
     * Input Car Info.
     */
    public void input(){
        //Su dung ham nhap lieu da viet san o package com.project3.validation.Input
        this.setCarCode(Input.inputAndCheckNotEmpty("Enter Car Code:", "Code must be not empty!", this.scan));
        this.setCarType(Input.inputAndCheckNotEmpty("Enter Car Type:", "Type must be not empty!", this.scan));
        this.setCarName(Input.inputAndCheckNotEmpty("Enter Car Name:", "Name must be not empty!", this.scan));
        this.setCarOwnerName(Input.inputAndCheckNotEmpty("Enter Car Owner's Name:", "Name must be not empty!", this.scan));
        this.setFrameNum(Input.inputAndCheckNotEmpty("Enter Car Frame Number:", "Frame Number must be not empty!", this.scan));
        this.setMachineNum(Input.inputAndCheckNotEmpty("Enter Car Machine Number:", "Machine Number must be not empty!", this.scan));
        this.setColor(Input.inputAndCheckNotEmpty("Enter Car Color:", "Color must be not empty!", this.scan));
        this.setDateOfman(Input.inputAndCheckDate("Enter Date Of Manufacture(dd/MM/yyyy):", "Invalid Date - Example: 30/03/2001", "dd/MM/yyyy", this.scan));
    }
    
    /**
     * Edit Car Info.
     */
    public void edit(){
        //Su dung ham nhap lieu da viet san o package com.project3.validation.Input
        this.setCarType(Input.inputAndCheckNotEmpty("Enter Car Type:", "Type must be not empty!", this.scan));
        this.setCarName(Input.inputAndCheckNotEmpty("Enter Car Name:", "Name must be not empty!", this.scan));
        this.setCarOwnerName(Input.inputAndCheckNotEmpty("Enter Car Owner's Name:", "Name must be not empty!", this.scan));
        this.setFrameNum(Input.inputAndCheckNotEmpty("Enter Car Frame Number:", "Frame Number must be not empty!", this.scan));
        this.setMachineNum(Input.inputAndCheckNotEmpty("Enter Car Machine Number:", "Machine Number must be not empty!", this.scan));
        this.setColor(Input.inputAndCheckNotEmpty("Enter Car Color:", "Color must be not empty!", this.scan));
        this.setDateOfman(Input.inputAndCheckDate("Enter Date Of Manufacture(dd/MM/yyyy):", "Invalid Date - Example: 30/03/2001", "dd/MM/yyyy", this.scan));
    }
    
}
