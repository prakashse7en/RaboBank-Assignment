package com.uploadfile.service;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.uploadfile.model.CustomerStatement;
import com.uploadfile.util.CommonUtil;

@Component
public class ExposeFile {

	public List<CustomerStatement> genrateCSVReport(Reader file) throws IOException {
		List<CustomerStatement> customerStatementList = null;
		CSVReader reader = new CSVReader(file, ',', '\'', 1); //skips first line
		
		// read line by line
		String[] record = null;

		while ((record = reader.readNext()) != null) {
			CustomerStatement customerStatement = CommonUtil.formCustomerStatement(record);
			if(null == customerStatementList){
				customerStatementList = new ArrayList<CustomerStatement>();
			}
			customerStatementList.add(customerStatement);
		}

		reader.close();
		return customerStatementList;
	}
}
