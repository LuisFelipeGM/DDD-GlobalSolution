/**
 * Classe para objetos do tipo Admin
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */

package fiap.model;

public class Admin {

	private int idAdmin;
	private String nmAdmin;
	private String dsEmail;
	private String dsSenha;

	public Admin() {
	}

	public Admin(int idAdmin, String nmAdmin, String dsEmail, String dsSenha) {
		this.idAdmin = idAdmin;
		this.nmAdmin = nmAdmin;
		this.dsEmail = dsEmail;
		this.dsSenha = dsSenha;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getNmAdmin() {
		return nmAdmin;
	}

	public void setNmAdmin(String nmAdmin) {
		this.nmAdmin = nmAdmin;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsSenha() {
		return dsSenha;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}

}
