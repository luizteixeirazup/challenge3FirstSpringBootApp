package br.com.zup.challenge.three.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.zup.challenge.three.repository.FileMapRepository;

@Component
public class FileMapService {
	
	private FileMapRepository repository;
	private Map<String, String> values;
	
	private String pathName = "C:\\Users\\Luiz Guilherme\\Desktop\\Root\\File1.txt";
	
	@Autowired
	public FileMapService(FileMapRepository repository) throws IOException {
		values = repository.readFile(pathName);
		this.repository = repository;
	}
	
	public void get(String key) {
		System.out.println(values.get(key));
	}

	public void set(String key, String value) throws FileNotFoundException {
		values.put(key, value);
		
		this.repository.saveFile(values, pathName);
	}

	public void delete(String key) throws FileNotFoundException {
		values.remove(key);
		
		this.repository.saveFile(values, pathName);
	}

	public void list() {
		Set<String> keys = values.keySet();
			
		for (String key : keys) {
			System.out.println(key + ":" + values.get(key));
		}
	}
}
