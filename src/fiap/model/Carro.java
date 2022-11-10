package fiap.model;

import java.time.LocalDate;

public class Carro {

	private int idCarro;
	private int idEmpresa;
	private int nrSerie;
	private String nmMarca;
	private String nmModelo;
	private String nrPlaca;
	private LocalDate dtFabricacao;

	public Carro() {
	}

	public Carro(int idCarro, int idEmpresa, int nrSerie, String nmMarca, String nmModelo, String nrPlaca,
			LocalDate dtFabricacao) {
		super();
		this.idCarro = idCarro;
		this.idEmpresa = idEmpresa;
		this.nrSerie = nrSerie;
		this.nmMarca = nmMarca;
		this.nmModelo = nmModelo;
		this.nrPlaca = nrPlaca;
		this.dtFabricacao = dtFabricacao;
	}

	public int getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public int getNrSerie() {
		return nrSerie;
	}

	public void setNrSerie(int nrSerie) {
		this.nrSerie = nrSerie;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNmMarca() {
		return nmMarca;
	}

	public void setNmMarca(String nmMarca) {
		this.nmMarca = nmMarca;
	}

	public String getNmModelo() {
		return nmModelo;
	}

	public void setNmModelo(String nmModelo) {
		this.nmModelo = nmModelo;
	}

	public String getNrPlaca() {
		return nrPlaca;
	}

	public void setNrPlaca(String nrPlaca) {
		this.nrPlaca = nrPlaca;
	}

	public LocalDate getDtFabricacao() {
		return dtFabricacao;
	}

	public void setDtFabricacao(LocalDate dtFabricacao) {
		this.dtFabricacao = dtFabricacao;
	}

}
