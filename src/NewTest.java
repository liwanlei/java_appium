/*
 * 组织测试用例
 */
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Page;
import location.ZTestReport;
import unitil.LogNew;
import unitil.ReadExcel;
import unitil.SeleniumApi;
@Listeners({ZTestReport.class})
public class NewTest {
	public  LogNew logger = new LogNew(this.getClass());
  private WebDriver driver;	
  private String path = System.getProperty("user.dir")+File.separator+"dataforcase"+File.separator+"case.xlsx";
  @DataProvider(name="DP1")
  public Object[][] createData() throws Exception {
	  Object[][]  m =new ReadExcel().getTableArray(path,"axt");	  
		return m;
  }
  @DataProvider(name="DP12")
  public Object[][] createData2() throws Exception {
  	Object[][] m = new ReadExcel().getTableArray(path,"axtreg");
		return m;
  }
  @DataProvider(name="DP13")
  public Object[][] createDatajd() throws Exception {
  	Object[][]  m =new ReadExcel().getTableArray(path, "jd");
		return m;
  }
  @Test(dataProvider="DP1",description="爱学堂登录测试")
  public void f(String url,String name,String password,String asserts) {
	 logger.info("开始登录测试");
	 WebElement passw= new Page().Login(this.driver, url, name, password);
	 logger.info("开始断言");
	 assertEquals(passw.getText(),asserts);
  }
  @Test(dataProvider="DP12",description="爱学堂注册测试")
  public void f2(String url,String phonenumber, String verify, String phonecode, String pass_word, String repasswd,String asserts ) throws IOException {
	  logger.info("开始注册测试");
	 WebElement rElement= new Page().reg(driver, url, phonenumber, verify, phonecode, pass_word, repasswd);
	 assertEquals(rElement.getText(),asserts);
  }
  @Test(dataProvider="DP13",description="jd测试")
  public void f3( String url,String user_name,String pass_word,String asserts) {
	  logger.info("开始jd测试..."+"输入用户名："+user_name);
	 String rElement= new Page().jDElement(driver,url,user_name,pass_word);
	 assertEquals(rElement,asserts);
	 logger.info("断言");
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\chromedriver_win32\\chromedriver.exe");
	     SeleniumApi SeleniumApi = new SeleniumApi();
		this.driver=SeleniumApi.opendriver("chrome");
		System.out.println(this.driver);
		logger.info("开始测试");
  }
  @AfterTest
  public void afterTest() {
	  logger.info("测试结束");
	  driver.quit();
  }

}
