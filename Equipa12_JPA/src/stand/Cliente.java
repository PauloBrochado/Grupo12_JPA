package stand;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {
	@Column(name = "CLIENT_SPECIFIC")
    private String clientSpecific = "cliente";
	private String email;
	private String nome;
	private int nnr;
	public Cliente() {
	}
	public Cliente(int id,String pass,String mail,String nome,int nnr) {
		super(id,pass);
		this.nome = nome;
	
		this.email = mail;
		this.nnr = nnr;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNnr() {
		return nnr;
	}
	public void setNnr(int nnr) {
		this.nnr = nnr;
	}
	@Override
	public String toString() {
		return "Cliente [clientSpecific=" + clientSpecific + ", email=" + email + ", nome=" + nome + ", nnr=" + nnr + "]";
	}
}


