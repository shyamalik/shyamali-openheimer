# shyamali-openheimer
This repository includes the UI and API automation tests for the openheimer project


### Steps to run the UI automation test and API automation Test

(Hint- API automation tests can be found in the package - com.openheimer.api
UI automation tests can be found in the package - com.openheimer.ui)

1. Spinup the openheimer project jar file using the -java -jar {set your jar location here}\oppenheimer-project-dev\OppenheimerProjectDev.jar

2. Execute the tests

### Issues encountered when writing tests and how they were resolved

1. Got the test ignored issue unexpecedly and resolve by changing the chosen browser from CHROME to FIREFOX
2. Upload file path gave file not found error for relative path and resolved by using "String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\EmployeeTax - Sheet1.csv";"
3. Only completed AC1 in 4th user story