/**
 * Classe para objetos do tipo Telefone
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.model;

public class Telefone {

	private int idTelefone;
	private int idUsuario;
	private int nrDDI;
	private int nrDDD;
	private int nrTelefone;
	private String stTelefone;

	public Telefone() {
	}

	public Telefone(int idTelefone, int idUsuario, int nrDDI, int nrDDD, int nrTelefone, String stTelefone) {
		this.idTelefone = idTelefone;
		this.idUsuario = idUsuario;
		this.nrDDI = nrDDI;
		this.nrDDD = nrDDD;
		this.nrTelefone = nrTelefone;
		this.stTelefone = stTelefone;
	}



	public int getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getNrDDI() {
		return nrDDI;
	}

	public void setNrDDI(int nrDDI) {
		this.nrDDI = nrDDI;
	}

	public int getNrDDD() {
		return nrDDD;
	}

	public void setNrDDD(int nrDDD) {
		this.nrDDD = nrDDD;
	}

	public int getNrTelefone() {
		return nrTelefone;
	}

	public void setNrTelefone(int nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public String getStTelefone() {
		return stTelefone;
	}

	public void setStTelefone(String stTelefone) {
		this.stTelefone = stTelefone;
	}

}
