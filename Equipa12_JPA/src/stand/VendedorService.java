package stand;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import stand.Vendedor;
import stand.Carro;

public class VendedorService {

	protected EntityManager em;
    
    public void VendedorService(EntityManager em) {
		this.em = em;
	}
   
    public Vendedor updateVendedor(Vendedor ad) {
		
    	Vendedor adToUpdate = findVendedor(ad.getId());
		
		if (adToUpdate == null) {			
			em.persist(ad);
			
			return ad;
		}
		
		adToUpdate.setId(ad.getId());
		adToUpdate.setNome(ad.getNome());
		adToUpdate.setPass(ad.getPass());
		
		em.persist(adToUpdate);
		
		return adToUpdate;
	}
    
    public Vendedor updateVendedor(int id,String pass,String nome) {
		
    	Vendedor ad = findVendedor(id);
		
		if (ad == null) {
			ad = new Vendedor(id, pass, nome);
			em.persist(ad);
			
			return ad;
		}
		
		ad.setId(id);
		ad.setNome(nome);
		ad.setPass(pass);
		
		em.persist(ad);
		
		return ad;
	}

    public  Vendedor findVendedor(int id) {
		
		return em.find(Vendedor.class, id);
		
	}

    public Vendedor removeVendedor(int id) {
		
    	Vendedor aff = findVendedor(id);
		
		if (aff != null)
			em.remove(aff);
		
		
		return null;
		
				
	}
    
    public void listVendedor() {
		try {
			em.getTransaction().begin();
			
			@SuppressWarnings("unchecked")
			List<Vendedor> affiliates = em.createQuery("SELECT ad FROM Vendedor ad").getResultList();
			
			for (Iterator<Vendedor> iterator = affiliates.iterator(); iterator.hasNext();) {
				Vendedor affiliate = (Vendedor) iterator.next();
				System.out.println(affiliate.toString());
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

    public List<Vendedor> findAllVendedor() {
		
		 Query qd = em.createQuery("SELECT ad FROM Vendedor ad");
		 
		 return qd.getResultList();
	}
}


