/**Classe de Controller dos objetos do tipo Empresa chamando os metodos do CRUD
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.controller;

import java.sql.*;
import java.util.*;
import fiap.model.*;

public class EmpresaController {

	/**Metodo para chamar o método de inserir do DAO
	* @author Luis Felipe
	* @param int idEmpresa, String nmEmpresa, String nrCNPJ, String dsEmail, String dsSenha
	* @return String - com o resultado da operação 
	*/
	public String insereEmpresa(int idEmpresa, String nmEmpresa, String nrCNPJ, String dsEmail, String dsSenha) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		EmpresaDAO empdao = new EmpresaDAO(con);
		Empresa emp = new Empresa();
		emp.setIdEmpresa(idEmpresa);
		emp.setNmEmpresa(nmEmpresa);
		emp.setNrCnpj(nrCNPJ);
		emp.setDsEmail(dsEmail);
		emp.setDsSenha(dsSenha);
		resultado = empdao.inserir(emp);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	/**Metodo para chamar o método de alterar do DAO
	* @author Luis Felipe
	* @param int idEmpresa, String nmEmpresa, String nrCNPJ, String dsEmail, String dsSenha
	* @return String - com o resultado da operação 
	*/
	public String alteraEmpresa(int idEmpresa, String nmEmpresa, String nrCNPJ, String dsEmail, String dsSenha) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		EmpresaDAO empdao = new EmpresaDAO(con);
		Empresa emp = new Empresa();
		emp.setIdEmpresa(idEmpresa);
		emp.setNmEmpresa(nmEmpresa);
		emp.setNrCnpj(nrCNPJ);
		emp.setDsEmail(dsEmail);
		emp.setDsSenha(dsSenha);
		resultado = empdao.alterar(emp);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	/**Metodo para chamar o método de excluir do DAO
	* @author Luis Felipe
	* @param int idEmpresa
	* @return String - com o resultado da operação 
	*/
	public String excluiEmpresa(int idEmpresa) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		EmpresaDAO empdao = new EmpresaDAO(con);
		Empresa emp = new Empresa();
		emp.setIdEmpresa(idEmpresa);
		resultado = empdao.excluir(emp);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	/**Metodo para chamar o método de consulta do DAO
	* @author Luis Felipe
	* @param int id
	* @return List<String> - com a lista com todos os valores da consulta
	*/
	public List<String> listaUmaEmpresa(int id){
		Connection con = Conexao.abrirConexao();
		EmpresaDAO empdao = new EmpresaDAO(con);
		List<String> lista = empdao.listarUm(id);
		if (lista != null) {
			Conexao.fecharConexao(con);
			return lista;
		}
		Conexao.fecharConexao(con);
		return null;
	}
	
}
