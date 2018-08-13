upackage com.crm.vtiger.objectrepositorylib;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

	@FindBy(name="user_name")
	private WebElement username;
	
	@FindBy(name="user_password")
	private WebElement pass;

	@FindBy(id="submitButton")
	private WebElement login;
	
	
	public void LoginIntoApp(String USER,String PASS) throws IOException
	{
		username.sendKeys(USER);
		pass.sendKeys(PASS);
		login.click();
	}
	
}
