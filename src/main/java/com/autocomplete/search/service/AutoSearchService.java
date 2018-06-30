package com.autocomplete.search.service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AutoSearchService {

	private final Trie<String, String> cityTrie = new PatriciaTrie<>();

	private Logger logger = LoggerFactory.getLogger(AutoSearchService.class);

	/**
	 * THis is not necessary if we use Elastic Search which uses lucene which can handle any size of data
	 */
	public AutoSearchService() {
		try {
			//Loading the city names file
			File file = new File(this.getClass().getResource("/cities.txt").toURI());

			List<String> cities = FileUtils.readLines(file, "UTF-8");

			//Initializing fixed city as Radix Trie
			for (String city : cities) {
				cityTrie.put(city.toUpperCase(), city);
			}

		} catch (IOException | URISyntaxException e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * Return the list of cities which are starts with start and maximum of atmost
	 * @param start
	 * @param atmost
	 * @return
	 */
	public List<String> getCitySuggestions(String start, int atmost) {
		return cityTrie.prefixMap(start).values().stream().limit(atmost).collect(Collectors.toList());
	}

}
