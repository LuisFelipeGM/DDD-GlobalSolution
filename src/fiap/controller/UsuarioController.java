/**Classe de Controller dos objetos do tipo Usuario chamando os metodos do CRUD
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.controller;

import java.sql.*;
import java.util.*;
import fiap.model.*;

public class UsuarioController {
	
	/**Metodo para chamar o método de inserir do DAO
	* @author Luis Felipe
	* @param int idUsuario, String nmCompleto, String dsEmail, String dsSenha, String nrCPF, int nrDDI, int nrDDD, int nrTelefone, String stTelefone 
	* @return String - com o resultado da operação 
	*/
	public String insereUsuario(int idUsuario, String nmCompleto, String dsEmail, String dsSenha, String nrCPF, 
			int nrDDI, int nrDDD, int nrTelefone, String stTelefone) {
		String resultado, resultado2;
		Connection con = Conexao.abrirConexao();
		UsuarioDAO usudao = new UsuarioDAO(con);
		Usuario usu = new Usuario();
		usu.setIdUsuario(idUsuario);
		usu.setNmCompleto(nmCompleto);
		usu.setDsEmail(dsEmail);
		usu.setDsSenha(dsSenha);
		usu.setNrCPF(nrCPF);
		resultado = usudao.inserir(usu);
		Conexao.fecharConexao(con);
		if(resultado.equals("Inserido com Sucesso")) {
			Connection con2 = Conexao.abrirConexao();
			TelefoneDAO teldao = new TelefoneDAO(con2);
			Telefone tel = new Telefone();
			tel.setIdTelefone(idUsuario);
			tel.setIdUsuario(idUsuario);
			tel.setNrDDD(nrDDD);
			tel.setNrDDI(nrDDI);
			tel.setNrTelefone(nrTelefone);
			tel.setStTelefone(stTelefone);
			resultado2 = teldao.inserir(tel);
			Conexao.fecharConexao(con2);
			if(resultado2.equals("Erro ao inserir")) {
				excluiUsuario(idUsuario);
				return "Erro ao Cadastrar Usuario";
			}
			return resultado2;
		} 
		
		return resultado;	
	}
	
	/**Metodo para chamar o método de alterar do DAO
	* @author Luis Felipe
	* @param int idUsuario, String nmCompleto, String dsEmail, String dsSenha, String nrCPF, int nrDDI, int nrDDD, int nrTelefone, String stTelefone 
	* @return String - com o resultado da operação 
	*/
	public String alteraUsuario(int idUsuario, String nmCompleto, String dsEmail, String dsSenha, String nrCPF, 
			int nrDDI, int nrDDD, int nrTelefone, String stTelefone) {
		String resultado, resultado2;
		Connection con = Conexao.abrirConexao();
		UsuarioDAO usudao = new UsuarioDAO(con);
		Usuario usu = new Usuario();
		usu.setIdUsuario(idUsuario);
		usu.setNmCompleto(nmCompleto);
		usu.setDsEmail(dsEmail);
		usu.setDsSenha(dsSenha);
		usu.setNrCPF(nrCPF);
		resultado = usudao.alterar(usu);
		Conexao.fecharConexao(con);
		if(resultado.equals("Alterado com sucesso")) {
			Connection con2 = Conexao.abrirConexao();
			TelefoneDAO teldao = new TelefoneDAO(con2);
			Telefone tel = new Telefone();
			tel.setIdTelefone(idUsuario);
			tel.setIdUsuario(idUsuario);
			tel.setNrDDD(nrDDD);
			tel.setNrDDI(nrDDI);
			tel.setNrTelefone(nrTelefone);
			tel.setStTelefone(stTelefone);
			resultado2 = teldao.alterar(tel);
			Conexao.fecharConexao(con2);
			return resultado2;
		} 
		
		return resultado;	
	}
	
	/**Metodo para chamar o método de excluir do DAO
	* @author Luis Felipe
	* @param int idUsuario
	* @return String - com o resultado da operação 
	*/
	public String excluiUsuario(int idUsuario) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		TelefoneDAO teldao = new TelefoneDAO(con);
		Telefone tel = new Telefone();
		tel.setIdTelefone(idUsuario);
		teldao.excluir(tel);
		UsuarioDAO usudao = new UsuarioDAO(con);
		Usuario usu = new Usuario();
		usu.setIdUsuario(idUsuario);
		resultado = usudao.excluir(usu);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	/**Metodo para chamar o método de consulta do DAO
	* @author Luis Felipe
	* @param int id
	* @return List<String> - com a lista com todos os valores da consulta
	*/
	public List<String> listaUmUsuario(int id){
		Connection con = Conexao.abrirConexao();
		UsuarioDAO usudao = new UsuarioDAO(con);
		List<String> lista = usudao.listarUm(id);
		if (lista != null) {
			Conexao.fecharConexao(con);
			return lista;
		}
		Conexao.fecharConexao(con);
		return null;
	}

}
