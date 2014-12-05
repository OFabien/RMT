/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	private static EntityManagerFactory emf;
	
	private PersistenceManager() {
		// TODO Auto-generated constructor stub
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("RMT-warPU");
		}
		return emf;
	}
	
	public static void closeEntityManagerFactory() {
		if(emf != null && emf.isOpen()) emf.close();
	}
}
