package fiap.controller;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import fiap.model.*;

public class CarroController {
	
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
	
	public List<String> listaUmCarro(int id){
		Connection con = Conexao.abrirConexao();
		CarroDAO cardao = new CarroDAO(con);
		List<String> lista = cardao.listarUm(id);
		if (lista != null) {
			return lista;
		}
		Conexao.fecharConexao(con);
		return null;
	}

}
