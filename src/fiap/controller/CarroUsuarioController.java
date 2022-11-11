package fiap.controller;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import fiap.model.*;

public class CarroUsuarioController {
	
	public String insereCarroUsuario(int idCarroUsuario, int idCarro, int idUsuario, LocalDate dtInicio,
			LocalDate dtFim) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroUsuarioDAO cudao = new CarroUsuarioDAO(con);
		CarroUsuario cu = new CarroUsuario();
		cu.setIdCarroUsuario(idCarroUsuario);
		cu.setIdCarro(idCarro);
		cu.setIdUsuario(idUsuario);
		cu.setDtInicio(dtInicio);
		cu.setDtFim(dtFim);
		resultado = cudao.inserir(cu);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	public String alteraCarroUsuario(int idCarroUsuario, int idCarro, int idUsuario, LocalDate dtInicio,
			LocalDate dtFim) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroUsuarioDAO cudao = new CarroUsuarioDAO(con);
		CarroUsuario cu = new CarroUsuario();
		cu.setIdCarroUsuario(idCarroUsuario);
		cu.setIdCarro(idCarro);
		cu.setIdUsuario(idUsuario);
		cu.setDtInicio(dtInicio);
		cu.setDtFim(dtFim);
		resultado = cudao.alterar(cu);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	public String excluiCarroUsuario(int idCarroUsuario) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroUsuarioDAO cudao = new CarroUsuarioDAO(con);
		CarroUsuario cu = new CarroUsuario();
		cu.setIdCarroUsuario(idCarroUsuario);
		resultado = cudao.excluir(cu);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	public List<String> listaUmCarroUsuario(int id){
		Connection con = Conexao.abrirConexao();
		CarroUsuarioDAO cudao = new CarroUsuarioDAO(con);
		List<String> lista = cudao.listarUm(id);
		if (lista != null) {
			return lista;
		}
		Conexao.fecharConexao(con);
		return null;
	}

}
