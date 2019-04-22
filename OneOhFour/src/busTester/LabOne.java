package busTester;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;


public class LabOne {
	
	//TODO: add JS comment criteria
	public static int[] labOneTest(File folder) {
			
			File[] labs = folder.listFiles();
			int[] res = new int[labs.length];
			for (int i = 0; i < labs.length; i++) {
				int points = 0;
				Tester.initWeb();
				Tester.driver.get(labs[i].getPath());
				try {
					if (Tester.driver.switchTo().alert().getText().equals("Hello, world!")) {
						points += 50;
					}
					Tester.driver.switchTo().alert().accept();
					Tester.driver.switchTo().alert().accept();
					Tester.driver.switchTo().alert().sendKeys("John");
					Tester.driver.switchTo().alert().accept();
					String body = Tester.driver.findElement(By.xpath("//body")).getText();
					if (body.contains("John")) {
						points += 50;
					}
					else {
						System.out.println("Comment: Name not displayed on page after prompt.");
					}
				} catch (NoAlertPresentException e) {
					System.out.println("Comment: No alert displayed");
				}
				
				Tester.endWeb();
				res[i] = points;
			}
			
			return res;
		}
}
