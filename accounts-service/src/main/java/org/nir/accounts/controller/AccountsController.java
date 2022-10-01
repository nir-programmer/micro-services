package org.nir.accounts.controller;


import org.nir.accounts.config.AccountsServiceConfig;
import org.nir.accounts.model.Accounts;
import org.nir.accounts.model.Customer;
import org.nir.accounts.model.Properties;
import org.nir.accounts.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class AccountsController 
{
	@Autowired AccountsRepository accountsRepository; 
	
	@Autowired
	AccountsServiceConfig accountsConfig;
	
	/**
	 *   Given the customer input , check  the DB if there is accounts with the customer.id , and returns accounts details to who
	 *   made the call to this end point
	 * 
	 */
	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer)
	{
		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
		
		if(accounts != null)
			return accounts; 
		
		else 
			return null;
		
	}
	
	
	@GetMapping("/account/properties")
	public String getPropertyDetails() throws JsonProcessingException 
	{
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		Properties properties = new Properties(accountsConfig.getMsg(), accountsConfig.getBuildVersion(), 
				accountsConfig.getMailDetails() ,accountsConfig.getActiveBranches());
		
		String jsonStr = ow.writeValueAsString(properties);
		return jsonStr;
				
	}
//	@GetMapping("/account/properties")
//	public String getPropertyDetails() throws JsonProcessingException {
//		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//		Properties properties = new Properties(accountsConfig.getMsg(), accountsConfig.getBuildVersion(),
//				accountsConfig.getMailDetails(), accountsConfig.getActiveBranches());
//		String jsonStr = ow.writeValueAsString(properties);
//		return jsonStr;
//	}
	

}
