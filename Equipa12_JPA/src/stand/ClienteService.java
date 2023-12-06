package stand;

import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ClienteService {
	
	private static final String PERSISTENCE_UNIT_NAME = "LibraryJPA";
	private static EntityManagerFactory factory;
	private static EntityManager em = null;
	
//verifica se e null e dps roda 
	private static EntityManager getEM() {
		if (em == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			em = factory.createEntityManager();
		}
		return em;
	}

	
	public ClienteService(EntityManager em) {
		this.em = em;
	}
	
	public ClienteService() {
		  this.em = getEM();		// TODO Auto-generated constructor stub
	}

	public Cliente updateClient(Cliente cli) {
		
		Cliente cliToUpdate = em.find(Cliente.class, cli.getId());
		
		if (cliToUpdate == null) {			
			em.persist(cli);
			return cli;
		}

		cliToUpdate.setNome(cli.getNome());
		cliToUpdate.setNnr(cli.getNnr());
		cliToUpdate.setEmail(cli.getEmail());
		
		em.persist(cliToUpdate);
		
		return cliToUpdate;
	}
	public Cliente updateClient(int id,String pass,String mail,String nome,int nnr) {
			
			Cliente cli = em.find(Cliente.class, id);
			
			if (cli == null) {
				cli = new Cliente(id,pass,mail,nome,nnr);
				em.persist(cli);
				return cli;
			}
	
			cli.setNome(cli.getNome());
			cli.setNnr(cli.getNnr());
			cli.setEmail(cli.getEmail());
			
			em.persist(cli);
			
			return cli;
		}
	public  Cliente removeClient(int id) {
			
			Cliente cli = findClient(id);
			
			if (cli != null)
				em.remove(cli);
			
			return cli;
					
		}

	public Cliente findClient( int id) {
		return em.find(Cliente.class, id);
		
	}
	public List<Cliente> findAllClients() {
		 Query qd = em.createQuery("SELECT cli FROM Client cli");
		 return qd.getResultList();
	}
	
	public List<Cliente> listClients() {
		try {
			em.getTransaction().begin();
			
			@SuppressWarnings("unchecked")
			List<Cliente> clients = em.createQuery("SELECT cli FROM Cliente cli").getResultList();
			
			for (Iterator<Cliente> iterator = clients.iterator(); iterator.hasNext();) {
				Cliente client = (Cliente) iterator.next();
				System.out.println(client.toString());
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		return null;
	}
}