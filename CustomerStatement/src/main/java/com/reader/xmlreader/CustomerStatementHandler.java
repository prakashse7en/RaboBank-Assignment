package com.reader.xmlreader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.reader.model.CustomerStatement;
import com.reader.util.CommonUtil;

public class CustomerStatementHandler extends DefaultHandler  {

	private List<CustomerStatement> customerStatementList; //no need of this list
	
	private CustomerStatement customerStatement;
	
	private List<CustomerStatement> dupcustomerStatementList = new ArrayList<CustomerStatement>();
	private Map<String,CustomerStatement> customerStatementMap = new HashMap<String,CustomerStatement>();
	private List<CustomerStatement> invalidCurrencyList = new ArrayList<CustomerStatement>();
	
	
	boolean accountNumber,description,startBalance,mutation,endBalance;
	
	 @Override
	 public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		 if (qName.equalsIgnoreCase("record")) {
			 String id = attributes.getValue("reference");
			 customerStatement = new CustomerStatement();
			 customerStatement.setReferenceNumber(id);
	            if (customerStatementList == null){
	            	customerStatementList = new ArrayList<CustomerStatement>();
	            }
		 } else if (qName.equalsIgnoreCase("accountNumber")) {
			 accountNumber = true;
		 } else if (qName.equalsIgnoreCase("description")) {
			 description = true;
		 } else if (qName.equalsIgnoreCase("startBalance")) {
			 startBalance = true;
		 } else if (qName.equalsIgnoreCase("mutation")) {
			 mutation = true;
		 }else if (qName.equalsIgnoreCase("endBalance")) {
			 endBalance = true;
		 }
	 }
	 

	 @Override
	 public void endElement(String uri, String localName, String qName) throws SAXException {
		 if (qName.equalsIgnoreCase("record")) {
			 customerStatementList.add(customerStatement);
			 //perform duplicate checking logic
			 if(!customerStatementMap.containsKey(customerStatement.getReferenceNumber())){
					customerStatementMap.put(customerStatement.getReferenceNumber(), customerStatement);
				}else{
					dupcustomerStatementList.add(customerStatement);
				}
	        }
	 }
	
	 @Override
	    public void characters(char ch[], int start, int length) throws SAXException {

	        if (accountNumber) {
	            customerStatement.setAccountNumber(new String(ch, start, length));
	            accountNumber = false;
	        } else if (description) {
	        	customerStatement.setDescription(new String(ch, start, length));
	            description = false;
	        } else if (startBalance) {
	        	customerStatement.setStartBalance(Double.parseDouble(new String(ch, start, length)));
	            startBalance = false;
	        } else if (mutation) {
	        	customerStatement.setMutation(Double.parseDouble(new String(ch, start, length)));
	            mutation = false;
	        }else if (endBalance) {
	        	//perform currency checking logic
	        	customerStatement.setEndBalance(Double.parseDouble(new String(ch, start, length)));
	        	if(!CommonUtil.isValidCurrency(customerStatement.getEndBalance())){
					invalidCurrencyList.add(customerStatement);
				}
	            endBalance = false;
	        }
	    }
	 
	 public List<CustomerStatement> getCustomerStatementList() {
			return customerStatementList;
		}


	public List<CustomerStatement> getDupcustomerStatementList() {
		return dupcustomerStatementList;
	}


	public List<CustomerStatement> getInvalidCurrencyList() {
		return invalidCurrencyList;
	}
	 
}
