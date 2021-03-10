package employeetask;

import java.util.*;
import java.util.regex.Pattern;


public class EmployeeSet {
	
	

	public static void main(String[] args) {
		EmployeeSet employeeSet = new EmployeeSet();
		employeeSet.navigation();

	}

	static Scanner scan = new Scanner(System.in);
	static TreeSet<Employee> empTreeSet = new TreeSet<Employee>(new EmpComparator());
	
//method that navigates the user to the choice that is made 
	protected void navigation() {
		EmployeeSet employeeSet = new EmployeeSet();
		int menuChoice =0;
		int loopExit = 0;

		while (loopExit < 10) {
			System.out.println("Enter a choice");
			System.out.println("1) Add Employee");
			System.out.println("2) show Employees");
			System.out.println("3) Exit");
			try {
			int	choiceref =Integer.parseInt(scan.next()) ;
			menuChoice=choiceref;
			} catch (Exception e) {

				employeeSet.navigation();
			}

			switch (menuChoice) {
			case 1:
				int i = employeeSet.addEmployee();
				if (i == 1) {
					System.out.println("Employee Sucessfully added");
				} else
					System.out.println("Employee not added");
				break;

			case 2:
				employeeSet.printEmployees();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("inavlid");
				employeeSet.navigation();

			}

		}

	}
	
//method to add employee data to empTreeSet
	int addEmployee() {
		EmployeeSet employeeSet = new EmployeeSet();
		try {
			System.out.println("Enter the ID of the employee");
			int id = employeeSet.id();
			System.out.println("Enter the NAME of the employee");
			String name = name();
			System.out.println("Enter the SALARY of the employee");
			double salary = employeeSet.salary();
			System.out.println("Enter the AGE of the employee");
			int age = age() ;
			empTreeSet.add(new Employee(id, name, salary, age));
		} catch (Exception e) {
			addEmployee();
		}

		return 1;
	}

	void printEmployees() {
		empTreeSet.forEach(employee -> System.out.println(employee));
	}
	
// method to validate the id is only numeric
	int id() {
		Scanner scan = new Scanner(System.in);
		System.out.println("NOTE: input should be numeric");
		try {
			 int id = scan.nextInt();
			return id;
		} catch (Exception e) {
			System.out.println("inavalid entry");
			id();
		}
		return 0;
	}
	
	// method to validate the salary is only numeric
	double salary() {
		Scanner scan = new Scanner(System.in);
		System.out.println("NOTE: input should be numeric");
		try {
			double salary = scan.nextDouble();
			return salary;
		} catch (Exception e) {
			System.out.println("inavalid entry");
			salary();
		}
		return 0;
	}
	
	// method to validate the name contains only  alphabetical input
	String name() {
		Scanner scan = new Scanner(System.in);
		System.out.println("NOTE: input should be alphabatical");
		try {
			String nameref = scan.next();
			if(Pattern.matches("[A-Za-z]{1,}",nameref ))
			{
				String name = nameref;
				return name;
			}
			
		} catch (Exception e) {
			System.out.println("inavalid entry");
			 name();
		}
		return null;
	}
	
	// method to validate the is age is only numeric
	int age() {
		Scanner scan = new Scanner(System.in);
		System.out.println("NOTE: input should be numeric");
		try {
			 int age = scan.nextInt();
			return age;
		} catch (Exception e) {
			System.out.println("inavalid entry");
			age();
		}
		return 0;
	}

}
