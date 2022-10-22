package com.care.ajax;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service
public class AjaxService {
		@Autowired private AjaxRepository repo;

		public int insert() throws FileNotFoundException, IOException {
			ClassPathResource resource = new ClassPathResource("ex5.json");
			FileReader reader = new FileReader(resource.getFile());
			
			Gson gson = new Gson(); 
			JsonObject obj = gson.fromJson(reader, JsonObject.class);
			
			JsonArray array = obj.get("cd").getAsJsonArray(); 
			for(int i = 0; i < array.size(); i++) {
				JsonObject o = array.get(i).getAsJsonObject();
				AjaxDTO dto = new AjaxDTO();
				dto.setTitle(o.get("title").toString());
				dto.setArtist(o.get("artist").toString());
				dto.setPrice(o.get("price").toString());
				
				int result = repo.insert(dto);
				if(result == 0)
					return 0;
				}
			return 1;
		}
}
