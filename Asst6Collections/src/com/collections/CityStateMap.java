package com.collections;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class CityStateMap {

	HashMap <String, String> cityStateMap;
	
	public CityStateMap() {
		cityStateMap = new HashMap<>();
	}
	
	public void populateCityStateMap(String filename) {
		File file = new File(filename);
		Properties properties = new Properties();
		
		try(FileReader fr = new FileReader(file)) {
			properties.load(fr);
			
			for (String key : properties.stringPropertyNames()) {
				cityStateMap.put(key, properties.getProperty(key));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Map<String, String> getCityStateMap() {
		return cityStateMap;
	}
	
	public ArrayList<String> getAllCities() {
		return new ArrayList<>(cityStateMap.keySet());
	}
	
	public ArrayList<String> getAllStates() {
		return new ArrayList<>(cityStateMap.values());
	}
	
	public ArrayList<String> getCitiesForState(String state) {
		ArrayList <String> cities = new ArrayList<>();
		
		for (String city : cityStateMap.keySet()) {
			if (cityStateMap.get(city).equals(state)) {
				cities.add(city);
			}
		}
		
		return cities;
	}
	
	@Override
	public String toString() {
		return "CityStateMap [cityStateMap=" + cityStateMap + "]";
	}
	
	public void add(String city, String state) {
		if (cityStateMap.containsKey(city)) {
			System.out.println("Duplicate city detected. Overriding value.");
		}
		
		cityStateMap.put(city, state);
	}
	
	public void deletePairsForState(String state) {
		Iterator <String> itr = cityStateMap.values().iterator();
		
		while (itr.hasNext()) {
			if (itr.next().equals(state)) {
				itr.remove();
			}
		}
	}
	
	public static void main(String[] args) {
		String filename = "cityStateValues.txt";
		CityStateMap csm = new CityStateMap();
		
		csm.populateCityStateMap(filename);
		System.out.println("CityStateMap from file : ");
		System.out.println(csm.getCityStateMap() + "\n");
		
		ArrayList <String> cityList = csm.getAllCities();
		System.out.println("List of all cities :");
		System.out.println(cityList + "\n");
		
		ArrayList <String> stateList = csm.getAllStates();
		System.out.println("List of all states :");
		System.out.println(stateList + "\n");
		
		ArrayList <String> cityListForMah = csm.getCitiesForState("Maharashtra");
		System.out.println("List of all cities from Maharashtra : ");
		System.out.println(cityListForMah + "\n");

		csm.add("Pune", "Delhi");
		System.out.println("Added Pune : Delhi --> " + csm + "\n");
		
		csm.add("Pune", "Maharashtra");
		System.out.println("Added Pune : Maharashtra --> " + csm + "\n");
		
		csm.add("Hubli", "Karnataka");
		System.out.println("Added Hubli : Karnataka --> " + csm + "\n");
		
		System.out.println("Removing all cities from state Karnataka : ");
		csm.deletePairsForState("Karnataka");
		System.out.println(csm);
	}

}
