package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FileHandling extends WebDriverInitialization {

	WebDriver driver;
	public static File oldfilename;
	public static File newfilename;

	

	public FileHandling() {
		// TODO Auto-generated constructor stub
		fileRname();
	}



	public static void fileRname() {
		System.out.println("**************************************************************************");
		oldfilename = new File("C:\\Users\\rahul\\git\\Affirm\\Affirm\\Downloads\\JoinedFile.pdf");
		newfilename = new File(
				"C:\\Users\\rahul\\git\\Affirm\\Affirm\\Downloads\\" + WebDriverInitialization.TC_Name + "PDF.pdf");
		Boolean flag= oldfilename.renameTo(newfilename);
		if (flag)
			System.out.println("Filename is updated");
		else
			System.out.println("File Rename failed");

	}

}
