/**Classe de Controller dos objetos do tipo Carro chamando os metodos do CRUD
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.controller;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import fiap.model.*;

public class CarroController {
	
	/**Metodo para chamar o método de inserir do DAO
	* @author Luis Felipe
	* @param int idCarro, int idEmpresa, int nrSerie, String nmMarca, String nmModelo, String nrPlaca, LocalDate dtFabricacao
	* @return String - com o resultado da operação 
	*/
	public String insereCarro(int idCarro, int idEmpresa, int nrSerie, String nmMarca, String nmModelo, String nrPlaca,
			LocalDate dtFabricacao) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroDAO cardao = new CarroDAO(con);
		Carro car = new Carro();
		car.setIdCarro(idCarro);
		car.setIdEmpresa(idEmpresa);
		car.setNrSerie(nrSerie);
		car.setNmMarca(nmMarca);
		car.setNmModelo(nmModelo);
		car.setNrPlaca(nrPlaca);
		car.setDtFabricacao(dtFabricacao);
		resultado = cardao.inserir(car);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	/**Metodo para chamar o método de alterar do DAO
	* @author Luis Felipe
	* @param int idCarro, int idEmpresa, int nrSerie, String nmMarca, String nmModelo, String nrPlaca, LocalDate dtFabricacao
	* @return String - com o resultado da operação 
	*/
	public String alteraCarro(int idCarro, int idEmpresa, int nrSerie, String nmMarca, String nmModelo, String nrPlaca,
			LocalDate dtFabricacao) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroDAO cardao = new CarroDAO(con);
		Carro car = new Carro();
		car.setIdCarro(idCarro);
		car.setIdEmpresa(idEmpresa);
		car.setNrSerie(nrSerie);
		car.setNmMarca(nmMarca);
		car.setNmModelo(nmModelo);
		car.setNrPlaca(nrPlaca);
		car.setDtFabricacao(dtFabricacao);
		resultado = cardao.alterar(car);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	/**Metodo para chamar o método de excluir do DAO
	* @author Luis Felipe
	* @param int idCarro
	* @return String - com o resultado da operação 
	*/
	public String excluiCarro(int idCarro) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroDAO cardao = new CarroDAO(con);
		Carro car = new Carro();
		car.setIdCarro(idCarro);
		resultado = cardao.excluir(car);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	/**Metodo para chamar o método de consulta do DAO
	* @author Luis Felipe
	* @param int id
	* @return List<String> - com a lista com todos os valores da consulta
	*/
	public List<String> listaUmCarro(int id){
		Connection con = Conexao.abrirConexao();
		CarroDAO cardao = new CarroDAO(con);
		List<String> lista = cardao.listarUm(id);
		if (lista != null) {
			Conexao.fecharConexao(con);
			return lista;
		}
		Conexao.fecharConexao(con);
		return null;
	}

}
