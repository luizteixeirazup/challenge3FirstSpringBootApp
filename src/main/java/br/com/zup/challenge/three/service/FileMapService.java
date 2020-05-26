package br.com.zup.challenge.three.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class FileMapService {

	private String pathName = "C:/Users/Luiz Guilherme/Desktop/Notes/Arquivos PGG/Arquivo Challenge3 PGG.txt";
	
	private Map<String, String> values;

	public FileMapService() throws Exception {
		this.values = readFile(pathName);
	}
	
	public Map<String, String> readFile(String pathName) throws Exception {
		FileReader file = new FileReader(pathName);
		BufferedReader reader = new BufferedReader(file);
		String line = reader.readLine();

		Map<String, String> values = new HashMap<String, String>();

		while (line != null) {
			String key = line.substring(0, line.indexOf(":"));
			String value = line.substring(line.indexOf(":") + 1,line.length());

			values.put(key, value);

			line = reader.readLine();
		}

		reader.close();
		return values;
	}
	
	public void saveFile(Map<String, String> values, String pathName) throws Exception {
		PrintWriter writer = new PrintWriter(pathName);

		Set<String> keys = values.keySet();

		for (String key : keys) {
			writer.println(key + ":" + values.get(key));
		}

		writer.close();
	}


	public void get(String key) throws Exception {
		System.out.println(values.get(key));
	}

	public void set(String key, String value) throws Exception {
		values.put(key, value);
		saveFile(values, pathName);
	}

	public void delete(String key) throws Exception {
		values.remove(key);
		saveFile(values, pathName);
	}

	public void list() throws Exception {
		Set<String> keys = values.keySet();
		for (String key : keys) {
			System.out.println(key + ":" + values.get(key));
		}
	}
}
