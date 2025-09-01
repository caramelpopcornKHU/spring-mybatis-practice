package mybatis;

public class Emp {

	public int id;
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
		return "Emp [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary=" + salary
				+ ", commissionPct=" + commissionPct + ", managerId=" + managerId + ", departmentId=" + departmentId
				+ "]";
	}
	
	

}
