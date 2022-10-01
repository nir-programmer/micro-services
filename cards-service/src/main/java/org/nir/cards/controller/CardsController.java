package org.nir.cards.controller;

import java.util.List;

import org.nir.cards.model.Cards;
import org.nir.cards.model.Customer;
import org.nir.cards.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
	
	@Autowired
	private CardsRepository cardsRepository; 
	
	
	/**
	 * OK!!!
		curl -X POST http://localhost:8081/myCards -H 'Content-Type: application/json' -d '{"customerId" : 1}'
	 */
	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestBody Customer customer) {
		List<Cards> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
		if (cards != null) {
			return cards;
		} else {
			return null;
		}

	}

}
