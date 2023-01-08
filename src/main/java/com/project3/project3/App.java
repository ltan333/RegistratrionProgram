/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.project3;

import com.project3.validation.Input;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Me
 */
public class App {

    //List luu tru toan bo nhan vien
    private LinkedList<Employee> employees = new LinkedList<>();
    //List luu tru toan bo xe
    private LinkedList<Car> cars = new LinkedList<>();
    //List luu toan bo lich su giam dinh xe
    private LinkedList<RegistrationLog> registrationLogs = new LinkedList<>();
    Scanner scan = new Scanner(System.in);

    /**
     * Show all employee.
     *
     * @param empList List of Employee
     */
    public static void showAllEmp(LinkedList<Employee> empList) {
        System.out.println("==============> SHOW ALL EMPLOYEE <==============");
        for (Employee e : empList) {
            System.out.println(e.toString());
        }
    }

    /**
     * Show all car.
     *
     * @param carList List of Car
     */
    public static void showAllCar(LinkedList<Car> carList) {
        System.out.println("==============> SHOW ALL CAR <==============");

        for (Car e : carList) {
            System.out.println(e.toString());
        }
    }

    /**
     * Show all reg.
     *
     * @param regList List of Registration
     */
    public static void showAllReg(LinkedList<RegistrationLog> regList) {
        System.out.println("==============> SHOW ALL REGISTRATION <==============");

        for (RegistrationLog e : regList) {
            System.out.println(e.toString());
        }
    }

    /**
     * Create new employee.
     */
    public void createEmp() {
        System.out.println("==============> CREATE NEW EMPLOYEE <==============");

        //Tao moi 1 nhan vien
        Employee emp = new Employee();
        try {
            //Su dung mau nhap lieu viet san de nhap code
            String code = Input.inputAndCheckNotEmpty("Enter Employee Code:", "Code must be not empty!", scan);
            //Neu code da ton tai -> error
            if (findEmployeeByCode(code, employees).getCode().equalsIgnoreCase(code)) {
                System.out.println("Employee Code Exist!");
                return;
            }
            //Neu Code ko bi trung thi nhap tiep cac thong tin con lai
            emp.setCode(code);
            emp.edit();
            //Them nhan vien day du thong tin vao list luu tru
            employees.add(emp);
            //Thanh cong
            System.out.println("Employee have been created");
        } catch (Exception e) {
            //Neu bi loi o dau do :)
            System.out.println("Sometimes went wrong!");
            e.printStackTrace();
        }

    }

    /**
     * Edit a employee info by employee code.
     */
    public void editEmp() {
        System.out.println("==============> EDIT A EMPLOYEE <==============");

        System.out.print("Employee Code: ");
        String code = scan.nextLine();
        //Sau khi co code thi tim xem code co ton tai khong
        for (int i = 0; i < employees.size(); i++) {
            //Neu co thi edit
            if (employees.get(i).getCode().equalsIgnoreCase(code)) {
                employees.get(i).edit();
                //edit thanh cong
                System.out.println("Infomation has been updated");
                return;
            }
        }
        //Neu tim het list ma khong thay thi fail.
        System.out.println("Not Found This Employee!");

    }

    /**
     * Delete a employee by employee code.
     */
    public void delEmp() {
        System.out.println("==============> DELETE A EMPLOYEE <==============");
        System.out.print("Employee Code: ");
        String code = scan.nextLine();
        for (int i = 0; i < employees.size(); i++) {
            //Lay code -> Kiem tra co ton tai khong
            if (employees.get(i).getCode().equalsIgnoreCase(code)) {
                //Neu co thi in ra thong tin cho nguoi ta doc
                System.out.println("Code: " + employees.get(i).getCode());
                System.out.println("Name: " + employees.get(i).getName());
                System.out.println("Address: " + employees.get(i).getAddr());
                //Hoi co chac chan xoa nhan vien khong -> Dung mau nhap lieu viet san
                if (Input.inputYesOrNo("Are you sure to delete? (y/n): ", "Only type yes or no please!", scan)) {
                    //Neu yes thi xoa
                    employees.remove(employees.get(i));
                    //Thanh cong
                    System.out.println("Delete Success");
                    return;
                }
                //Neu No thi thoi
                System.out.println("");
                return;
            }
        }
        System.out.println("Not Found This Employee!");
    }

    /**
     * Find a employee by employee code.
     *
     * @param employeeCode Employee code string.
     * @param empList List of employee
     * @return Found employee or empty employee.
     */
    public static Employee findEmployeeByCode(String employeeCode, LinkedList<Employee> empList) {
        //Lay code => tim trong list
        for (Employee e : empList) {
            //Neu thay thi tra ve 
            if (e.getCode().equalsIgnoreCase(employeeCode)) {
                return e;
            }
        }
        //Khong thay thi tra ve nhan vien trong thong tin
        return new Employee("","","");
    }

