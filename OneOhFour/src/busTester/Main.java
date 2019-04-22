package busTester;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	
	//TODO: output scores to csv, sql functionality
	public static void main(String[] args) throws IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the path to your lab folder: ");
		File folder = new File(buff.readLine());
		System.out.println("Enter the lab number you want to test: ");
		int labNumber = Integer.parseInt(buff.readLine());
		
		Tester test = new Tester(labNumber, folder);
		
	}
	

	
	
	
}
