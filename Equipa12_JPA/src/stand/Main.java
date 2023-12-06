package stand;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "LibraryJPA"; 
    private static EntityManagerFactory factory;
    private static EntityManager entityManager = null;
    
    public static void listItemsDB() {
		EntityManager em = getEM();
		
		
		List<Administrador> AdminrResults = em.createQuery("SELECT u FROM Administrador u").getResultList();
		List<Pessoa> AllResults = em.createQuery("SELECT u FROM Pessoa u").getResultList();
		List<Vendedor> VendedorResults = em.createQuery("SELECT a FROM Vendedor a").getResultList();
		List<Cliente> ClientResults = em.createQuery("SELECT c FROM Cliente c").getResultList();
		List<Carro> CarroResults = em.createQuery("SELECT s FROM Carro s").getResultList();
		
	}
    
    public static void fillAdministrador() {
		
		System.out.println("========");
		System.out.println("  fillAdministrador   ");
		System.out.println("========");
		EntityManager em = getEM();
		
		List<Pessoa> AllResults;
		List<Administrador> AdminResults;
		
		AdministradorService admin = new AdministradorService(getEM());
		
		em.getTransaction().begin();
		
		Administrador v = new Administrador(1, "123abc", "AdminName", "AdminFunction");		
		admin.updateAdministrador(v);
						
		admin.updateAdministrador(0, "123abc", "AdminName2", "AdminFunction");

		em.getTransaction().commit();
		
		AllResults = em.createQuery("SELECT u FROM Pessoa u").getResultList();
		
		AdminResults = em.createQuery("SELECT a FROM Vendedor a").getResultList();
		
		admin.listAdministrador();
		
	}
    
    
    public static void fillVendedor() {
		
		System.out.println("========");
		System.out.println("  fillVendedor   ");
		System.out.println("========");
		EntityManager em = getEM();
		
		List<Pessoa> AllResults;
		List<Vendedor> VendedorResults;
		List<Administrador> AdminResults;
		
		AdministradorService admin = new AdministradorService(getEM());
		
		em.getTransaction().begin();
		
		Administrador v = new Administrador(1, "123abc", "AdminName", "AdminFunction");		
		admin.updateAdministrador(v);
						
		admin.updateAdministrador(0, "123abc", "AdminName2", "AdminFunction");

		em.getTransaction().commit();
		
		AllResults = em.createQuery("SELECT u FROM Pessoa u").getResultList();
		
		AdminResults = em.createQuery("SELECT a FROM Vendedor a").getResultList();
		
		admin.listAdministrador();
		
	}
    
    
    
    public static void fillClients() {
		
		System.out.println("========");
		System.out.println("  fillClients   ");
		System.out.println("========");
		EntityManager em = getEM();
		
		List<Pessoa> AllResults;
		List<Cliente> ClientResults;
		
		ClienteService cliente = new ClienteService(getEM());
		
		em.getTransaction().begin();		
		
		Cliente cli = new Cliente(0, "abc123", "cliente1@upt.pt", "Paulo", 5);			
		cliente.updateClient(cli);
						
		cliente.updateClient(0, "abc123", "cliente2@upt.pt", "Alexandre", 15);

		em.getTransaction().commit();
		
		AllResults = em.createQuery("SELECT u FROM Utilizador u").getResultList();
		
		ClientResults = em.createQuery("SELECT c FROM Cliente c").getResultList();
		
		cliente.listClients();
	}
    
    public static void fillCarros() {
	    System.out.println("========");
	    System.out.println("  fillCarros  ");
	    System.out.println("========");

	    EntityManager em = getEM();

	    List<Carro> CarroResults;

	    CarroService carroService = new CarroService(em);

	    em.getTransaction().begin();

	    Carro carro1 = carroService.updateCarro(0, "Marca1", "Modelo1", 2023, "Tipo1", 200, 500, "Descrição1", 25000.0, null, true);
	    //carroService.updateCarro(0, null, null, 0, null, 0, 0, null, 0, null, false);

	    Carro carro2 = carroService.updateCarro(0, "Marca2", "Modelo1", 2020, "Tipo1", 200, 500, "Descrição1", 25000.0, null, true);
	    //carroService.updateCarro(0, null, null, 0, null, 0, 0, null, 0, null, false);

	    em.getTransaction().commit();

	    CarroResults = em.createQuery("SELECT s FROM Carro s").getResultList();
	    carroService.listAllCars();;
	}
    
    public static EntityManager getEM() {
		if (entityManager == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
    
    public static void main(String[] args) {
		
		System.setProperty("derby.language.sequence.preallocator", "1");
		
		fillAdministrador();
		fillClients();
		fillCarros();
		fillVendedor();
	}
    	
}