package module2;

import java.util.HashMap;
import java.util.Map;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class LifeExpectancy extends PApplet {

	UnfoldingMap map;
	Map<String, Float> lifeExpByCountry;
	
	public void setup() {
	
		size(800, 600, OPENGL);
		
		map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
		// Event Dispatcher
		MapUtils.createDefaultEventDispatcher(this, map);
		// Load file into memory
		lifeExpByCountry = loadLifeExpectancyFromCSV("D:/eclipse/workspace/UCSDUnfoldingMaps/data/LifeExpectancyWorldBank.csv");
	}
	
	private Map<String, Float> loadLifeExpectancyFromCSV(String fileName) {
		// TODO Auto-generated method stub
		Map<String, Float> lifeExpMap = new HashMap<String, Float> ();
		// Load file as amount of rows
		String[] rows = loadStrings(fileName);
		
		for (String row: rows) {
			// Split row by columns
			String[] columns = row.split(",");
			// Parse float
			float value = Float.parseFloat(columns[5]);
			// Fills Map with columns data
			lifeExpMap.put(columns[4], value);
		}
		
		return lifeExpMap;
	}

	public void draw() {
		map.draw();
	}
	
}