    /**
     * Find a car by car code.
     *
     * @param carCode Car code string.
     * @param carList List of car
     * @return Found car or empty car.
     */
    public static Car findCarByCode(String carCode, LinkedList<Car> carList) {
        //Lay code => tim trong list
        for (Car car : carList) {
            //Neu thay thi tra ve 
            if (car.getCarCode().equalsIgnoreCase(carCode)) {
                return car;
            }
        }
        //Khong thay thi tra ve xe trong thong tin
        return new Car("","","","","","","",new Date());
    }

    /**
     * Find a registration by registration code.
     *
     * @param registrationCode Registration code string.
     * @return Found Registration or empty Registration.
     */
    public static RegistrationLog findRegistrationByCode(String registrationCode, LinkedList<RegistrationLog> regList) {
        //Lay code => tim trong list
        for (RegistrationLog reg : regList) {
            //Neu thay thi tra ve 
            if (reg.getCode().equalsIgnoreCase(registrationCode)) {
                return reg;
            }
        }
        //Khong thay thi tra ve log dang kiem trong thong tin
        return new RegistrationLog("",new Employee(),new Car(),false,new Date());
    }

    public void createCar() {
        System.out.println("==============> CREATE NEW CAR <==============");
        //Tao moi 1 nhan vien
        Car car = new Car();
        try {
            //Su dung mau nhap lieu viet san de nhap code
            String code = Input.inputAndCheckNotEmpty("Enter Car Code:", "Code must be not empty!", scan);
            //Neu code da ton tai -> error
            if (findCarByCode(code, cars).getCarCode().equalsIgnoreCase(code)) {
                System.out.println("Car Code Exist!");
                return;
            }
            //Neu Code ko bi trung thi nhap tiep cac thong tin con lai
            car.setCarCode(code);
            car.edit();
            //Them xe day du thong tin vao list luu tru
            cars.add(car);
            //Thanh cong
            System.out.println("Car have been created");
        } catch (Exception e) {
            //Neu bi loi o dau do :)
            System.out.println("Sometimes went wrong!");
        }
    }

    /**
     * Edit a car info by car code.
     */
    public void editCar() {
        System.out.println("==============> EDIT A CAR <==============");
        System.out.print("Car Code: ");
        String code = scan.nextLine();
        //Sau khi co code thi tim xem code co ton tai khong
        for (int i = 0; i < cars.size(); i++) {
            //Neu co thi edit
            if (cars.get(i).getCarCode().equalsIgnoreCase(code)) {
                cars.get(i).edit();
                //edit thanh cong
                System.out.println("Infomation has been updated");
                return;
            }
        }
        //Neu tim het list ma khong thay thi fail.
        System.out.println("Not Found This Car!");

    }

    /**
     * Delete a employee by employee code.
     */
    public void delCar() {
        System.out.println("==============> DELETE A CAR <==============");
        System.out.print("Car Code: ");
        String code = scan.nextLine();
        for (int i = 0; i < cars.size(); i++) {
            //Lay code -> Kiem tra co ton tai khong
            if (cars.get(i).getCarCode().equalsIgnoreCase(code)) {
                //Neu co thi in ra thong tin cho nguoi ta doc
                System.out.println("Code: " + cars.get(i).getCarCode());
                System.out.println("Name: " + cars.get(i).getCarName());
                System.out.println("Type: " + cars.get(i).getCarType());
                System.out.println("Car Owner's Name: " + cars.get(i).getCarOwnerName());
                System.out.println("Frame Number: " + cars.get(i).getFrameNum());
                System.out.println("Machine Number: " + cars.get(i).getMachineNum());
                System.out.println("Color: " + cars.get(i).getColor());
                System.out.println("Date of Manufacture: " + new SimpleDateFormat("dd/MM/yyyy").format(cars.get(i).getDateOfman()));

                //Hoi co chac chan xoa car khong -> Dung mau nhap lieu viet san
                if (Input.inputYesOrNo("Are you sure to delete? (y/n): ", "Only type yes or no please!", scan)) {
                    //Neu yes thi xoa
                    cars.remove(cars.get(i));
                    //Thanh cong
                    System.out.println("Delete Success");
                    return;
                }
                //Neu No thi thoi
                System.out.println("");
                return;
            }
        }
        System.out.println("Not Found This Car!");
    }

    /**
     * Create a new registration.
     *
     * @param empList List of Employee
     * @param carList List of Car
     */
    public void createRegistration(LinkedList<Employee> empList, LinkedList<Car> carList) {
        System.out.println("==============> CREATE NEW REGISTRATION <==============");
        //Tao moi 1 ban dang kiem
        RegistrationLog reg = new RegistrationLog();
        try {
            //Su dung mau nhap lieu viet san de nhap thong tin
            boolean status = reg.input(empList, carList,registrationLogs);
            //Neu Nhap Sai thong tin thi fail.
            if(!status){
                return;
            }
            registrationLogs.add(reg);
            //Thanh cong
            System.out.println("Registration have been created");
        } catch (Exception e) {
            //Neu bi loi o dau do :)
            System.out.println("Sometimes went wrong!");
        }
    }

