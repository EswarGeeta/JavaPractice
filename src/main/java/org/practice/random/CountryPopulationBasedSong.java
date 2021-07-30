package org.practice.random;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class CountryPopulationBasedSong {

	private final Map<String, CountryDetails> countryMap = new HashMap<>();

	public CountryPopulationBasedSong() {
	
		countryMap.put("india", new CountryDetails("india", "jana gana mana", 3000));
		countryMap.put("china", new CountryDetails("china", "china song", 5000));
		countryMap.put("japan", new CountryDetails("japan", "japan song", 2000));

		int totalPopulation = countryMap.values().stream().mapToInt(CountryDetails::getPopulation).sum();
		double fraction = 0;
		for(CountryDetails country : countryMap.values()) {
			country.setFractionLower(fraction);
			fraction += (double) country.getPopulation()/totalPopulation;
			country.setFractionUpper(fraction);
		}
	}

	public String getSong() {
		double random = Math.random();
		Optional<CountryDetails> result=  countryMap.values().stream().filter(country -> country.getFractionLower() <= random && random <= country.getFractionUpper() ).findFirst();
		if(result.isPresent())
			return result.get().getSongName();
		else 
			return "default song";
	}

	public static void main(String[] args) {
		CountryPopulationBasedSong controller = new CountryPopulationBasedSong();
		Map<String, Integer> songs = new HashMap<>();
		for(int i=0; i<1000; i++) {
			
			String song = controller.getSong();
			if(songs.containsKey(song))
				songs.put(song, songs.get(song)+1);
			else
				songs.put(song, 1);
		}

		for(Entry<String, Integer> song : songs.entrySet()) {
			System.out.println(song.getKey() + " " + song.getValue());
		}
	}

	@Getter
	@Setter
	class CountryDetails{
		String name;
		String songName;
		int population;
		double fractionLower;
		double fractionUpper;

		public CountryDetails(String name, String songName, int population) {
			this.name = name;
			this.songName = songName;
			this.population = population;
		}
	}

}
