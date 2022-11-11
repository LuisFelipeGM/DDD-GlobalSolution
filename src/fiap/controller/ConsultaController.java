/**Classe de Controller da consulta, chamando o metodo do DAO
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.controller;

import java.sql.*;
import java.util.*;
import fiap.model.*;

public class ConsultaController {
	
	/**Metodo para chamar o método de consulta do DAO
	* @author Luis Felipe
	* @param int nrSerie
	* @return List<String> - com a lista com todos os valores da consulta
	*/
	public String listaUmUsuario(int nrSerie){
		Connection con = Conexao.abrirConexao();
		ConsultaDAO condao = new ConsultaDAO(con);
		try {
			List<String> lista = condao.listarUm(nrSerie);
			String dados = "";
			if (lista != null) {
				//System.out.println(lista);
				dados = "Consulta Completa do Número de Série\n\n";
				dados += "Número de Série: " + lista.get(0) + "\n";
				dados += "Nome: " + lista.get(1) + "\n";
				dados += "Email: " + lista.get(2) + "\n";
				dados += "CPF: " + lista.get(3) + "\n";
				dados += "Telefone: (" + lista.get(4) + ") " + lista.get(5) + "\n";
				dados += "Data de Aquisição: " + lista.get(6) + "\n";
				dados += "Marca: " + lista.get(7) + "\n";
				dados += "Modelo: " + lista.get(8) + "\n";
				dados += "Placa: " + lista.get(9) + "\n";
				dados += "Calibragem do Pneu: " + lista.get(10) + "\n";
				dados += "Vida Útil do Pneu: " + lista.get(11) + "\n";
				dados += "Vida Útil da Suspensão: " + lista.get(12) + "\n";
				dados += "Quilometragem: " + lista.get(13) + "\n";
				dados += "Vida Útil do Freio: " + lista.get(14) + "\n";
				dados += "Data Última Manutenção: " + lista.get(15) + "\n";
				dados += "Vida Útil do Motor: " + lista.get(16) + "\n";
				dados += "Carga da Bateria: " + lista.get(17) + "\n";
				dados += "Vida Útil da Bateria: " + lista.get(18) + "\n";
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return null;
		}
	}

}
