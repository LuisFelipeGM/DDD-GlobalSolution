/**Classe de Controller dos objetos do tipo Admin chamando os metodos do CRUD
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.controller;

import java.sql.*;
import java.util.*;
import fiap.model.*;

public class AdminController {

	/**Metodo para chamar o método de inserir do DAO
	* @author Luis Felipe
	* @param int idAdmin, String nmAdmin, String dsEmail, String dsSenha
	* @return String - com o resultado da operação 
	*/
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
	
	/**Metodo para chamar o método de alterar do DAO
	* @author Luis Felipe
	* @param int idAdmin, String nmAdmin, String dsEmail, String dsSenha
	* @return String - com o resultado da operação 
	*/
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
	
	/**Metodo para chamar o método de excluir do DAO
	* @author Luis Felipe
	* @param int idAdmin
	* @return String - com o resultado da operação 
	*/
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
	
	/**Metodo para chamar o método de consulta do DAO
	* @author Luis Felipe
	* @param int id
	* @return List<String> - com a lista com todos os valores da consulta
	*/
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
