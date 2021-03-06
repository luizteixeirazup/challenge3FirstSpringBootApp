package br.com.zup.challenge.three.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.zup.challenge.three.service.FileMapService;

@Component
public class FileMapController {

	@Autowired
	private FileMapService fileMapService;

	public void run(String... args) {
		try {
			if (args[0].equals("get")) {
				fileMapService.get(args[1]);
			} else if (args[0].equals("set")) {
				String key = args[1].substring(0, args[1].indexOf(":"));
				String value = args[1].substring(args[1].indexOf(":") + 1,args[1].length());

				fileMapService.set(key, value);
			} else if (args[0].equals("delete")) {
				fileMapService.delete(args[1]);
			} else if (args[0].equals("list")) {
				fileMapService.list();
			} else {
				System.out.println("Função não encontrada!");
			}
		} catch (Exception e) {
			System.out.println("Deu Exceção: " + e);
		}
	}
}
