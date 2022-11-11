/**
 * Classe para objetos do tipo Bateria
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.model;

import javax.swing.JOptionPane;

public class Bateria {

	private int idBateria;
	private int idInfoCarro;
	private int nrBateriaCarga;
	private int dsBateriaVidaUtil;

	public Bateria() {
	}

	public Bateria(int idBateria, int idInfoCarro, int nrBateriaCarga, int dsBateriaVidaUtil) {
		this.idBateria = idBateria;
		this.idInfoCarro = idInfoCarro;
		this.nrBateriaCarga = nrBateriaCarga;
		this.dsBateriaVidaUtil = dsBateriaVidaUtil;
	}

	public int getIdBateria() {
		return idBateria;
	}

	public void setIdBateria(int idBateria) {
		this.idBateria = idBateria;
	}

	public int getIdInfoCarro() {
		return idInfoCarro;
	}

	public void setIdInfoCarro(int idInfoCarro) {
		this.idInfoCarro = idInfoCarro;
	}

	public int getNrBateriaCarga() {
		return nrBateriaCarga;
	}

	public void setNrBateriaCarga(int nrBateriaCarga) {
		try {
			if (nrBateriaCarga > 0 && nrBateriaCarga < 1000) {
				this.nrBateriaCarga = nrBateriaCarga;
			} else {
				throw new Exception("Valor Invalido!\nColoque apenas 3 caracteres na Carga da Bateria");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public int getDsBateriaVidaUtil() {
		return dsBateriaVidaUtil;
	}

	public void setDsBateriaVidaUtil(int dsBateriaVidaUtil) {
		try {
			if (dsBateriaVidaUtil > 0 && dsBateriaVidaUtil < 1000) {
				this.dsBateriaVidaUtil = dsBateriaVidaUtil;
			} else {
				throw new Exception("Valor Invalido!\nColoque apenas 3 caracteres na Vida Util da Bateria");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

}
