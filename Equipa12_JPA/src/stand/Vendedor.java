package stand;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Vendedor extends Pessoa {
	@Column(name = "VENDEDOR_SPECIFIC")
	private String nome;
	
	public Vendedor() {
		
	}
	public Vendedor(int id,String pass,String nome) {
		super(id,pass);
		this.nome = nome;
	}

    // Getters e Setters
	
	private List<Carro> carros = new ArrayList<Carro>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Carro> getCarros() {
		return carros;
	}
	// To String
	
	@Override
	public String toString() {
		return "Vendedor [nome=" + nome + "]";
		
	}

	

}	

