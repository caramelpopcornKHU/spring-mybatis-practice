package myspring;

public class Emp {

	public int employeeId;
	public String firstName;
	public String lastName;
	public String email;
	public String phoneNumber;
	public String hireDate;
	public String jobId;
	public int salary;
	public float commissionPct;
	public int managerId;
	public int departmentId;
	
	
	@Override
	public String toString() {
		return "Emp [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", salary="
				+ salary + "]";
	}

}
