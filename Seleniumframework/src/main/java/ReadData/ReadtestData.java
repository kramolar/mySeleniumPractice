package ReadData;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadtestData {   // 1. loading file 2. reading the keys
	
	Properties prop;
	
	static String file = "./src/main/resources/data/testData.properties";

public ReadtestData() {
	File src = new File(file);
	try {
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
	} catch (Exception e) {
		System.out.println("Exception is " + e.getMessage());
	}
}

public String getUsername() {
	return prop.getProperty("Uname");
}


public String getPassword() {
	return prop.getProperty("password");
}

public String getErr() {
	return prop.getProperty("Error");  // Epic sadface: Username and password do not match any user in this service
}

public String getEmptyErr() {
	return prop.getProperty("emptyError");
}

public String getInvalidUname() {
	return prop.getProperty("invaliduname");
}

public String getinvalidpwd() {
	return prop.getProperty("invalidpwd");
}


}
