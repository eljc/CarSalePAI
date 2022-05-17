package com.eljc.carsale.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.eljc.carsale.model.Makes;

@DataJpaTest
@ActiveProfiles("test")
public class MakesRepositoryTest {

	@Autowired
	private MakesRepository makeRepository;
	
	@DisplayName("Test FINDALL MAKES")	 
	@Test
	public void testFindByMakeName() {	
		List<Makes> makes = makeRepository.findAll();
		
		assertEquals(2, makes.size());
		
		assertFalse(makes.isEmpty());
	}

}
