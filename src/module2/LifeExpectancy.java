package module2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class LifeExpectancy extends PApplet {

	private UnfoldingMap map;
	private Map<String, Float> lifeExpByCountry;
	
	List<Feature> countries;
	List<Marker> countryMarkers;
	
	public void setup() {
	
		size(800, 600, OPENGL);
		
		map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
		// Event Dispatcher
		MapUtils.createDefaultEventDispatcher(this, map);
		// Load file into memory
		lifeExpByCountry = loadLifeExpectancyFromCSV("D:/eclipse/workspace/UCSDUnfoldingMaps/data/LifeExpectancyWorldBank.csv");
		// Load Countries and Markers
		countries = GeoJSONReader.loadData(this, "D:/Eclipse/Workspace/UCSDUnfoldingMaps/data/countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);
	}
	
	private Map<String, Float> loadLifeExpectancyFromCSV(String fileName) {
		// TODO Auto-generated method stub
		Map<String, Float> lifeExpMap = new HashMap<String, Float> ();
		// Load file as amount of rows
		String[] rows = loadStrings(fileName);
		
		int i = 1;
		
		for (String row: rows) {
			// Split row by columns
			String[] columns = row.split(",");
			// Parse float
			String strVal = columns[5];
			
			//if (!strVal.substring(0, 0).equals("\"")) {
			if (strVal.equals("..")) {
				strVal = "0"; }
			
			try {
			float value = Float.parseFloat(strVal); //
			
			String key = columns[4];
			// Fills Map with columns data
			lifeExpMap.put(key, value); // Country ID, Life expectancy float
			
			System.out.println("Rownumber - " + i);
			
			i++;
			} catch (NumberFormatException e) {
				System.out.println("Rownumber - ERROR");
			} 
			//}
		}
		
		return lifeExpMap;
	}

	public void draw() {
		map.draw();
	}
	
}
