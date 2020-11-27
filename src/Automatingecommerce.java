import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automatingecommerce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] neededItems = {"Cucumber", "Beetroot", "Tomato", "Beans"};
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		List<WebElement> productNames = driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		List itemsNeededList = Arrays.asList(neededItems);
		
		
		int j = 0;
		for(int i=0; i<productNames.size(); i++) {
			
			String[] product = productNames.get(i).getText().split("-");
			String productName = product[0].trim();
			
			if(itemsNeededList.contains(productName)) {
				
				j++;
				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==neededItems.length) {
					break;
				}
			}
			
		}
		
		


	}

}
