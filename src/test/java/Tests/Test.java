package Tests;

import Utility.ReadPropertyFile;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String filePath= System.getProperty("user.dir") + "\\Common.properties";
		System.out.println(ReadPropertyFile.getURL());
	
	}

}
