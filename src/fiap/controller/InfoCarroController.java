/**Classe de Controller dos objetos do tipo InfoCarro chamando os metodos do CRUD
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.controller;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import fiap.model.*;

public class InfoCarroController {
	
	/**Metodo para chamar o método de inserir do DAO
	* @author Luis Felipe
	* @param int idInfoCarro, int idCarro, int nrPneuCalibragem, int dsPneuVidaUtil, int dsSuspensaoVidaUtil, int dsQuilometragem, int dsFreioVidaUtil, LocalDate dtUltManutencao
	* @return String - com o resultado da operação 
	*/
	public String insereInfoCarro(int idInfoCarro, int idCarro, int nrPneuCalibragem, int dsPneuVidaUtil, int dsSuspensaoVidaUtil,
			int dsQuilometragem, int dsFreioVidaUtil, LocalDate dtUltManutencao) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		InfoCarroDAO infoCardao = new InfoCarroDAO(con);
		InfoCarro infoCar = new InfoCarro();
		infoCar.setIdInfoCarro(idInfoCarro);
		infoCar.setIdCarro(idCarro);
		infoCar.setNrPneuCalibragem(nrPneuCalibragem);
		infoCar.setDsPneuVidaUtil(dsPneuVidaUtil);
		infoCar.setDsSuspensaoVidaUtil(dsSuspensaoVidaUtil);
		infoCar.setDsQuilometragem(dsQuilometragem);
		infoCar.setDsFreioVidaUtil(dsFreioVidaUtil);
		infoCar.setDtUltManutencao(dtUltManutencao);
		resultado = infoCardao.inserir(infoCar);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	/**Metodo para chamar o método de alterar do DAO
	* @author Luis Felipe
	* @param int idInfoCarro, int idCarro, int nrPneuCalibragem, int dsPneuVidaUtil, int dsSuspensaoVidaUtil, int dsQuilometragem, int dsFreioVidaUtil, LocalDate dtUltManutencao 
	* @return String - com o resultado da operação 
	*/
	public String alteraInfoCarro(int idInfoCarro, int idCarro, int nrPneuCalibragem, int dsPneuVidaUtil, int dsSuspensaoVidaUtil,
			int dsQuilometragem, int dsFreioVidaUtil, LocalDate dtUltManutencao) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		InfoCarroDAO infoCardao = new InfoCarroDAO(con);
		InfoCarro infoCar = new InfoCarro();
		infoCar.setIdInfoCarro(idInfoCarro);
		infoCar.setIdCarro(idCarro);
		infoCar.setNrPneuCalibragem(nrPneuCalibragem);
		infoCar.setDsPneuVidaUtil(dsPneuVidaUtil);
		infoCar.setDsSuspensaoVidaUtil(dsSuspensaoVidaUtil);
		infoCar.setDsQuilometragem(dsQuilometragem);
		infoCar.setDsFreioVidaUtil(dsFreioVidaUtil);
		infoCar.setDtUltManutencao(dtUltManutencao);
		resultado = infoCardao.alterar(infoCar);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	/**Metodo para chamar o método de excluir do DAO
	* @author Luis Felipe
	* @param int idInfoCarro
	* @return String - com o resultado da operação 
	*/
	public String excluiInfoCarro(int idInfoCarro) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		InfoCarroDAO infoCardao = new InfoCarroDAO(con);
		InfoCarro infoCar = new InfoCarro();
		infoCar.setIdInfoCarro(idInfoCarro);
		resultado = infoCardao.excluir(infoCar);
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
		InfoCarroDAO infoCardao = new InfoCarroDAO(con);
		List<String> lista = infoCardao.listarUm(id);
		if (lista != null) {
			Conexao.fecharConexao(con);
			return lista;
		}
		Conexao.fecharConexao(con);
		return null;
	}

}
