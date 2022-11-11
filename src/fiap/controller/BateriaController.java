/**Classe de Controller dos objetos do tipo Bateria chamando os metodos do CRUD
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.controller;

import java.sql.*;
import java.util.*;
import fiap.model.*;

public class BateriaController {

	/**Metodo para chamar o método de inserir do DAO
	* @author Luis Felipe
	* @param int idBateria, int idInfoCarro, int nrBateriaCarga, int dsBateriaVidaUtil
	* @return String - com o resultado da operação 
	*/
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
	
	/**Metodo para chamar o método de alterar do DAO
	* @author Luis Felipe
	* @param int idBateria, int idInfoCarro, int nrBateriaCarga, int dsBateriaVidaUtil
	* @return String - com o resultado da operação 
	*/
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
	
	/**Metodo para chamar o método de excluir do DAO
	* @author Luis Felipe
	* @param int idBateria
	* @return String - com o resultado da operação 
	*/
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
	
	/**Metodo para chamar o método de consulta do DAO
	* @author Luis Felipe
	* @param int id
	* @return List<String> - com a lista com todos os valores da consulta
	*/
	public List<String> listaUmaBateria(int id){
		Connection con = Conexao.abrirConexao();
		BateriaDAO batdao = new BateriaDAO(con);
		List<String> lista = batdao.listarUm(id);
		if (lista != null) {
			Conexao.fecharConexao(con);
			return lista;
		}
		Conexao.fecharConexao(con);
		return null;
	}
	
}
