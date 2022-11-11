package fiap.controller;

import java.sql.*;
import java.util.*;
import fiap.model.*;

public class EmpresaController {

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
	
	public List<String> listaUmaEmpresa(int id){
		Connection con = Conexao.abrirConexao();
		EmpresaDAO empdao = new EmpresaDAO(con);
		List<String> lista = empdao.listarUm(id);
		if (lista != null) {
			return lista;
		}
		Conexao.fecharConexao(con);
		return null;
	}
	
}
