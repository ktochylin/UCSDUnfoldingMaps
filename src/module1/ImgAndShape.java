package module1;

import processing.core.PApplet;
import processing.core.PImage;

public class ImgAndShape extends PApplet{

	private String url = "http://www.tabletwallpapers.org/download/earth-wallpaper_1024x1024.png";
	private PImage img;
	
	public void setup() {
		
		size(200, 300, P2D);
		
		img = loadImage(url, "png");
	}
	
	public void draw() {
		background(0);
		// Heavy action
		// img = loadImage(url, "png");
		img.resize(width, height);
		image(img, 0, 0);
		ellipse(width/4, height/5, height/5, height/5);
		fill(255, 209, 0);
		stroke(255, 209, 0);
	}
}
	
