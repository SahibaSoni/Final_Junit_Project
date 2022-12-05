package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckBox {
	
	WebDriver driver;
	
	public CheckBox(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH,using = "//input[@onclick = 'checkAll();']")WebElement toggleAllCheckbox;
    @FindBy(how = How.XPATH,using = "//div[@id = 'todos-content']//input[@type = 'checkbox']")List<WebElement> listAllCheckBox;
    @FindBy(how = How.NAME,using = "submit") WebElement removeElement;
    @FindBy(how = How.XPATH,using = "//div[@id = 'todos-content']//input[@type = 'checkbox']")List<WebElement> listAllCheckBoxAfterRemove;
    //@FindBy(how = How.XPATH,using = "//div[@id = 'todos-content']//input[@type='checkbox']")List<WebElement> LIST_OF_WEBELEMENT_LATER;
	
	public String clickToggleAll()
	{
		toggleAllCheckbox.click();
		String actualToggleAllText = toggleAllCheckbox.getAttribute("name");
		System.out.println(actualToggleAllText);
		return actualToggleAllText;
	}
	
	public boolean validateAllListCheckBox()
	{
		int total_Element_List =listAllCheckBox.size();
		int count=0;
		
		for(int i =0;i<total_Element_List;i++)
		{
			if(listAllCheckBox.get(i).isSelected())
			{
				count++;
			}
		}	
		System.out.println(count);
		if(total_Element_List == count)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean removeOneElement()
	{
		int total_Element_List =listAllCheckBox.size();
		System.out.println("-------------------"+total_Element_List);
		
		listAllCheckBox.get(0).click();
		removeElement.click();
		int after_Remove_List = listAllCheckBoxAfterRemove.size();
		System.out.println("-------------------"+after_Remove_List);
		
		if(total_Element_List > after_Remove_List)
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean allCheckBoxRemove()
	{
		toggleAllCheckbox.click();
		removeElement.click();
		
		int total_Element_List =listAllCheckBox.size();
		System.out.println("-------------------"+total_Element_List);
		
		int after_Remove_List = listAllCheckBoxAfterRemove.size();
		System.out.println("-------------------"+after_Remove_List);
		
		if(total_Element_List ==0 && after_Remove_List ==0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	

}
