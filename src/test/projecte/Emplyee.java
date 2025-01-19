/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.projecte;

/**
 *
 * @author sama
 */
public class Emplyee {

    int Emp_ID;
    String Name;
    String Depart;
    double Salary;
    double Bonus;
    boolean Resident;
    static int NOC;

    Emplyee() {
        Emp_ID = 000;
        Name = "not Inserted";
        Depart = "not Inserted";
        Salary = 00000;
        Bonus = 000;
        Resident = false;
        NOC++;
    }

    Emplyee(int EID, String N) {
        Emp_ID = EID;
        Name = N;
        NOC++;
    }

    Emplyee(int EID, String Na, String Dep, double Sal) {
        this(EID, Na);
        Depart = Dep;
        Salary = Sal;
    }

    Emplyee(int EID, String Na, String Dep, double Sal, double Bon, boolean Res) {
        this(EID, Na, Dep, Sal);
        Bonus = 000;
        Resident = false;
        NOC++;
    }

    public Emplyee(Emplyee takeCapy) {
        this.Salary = takeCapy.Salary;
    }

    public boolean IsSallaryEqul(Emplyee externalEmp) {
        if (this.Salary == externalEmp.Salary) {
            return true;
        } else {
            return false;
        }

    }

    public void SetEmp_ID(int EID) {
        Emp_ID = EID;
    }

    public void SetName(String N) {
        Name = N;
    }

    public void SetDepart(String Dep) {
        Depart = Dep;
    }

    public void SetSalary(double Sal) {
        Salary = Sal;
    }

    public void SetBonus(double Bo) {
        Bonus = Bo;
    }

    public void SetResident(boolean Res) {
        Resident = Res;
    }

    public int GetEmp_ID() {
        return Emp_ID;
    }

    public String GetName() {
        return Name;
    }

    public String GetDepart() {
        return Depart;
    }

    public double GetSalary() {
        return Salary;
    }

    public double GetBonus() {
        return Bonus;
    }

    public String GetResident() {
        if (Resident == true) {
            return "Resident";
        } else {
            return "Not Resident";
        }
    }

    public void Print() {
        System.out.println("Hello With Emplyee Class");
        System.out.println("we have => " + NOC + "class");
        for (int i = 0; i < NOC; i++) {
            System.out.println("your name is => " + this.GetName());
            System.out.println("your ID is => " + this.GetEmp_ID());
            System.out.println("your Depart is => " + this.GetDepart());
            System.out.println("your full Salary are => " + (this.GetSalary() + this.GetBonus()));
            System.out.println("your are => " + this.GetResident());
            System.out.println("===============================");

        }
    }
}
