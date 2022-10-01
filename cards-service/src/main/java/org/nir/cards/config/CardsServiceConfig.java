package org.nir.cards.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Configuration
@Setter 
@Getter @Data @ToString
//to load all the properties with the prefix "accounts" - during startup - ask the config server
@ConfigurationProperties(prefix = "cards")
public class CardsServiceConfig {
	
	private String msg;
	//spring will remove "-" form a proprty name: accounts.build-version
	private String buildVersion; 
	
	//I have many properties that start with accounts.mailDetails : 
	//accounts.mailDetails.hostName=prod-accounts@nir.com , accounts.mailDetails.port=8080 , etc:key value pairs:  (hostName, prod-accounts@nir.com)
	private Map<String, String> mailDetails;
	private List<String> activeBranches;


}
