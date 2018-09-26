/**
*lileilei
 * 2018年9月25日
* SeleniumApi.java
 */
package unitil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumApi {
	private WebDriver driver=null;
	/*
	 * 对selenium进行简单的封装
	 * 在实际中使用更加简单
	 */
	public WebDriver opendriver(String drive) {
		if(drive.equals("chrome")){
			driver = new ChromeDriver();
		}else if(drive.equals("ie")){
			driver = new InternetExplorerDriver();
		}else if(drive.equals("firefox")){
			driver = new FirefoxDriver();
		}else{
			
		}
		return driver;	
	}
	public  By find_element(String css) {
		String key = css.split("->")[0];
		String value = css.split("->")[1];
		try {
			if(key.equals("id")){
				 return By.id(value);
			}else if(key.equals("name")){
				return By.name(value);
			}else if(key.equals("css")){
				return By.cssSelector(value);
			}else if(key.equals("xpath")){
				return By.xpath(value);
			}else if(key.equals("class")){
				return By.className(value);
			}else if(key.equals("link")){
				return By.linkText(value);
			}else{
				System.out.println("请检查定位元素是否正确....");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
	public void doubleclick(String css) {
		/*
		 * 双击
		 */
		try {
			Actions action = new Actions(driver);
		    action.doubleClick(driver.findElement(find_element(css))).perform();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		}
	public void moveToElement(String p_id){//鼠标悬浮
		try{
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(find_element((p_id)))).perform();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		}
}

