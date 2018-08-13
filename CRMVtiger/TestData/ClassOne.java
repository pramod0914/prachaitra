import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClassOne {
	
@BeforeMethod
	
	public void BeforeMethod() {
		System.out.println("hi i am BeforeMethod classone");
	}
	
	@Test
	public void method2() {
		System.out.println("hi i am @Test classone");
	}
	
	@AfterMethod

	
	public void AfterMethod() {
		System.out.println("hi i am AfterMethod classone");
	}

}
