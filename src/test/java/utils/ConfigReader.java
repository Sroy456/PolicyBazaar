package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public static Properties prop;

	public static Properties property() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("config.properties");
			try {

				prop.load(fis);

			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}
		return prop;
	}

}