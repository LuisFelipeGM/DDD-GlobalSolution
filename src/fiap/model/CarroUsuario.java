/**
 * Classe para objetos do tipo CarroUsuario
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */

package fiap.model;

import java.time.LocalDate;

public class CarroUsuario {

	private int idCarroUsuario;
	private int idCarro;
	private int idUsuario;
	private LocalDate dtInicio;
	private LocalDate dtFim;

	public CarroUsuario() {
	}

	public CarroUsuario(int idCarroUsuario, int idCarro, int idUsuario, int nrSerie, LocalDate dtInicio,
			LocalDate dtFim) {
		this.idCarroUsuario = idCarroUsuario;
		this.idCarro = idCarro;
		this.idUsuario = idUsuario;
		this.dtInicio = dtInicio;
		this.dtFim = dtFim;
	}

	public int getIdCarroUsuario() {
		return idCarroUsuario;
	}

	public void setIdCarroUsuario(int idCarroUsuario) {
		this.idCarroUsuario = idCarroUsuario;
	}

	public int getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public LocalDate getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(LocalDate dtInicio) {
		this.dtInicio = dtInicio;
	}

	public LocalDate getDtFim() {
		return dtFim;
	}

	public void setDtFim(LocalDate dtFim) {
		this.dtFim = dtFim;
	}

}
