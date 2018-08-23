Customer Statement Report
--------------------------
Application is used to read customer statement from csv/xml and genrate report containing list of duplicate transaction numbers and invalid currency list record

Prerequisites
-------------
* Install JDK1.7/1.8 and apache maven and STS preferred else any other IDE like Eclipse/IntelliJ
* OpenCSV dependency for reading csv files
* SaxPArser from javax for reading xml files

Files
-----
* CustomerStatementReader.java
	* Main program used to identify files marked with .xml or .csv and genrate report by calling corresponding classes
* OpenCSVReader.java
	* used to read csv file . Skips first line since it is header.
	* each line in csv is converted to pojo
	* invalid end balance is validate and populated in invalidCurrencyList
	* map is defined with reference number as key and customer statement as value.For each insertion key(reference number) is checked if already exist then corresponding customer statement is added to duplicateCustomerStatementList
* CustomerParserSAX.java
	* used to read valid xml file and prints the duplicate and invalid values
* CustomerStatementHandler.java
	* walks all the tags in the xml prints the data . checks each tag for attribute reference and gets others values and convert it into customer statement pojo
	* checks if it is at either of accountNumber or description or startBalance or mutation or endBalance and populates the data . While populating endbalace currency validation is performed and invalid data is added invalidCurrencyList
	* map is defined with reference number as key and customer statement as value.For each insertion key(reference number) is checked if already exist then corresponding customer statement is added to duplicateCustomerStatementList
* CustomerStatementReader.java
	* final constants are declared here
* CustomerStatement.java
	* pojo class
* CommonUtil.java	
	* common methods are declared here
STEPS
-----
* place csv file and xml in the folder and sspecify the path CommonConstants.java for FILE_PATH constant
* run CustomerStatementReader.java

