package org.nir.cards.repository;

import java.util.List;

import org.nir.cards.model.Cards;
import org.springframework.data.repository.CrudRepository;

//Why Long? the card id is int
public interface CardsRepository extends CrudRepository<Cards, Long> 
{
	
	List<Cards> findByCustomerId(int customerId);
}
