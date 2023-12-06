package stand;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Administrador extends Pessoa {
    
	@Column(name = "ADMINISTRADOR_SPECIFIC")
    private String funcao;
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public Administrador() {
		
	}
	public Administrador(int id,String pass,String nome,String funcao) {
		super(id,pass);
		this.nome = nome;
		this.funcao = funcao;
	}
	@Override
	public String toString() {
		return "Admin [funcao=" + funcao + ", nome=" + nome + "]";
	}
}
