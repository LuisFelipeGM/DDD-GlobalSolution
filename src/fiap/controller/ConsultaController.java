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
	
	/**Metodo para chamar o m�todo de consulta do DAO
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
				dados = "Consulta Completa do N�mero de S�rie\n\n";
				dados += "N�mero de S�rie: " + lista.get(0) + "\n";
				dados += "Nome: " + lista.get(1) + "\n";
				dados += "Email: " + lista.get(2) + "\n";
				dados += "CPF: " + lista.get(3) + "\n";
				dados += "Telefone: (" + lista.get(4) + ") " + lista.get(5) + "\n";
				dados += "Data de Aquisi��o: " + lista.get(6) + "\n";
				dados += "Marca: " + lista.get(7) + "\n";
				dados += "Modelo: " + lista.get(8) + "\n";
				dados += "Placa: " + lista.get(9) + "\n";
				dados += "Calibragem do Pneu: " + lista.get(10) + "\n";
				dados += "Vida �til do Pneu: " + lista.get(11) + "\n";
				dados += "Vida �til da Suspens�o: " + lista.get(12) + "\n";
				dados += "Quilometragem: " + lista.get(13) + "\n";
				dados += "Vida �til do Freio: " + lista.get(14) + "\n";
				dados += "Data �ltima Manuten��o: " + lista.get(15) + "\n";
				dados += "Vida �til do Motor: " + lista.get(16) + "\n";
				dados += "Carga da Bateria: " + lista.get(17) + "\n";
				dados += "Vida �til da Bateria: " + lista.get(18) + "\n";
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return null;
		}
	}

}
