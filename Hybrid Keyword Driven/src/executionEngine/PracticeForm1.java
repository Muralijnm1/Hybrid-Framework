package executionEngine;
//package testCases;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.*;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class PracticeForm1 {	
		static WebDriver driver;
		
	/*public PracticeFormTest(WebDriver driver) {
			PracticeFormTest.driver=driver;
			// TODO Auto-generated constructor stub
		}*/
	private static String partial_Link_Test = "//*[@id='content']//a/strong[text()='Partial Link Test']";
	private static String link_test = "//*[@id='content']//div[5]/a/strong";
	//private static String first_Name = "//*[@id='content']//div[8]/input";
	private static String first_Name = "//input[@name='firstname']";
	private static String last_Name = "//input[@name='lastname']";
	private static String sex_Male = "//*[@id='sex-0']";
	private static String sex_Female = "//*[@id='sex-1']";
	private String years_Of_Exp ="//*[@id='exp-2']";
	private String date = "//*[@id='datepicker']";
	private String profession = "//*[@id='profession-1']";
	private String chooseFile = "//*[@id='photo']";
	private String tool = "//*[@id='tool-2']";
	private String continent = "//*[@id='continents']";
	private String selenium_Commands = "//*[@id='selenium_commands']";
	private String submit_Button = "//*[@id='submit']";	
	private int iTestCaseRow = 1;
	
	 @BeforeMethod
	  public static void beforeMethod() throws Exception {
		    //DOMConfigurator.configure("log4j.xml");			
		    System.setProperty("webdriver.chrome.driver", "F:\\Eclipse\\chromedriver.exe");			
			driver = new ChromeDriver();
			//Log.info("New driver instantiated");
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    //Log.info("Implicit wait applied on the driver for 10 seconds");
		    driver.get("http://toolsqa.com/automation-practice-form/");	
		    //driver.get(URL1);
		    //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		    //driver.switchTo().frame(0);
		    Thread.sleep(3000);
	        }
	 public static void verify_partial_link_Test(){
		 WebElement link = driver.findElement(By.xpath(partial_Link_Test));
		 String actual_text = link.getText();
		 String expeccted_Text = "Partial";
		 //assert.assertEquals(actual_text, expeccted_Text);
		 Assert.assertTrue(actual_text.contains(expeccted_Text));
	 }
	 public static void verify_link_Test(){
		 WebElement link = driver.findElement(By.xpath(link_test));
		 String actual_text = link.getText();
		 String expeccted_Text = "Link Test";		 
		 Assert.assertTrue(actual_text.equals(expeccted_Text));
	 }
	 public static void set_FirstName(String fName){
		 WebElement firstName_textBox = driver.findElement(By.xpath(first_Name));
		 firstName_textBox.clear();
		 firstName_textBox.sendKeys(fName);				 
	 }
	 public static void set_LastName(String lName){
		 WebElement lastName_textBox = driver.findElement(By.xpath(last_Name));
		 lastName_textBox.clear();
		 lastName_textBox.sendKeys(lName);				 
	 }
	 public static void click_Sex_Radio_button(String sex){	
		 WebElement sex_Radio_Button;
		 if (sex.equals("Male")){
			 sex_Radio_Button = driver.findElement(By.xpath(sex_Male)); 
		 }
		 else{
			 sex_Radio_Button = driver.findElement(By.xpath(sex_Female)); 
		 }
		 sex_Radio_Button.click();				 
	 }
	 public static void click_Exp_Radio_button(String exp){	
		 WebElement exp_Radio_Button;		 
		 exp_Radio_Button = driver.findElement(By.xpath("//*[@id='exp-"+exp+"']")); 
		 System.out.println("//*[@id='exp-"+exp+"']");
		 exp_Radio_Button.click();				 
	 }
	 public static void click_Profession_Check_box(String profession){	
		 WebElement profession_Check_box;
		 if (profession.equals("Manual Tester")){
			 profession_Check_box = driver.findElement(By.xpath("//*[@id='profession-0']")); 
		 }
		 else{
			 profession_Check_box = driver.findElement(By.xpath("//*[@id='profession-1']"));
		 }
		 if (profession_Check_box.isSelected()){
			 return;
		 }
		 else{
		 profession_Check_box.click();
		 }
	 }
	 public static void uploadFile(String fileName){	
		 WebElement choose_File_Button;		 
		 choose_File_Button = driver.findElement(By.xpath("//*[@id='photo']")); 
		 //System.out.println("//*[@id='exp-+'exp'']");
		 choose_File_Button.click();
		 //String filePath = System.getProperty(("user.dir")+"\\executionEngine\\");
		 String filePath = System.getProperty(("F:\\Eclipse\\Workspace\\Hybrid Keyword Driven\\src\\executionEngine\\Keyword_Driven"));
		 //System.out.println(user.dir);
		 StringSelection stringSelection = new StringSelection(filePath);
		 Toolkit.getDefaultToolkit().getSystemClipboard().getContents(stringSelection);
		 Robot robot;
		 try{
			 robot = new Robot();
			 robot.delay(3000);
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 robot.keyPress(KeyEvent.VK_V);
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 robot.keyRelease(KeyEvent.VK_V);
			 robot.keyPress(KeyEvent.VK_ENTER);
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 System.out.println("");
		 }catch (AWTException e){
			 e.printStackTrace();			 
		 }		 
	
	 }

	 public static void selectContinent(String continent){	
		 WebElement continent_List_box;
		 continent_List_box = driver.findElement(By.xpath("//*[@id='continents']"));
		 Select select = new Select(continent_List_box);
		 ArrayList<WebElement> options = new ArrayList<WebElement>(select.getOptions());
		 for (WebElement we: options){
			 if (we.getText().equals(continent)){
				 we.click();
			 }
		 }		 
	 }
	 public static void selectCommands(String...command){	
		 WebElement commands_DropDownList_box;
		 commands_DropDownList_box = driver.findElement(By.xpath("//*[@id='selenium_commands']"));
		 Select select = new Select(commands_DropDownList_box);
		 ArrayList<WebElement> options = new ArrayList<WebElement>(select.getOptions());
		 for(String x:command){
		 for (WebElement we: options){
			 if (we.getText().equals(x)){
				 we.click();
			 }
		 }		 
	 }
	 }
	 public void clickOnButton(){		
		 WebElement button = driver.findElement(By.xpath("//*[@id='submit']"));
		 button.click();
	 }
	 
	 @Test
	 public static void formTest(){
		 verify_partial_link_Test();
		 verify_link_Test();
		 set_FirstName("Murali");
		 set_LastName("Janjanam");
		 click_Sex_Radio_button("Female");
		 click_Exp_Radio_button("2");
		 click_Profession_Check_box("Automation Tester");
		 uploadFile("Keyword_Driven");
		 selectContinent("Europe");
		 selectCommands("Browser Commands","Navigation Commands"); 
		 
	 }
	  @AfterMethod
	  public static void afterMethod() {		  
		    driver.close();
	  		}
	  public static void selectDate() throws InterruptedException{
		 String selectData = "05/15/2018";	
		 String[] splitDate = selectData.split("/");
		 Date d = new Date(selectData);
		 SimpleDateFormat dt = new SimpleDateFormat("MMMM/dd/yyyy");
		 String date = dt.format(d);
		 System.out.println(date);
		 String[] split = date.split("/");
		 System.out.println(split[0]+" "+split[1]+" "+split[2]);
		 String month = split[0]+" "+split[2];
		 System.out.println("month----"+month);
		 System.setProperty("webdriver.chrome.driver", "F:\\Eclipse\\chromedriver.exe");	
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.goibibo.com/flights/");
		 driver.findElement(By.xpath("//*[@id='gi_oneway_label']")).click();		
		 Thread.sleep(2000);
		 //String[] splitDate = selectData.split("/");
		//*[@id='fare_20180516']
		 String firstPart = "//*[@id='fare_";
		 //String secondPart = "']/div";
		 String finalPart = firstPart + splitDate[2]+splitDate[0]+splitDate[1]+"']";	
		 System.out.println("Selecting this date in Calender:-"+finalPart);
		 driver.findElement(By.xpath("//*[@id='searchWidgetCommon']//input[contains(@placeholder,'Choose Date')]")).click();
		 Thread.sleep(2000);
		 while(true){
			 try{
				 
				 driver.findElement(By.xpath("//*[contains(text(),'"+month+"')]")).isDisplayed();
				 driver.findElement(By.xpath(finalPart)).click();
				 break;
				  }
			 catch(Exception e){
			 driver.findElement(By.xpath("//*[@id='searchWidgetCommon']//span[contains(@class,'NavButton')]")).click();
			 Thread.sleep(2000);
			 }			 
		 }
		 driver.quit();
	  }	 
	  public static void practiceTables() {
			
				System.setProperty("webdriver.chrome.driver", "F:\\Eclipse\\chromedriver.exe");	
				 WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("http://toolsqa.wpengine.com/automation-practice-table");
				
				//Here we are storing the value from the cell in to the string variable
				String sCellValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[2]")).getText();
				System.out.println(sCellValue);
				
				// Here we are clicking on the link of first row and the last column
				driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[6]/a")).click();        
				System.out.println("Link has been clicked otherwise an exception would have thrown");
				driver.close();
			}
	  public static void practiceTable2() {
		  System.setProperty("webdriver.chrome.driver", "F:\\Eclipse\\chromedriver.exe");	
			 WebDriver driver = new ChromeDriver();
			driver.get("http://toolsqa.wpengine.com/automation-practice-table");
			String sRow = "1";
			String sCol = "2";
			
			//Here we are locating the xpath by passing variables in the xpath
			String sCellValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + sRow + "]/td[" + sCol + "]")).getText();
			System.out.println(sCellValue);
			String sRowValue = "Clock Tower Hotel";
			
			//First loop will find the 'ClOCK TWER HOTEL' in the first column
			for (int i=1;i<=5;i++){
				String sValue = null;
				sValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/th")).getText();
					if(sValue.equalsIgnoreCase(sRowValue)){
						// If the sValue match with the description, it will initiate one more inner loop for all the columns of 'i' row 
						for (int j=1;j<=5;j++){
							String sColumnValue= driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/td["+ j +"]")).getText();
							System.out.println(sColumnValue);
						}
					break;
					}
				}
			driver.close();
		}
	  public static void handlingDynamicTable(){
		  System.setProperty("webdriver.chrome.driver", "F:\\Eclipse\\chromedriver.exe");	
			 WebDriver driver = new ChromeDriver();
			driver.get("http://toolsqa.wpengine.com/automation-practice-table");
		  WebElement htmlTable = driver.findElement(By.xpath("//*[@id='content']/table/tbody"));
		  ArrayList<WebElement> rows = new ArrayList<WebElement>(htmlTable.findElements(By.tagName("tr")));
		  System.out.println("Number of rows: "+rows.size());
		  for(int rnum=0;rnum<rows.size();rnum++){
			  ArrayList<WebElement> columnsHeaders = new ArrayList<WebElement>(rows.get(rnum).findElements(By.tagName("th")));
			  if (rnum==0){
			  System.out.println("Number of columns: "+columnsHeaders.size());
			  }
			  for(int cnum=0;cnum<columnsHeaders.size();cnum++){
			  System.out.print("       "+columnsHeaders.get(cnum).getText());
			  //System.out.print("      ");
			  }			  
			  }
		  		System.out.println();
		  for(int rnum=0;rnum<rows.size();rnum++){
			  ArrayList<WebElement> columns = new ArrayList<WebElement>(rows.get(rnum).findElements(By.tagName("td")));
			  
			  for(int cnum=0;cnum<columns.size();cnum++){
			  System.out.print("       "+columns.get(cnum).getText());			  
			  }	
			  System.out.println();
			  }  
		  driver.quit();
	  }
	  public static void dragAndDrop() throws InterruptedException{
		  System.setProperty("webdriver.chrome.driver", "F:\\Eclipse\\chromedriver.exe");	
			 WebDriver driver = new ChromeDriver();
			driver.get("https://jqueryui.com/droppable");
		  Actions action = new Actions(driver);
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		  driver.switchTo().frame(0);
		  WebElement drag = driver.findElement(By.id("draggable"));
		  WebElement drop = driver.findElement(By.id("droppable"));
		  action.doubleClick(drag);
		  Thread.sleep(4000);
		  action.dragAndDrop(drag, drop).perform();
		  Thread.sleep(4000);
		  action.contextClick(drop);
		  Thread.sleep(4000);
		  driver.quit();
	  }
	  public static void browserTab() throws InterruptedException{
		  System.setProperty("webdriver.chrome.driver", "F:\\Eclipse\\chromedriver.exe");	
			 WebDriver driver = new ChromeDriver();
			driver.get("http://www.dezlearn.com/testingpage/");		
			driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//a[@id='popup']")).click();
		  String window1 = driver.getWindowHandle();/*
		  driver.findElement(By.xpath("//*[@id='fsl']/a[2]")).click();
		  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//*[@id='hero']/div[1]/div/div[1]/p[2]/a")).click();
		  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//*[@id='identifierNext']/content")).click();*/
		  Set<String> windows = driver.getWindowHandles();
		  for(String x : windows){
			  driver.switchTo().window(x);
			  System.out.println(driver.getCurrentUrl());
			  System.out.println(driver.getTitle());
		  }
		  for(String x : windows){
			  if(x.equals(window1)==false){
				  driver.switchTo().window(x);
				  break;
			  }
		  }
		  System.out.println(driver.getCurrentUrl());
		  System.out.println(driver.getTitle());
		  driver.switchTo().window(window1);
		  System.out.println(driver.getCurrentUrl());
		  System.out.println(driver.getTitle());
		  Thread.sleep(3000);
		  //Frames
		  driver.switchTo().frame("queries-iframe");
		  Thread.sleep(3000);
		  WebElement we = explicitWait(driver,"//*[@id='ninja_forms_field_11']");
		  we.sendKeys("Murali");
		  //driver.findElement(By.xpath("//*[@id='ninja_forms_field_11']")).sendKeys("Murali");
		  Thread.sleep(3000);
		  driver.switchTo().parentFrame();
		  //alert
		  driver.findElement(By.xpath("//*[@id='panel-197-0-0-1']/div/div/p[2]/button")).click();
		  Alert alert = driver.switchTo().alert();
		  Thread.sleep(3000);
		  alert.accept();
		  Thread.sleep(3000);
		  JavascriptExecutor js = ((JavascriptExecutor) driver);
		  js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		  Thread.sleep(3000);
		  js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		  Thread.sleep(3000);
			js.executeScript("window.scrollTo(0, 300);");
			  Thread.sleep(3000);
			  js.executeScript("window.scrollTo(0, -200);");
			  Thread.sleep(3000);
			  driver.get("http://www.dezlearn.com/testingpage/");	
			 // driver.switchTo().(driver.get("http://www.dezlearn.com/testingpage/"));
			  
		  driver.quit();
	  }
	  @Test
	  public static void getScreenShot() throws IOException{
		  System.setProperty("webdriver.chrome.driver", "F:\\Eclipse\\chromedriver.exe");	
			 WebDriver driver = new ChromeDriver();
			driver.get("http://www.dezlearn.com/testingpage/");		
			driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		  String screenshotName = "Failed";
		  String dateName = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  String destination = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+dateName+".png";
		  File finalDestination = new File(destination);
		  FileHandler.copy(source, finalDestination);	
		  driver.quit();
		//return destination; 	 
		  }
	  public static WebElement explicitWait(WebDriver driver,String id){
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(id)));
		return element;
		 
	  }
	  
 public static void main(String[] args) throws Exception {				
		
		/*	PracticeForm1.beforeMethod();
			PracticeForm1.formTest();
			PracticeForm1.afterMethod();
	 		selectDate();
	 		practiceTables();
	 		practiceTable2();
	 		handlingDynamicTable();
	 		dragAndDrop();
	 		browserTab();*/
	 		getScreenShot();
		}
		

	}


