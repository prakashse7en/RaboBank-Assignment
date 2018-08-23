package com.uploadfile.util;

import com.uploadfile.model.CustomerStatement;

public class CommonUtil {

	
	public static CustomerStatement formCustomerStatement(String[] record){
		CustomerStatement customerStatement = new CustomerStatement();
		customerStatement.setFirstName(record[0]);
		customerStatement.setLastName(record[1]);
		customerStatement.setIssueCount(record[2]);
		customerStatement.setDob(record[3]);
		return customerStatement;
	}
}
