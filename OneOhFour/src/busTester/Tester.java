package busTester;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Tester {
	private int labNumber;
	private static WebDriver driver;
	private File folder;
	
	public Tester(int labNumber, File folder) {
		this.labNumber = labNumber;
		this.folder = folder;
		File[] contents = folder.listFiles();
		int[] scores = this.test();
		for(int i = 0; i < scores.length; i++) System.out.format("Score for %s: %d%n", contents[i].getName(), scores[i]);
	}

	
	public int[] test() {
		switch (this.labNumber) {
			case 1:
				return labOneTest();
			case 2:
				return labTwoTest();
			case 3:
				return labThreeTest();
			case 4:
				return labFourTest();
			default:
				return new int[0];
		}
	}
	
	private int[] labOneTest() {
		
		File[] labs = this.folder.listFiles();
		int[] res = new int[labs.length];
		for (int i = 0; i < labs.length; i++) {
			int points = 0;
			initWeb();
			driver.get(labs[i].getPath());
			if (driver.switchTo().alert().getText().equals("Hello, world!")) {
				points += 50;
			}
			driver.switchTo().alert().accept();
			driver.switchTo().alert().accept();
			driver.switchTo().alert().sendKeys("John");
			driver.switchTo().alert().accept();
			String body = driver.findElement(By.xpath("//body")).getText();
			if (body.contains("John")) {
				points += 50;
			}
			
			endWeb();
			res[i] = points;
		}
		
		return res;
	}
	
	private int[] labTwoTest() {
		int[] res = new int[0];
		return res;
	}
	
	private int[] labThreeTest() {
		int[] res = new int[0];
		return res;
	}
	
	private int[] labFourTest() {
		int[] res = new int[0];
		return res;
	}
	
	
	public static void initWeb() {
		String path = System.getProperty("user.home");
		System.setProperty("webdriver.chrome.driver", path + "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public static void endWeb() {
		driver.quit();
	}
	
	
	
}
