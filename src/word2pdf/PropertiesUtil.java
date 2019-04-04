package word2pdf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class PropertiesUtil {
	private static Properties prop;

	static {
		if (null == prop) {
			readPropertyFile();
		}

	}

	private static void readPropertyFile() {
		prop = new Properties();
		InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("path.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String propKey) {
		return prop.getProperty(propKey).trim();
	}
}
