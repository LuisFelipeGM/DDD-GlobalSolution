/**
 * Classe para objetos do tipo InfoCarro
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.model;

import java.time.LocalDate;

public class InfoCarro {

	private int idInfoCarro;
	private int idCarro;
	private int nrPneuCalibragem;
	private int dsPneuVidaUtil;
	private int dsSuspensaoVidaUtil;
	private int dsQuilometragem;
	private int dsFreioVidaUtil;
	private LocalDate dtUltManutencao;

	public InfoCarro() {
	}

	public InfoCarro(int idInfoCarro, int idCarro, int nrPneuCalibragem, int dsPneuVidaUtil, int dsSuspensaoVidaUtil,
			int dsQuilometragem, int dsFreioVidaUtil, LocalDate dtUltManutencao) {
		this.idInfoCarro = idInfoCarro;
		this.idCarro = idCarro;
		this.nrPneuCalibragem = nrPneuCalibragem;
		this.dsPneuVidaUtil = dsPneuVidaUtil;
		this.dsSuspensaoVidaUtil = dsSuspensaoVidaUtil;
		this.dsQuilometragem = dsQuilometragem;
		this.dsFreioVidaUtil = dsFreioVidaUtil;
		this.dtUltManutencao = dtUltManutencao;
	}

	public int getIdInfoCarro() {
		return idInfoCarro;
	}

	public void setIdInfoCarro(int idInfoCarro) {
		this.idInfoCarro = idInfoCarro;
	}

	public int getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

	public int getNrPneuCalibragem() {
		return nrPneuCalibragem;
	}

	public void setNrPneuCalibragem(int nrPneuCalibragem) {
		this.nrPneuCalibragem = nrPneuCalibragem;
	}

	public int getDsPneuVidaUtil() {
		return dsPneuVidaUtil;
	}

	public void setDsPneuVidaUtil(int dsPneuVidaUtil) {
		this.dsPneuVidaUtil = dsPneuVidaUtil;
	}

	public int getDsSuspensaoVidaUtil() {
		return dsSuspensaoVidaUtil;
	}

	public void setDsSuspensaoVidaUtil(int dsSuspensaoVidaUtil) {
		this.dsSuspensaoVidaUtil = dsSuspensaoVidaUtil;
	}

	public int getDsQuilometragem() {
		return dsQuilometragem;
	}

	public void setDsQuilometragem(int dsQuilometragem) {
		this.dsQuilometragem = dsQuilometragem;
	}

	public int getDsFreioVidaUtil() {
		return dsFreioVidaUtil;
	}

	public void setDsFreioVidaUtil(int dsFreioVidaUtil) {
		this.dsFreioVidaUtil = dsFreioVidaUtil;
	}

	public LocalDate getDtUltManutencao() {
		return dtUltManutencao;
	}

	public void setDtUltManutencao(LocalDate dtUltManutencao) {
		this.dtUltManutencao = dtUltManutencao;
	}

}
