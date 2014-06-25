package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.entity.Geek;

@Repository
public class GeekDao {
	@PersistenceContext
	private EntityManager entityManager;
	

	public Geek findById(Long id){
		return entityManager.find(Geek.class, id);
		
	}
	public void persist(Geek geek){
		entityManager.persist(geek);
		entityManager.flush();
		
	}

	public List<Geek> finAll(){
		TypedQuery<Geek> query = entityManager.createQuery("SELECT g FROM Geek g", Geek.class);
		return query.getResultList();
		
		
	}
	public List<Geek> findintret(String intret){
		TypedQuery<Geek> query = entityManager.createQuery("SELECT g FROM Geek g WHERE g.nomCentre like :nomCentre", Geek.class);
		query.setParameter("nomCentre", "%"+intret+"%");
		return query.getResultList();
		
	}
	public List<Geek> findintretsexe(String intret, String sexe) {
		TypedQuery<Geek> query = entityManager.createQuery("SELECT g FROM Geek g WHERE g.nomCentre like :nomCentre and :sexe", Geek.class);
		query.setParameter("nomCentre", "%"+intret+"%");
		query.setParameter("sexe" , "%"+sexe+"%" );
		return query.getResultList();
	}
}
