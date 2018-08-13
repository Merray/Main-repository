package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.PersonneRepository;
import repositories.SalleRepository;

@Service
public class PersonneService {

	@Autowired
	private PersonneRepository personneRepository;
	@Autowired
	private SalleRepository salleRepository;
	
}
