package module1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import processing.core.PApplet;
import processing.core.PImage;

public class DynamicEllipse extends PApplet {

	private PImage webImg;
	
	public void setup() {
		size(800, 800, P2D);  // Set up the Applet window to be 800x600
		                      // The OPENGL argument indicates to use the 
		                      // Processing library's 2D drawing
		                      // You'll learn more about processing in Module 3

		// This sets the background color for the Applet.  
		// Play around with these numbers and see what happens!
		// this.background(128, 128, 128);	
		// String url = "http://orig08.deviantart.net/80aa/f/2009/013/6/8/o_by_p0rg.jpg";
		
		// this.webImg = loadImage(url, "jpg");
		
		URL urlTest = null;
		try {
			urlTest = new URL("http://www.goog9999le.com");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			final URLConnection conn = urlTest.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void draw() {
		
		// image(this.webImg, 0, 0);
		
		ellipse(width/2, height/2, height/2, height/2);
		
	}
}
