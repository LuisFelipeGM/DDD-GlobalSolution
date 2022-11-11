package fiap.controller;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import fiap.model.*;

public class InfoCarroController {
	
	public String insereInfoCarro(int idInfoCarro, int idCarro, int nrPneuCalibragem, int dsPneuVidaUtil, int dsSuspensaoVidaUtil,
			int dsQuilometragem, int dsFreioVidaUtil, LocalDate dtUltManutencao) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		InfoCarroDAO infoCardao = new InfoCarroDAO(con);
		InfoCarro infoCar = new InfoCarro();
		infoCar.setIdInfoCarro(idInfoCarro);
		infoCar.setIdCarro(idCarro);
		infoCar.setNrPneuCalibragem(nrPneuCalibragem);
		infoCar.setDsPneuVidaUtil(dsPneuVidaUtil);
		infoCar.setDsSuspensaoVidaUtil(dsSuspensaoVidaUtil);
		infoCar.setDsQuilometragem(dsQuilometragem);
		infoCar.setDsFreioVidaUtil(dsFreioVidaUtil);
		infoCar.setDtUltManutencao(dtUltManutencao);
		resultado = infoCardao.inserir(infoCar);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	public String alteraInfoCarro(int idInfoCarro, int idCarro, int nrPneuCalibragem, int dsPneuVidaUtil, int dsSuspensaoVidaUtil,
			int dsQuilometragem, int dsFreioVidaUtil, LocalDate dtUltManutencao) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		InfoCarroDAO infoCardao = new InfoCarroDAO(con);
		InfoCarro infoCar = new InfoCarro();
		infoCar.setIdInfoCarro(idInfoCarro);
		infoCar.setIdCarro(idCarro);
		infoCar.setNrPneuCalibragem(nrPneuCalibragem);
		infoCar.setDsPneuVidaUtil(dsPneuVidaUtil);
		infoCar.setDsSuspensaoVidaUtil(dsSuspensaoVidaUtil);
		infoCar.setDsQuilometragem(dsQuilometragem);
		infoCar.setDsFreioVidaUtil(dsFreioVidaUtil);
		infoCar.setDtUltManutencao(dtUltManutencao);
		resultado = infoCardao.alterar(infoCar);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	public String excluiInfoCarro(int idInfoCarro) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		InfoCarroDAO infoCardao = new InfoCarroDAO(con);
		InfoCarro infoCar = new InfoCarro();
		infoCar.setIdInfoCarro(idInfoCarro);
		resultado = infoCardao.excluir(infoCar);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	public List<String> listaUmaEmpresa(int id){
		Connection con = Conexao.abrirConexao();
		InfoCarroDAO infoCardao = new InfoCarroDAO(con);
		List<String> lista = infoCardao.listarUm(id);
		if (lista != null) {
			return lista;
		}
		Conexao.fecharConexao(con);
		return null;
	}

}
