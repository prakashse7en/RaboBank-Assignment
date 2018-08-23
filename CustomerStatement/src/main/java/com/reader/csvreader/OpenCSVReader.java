package com.reader.csvreader;


import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.reader.model.CustomerStatement;
import com.reader.util.CommonUtil;

public class OpenCSVReader {

	private List<CustomerStatement> customerStatementList;
	private List<CustomerStatement> dupcustomerStatementList;
	private Map<String,CustomerStatement> customerStatementMap = new HashMap<String,CustomerStatement>();
	private List<CustomerStatement> invalidCurrencyList;
	
	public void genrateCSVReport(Reader file) throws IOException {
		CSVReader reader = new CSVReader(file, ',', '\'', 1); //skips first line
		
		// read line by line
		String[] record = null;

		while ((record = reader.readNext()) != null) {
			CustomerStatement customerStatement = CommonUtil.formCustomerStatement(record);
			if(!CommonUtil.isValidCurrency(customerStatement.getEndBalance())){
				if(null == invalidCurrencyList){
					invalidCurrencyList = new ArrayList<CustomerStatement>();
				}
				invalidCurrencyList.add(customerStatement);
			}
			if(!customerStatementMap.containsKey(record[0])){
				customerStatementMap.put(record[0], customerStatement);
			}else{
				if(null == dupcustomerStatementList){
					dupcustomerStatementList = new ArrayList<CustomerStatement>();
				}
				dupcustomerStatementList.add(customerStatement);
			}
			if(null == customerStatementList){
				customerStatementList = new ArrayList<CustomerStatement>();
			}
			customerStatementList.add(customerStatement);
		}

		System.out.println("inside csv starts");
		dupcustomerStatementList.stream().forEach(System.out::println);		
		invalidCurrencyList.stream().forEach(System.out::println);	
		System.out.println("inside csv ends");
		reader.close();
	}

	
}