    /**
     * Edit a registration info by registration code.
     *
     * @param empList List of Employee
     * @param carList List of Car
     */
    public void editReg(LinkedList<Employee> empList, LinkedList<Car> carList) {
        System.out.println("==============> EDIT A REGISTRATION <==============");
        System.out.print("Registration Code: ");
        String code = scan.nextLine();
        //Sau khi co code thi tim xem code co ton tai khong
        for (int i = 0; i < registrationLogs.size(); i++) {
            //Neu co thi edit
            if (registrationLogs.get(i).getCode().equalsIgnoreCase(code)) {
                boolean status = registrationLogs.get(i).edit(empList, carList);
                //Neu edit sai thong tin
                if(!status){
                    return;
                }
                //edit thanh cong
                System.out.println("Infomation has been updated");
                return;
            }
        }
        //Neu tim het list ma khong thay thi fail.
        System.out.println("Not Found This Registration!");

    }

    /**
     * Delete a registration by registration code.
     */
    public void delRegistration() {
        System.out.println("==============> DELETE A REGISTRATION <==============");
        System.out.print("Registration Code: ");
        String code = scan.nextLine();
        for (int i = 0; i < registrationLogs.size(); i++) {
            //Lay code -> Kiem tra co ton tai khong
            if (registrationLogs.get(i).getCode().equalsIgnoreCase(code)) {
                //Neu co thi in ra thong tin cho nguoi ta doc
                System.out.println("Code: " + registrationLogs.get(i).getCode());
                System.out.println("Car: " + registrationLogs.get(i).getCar().toString());
                System.out.println("Employee: " + registrationLogs.get(i).getEmployee().toString());
                System.out.println("Date of Registration: " + new SimpleDateFormat("dd/MM/yyyy").format(registrationLogs.get(i).getDate()));
                System.out.println("Status: " + (registrationLogs.get(i).isStatus() ? "Passed" : "Failed"));

                //Hoi co chac chan xoa khong -> Dung mau nhap lieu viet san
                if (Input.inputYesOrNo("Are you sure to delete? (y/n): ", "Only type yes or no please!", scan)) {
                    //Neu yes thi xoa
                    registrationLogs.remove(registrationLogs.get(i));
                    //Thanh cong
                    System.out.println("Delete Success");
                    return;
                }
                //Neu No thi thoi
                System.out.println("");
                return;
            }
        }
        System.out.println("Not Found This Car!");
    }

    /**
     * Show Menu and RUN.
     */
    public void mainMenu(App app) {
        try {
            Scanner scan = new Scanner(System.in);
            int choose;
            do {
                System.out.print("==============> REGISTRATION MANAGEMENT SYSTEM <=============="
                        + "\n1. Create New Employee"
                        + "\n2. Edit Employee By Code"
                        + "\n3. Delete Employee By Code"
                        + "\n4. Show All Employee"
                        + "\n5. Create New Car"
                        + "\n6. Edit Car By Code"
                        + "\n7. Delete Car By Code"
                        + "\n8. Show All Car"
                        + "\n9. Create New Registration"
                        + "\n10. Edit Registration By Code"
                        + "\n11. Delete Registration By Code"
                        + "\n12. Show All Registration"
                        + "\n13. Exit"
                        + "\n   Please choose: ");
                choose = scan.nextInt();
                scan.nextLine();
                switch (choose) {
                    case 1:
                        app.createEmp();
                        break;
                    case 2:
                        app.editEmp();
                        break;
                    case 3:
                        app.delEmp();
                        break;
                    case 4:
                        app.showAllEmp(app.employees);
                        break;
                    case 5:
                        app.createCar();
                        break;
                    case 6:
                        app.editCar();
                        break;
                    case 7:
                        app.delCar();
                        break;
                    case 8:
                        app.showAllCar(app.cars);
                        break;
                    case 9:
                        app.createRegistration(app.employees, app.cars);
                        break;
                    case 10:
                        app.editReg(app.employees, app.cars);
                        break;
                    case 11:
                        app.delRegistration();
                        break;
                    case 12:
                        app.showAllReg(app.registrationLogs);
                        break;
                    case 13:
                        System.out.println("---Powered by Me!---");
                        break;
                    default:
                        //Nhập ko đúng case thì hiện cái này.
                        System.out.println("Invalid option!");
                        break;
                }
                //Nhập đúng case thì lập lại.
            } while (choose > 0 && choose < 13);
        } catch (InputMismatchException e) {
            //Nhập chữ hay &%*^ thì cho nhập lại luôn.
            System.out.println("Invalid option!");
            mainMenu(app);
        }
    }
}
