/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.project3;

import com.project3.validation.Input;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Me
 */
public class RegistrationLog {

    private String code;
    private Employee employee;
    private Car car;
    private boolean status;
    private Date date;
    private Scanner scan = new Scanner(System.in);

    public RegistrationLog() {
    }

    public RegistrationLog(String code, Employee employee, Car car, boolean status, Date date) {
        this.code = code;
        this.employee = employee;
        this.car = car;
        this.status = status;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RegistrationLog{" + "code=" + code + ", employee=" + employee + ", car=" + car + ", status=" + status + ", date=" + date + '}';
    }

    /**
     * Input Registration Info.
     * @param employees List of Employee
     * @param cars List of Car
     * @param regs List of Registration
     * @return status boolean.
     */
    public boolean input(LinkedList<Employee> employees, LinkedList<Car> cars, LinkedList<RegistrationLog> regs) {
        //Mot cach trien khai khac so voi 2 class con lai, input va check code ngay tai oject.
        //Input code bang ham iput viet san
        String localCode = (Input.inputAndCheckNotEmpty("Enter Registration Code:", "Code must be not empty!", this.scan));
        //Su dung ham tim kiem regis da tao xem co bi trung khong
        RegistrationLog localReg = App.findRegistrationByCode(localCode, regs);
        //Neu da ton tai thi bao loi, tra ve false, khong thi bo qua va chay tiep
        if (localReg.getCode().equalsIgnoreCase(localCode)) {
            System.out.println("Car code does not exits!");
            return false;
        }
        //Nhap ngay thang bang ham input viet san.
        Date localDate = (Input.inputAndCheckDate("Enter Date (dd/MM/yyyy):", "Invalid Date - Example: 30/03/2001", "dd/MM/yyyy", this.scan));
        //Tuong tu vs o tren
        String carCode = Input.inputAndCheckNotEmpty("Enter Car Code:", "Car Code must be not empty!", this.scan);
        Car localCar = App.findCarByCode(carCode, cars);
        if (!localCar.getCarCode().equalsIgnoreCase(carCode)) {
            System.out.println("Car code does not exits!");
            return false;
        }
        //Tuong tu
        String empCode = Input.inputAndCheckNotEmpty("Enter Employee Code:", "Employee Code must be not empty!", this.scan);
        Employee emp = App.findEmployeeByCode(empCode, employees);
        if (!emp.getCode().equalsIgnoreCase(empCode)) {
            System.out.println("Employee code does not exits!");
            return false;
        }
        //Input hop le het thi set vao object
        this.setCode(localCode);
        this.setDate(localDate);
        this.setEmployee(emp);
        this.setCar(localCar);
        this.setStatus(Input.inputYesOrNo("Pass Registration (y/n)?:", "Only type yes or no please!", this.scan));
        //Thong cong het thi tra ve true
        return true;
    }

    /**
     * Edit Registration Info.
     * @param employees List of Employee
     * @param cars List of Car
     * @return status boolean.
     */
    public boolean edit(LinkedList<Employee> employees, LinkedList<Car> cars) {
        //Copy tu input
        Date localDate = (Input.inputAndCheckDate("Enter Date (dd/MM/yyyy):", "Invalid Date - Example: 30/03/2001", "dd/MM/yyyy", this.scan));
        String carCode = Input.inputAndCheckNotEmpty("Enter Car Code:", "Car Code must be not empty!", this.scan);
        Car localCar = App.findCarByCode(carCode, cars);
        if (!localCar.getCarCode().equalsIgnoreCase(carCode)) {
            System.out.println("Car code does not exits!");
            return false;
        }
        
        String empCode = Input.inputAndCheckNotEmpty("Enter Employee Code:", "Employee Code must be not empty!", this.scan);
        Employee emp = App.findEmployeeByCode(empCode, employees);
        if (!emp.getCode().equalsIgnoreCase(empCode)) {
            System.out.println("Employee code does not exits!");
            return false;
        }
        this.setDate(localDate);
        this.setEmployee(emp);
        this.setCar(localCar);
        this.setStatus(Input.inputYesOrNo("Pass Registration (y/n)?:", "Only type yes or no please!", this.scan));
        return true;
    }

}
