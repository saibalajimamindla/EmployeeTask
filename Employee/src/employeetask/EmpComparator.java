package employeetask;

import java.util.Comparator;

public class EmpComparator implements Comparator<Employee> {

	public int compare(Employee employee1, Employee employee2) {

		Double salary1 = (Double) employee1.getSalary();
		Double salary2 = (Double) employee2.getSalary();

		String name1 = (String) employee1.getEmployeeName();
		String name2 = (String) employee2.getEmployeeName();

		Integer age1 = (Integer) employee1.getAge();
		Integer age2 = (Integer) employee2.getAge();

		if (salary1 < salary2)
			return -1;
		else if (salary1 > salary2) {
			return +1;
		}

		else {
			if (name1.equals(name2)) {
				return age2.compareTo(age1);
			}
			return name1.compareTo(name2);
		}

	}

}
