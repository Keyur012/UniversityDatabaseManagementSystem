package dao;

public class Admin {
	private String employeeId,employeeOfficeName,post;
	
	private int employeeOfficeNumber;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeOfficeName() {
		return employeeOfficeName;
	}

	public void setEmployeeOfficeName(String employeeOfficeName) {
		this.employeeOfficeName = employeeOfficeName;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public int getEmployeeOfficeNumber() {
		return employeeOfficeNumber;
	}

	public void setEmployeeOfficeNumber(int employeeOfficeNumber) {
		this.employeeOfficeNumber = employeeOfficeNumber;
	}
	
}
