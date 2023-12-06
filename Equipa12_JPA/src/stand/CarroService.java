package stand;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class CarroService {
protected EntityManager em;
private static EntityManager entityManager = null;	
private static final String PERSISTENCE_UNIT_NAME = "LibraryJPA"; // Substitua pelo nome da sua unidade de persistência
private static EntityManagerFactory factory;


	public CarroService(EntityManager em) {
		this.em = em;
	}
	
	public Carro updateCarro(int id,String marca, String modelo, int ano, String tipo, int cavalos, int autonomia, String descricao, double precoVenda, Vendedor vendedor, boolean estado) {	
		Carro a = em.find(Carro.class, id);
		if (a == null) {
			a = new Carro();
			em.persist(a);
		}
		a.setId(id);
        a.setMarca(marca);
        a.setModelo(modelo);
        a.setAno(ano);
        a.setTipo(tipo);
        a.setCavalos(cavalos);
        a.setAutonomia(autonomia);
        a.setDescricao(descricao);
        a.setPrecoVenda(precoVenda);
        a.setEstado(true);
        em.persist(a);
		return a;
	}
	
	public void mudarEstado(int id,boolean estado) {
		Carro a = em.find(Carro.class, id);
		if (a == null) {
			a = new Carro();
			em.persist(a);
		}
		
		a.setEstado(false);
		System.out.println("Carro Vendido com Sucesso");
	}
	

	public CarroService removeCarro(int id) {
		Carro l = findCarro(id);
		if(l != null) 
			em.remove(l);
		return null;
	}
	
	public Carro findCarro( int id) {
		return em.find(Carro.class, id);
	}
	
	public static void listAllCars() {
        EntityManager em = getEntityManager();
        CarroService carroService = new CarroService(em);
        List<Carro> carros = carroService.findAllCarros();

        System.out.println("\n======= Lista de Carros =======");
        for (Carro carro : carros) {
            System.out.println(carro);
        }
    }
	
	 public static void addNewCar() {
	        EntityManager em = getEntityManager();
	        CarroService carroService = new CarroService(em);
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("\n======= Adiconar Automovel =======");

	        System.out.print("Marca:");
	        String marca = scanner.nextLine();

	        System.out.print("Modelo: ");
	        String modelo = scanner.nextLine();

	        System.out.print("Ano: ");
	        int ano = scanner.nextInt();

	        System.out.print("Tipo:");
	        String tipo = scanner.next();

	        System.out.print("Cavalos:");
	        int cavalos = scanner.nextInt();

	        System.out.print("Autonomia: ");
	        int autonomia = scanner.nextInt();

	        scanner.nextLine(); 

	        System.out.print("Descrição: ");
	        String descricao = scanner.nextLine();

	        System.out.print("Preço: ");
	        double precoVenda = scanner.nextDouble();

	        
	        System.out.print("ID Vendedor: ");
	        int vendedorId = scanner.nextInt();
	        Vendedor vendedor = em.find(Vendedor.class, vendedorId);

	        Carro newCar = new Carro(0, marca, modelo, ano, tipo, cavalos, autonomia, descricao, precoVenda, vendedor, true);

	        em.getTransaction().begin();
	        em.persist(newCar);
	        em.getTransaction().commit();

	        System.out.println("Novo Automóvel adicionado!");
	    }
	 
	 public static void updateCar() {
	        EntityManager em = getEntityManager();
	        CarroService carroService = new CarroService(em);
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("ID Automovel para atualizar: ");
	        int carId = scanner.nextInt();
	        scanner.nextLine(); 
	        
	        Carro carToUpdate = carroService.findCarro(carId);
	        
	        if (carToUpdate != null) {
	            em.getTransaction().begin();
	            carroService.removeCarro(carId);
	            em.getTransaction().commit();

	            System.out.println("Automóvel Removido com sucesso!");
	        } else {
	            System.out.println("Automovel não encontrado com o ID: " + carId);
	        }

	        System.out.print("Marca: ");
	        String marca = scanner.next();

	        System.out.print("Modelo: ");
	        String modelo = scanner.next();

	        System.out.print("Ano: ");
	        int ano = scanner.nextInt();

	        System.out.print("Tipo:");
	        String tipo = scanner.next();

	        System.out.print("Cavalos: ");
	        int cavalos = scanner.nextInt();

	        System.out.print("Autonomia: ");
	        int autonomia = scanner.nextInt();

	        scanner.nextLine(); 
	        System.out.print("Descrição: ");
	        String descricao = scanner.nextLine();

	        System.out.print("Preço: ");
	        double precoVenda = scanner.nextDouble();

	       
	        System.out.print("ID Vendedor: ");
	        int vendedorId = scanner.nextInt();
	        Vendedor vendedor = em.find(Vendedor.class, vendedorId);

	        carroService.updateCarro(carId, marca, modelo, ano, tipo, cavalos, autonomia, descricao, precoVenda, vendedor, true);
	        
	        System.out.println("Automóvel atualizado!");
	        
	    }
	 
	 public static void removeCar() {
	        EntityManager em = getEntityManager();
	        CarroService carroService = new CarroService(em);
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("\n======= Remover Automóvel =======");

	        System.out.print("ID Automóvel para remover: ");
	        int carId = scanner.nextInt();

	        Carro carToRemove = carroService.findCarro(carId);

	        if (carToRemove != null) {
	            em.getTransaction().begin();
	            carroService.removeCarro(carId);
	            em.getTransaction().commit();

	            System.out.println("Automóvel Removido com sucesso!");
	        } else {
	            System.out.println("Automovel não encontrado com o ID: " + carId);
	        }
	    }
	 
	@SuppressWarnings("unchecked")
	public List<Carro> findAllCarros() {
		Query qd = em.createQuery("Select a from Carro a");
		return qd.getResultList();
	}
	
	public static EntityManager getEntityManager() {
        if (entityManager == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
}