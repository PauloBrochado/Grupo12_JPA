package stand;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.InheritanceType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import org.eclipse.persistence.annotations.ClassExtractor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@ClassExtractor(PessoaClassExtractor.class)
public abstract class Pessoa {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String pass;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Pessoa() {
	}
	public Pessoa(int id,String pass) {
		this.pass = pass;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Utilizador [id=" + id + ", pass=" + pass + "]";
	}

}
