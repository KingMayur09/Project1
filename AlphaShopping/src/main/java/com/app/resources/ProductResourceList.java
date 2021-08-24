package com.app.resources;

import org.apache.log4j.Logger;

import com.app.Main;

public class ProductResourceList {

	private static Logger log = Logger.getLogger(Main.class);

	public static void productListByName() {

		String[] productList = { "Tv", "Mobile", "Laptop", "T-shirt", "Shirt", "Jeans",
				"Dishes", "Dinner-set", "Bumbells","Coronil","Immunity-buster","Complain","Wrist-band","Watch","Car-Toy","Shampoo","Hair Oil"};

		log.info("**************************************************");
		for (int i = 0; i < productList.length; i++) {

			log.info((i + 1) + ".)" + productList[i]);
		}
	}
	public static void productListByCategory() {

		String[] productList = { "Electronics", "Clothing",   "Grocery", "Health-Beauty",
				"Sports & Fitness", "Toys" };

		log.info("**************************************************");
		for (int i = 0; i < productList.length; i++) {

			log.info((i + 1) + ".)" + productList[i]);
		}
	}
	public static void productListByCompany() {

		String[] productList = { "LG", "Sony", "Vu", "Denizen", "Wrangler", "Dell","Hp","Lenovo","Zenith","Navia","Patanjali","Rolex","Dove","Horlicks" };

		log.info("**************************************************");
		for (int i = 0; i < productList.length; i++) {

			log.info((i + 1) + ".)" + productList[i]);
		}
	}

}