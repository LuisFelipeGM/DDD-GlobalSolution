package fiap.model;

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
		this.nrBateriaCarga = nrBateriaCarga;
	}

	public int getDsBateriaVidaUtil() {
		return dsBateriaVidaUtil;
	}

	public void setDsBateriaVidaUtil(int dsBateriaVidaUtil) {
		this.dsBateriaVidaUtil = dsBateriaVidaUtil;
	}

}
