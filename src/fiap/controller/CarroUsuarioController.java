/**Classe de Controller dos objetos do tipo CarroUsuario chamando os metodos do CRUD
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.controller;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import fiap.model.*;

public class CarroUsuarioController {
	
	/**Metodo para chamar o método de inserir do DAO
	* @author Luis Felipe
	* @param int idCarroUsuario, int idCarro, int idUsuario, LocalDate dtInicio
	* @return String - com o resultado da operação 
	*/
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
	
	/**Metodo para chamar o método de alterar do DAO
	* @author Luis Felipe
	* @param int idCarroUsuario, int idCarro, int idUsuario, LocalDate dtInicio, LocalDate dtFim
	* @return String - com o resultado da operação 
	*/
	public String alteraCarroUsuario(int idCarroUsuario, int idCarro, int idUsuario, LocalDate dtInicio, LocalDate dtFim) {
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
	
	/**Metodo para chamar o método de excluir do DAO
	* @author Luis Felipe
	* @param int idCarroUsuario
	* @return String - com o resultado da operação 
	*/
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
	
	/**Metodo para chamar o método de consulta do DAO
	* @author Luis Felipe
	* @param int id
	* @return List<String> - com a lista com todos os valores da consulta
	*/
	public List<String> listaUmCarroUsuario(int id){
		Connection con = Conexao.abrirConexao();
		CarroUsuarioDAO cudao = new CarroUsuarioDAO(con);
		List<String> lista = cudao.listarUm(id);
		if (lista != null) {
			Conexao.fecharConexao(con);
			return lista;
		}
		Conexao.fecharConexao(con);
		return null;
	}

}
