package br.com.zup.challenge.three.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.zup.challenge.three.service.FileMapService;

@Component
public class FileMapController{

	@Autowired
	private FileMapService service;

	public void run(String... args) {
		try {
			
//			FileMapRepository repository = new FileMapRepository();
//			service = new FileMapService(repository);
			
			if (args[0].equals("get")) {
				service.get(args[1]);
			} else if (args[0].equals("set")) {			
				String line = args[1];
				String key = line.substring(0, line.indexOf(":"));
				String value = line.substring(line.indexOf(":") + 1,line.length());
				
				service.set(key, value);
			} else if (args[0].equals("delete")) {
				service.delete(args[1]);
			} else if (args[0].equals("list")) {
				service.list();
			} else {
				System.out.println("Função não encontrada!");
			}
		} catch (Exception e) {
			System.out.println("Deu Exceção: " + e);
		}
	}

}
