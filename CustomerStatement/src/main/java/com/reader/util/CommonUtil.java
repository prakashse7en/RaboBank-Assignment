package com.reader.util;

import com.reader.model.CustomerStatement;

public class CommonUtil {

	public static Boolean isValidCurrency(Double currency) {
		if (currency > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public static CustomerStatement formCustomerStatement(String[] record){
		CustomerStatement customerStatement = new CustomerStatement();
		customerStatement.setReferenceNumber(record[0]);
		customerStatement.setAccountNumber(record[1]);
		customerStatement.setDescription(record[2]);
		customerStatement.setStartBalance(Double.parseDouble(record[3]));
		customerStatement.setMutation(Double.parseDouble(record[4]));
		customerStatement.setEndBalance(Double.parseDouble(record[5]));
		return customerStatement;
	}
}
