package stand;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private String descricao;
    private String tipo;
    private int cavalos;
    private int autonomia;
    private double precoVenda;
    private boolean estado;

    @ManyToOne
    private Vendedor vendedor;

    public Carro() {
    	id = 0;
    	marca = null;
    	modelo = null;
    	ano = 0;
    	descricao = null;
    	tipo = null;
    	cavalos = 0;
    	autonomia = 0;
    	precoVenda = 0;
    	estado = true;
    	
    }

    public Carro(int id,String marca, String modelo, int ano, String tipo, int cavalos, int autonomia, String descricao, double precoVenda, Vendedor vendedor, boolean estado) {
        this.id=id;
    	this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
        this.autonomia = autonomia;
        this.cavalos = cavalos;
        this.tipo = tipo;
        this.vendedor = vendedor;
        this.estado= true;
    }
    
    // Getters e Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCavalos() {
		return cavalos;
	}

	public void setCavalos(int cavalos) {
		this.cavalos = cavalos;
	}

	public int getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(int autonomia) {
		this.autonomia = autonomia;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	/**
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

// To String
@Override
	public String toString() {
		 String st ="Carro [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", descricao="
				+ descricao + ", tipo=" + tipo + ", cavalos=" + cavalos + ", autonomia=" + autonomia + ", precoVenda="
				+ precoVenda + ", vendedor=" + vendedor + ",estado=" + estado + "]";
		 return st;
	}
}