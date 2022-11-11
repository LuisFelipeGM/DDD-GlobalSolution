package fiap.controller;

import java.sql.*;
import java.util.*;
import fiap.model.*;

public class AdminController {

	public String insereAdm(int idAdmin, String nmAdmin, String dsEmail, String dsSenha) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		AdminDAO admdao = new AdminDAO(con);
		Admin adm = new Admin();
		adm.setIdAdmin(idAdmin);
		adm.setNmAdmin(nmAdmin);
		adm.setDsEmail(dsEmail);
		adm.setDsSenha(dsSenha);
		resultado = admdao.inserir(adm);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	public String alteraAdm(int idAdmin, String nmAdmin, String dsEmail, String dsSenha) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		AdminDAO admdao = new AdminDAO(con);
		Admin adm = new Admin();
		adm.setIdAdmin(idAdmin);
		adm.setNmAdmin(nmAdmin);
		adm.setDsEmail(dsEmail);
		adm.setDsSenha(dsSenha);
		resultado = admdao.alterar(adm);
		Conexao.fecharConexao(con);
		return resultado;
	}
	
	public String excluiAdm(int idAdmin) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		AdminDAO admdao = new AdminDAO(con);
		Admin adm = new Admin();
		adm.setIdAdmin(idAdmin);
		resultado = admdao.excluir(adm);
		Conexao.fecharConexao(con);
		return resultado;
	}
	
	public List<String> listaUmAdm(int id){
		Connection con = Conexao.abrirConexao();
		AdminDAO admdao = new AdminDAO(con);
		List<String> lista = admdao.listarUm(id);
		if (lista != null) {
			Conexao.fecharConexao(con);
			return lista;
		}
		Conexao.fecharConexao(con);
		return null;
	}
}
