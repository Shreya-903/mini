import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int empID;
    int empSalary; 
    String empName;
    long empPhone;
    String empPost;
    int isPaid;
    public Employee(int id, String name,  long contact_no, int salary, String empPost)
	{
		this.empID = id;
		this.empName = name;
		this.empSalary = salary;
		this.empPhone = contact_no;
		this.empPost = empPost;
	}
    public String toString()
	{
		return "\nEmployee Details :" + "\nID: " + this.empID + "\nName: " + this.empName + "\nSalary: " + 
				this.empSalary + "\nContact No: " + this.empPhone + "\nEmail-id: " + this.empPost;
	}
}
public class main {

    static void empDetails(ArrayList<Employee> al) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Employee ID to search :");
        int i=0, id;
        id = input.nextInt();
        for(Employee e: al)
        {
            if(id == e.empID)
            {
                System.out.println(e+"\n");
                i++;
            }
        }
        if(i == 0)
        {
            System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
        }
    }
    static void newEmployee(ArrayList<Employee> al) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the following details to ADD list:\n");
        System.out.println("Enter ID :");
        int id = input.nextInt();
        System.out.println("Enter Name :");
        String name = input.next();
        System.out.println("Enter Phone No. :");
        long contact_no = input.nextLong();
        System.out.println("Enter Salary :");
        int salary = input.nextInt();
        System.out.println("Enter Post :");
        String empPost = input.next();
        al.add(new Employee(id, name,  contact_no, salary, empPost));
    }

    static void empList(ArrayList<Employee> al)
	{
		System.out.println(String.format("%-10s%-15s%-10s%-20s%-10s", "ID","Name","salary","contact-no","Email-Id"));
		for(Employee e : al)
		{
			System.out.println(String.format("%-5s%-20s%-10s%-15s%-10s",e.empID,e.empName,e.empSalary,e.empPhone,e.empPost));
		}
	}
    public static void main(String[] args) {

        // int empID;
        // int empSalary; 
        // String empName;
        // long empPhone;
        // String empPost;
        // int isPaid;

        Scanner input = new Scanner(System.in);

        ArrayList<Employee> al = new ArrayList<Employee>();
		
		File f = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos =null;

        try{
			
			f = new File("EmployeeDataList1.txt");
			if(f.exists())
			{
				fis = new FileInputStream(f);
				ois = new ObjectInputStream(fis);
				al = (ArrayList<Employee>)ois.readObject();
			}
			
		}
		catch(Exception exp){
			System.out.println(exp);
		}

        do {
            System.out.println("\t\tChoose Action\t\t\n\n");
            System.out.println("1. New Employee\n2. Update Employee Details\n3. Employee Details\n4. Employee List\n5. Fire Employee\n6. Employee salary\n7. Promote Employee\n8. Pay Salary\n9. Salary status\n10. Exit\n");
            int choice = input.nextInt();
            switch(choice) {
                case 1:newEmployee(al);
                break;
        
                // case 2:updateEmp();
                // break;
        
                case 3:empDetails(al);
                break;
        
                case 4:empList(al);
                break;
        
                // case 5:fireEmployee();
                // break;
        
                // case 6:getEmpSalary();
                // break;
                
                // case 7:promoteEmp();
                // break;
        
                // case 8:paySalary();
                // break;
        
                // case 9:isSalaryPaid();
                // break;
        
                // case 10:exit(0);
                // break;

                default: System.out.println("Invalid Choice!!\n");
            }
        } while(true);
    }
}
