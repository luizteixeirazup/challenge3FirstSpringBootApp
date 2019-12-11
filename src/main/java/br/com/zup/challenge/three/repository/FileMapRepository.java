package br.com.zup.challenge.three.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class FileMapRepository {

	public Map<String, String> readFile(String pathName) throws IOException {
		FileReader file = new FileReader(pathName);
		BufferedReader reader = new BufferedReader(file);

		Map<String, String> values = new HashMap<String, String>();

		String line = reader.readLine();

		while (line != null) {
			String key = line.substring(0, line.indexOf(":"));
			String value = line.substring(line.indexOf(":") + 1,line.length());

			values.put(key, value);

			line = reader.readLine();
		}

		reader.close();
		return values;
	}

	public void saveFile(Map<String, String> values, String pathName) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(pathName);

		Set<String> keys = values.keySet();

		for (String key : keys) {
			writer.println(key + ":" + values.get(key));
		}

		writer.close();
	}
}
