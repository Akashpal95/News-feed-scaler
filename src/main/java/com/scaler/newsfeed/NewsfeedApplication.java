package com.scaler.newsfeed;

import java.util.Scanner;

import org.hibernate.internal.util.securitymanager.SystemSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.scaler.newsfeed.commands.CommandManager;


@SpringBootApplication
public class NewsfeedApplication implements CommandLineRunner{

	@Autowired
	CommandManager commandManager; 
	public static void main(String[] args) {
		
		SpringApplication.run(NewsfeedApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scn = new Scanner(System.in);
		while(true){
			String input = scn.nextLine();
			commandManager.execute(input);
		}
		// System.out.println("Hello");
	}

}
