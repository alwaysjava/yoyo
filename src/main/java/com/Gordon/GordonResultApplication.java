package com.Gordon;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
public class GordonResultApplication {
	
	public static void main(String[] args) {
SpringApplication.run(GordonResultApplication.class, args);
			BufferedReader br = null;
			try {
				//HardCoded Code Can be externalize to application.yml in spring boot project
				br = new BufferedReader(new FileReader("e:\\data.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			String line;
			ArrayList<String> satisfaction = new ArrayList<>();
			ArrayList<String> timeTakenToEat = new ArrayList<>();

			// Conversion of columns in file to List
			try {
				while ((line = br.readLine()) != null) {
					String[] st = line.split(" ");
					System.out.println(Arrays.toString(st));
					satisfaction.add(st[0]);
					timeTakenToEat.add(st[1]);
				}

			} catch (IOException | NullPointerException e) {
				e.printStackTrace();
			}

			// Getting List of our Interest
			ArrayList<Integer> satisfactionInteger = new ArrayList<>();
			for (String s : satisfaction) {
				satisfactionInteger.add(Integer.parseInt(s));
			}
			Collections.sort(satisfactionInteger);

			// Final Result
			System.out.println(
					"Highest Satisfaction For Gordon is:" + satisfactionInteger.get((satisfactionInteger.size()) - 1));
		}

	}

