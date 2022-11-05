package com.mager.oathspringexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.webjars.WebJarAssetLocator;

import java.util.Map;

@SpringBootApplication
public class OathspringexampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OathspringexampleApplication.class, args);
    }

	@Autowired
	ClientRegistrationRepository clientRegistrationRepository;

	@Override
	public void run(String... args) throws Exception {
		WebJarAssetLocator locator = new WebJarAssetLocator();
		Map<String, WebJarAssetLocator.WebJarInfo> allWebJars = locator.getAllWebJars();
		allWebJars.forEach((s, webJarInfo) -> System.out.println(s + " - " + webJarInfo.toString()));
		System.out.println(locator.getFullPath("js.cookie.js"));
		System.out.println("clientRegistrationRepository.findByRegistrationId(\"google\").toString() = " + clientRegistrationRepository.findByRegistrationId("google").toString());
		System.out.println("clientRegistrationRepository.findByRegistrationId(\"google\").toString() = " + clientRegistrationRepository.findByRegistrationId("github").toString());
		ClientRegistration google = clientRegistrationRepository.findByRegistrationId("google");
		google.getScopes().forEach(System.out::println);
		System.out.println("google.getAuthorizationGrantType().getValue() = " + google.getAuthorizationGrantType().getValue());
		System.out.println("google.getClientAuthenticationMethod().getValue() = " + google.getClientAuthenticationMethod().getValue());

	}
}
