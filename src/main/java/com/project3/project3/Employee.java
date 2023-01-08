/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.project3;

import com.project3.validation.Input;
import java.util.Scanner;

/**
 *
 * @author Me
 */
public class Employee {
    private String code;
    private String name;
    private String addr;
    private Scanner scan = new Scanner(System.in);
    
    public Employee() {
    }

    public Employee(String code, String name, String addr) {
        this.code = code;
        this.name = name;
        this.addr = addr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Employee{" + "code=" + code + ", name=" + name + ", addr=" + addr + '}';
    }
    
    /**
     * Input Employee Info.
     */
    public void input(){
        //Su dung ham nhap lieu da viet san o package com.project3.validation.Input
        this.setCode(Input.inputAndCheckNotEmpty("Enter Employee Code:", "Code must be not empty!", this.scan));
        this.setName(Input.inputAndCheckNotEmpty("Enter Employee Name:", "Name must be not empty!", this.scan));
        this.setAddr(Input.inputAndCheckNotEmpty("Enter Employee Address:", "Address must be not empty!", this.scan));
    }
    
    /**
     * Edit Employee Info.
     */
    public void edit(){
        //Su dung ham nhap lieu da viet san o package com.project3.validation.Input
        this.setName(Input.inputAndCheckNotEmpty("Enter Employee Name:", "Name must be not empty!", this.scan));
        this.setAddr(Input.inputAndCheckNotEmpty("Enter Employee Address:", "Address must be not empty!", this.scan));
    }
    
}
