package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.entity.Geek;

public class GeekDaoTest  extends BaseDaoTest {
	@Autowired
	private GeekDao dao;
	

	@Before
	
	public void populateDatabase() {
        Operation operation = Operations.sequenceOf(
				Operations.deleteAllFrom("geek"),
				Operations.insertInto("geek")
				          .columns("id", "nom", "prenom", "adresseMail", "genre", "nomCentre")
				          .values("1", "aa", "aa", "aa@aa.com", "f", "java")
				          .values("2", "bb", "bb", "bb@bb.com", "M", "c++,java,php")
				          .values("4", "cc", "cc", "cc@cc.com", "M", "c")
				          .values("4", "dd", "dd", "dd@dd.com", "F", "c++")
						  .values("5", "ee", "ee", "ee@ee.com", "F", "c++")
				          .build());

        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }
	

	@Test
	public void findById(){
		Geek g = dao.findById(1L);
		Assert.assertEquals(1L,g.getId().longValue());
		
	}
	@Test
	 public void testFinAll() {
	     List<Geek> geeks = dao.finAll();
	     Assert.assertEquals("aa",geeks.get(0).getNom());
	     Assert.assertEquals("dd",geeks.get(1).getNom());
	    }
	
	@Test
	 public void testFindintret() {
		 String intret = "java";
	     List<Geek> geeks = dao.findintret(intret);
	     Assert.assertEquals("aa",geeks.get(0).getNom());
	    }
	
	

}
