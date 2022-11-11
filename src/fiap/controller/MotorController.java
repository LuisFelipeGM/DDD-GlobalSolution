package fiap.controller;

import java.sql.*;
import java.util.*;
import fiap.model.*;

public class MotorController {
	
	public String insereMotor(int idMotor, int idInfoCarro, int dsMotorVidaUtil) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		MotorDAO motdao = new MotorDAO(con);
		Motor mot = new Motor();
		mot.setIdMotor(idMotor);
		mot.setIdInfoCarro(idInfoCarro);
		mot.setDsMotorVidaUtil(dsMotorVidaUtil);
		resultado = motdao.inserir(mot);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	public String alteraMotor(int idMotor, int idInfoCarro, int dsMotorVidaUtil) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		MotorDAO motdao = new MotorDAO(con);
		Motor mot = new Motor();
		mot.setIdMotor(idMotor);
		mot.setIdInfoCarro(idInfoCarro);
		mot.setDsMotorVidaUtil(dsMotorVidaUtil);
		resultado = motdao.alterar(mot);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	public String excluiMotor(int idMotor) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		MotorDAO motdao = new MotorDAO(con);
		Motor mot = new Motor();
		mot.setIdMotor(idMotor);
		resultado = motdao.excluir(mot);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	public List<String> listaUmMotor(int id){
		Connection con = Conexao.abrirConexao();
		MotorDAO motdao = new MotorDAO(con);
		List<String> lista = motdao.listarUm(id);
		if (lista != null) {
			return lista;
		}
		Conexao.fecharConexao(con);
		return null;
	}

}
