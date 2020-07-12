package com.Listeners;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DisableImages {
	
		
	public static void main(String[] args) {
		
		  WebDriverManager.chromedriver().setup();
		  /* HashMap<String, Object> images = new HashMap<String, Object>();
          images.put("images", 2);
          HashMap<String, Object> prefs = new HashMap<String, Object>();
          prefs.put("profile.default_content_setting_values", images);

          ChromeOptions options=new ChromeOptions();
          //options.setExperimentalOption("prefs", prefs);*/
		
		 ChromeOptions options=new ChromeOptions();
		 options.addExtensions(new File("C:\\Users\\Sharma\\Downloads\\Block-image_v1.0.crx"));
         WebDriver driver=new ChromeDriver(options);
          
          driver.get("https://www.google.com/search?q=Block-image_v1.0.crx&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjKj5viocXqAhUIX30KHdEIB2cQ_AUoAXoECAsQAw&biw=1366&bih=576");

	}

}
