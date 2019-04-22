package busTester;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {
	private int labNumber;
	private static WebDriver driver;
	private File folder;
	
	public Tester(int labNumber, File folder) {
		this.labNumber = labNumber;
		this.folder = folder;
		System.out.println(this.test());
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
	
	
	
}
