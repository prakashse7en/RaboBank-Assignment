package com.uploadfile.model;


public class CustomerStatement {

	private String firstName;
	private String lastName;
	private String issueCount;
	private String dob;
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
	public String getIssueCount() {
		return issueCount;
	}
	public void setIssueCount(String issueCount) {
		this.issueCount = issueCount;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "CustomerStatement [firstName=" + firstName + ", lastName=" + lastName + ", issueCount=" + issueCount
				+ ", dob=" + dob + "]";
	}

	

	
}
