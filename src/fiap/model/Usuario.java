package fiap.model;

import javax.swing.JOptionPane;

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
		try {
			// 354.815.848-08
			// 0 1 2 3 4 5 6 7 8 9 10
			// 3 5 4 8 1 5 8 4 8 0 8
			if (nrCPF.length() == 14) {
				this.nrCPF = nrCPF;
			} else if (nrCPF.length() == 11) {
				String formato;
				formato = nrCPF.substring(0, 3) + ".";
				formato += nrCPF.substring(3, 6) + ".";
				formato += nrCPF.substring(6, 9) + "-";
				formato += nrCPF.substring(9, 11);
				this.nrCPF = formato;
			} else {
				throw new Exception("CPF Invalido!\nColoque o CPF sem espaços, e sem caracteres especiais!(11 Caracteres)");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
