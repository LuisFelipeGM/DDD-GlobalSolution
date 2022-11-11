/**Classe para o CRUD dos objetos do tipo Carro no Banco de Dados utilizando a classe Conexao
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.model;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO implements IDAO {
	
	private Connection con;
	private Carro carro;
	
	public CarroDAO(Connection con) {
		setCon(con);
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	/**Metodo para inserir um objeto Carro no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da operação 
	*/
	public String inserir(Object obj) {
		carro = (Carro) obj;
		String sql = "INSERT INTO T_GS_CARRO (ID_CARRO, ID_EMPRESA, NM_MARCA, NM_MODELO, NR_PLACA, NR_SERIE, DT_FABRICACAO) "
				+ "VALUES (?, ?, ?, ?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'))";
		try {
			
			// Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataFabricacao = carro.getDtFabricacao().format(formatter);
			
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, carro.getIdCarro());
			ps.setInt(2, carro.getIdEmpresa());
			ps.setString(3, carro.getNmMarca());
			ps.setString(4, carro.getNmModelo());
			ps.setString(5, carro.getNrPlaca());
			ps.setInt(6, carro.getNrSerie());
			ps.setString(7, dataFabricacao);
			if (ps.executeUpdate() > 0) {
				return "Inserido com Sucesso";
			} else {
				return "Erro ao inserir";
			}
			
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para alterar um objeto Carro no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da operação 
	*/
	public String alterar(Object obj) {
		carro = (Carro) obj;
		String sql = "UPDATE T_GS_CARRO SET ID_EMPRESA = ?, NM_MARCA = ?, NM_MODELO = ?, NR_PLACA = ?, NR_SERIE = ?, "
				+ "DT_FABRICACAO = TO_DATE(?, 'DD/MM/YYYY') WHERE ID_CARRO = ? ";
		try {
			// Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataFabricacao = carro.getDtFabricacao().format(formatter);
			
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, carro.getIdEmpresa());
			ps.setString(2, carro.getNmMarca());
			ps.setString(3, carro.getNmModelo());
			ps.setString(4, carro.getNrPlaca());
			ps.setInt(5, carro.getNrSerie());
			ps.setString(6, dataFabricacao);
			ps.setInt(7, carro.getIdCarro());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}
	
	/**Metodo para excluir um objeto Carro no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da operação 
	*/
	public String excluir(Object obj) {
		carro = (Carro) obj;
		String sql = "DELETE FROM T_GS_CARRO WHERE ID_CARRO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, carro.getIdCarro());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para consultar o Banco de Dados e trazer um objeto do tipo Carro
	* @author Luis Felipe
	* @param int - id do objeto no Banco de Dados
	* @return List<String> - com a lista com todos os valores do objeto
	*/
	public List<String> listarUm(int id){
		String sql = "SELECT ID_CARRO, ID_EMPRESA, NM_MARCA, NM_MODELO, NR_PLACA, NR_SERIE, "
				+ "TO_CHAR(DT_FABRICACAO, 'DD/MM/YYYY') DT_FABRICACAO FROM T_GS_CARRO WHERE ID_CARRO = ?";
		List<String> resul = new ArrayList<String>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				resul.add(rs.getString("ID_CARRO"));
				resul.add(rs.getString("ID_EMPRESA"));
				resul.add(rs.getString("NM_MARCA"));
				resul.add(rs.getString("NM_MODELO"));
				resul.add(rs.getString("NR_PLACA"));
				resul.add(rs.getString("NR_SERIE"));
				resul.add(rs.getString("DT_FABRICACAO"));
				return resul;
			} else {
				return resul;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
