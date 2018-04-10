package executionEngine;

import org.testng.annotations.*;

public class TestNG_Operations {
	
	@BeforeSuite
	public static void beforeSuit(){
		System.out.println("Before Suit");
	}
	@BeforeTest
	public static void beforeTest(){
		System.out.println("Before Test");
	}
	@BeforeClass
	public static void beforeClass(){
		System.out.println("Before Class");
	}
	@BeforeMethod
	public static void beforeMethod(){
		System.out.println("Before Method");
	}
	@AfterSuite
	public static void afterSuit(){
		System.out.println("After Suit");
	}
	@AfterTest
	public static void afterTest(){
		System.out.println("After Test");
	}
	@AfterClass
	public static void afterClass(){
		System.out.println("After Class");
	}
	@AfterMethod
	public static void afterMethod(){
		System.out.println("After Method");
	}
	@Test(priority=1, invocationCount=3,invocationTimeOut=2000)
	public static void method1(){
		System.out.println("I am in method1");
	}
	
	@Test(enabled=false)
	public static void method2(){
		System.out.println("I am in method2");
	}
	@Test
	public static void method3(){
		System.out.println("I am in method3");
	}
	@Test(priority=4,dependsOnMethods={"method5"})
	public static void method4(){
		System.out.println("I am in method4");
	}
	@Test(dependsOnMethods={"method1"})
	public static void method5(){
		System.out.println("I am in method5");
	}
	@Test(alwaysRun=true)
	public static void method6(){
		System.out.println("I am in method6");
	}
	@Test(invocationCount=3,invocationTimeOut=2000,description="Method7")
	public static void method7(){
		System.out.println("I am in method7");
	}
	@Test(groups={"group1"})
	public static void method8(){
		System.out.println("I am in method8");
	}
	@Test(groups={"group1"})
	public static void method9(){
		System.out.println("I am in method9");
	}
	@Test(groups={"group1"},dataProvider="getData")
	public static void method10(String name,String password){
		System.out.println("name and password "+name+" "+password);
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[3][2];
		data[0][0]="U1";
		data[0][1]="P1";
		data[1][0]="U2";
		data[1][1]="P2";
		data[2][0]="U3";
		data[2][1]="P3";		
		return data;	
		
	}
	@Parameters({"Browser"})
	@Test(groups={"group1"})
	public static void method11(String browser){
		System.out.println("name and browser "+browser);
	}
		
	}
	

             