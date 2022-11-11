/**
 * Classe para objetos do tipo Empresa
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.model;

import javax.swing.JOptionPane;

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
		try {
			// 0 1 2 3 4 5 6 7 8 9 10 11 12 13
			// 1 2 3 4 5 6 7 8 9 1 2  3  4  5
			// 12.345.678/9123-45
			if (nrCnpj.length() == 18 ) {
				this.nrCnpj = nrCnpj;
			} else if (nrCnpj.length() == 14) {
				String formato;
				formato = nrCnpj.substring(0, 2) + ".";
				formato += nrCnpj.substring(2, 5) + ".";
				formato += nrCnpj.substring(5, 8) + "/";
				formato += nrCnpj.substring(8, 12) + "-";
				formato += nrCnpj.substring(12, 14);
				this.nrCnpj = formato;
			} else {
				throw new Exception("CNPJ Invalido!\nColoque o CNPJ sem espaços, e sem caracteres especiais!(14 Caracteres)");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
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
