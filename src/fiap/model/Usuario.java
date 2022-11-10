package fiap.model;

public class Usuario {

	private int idUsuario;
	private String nmCompleto;
	private String dsEmail;
	private String dsSenha;
	private String nrCPF;

	public Usuario() {
	}

	public Usuario(int idUsuario, String nmCompleto, String dsEmail, String dsSenha, String nrCPF) {
		this.idUsuario = idUsuario;
		this.nmCompleto = nmCompleto;
		this.dsEmail = dsEmail;
		this.dsSenha = dsSenha;
		this.nrCPF = nrCPF;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNmCompleto() {
		return nmCompleto;
	}

	public void setNmCompleto(String nmCompleto) {
		this.nmCompleto = nmCompleto;
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

	public String getNrCPF() {
		return nrCPF;
	}

	public void setNrCPF(String nrCPF) {
		this.nrCPF = nrCPF;
	}

}
