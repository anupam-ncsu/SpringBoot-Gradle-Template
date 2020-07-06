package com.template.springbootgradle.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.template.springbootgradle.models.Citizen;

@Service
public class CitizenService {
	

	private List<Citizen> CitizenList = new ArrayList<>(Arrays.asList(

            new Citizen(1,"John Doe"),
            new Citizen(2,"Michael Jackson"),
            new Citizen(3,"Mannie Queen")
    ));
	
	public List<Citizen> getAllCitizens(){
		return CitizenList;
	}
	
	public Citizen getCitizen(String id) {
		return CitizenList.stream().filter(Citizen -> Citizen.getId().equals(Integer.parseInt(id))).findFirst().get();
	}

	public void addCitizen(Citizen citizen){
		CitizenList.add(citizen);
	}
	
	public void deleteCitizen(Citizen citizen) {
		CitizenList.remove(citizen);
	}
	
	public void updateCitizen(Citizen citizen) {
		for(Citizen ct : CitizenList) {
			if(ct.getId().equals(citizen.getId())) {
				CitizenList.set(citizen.getId()-1,citizen);
			}
		}
	}
	
	



}
