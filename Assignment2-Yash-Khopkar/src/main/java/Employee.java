
public class Employee {
	private String empNo;
	private String empName;
	private String department;
	private String empJob;
	
	public Employee(String empNo, String empName, String department, String empJob) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.department = department;
		this.empJob = empJob;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmpJob() {
		return empJob;
	}

	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}
	
	
}
