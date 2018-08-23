File upload and fetch
--------------------------
Application is used to read customer statement from csv/xml and genrate report containing list of duplicate transaction numbers and invalid currency list record

Prerequisites
-------------
* Install JDK1.7/1.8 and apache maven and STS preferred else any other IDE like Eclipse/IntelliJ
* use Thymleaf ,web,opencsv dependencies

Files
-----
* FileUploadApplication.java
	* spring boot application project instantiates the FileUploadApplication.java file
* MainController.java
	* default page loaded .upload.html is loaded
* MainRESTController.java
	* rest endpoints 
		* /rest/uploadMultiFiles - uploads multipart file .uploaded file into local drive.
		* /rest/getAllFilesNew - read the file uploaded and convert to customer pojo used opencsv to convert to pojo
* RestGlobalExceptionHandler.java
	* exception class triggered when incorrect multipart file is uploaded.
* models
	* UploadForm pojo for getting the description and multipart file
	* customer statement pojo for getting list of customer statement response
* ExposeFile.java
	* componenet used to read data from csv file
* CommonUtil.java
	* common methods are defined here

