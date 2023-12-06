package stand;

import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AdministradorService {
	
	protected EntityManager em;
	
	public AdministradorService(EntityManager em) {
		this.em = em;
	}
	
	public Administrador updateAdministrador(Administrador ad) {
		
		Administrador adToUpdate = findAdministrador(ad.getId());
		
		if (adToUpdate == null) {			
			em.persist(ad);
			
			return ad;
		}
		
		adToUpdate.setId(ad.getId());
		adToUpdate.setNome(ad.getNome());
		adToUpdate.setPass(ad.getPass());
		adToUpdate.setFuncao(ad.getFuncao());
		
		em.persist(adToUpdate);
		
		return adToUpdate;
	}
	public Administrador updateAdministrador(int id,String pass,String nome,String funcao) {
			
			Administrador ad = findAdministrador(id);
			
			if (ad == null) {
				ad = new Administrador(id, pass, nome, funcao);
				em.persist(ad);
				
				return ad;
			}
			
			ad.setId(id);
			ad.setNome(nome);
			ad.setFuncao(funcao);
			ad.setPass(pass);
			
			em.persist(ad);
			
			return ad;
		}
	public boolean removeAdministrador(int id) {
			
			Administrador aff = findAdministrador(id);
			
			if (aff != null)
				em.remove(aff);
			
			return false;		
		}
	
	public Administrador findAdministrador( int id) {
			
			return em.find(Administrador.class, id);
			
		}
		
	public List<Administrador> findAllAdministrador() {
			
			 Query qd = em.createQuery("SELECT ad FROM Administrador ad");
			 
			 return qd.getResultList();
		}
	public void listAdministrador() {
		try {
			em.getTransaction().begin();
			
			@SuppressWarnings("unchecked")
			List<Administrador> affiliates = em.createQuery("SELECT ad FROM Administrador ad").getResultList();
			
			for (Iterator<Administrador> iterator = affiliates.iterator(); iterator.hasNext();) {
				Administrador affiliate = (Administrador) iterator.next();
				System.out.println(affiliate.toString());
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
}