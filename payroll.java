import java.util.ArrayList;
import java.util.Scanner;

 abstract class Employee {
	
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	
	public Employee(String firstName, String lastName, String socialSecurityNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	public abstract double earnings();
	
	public abstract String getEmployeeType();
	
	
}

 class SalariedEmployee extends Employee {

	 private double weeklySalary;

     public SalariedEmployee(double weeklySalary, String firstName, String lastName, String socialSecurityNumber)
     {
         super(firstName, lastName, socialSecurityNumber);
         setWeeklySalary(weeklySalary);
     }
     
     public void setWeeklySalary(double weeklySalary)
     {
         if(weeklySalary>=0.0)
         {
             this.weeklySalary=weeklySalary;
         }
         else
             System.out.println("weekly salary must be >=0.0");
     }

     public double getWeeklySalary() 
     {
         return weeklySalary;
     } 
     
     public double earnings()
     {
         return getWeeklySalary();
     }
     
     
    public String getEmployeeType() {
    	 return "Salaried Employee";
    }

     
     public String toString()
     {
         return "FirstName: " + super.getFirstName()+"\nLastName: "+super.getLastName()+"\nSSN: "+super.getSocialSecurityNumber()+"\nEmployee: "+getEmployeeType()+"\nSalary is: "+earnings();
     }
              
	
}


 class WeeklyEmployee extends Employee{
	private double hoursWorked;
	private double perHourWage;
	
	public WeeklyEmployee(String firstName, String lastName, String socialSecurityNumber,double hoursWorked,double perHourWage)
	{
		super(firstName, lastName, socialSecurityNumber);
		SetHoursWorked(hoursWorked);
		setPerHourWage(perHourWage);
		
	} 
	
	public void SetHoursWorked(double hours) 
	{
		if(hoursWorked>=0&&hoursWorked<=168) 
		{
			this.hoursWorked=hours;
		}
		else {
			System.out.println("Hours must me greater than 0");
		}
	}
	
	public void setPerHourWage(double perHourWage) 
	{
		if(perHourWage>=0) 
		{
			this.perHourWage=perHourWage;
		}
		else {
			System.out.println("Hours should be greater than 0");
		}
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public double getPerHourWage() {
		return perHourWage;
	}
	
	
	
	public double earnings() {
		if(getHoursWorked()<=40)
			return getPerHourWage()*getHoursWorked();
		else {
			return 40*getPerHourWage()+(getHoursWorked()-40)*getPerHourWage()*1.5;
		}
	}
	
	
	public String getEmployeeType() {
		return "Weekly Employee";
	}
	
	
	public String toString() {
		return "FirstName: "+" "+ super.getFirstName()+"\nLastName: "+" "+super.getLastName()+"\nSSN: "+" "+super.getSocialSecurityNumber()+"\nEmployee: "+" "+getEmployeeType()+"Hours Worked: "+" "+ getHoursWorked()+"Per Hour Pay: "+" "+getPerHourWage()+"\nSalary is: "+" "+earnings();

	}
	
	
	
	
}


 class CommisionEmployee extends Employee {
	
	
	 private double grossSales;
     private double commisionRate;

  public CommisionEmployee(double grossSales, double commisionrate, String firstName, String lastName, String socialSecurityNumber) 
  { 
      super(firstName, lastName, socialSecurityNumber);
      setGrossSales(grossSales);
      setCommisionRate(commisionrate);
  }
  
  public void setCommisionRate(double commisionRate)
  {
      if(commisionRate>=0.0&&commisionRate<=100.0)
      {
          this.commisionRate=commisionRate/100;
      }
      else 
      {
    	  System.out.println("Rate % Must be Between 0 and 100");
      }
  }

  public double getCommisionrate() 
  {
      return commisionRate;
  }
  
  public void setGrossSales(double grossSales)
  {
      if (grossSales>=0.0)
      {
          this.grossSales=grossSales;
      }
      else throw new IllegalArgumentException("grossSales must be greater than 0.0");
  }

  public double getGrossSales() 
  {
      return grossSales;
  }
  
  
public String getEmployeeType() {
	
	  return "Commision Employee";
}
  

  
  
  public double earnings()
  {
      return getGrossSales()*getCommisionrate();
  }
  
  public String toString() 
  {
	  return "FirstName: " + super.getFirstName()+"\nLastName: "+super.getLastName()+"\nsocialsecuritynumber: "+super.getSocialSecurityNumber()+"\nEmployee: "+getEmployeeType()+"\nYour Gross sales are: "+getGrossSales()+"\nYOur Commision rate is: "+getCommisionrate()+"\nSalary is: "+earnings();
  }
   

}


 class BasePlusCommisonEmployee extends CommisionEmployee {

	private double baseSalary;
	
	 
	public BasePlusCommisonEmployee(double grossSales, double commisionrate, String firstName, String lastName,
			String socialSecurityNumber,double baseSalary) {
		super(grossSales, commisionrate, firstName, lastName, socialSecurityNumber);
		//setCommisionRate(commisionrate);
		setBaseSalary(baseSalary);
		
		
	}
	
	
	
	public void setBaseSalary(double baseSalary) 
	{
		if(baseSalary>=0) 
		{
			this.baseSalary=baseSalary;
		}
		else {
			System.out.println("Base salary must be greater than 0");
		}
	}

	

	public double getBaseSalary() {
		return baseSalary;
	}
	
	
	public double earnings() {
		double temp = (super.getCommisionrate()*getGrossSales())+getBaseSalary();
		double temp1 = temp/10;
		return temp+temp1;
	}
	

	public String getEmployeeType() {
		return "BasePlus Commmision Employee";
	}
	
	
	public String toString() {
        return "FirstName: " + super.getFirstName()+"\nLastName: "+super.getLastName()+"\nSSN: "+super.getSocialSecurityNumber()+"\nEmployee: "+getEmployeeType()+"\nYour Base Salary is :" + getBaseSalary()+"\nYour commision Rate is:  "+getCommisionrate()+"\nSalary is: "+earnings();

	}
	
	
}

public class payroll {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Employee> employees = new ArrayList<>();
    
    public static void printActions() {
         System.out.println("\nAvailable actions:\npress");
         System.out.println("0   to shutdown\n" +
                            "1   to add Salaried Employee\n" +
                            "2   to add Hourly Employee\n" +
                            "3   to add Commision Employee\n" +
                            "4   to add BasePlus Commision Employee\n" +
                            "5   to Print the total earnings of Employees\n" +
                            "6   to print Information About All Employees\n");
                            
                           
                                  
         System.out.println("Choose your action: ");
         
     }
    
     public static void main(String[] args)
     {
         
         boolean quit = false;
         printActions();
         while(!quit) {
             System.out.println("\nEnter action:");
             int action = scanner.nextInt();
             scanner.nextLine();
 
             switch (action) {
                 case 0:
                     System.out.println("\nShutting down...");
                     quit = true;
                     break;
 
                 case 1:
                     System.out.println("Enter Your First Name");
         String firstName = scanner.nextLine();
         
         System.out.println("Enter Your Last Name");
         String lastName = scanner.nextLine();
         
         System.out.println("Enter Your Social Security Number");
         String socialSecurityNumber = scanner.nextLine();
         
         System.out.println("Enter Your Weekly Salary");
         double weeklySalary = scanner.nextDouble();
         
         SalariedEmployee salariedEmployee = new SalariedEmployee(weeklySalary, firstName, lastName, socialSecurityNumber);
         employees.add(salariedEmployee);
                     break;
 
                 case 2:
                     System.out.println("Enter Your First Name");
         String firstName1 = scanner.nextLine();
         
         System.out.println("Enter Your Last Name");
         String lastName1 = scanner.nextLine();
         
         System.out.println("Enter Your Social Security Number");
         String socialSecurityNumber1 = scanner.nextLine();
         
         System.out.println("Enter your per hour pay");
         double perHourPay = scanner.nextDouble();
         
         System.out.println("Enter your hours worked in a week");
         double hoursWorkedPerWeek = scanner.nextDouble();
         
         WeeklyEmployee weeklyEmployee = new WeeklyEmployee(firstName1, lastName1, socialSecurityNumber1, hoursWorkedPerWeek, perHourPay);
         employees.add(weeklyEmployee);
         System.out.println("Weekly Employee Succesfully add to the list");
                     break;
 
                 case 3:
                    System.out.println("Enter Your First Name");
         String firstName2 = scanner.nextLine();
         
         System.out.println("Enter Your Last Name");
         String lastName2 = scanner.nextLine();
         
         System.out.println("Enter Your Social Security Number");
         String socialSecurityNumber2 = scanner.nextLine();
         
         System.out.println("Enter your Gross Sales");
         double grossSales = scanner.nextDouble();
         
         System.out.println("Enter your commision rate");
         double rate = scanner.nextDouble();
         
         CommisionEmployee commisionEmployee = new CommisionEmployee(grossSales, rate, firstName2, lastName2, socialSecurityNumber2);
         employees.add(commisionEmployee);
                     break;
 
                 case 4:
                     System.out.println("Enter Your First Name");
         String firstName3 = scanner.nextLine();
         
         System.out.println("Enter Your Last Name");
         String lastName3 = scanner.nextLine();
         
         System.out.println("Enter Your Social Security Number");
         String socialSecurityNumber3 = scanner.nextLine();
         
         System.out.println("Enter your Gross Sales");
         double grossSales3 = scanner.nextDouble();
         
         System.out.println("Enter your commision rate");
         double rate3 = scanner.nextDouble();
         
         System.out.println("Enter Your Base Salary");
         double baseSalary = scanner.nextDouble();
         
         BasePlusCommisonEmployee basePlusCommisonEmployee = new BasePlusCommisonEmployee(grossSales3, rate3, firstName3, lastName3, socialSecurityNumber3, baseSalary);
         employees.add(basePlusCommisonEmployee);
                     break;
 
                 case 5:
                     double totalEarnings =0.0;
         for (Employee employee : employees) {
             totalEarnings  = totalEarnings + employee.earnings();
             
         }
         System.out.println("Total Earnings of employees are :" + totalEarnings);
                     break;
                     
                 case 6:
                     for (Employee employee : employees) {
             System.out.println(employee.toString()+"\n");
         }
                     break;
                     
                 
             }
 
         }
 
 
        
     
 
     }
     
 }
 






