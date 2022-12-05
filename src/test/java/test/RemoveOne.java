package test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import page.CheckBox;
import util.BrowserFactory;

public class RemoveOne extends BrowserFactory{
	
	WebDriver driver;
	CheckBox checkBoxPage;
	
	@Before
	public void setUp()
	{
		driver = BrowserFactory.init();
		checkBoxPage = PageFactory.initElements(driver, CheckBox.class);
		driver.get("https://techfios.com/test/103/index.php");
	}
	
	@Test
	public void removeOne() {
		// RemoveOne
		//checkBoxPage.removeOneElement();
		Assert.assertEquals(true, checkBoxPage.removeOneElement());
	}

}
