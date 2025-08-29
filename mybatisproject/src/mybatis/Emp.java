package mybatis;

public class Emp {

	public int id;
	public String lastName;
	public String firstName;
	public int salary;
	public String jobId;
	
	@Override
	public String toString() {
		return "Emp [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", salary=" + salary
				+ ", jobId=" + jobId + "]";
	}
	
	

}
