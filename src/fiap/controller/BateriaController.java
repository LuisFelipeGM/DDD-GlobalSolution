package fiap.controller;

import java.sql.*;
import java.util.*;
import fiap.model.*;

public class BateriaController {

	public String insereBateria(int idBateria, int idInfoCarro, int nrBateriaCarga, int dsBateriaVidaUtil) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		BateriaDAO batdao = new BateriaDAO(con);
		Bateria bat = new Bateria();
		bat.setIdBateria(idBateria);
		bat.setIdInfoCarro(idInfoCarro);
		bat.setNrBateriaCarga(nrBateriaCarga);
		bat.setDsBateriaVidaUtil(dsBateriaVidaUtil);
		resultado = batdao.inserir(bat);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	public String alteraBateria(int idBateria, int idInfoCarro, int nrBateriaCarga, int dsBateriaVidaUtil) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		BateriaDAO batdao = new BateriaDAO(con);
		Bateria bat = new Bateria();
		bat.setIdBateria(idBateria);
		bat.setIdInfoCarro(idInfoCarro);
		bat.setNrBateriaCarga(nrBateriaCarga);
		bat.setDsBateriaVidaUtil(dsBateriaVidaUtil);
		resultado = batdao.alterar(bat);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	public String excluiBateria(int idBateria) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		BateriaDAO batdao = new BateriaDAO(con);
		Bateria bat = new Bateria();
		bat.setIdBateria(idBateria);
		resultado = batdao.excluir(bat);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	public List<String> listaUmaBateria(int id){
		Connection con = Conexao.abrirConexao();
		BateriaDAO batdao = new BateriaDAO(con);
		List<String> lista = batdao.listarUm(id);
		if (lista != null) {
			return lista;
		}
		Conexao.fecharConexao(con);
		return null;
	}
	
}
