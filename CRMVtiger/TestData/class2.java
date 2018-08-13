import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class class2 {
	
@BeforeMethod
	
	public void BeforeMethod() {
		System.out.println("hi i am BeforeMethod class2");
	}
	
	@Test
	public void method2() {
		System.out.println("hi i am @Test class2");
	}
	
	@AfterMethod

	
	public void AfterMethod() {
		System.out.println("hi i am AfterMethod class2");
	}

}
