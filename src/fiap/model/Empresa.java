package fiap.model;

public class Empresa {

	private int idEmpresa;
	private String nmEmpresa;
	private String nrCnpj;
	private String dsEmail;
	private String dsSenha;

	public Empresa() {
	}

	public Empresa(int idEmpresa, String nmEmpresa, String nrCnpj, String dsEmail, String dsSenha) {
		this.idEmpresa = idEmpresa;
		this.nmEmpresa = nmEmpresa;
		this.nrCnpj = nrCnpj;
		this.dsEmail = dsEmail;
		this.dsSenha = dsSenha;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNmEmpresa() {
		return nmEmpresa;
	}

	public void setNmEmpresa(String nmEmpresa) {
		this.nmEmpresa = nmEmpresa;
	}

	public String getNrCnpj() {
		return nrCnpj;
	}

	public void setNrCnpj(String nrCnpj) {
		this.nrCnpj = nrCnpj;
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
