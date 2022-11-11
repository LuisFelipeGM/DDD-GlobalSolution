/**Classe de Controller dos objetos do tipo Motor chamando os metodos do CRUD
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.controller;

import java.sql.*;
import java.util.*;
import fiap.model.*;

public class MotorController {
	
	/**Metodo para chamar o método de inserir do DAO
	* @author Luis Felipe
	* @param int idMotor, int idInfoCarro, int dsMotorVidaUtil 
	* @return String - com o resultado da operação 
	*/
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
	
	/**Metodo para chamar o método de alterar do DAO
	* @author Luis Felipe
	* @param int idMotor, int idInfoCarro, int dsMotorVidaUtil
	* @return String - com o resultado da operação 
	*/
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
	
	/**Metodo para chamar o método de excluir do DAO
	* @author Luis Felipe
	* @param int idMotor
	* @return String - com o resultado da operação 
	*/
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
	
	/**Metodo para chamar o método de consulta do DAO
	* @author Luis Felipe
	* @param int id
	* @return List<String> - com a lista com todos os valores da consulta
	*/
	public List<String> listaUmMotor(int id){
		Connection con = Conexao.abrirConexao();
		MotorDAO motdao = new MotorDAO(con);
		List<String> lista = motdao.listarUm(id);
		if (lista != null) {
			Conexao.fecharConexao(con);
			return lista;
		}
		Conexao.fecharConexao(con);
		return null;
	}

}
