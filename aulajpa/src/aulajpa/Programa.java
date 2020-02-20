package aulajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Carro;

public class Programa {
	
	public static void main(String[] args) {
		new Programa().inserir();
	}
	
	public void inserir() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aulajpa");
		
		Carro c1 = new Carro(null, "Toyota", "Corolla", 2011, "Prata");
		Carro c2 = new Carro(null, "Fiat", "Toro", 2018, "Vermelho");
		Carro c3 = new Carro(null, "Chevrolet", "Celta", 2005, "Preto");
		
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.getTransaction().commit();
		
		em.close();
		factory.close();
	}
	
	public void recuperarCarro() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aulajpa");
		EntityManager em = factory.createEntityManager();
		
		Carro carro = em.find(Carro.class, 2l);
		
		System.out.println(carro);
		
		em.close();
		factory.close();
	}
	
	public void atualizarCarro() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aulajpa");
		EntityManager em = factory.createEntityManager();
		
		Carro carro = em.find(Carro.class, 2l);
		carro.setCor("Branco");
		carro.setAno(2018);
		
		em.getTransaction().begin();
		em.merge(carro);
		em.getTransaction().commit();
		
		
		em.close();
		factory.close();
	}
	
	public void deletarCarro() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aulajpa");
		EntityManager em = factory.createEntityManager();
		
		Carro carro = em.find(Carro.class, 1l);
		
		em.getTransaction().begin();
		em.remove(carro);
		em.getTransaction().commit();
		
		em.close();
		factory.close();
	}

}
