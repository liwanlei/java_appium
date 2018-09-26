/**
*lileilei
 * 2018年9月26日
* PropertiesUtil.java
 */
package location;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class PropertiesUtil {
	private static Properties p=null;
	private static String path="config/page.properties";
	static {
		p=new Properties();
		File file=new File(path);
		InputStream in=null;
		try {
			in=new FileInputStream(file);
			p.load(in);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (in!=null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	public static String getProperties(String key){
		return p.getProperty(key);
		}
	public static String getProperties(String key, String
		defaultValue){
		return p.getProperty(key, defaultValue);
		}
}
