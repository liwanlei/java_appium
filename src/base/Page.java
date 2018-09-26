package base;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import location.PropertiesUtil;
import unitil.LogNew;
import unitil.SeleniumApi;
public class Page {
	static PropertiesUtil pUtil=new PropertiesUtil();
	static SeleniumApi seleniumApi=new SeleniumApi();
	static LogNew logger_user=new LogNew();
	public static WebElement Login(WebDriver driver,String url,String username,String pass_word) {
		logger_user.info("打开url："+url);
		driver.get(url);
		WebElement user=driver.findElement(seleniumApi.find_element(pUtil.getProperties("Login_User_id")));
        user.clear();
        user.sendKeys(username);
        WebElement password=driver.findElement(seleniumApi.find_element(pUtil.getProperties("Login_password_id")));
        password.clear();
        password.sendKeys(pass_word);
        WebElement login_btn=driver.findElement(seleniumApi.find_element(pUtil.getProperties("Login_btn_id")));
        login_btn.click();
        WebElement passage=driver.findElement(seleniumApi.find_element(pUtil.getProperties("Assert_login_id")));
        return passage;
	}
	public static WebElement reg(WebDriver driver,String url,String phonenumber,String verify,String phonecode,String pass_word,String repasswd) throws IOException {
		driver.get(url);
		WebElement phone=driver.findElement(seleniumApi.find_element(pUtil.getProperties("reg_moile")));
		phone.clear();
		phone.sendKeys(phonenumber);
        WebElement jiaoyan=driver.findElement(seleniumApi.find_element(pUtil.getProperties("reg_ver")));
        jiaoyan.clear();
        jiaoyan.sendKeys(verify);
        WebElement verifyCode=driver.findElement(seleniumApi.find_element(pUtil.getProperties("reg_vercode")));
        verifyCode.clear();
        verifyCode.sendKeys(phonecode);
        WebElement password=driver.findElement(seleniumApi.find_element(pUtil.getProperties("reg_password")));
        password.clear();
        password.sendKeys(pass_word);
        WebElement re_password=driver.findElement(seleniumApi.find_element(pUtil.getProperties("reg_repassword")));
        re_password.clear();
        re_password.sendKeys(repasswd);
        WebElement re_btn=driver.findElement(seleniumApi.find_element(pUtil.getProperties("reg_btn")));
        re_btn.click();
        try {
        	 WebElement re_=driver.findElement(seleniumApi.find_element(pUtil.getProperties("reg_assert")));
        	 File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//截图
 			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+phonenumber+"screen.png"));
        	 return re_;
		} catch (Exception e) {
			return null;
		}
	}
	public static String jDElement(WebDriver driver,String url, String user_name,String pass_word) {
		driver.get(url);
		WebElement dElement=driver.findElement(seleniumApi.find_element(pUtil.getProperties("jdd_login")));
		dElement.click();
		WebElement logind=driver.findElement(seleniumApi.find_element(pUtil.getProperties("jdd_login_user")));
		logind.click();
		WebElement username=driver.findElement(seleniumApi.find_element(pUtil.getProperties("jdlogin_user")));
		username.clear();
		username.sendKeys(user_name);
		WebElement password_user=driver.findElement(seleniumApi.find_element(pUtil.getProperties("jdlogin_password")));
		password_user.clear();
		password_user.sendKeys(pass_word);
		WebElement login_btn=driver.findElement(seleniumApi.find_element(pUtil.getProperties("jdlogin_btn")));
		login_btn.click();
		WebElement aElement=driver.findElement(seleniumApi.find_element(pUtil.getProperties("jdasserts_login")));
		return aElement.getText();		
	}
}