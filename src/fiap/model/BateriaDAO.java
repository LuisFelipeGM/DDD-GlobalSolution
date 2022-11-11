/**Classe para o CRUD dos objetos do tipo Bateria no Banco de Dados utilizando a classe Conexao
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BateriaDAO implements IDAO{
	
	private Connection con;
	private Bateria bateria;
	
	public BateriaDAO(Connection con) {
		setCon(con);
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	/**Metodo para inserir um objeto Bateria no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da operação 
	*/
	public String inserir(Object obj) {
		bateria = (Bateria) obj;
		String sql = "INSERT INTO T_GS_BATERIA (ID_BATERIA, ID_INFO_CARRO, NR_BATERIA_CARGA, DS_BATERIA_VIDA_UTIL) "
				+ "VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, bateria.getIdBateria());
			ps.setInt(2, bateria.getIdInfoCarro());
			ps.setInt(3, bateria.getNrBateriaCarga());
			ps.setInt(4, bateria.getDsBateriaVidaUtil());
			if (ps.executeUpdate() > 0) {
				return "Inserido com Sucesso";
			} else {
				return "Erro ao inserir";
			}
			
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para alterar um objeto Bateria no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da operação 
	*/
	public String alterar(Object obj) {
		bateria = (Bateria) obj;
		String sql = "UPDATE T_GS_BATERIA SET ID_INFO_CARRO = ?, NR_BATERIA_CARGA = ?, DS_BATERIA_VIDA_UTIL = ? WHERE ID_BATERIA = ? ";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, bateria.getIdInfoCarro());
			ps.setInt(2, bateria.getNrBateriaCarga());
			ps.setInt(3, bateria.getDsBateriaVidaUtil());
			ps.setInt(4, bateria.getIdBateria());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}
	
	/**Metodo para excluir um objeto Bateria no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da operação 
	*/
	public String excluir(Object obj) {
		bateria = (Bateria) obj;
		String sql = "DELETE FROM T_GS_BATERIA WHERE ID_BATERIA = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, bateria.getIdBateria());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para consultar o Banco de Dados e trazer um objeto do tipo Bateria
	* @author Luis Felipe
	* @param int - id do objeto no Banco de Dados
	* @return List<String> - com a lista com todos os valores do objeto
	*/
	public List<String> listarUm(int id){
		String sql = "SELECT * FROM T_GS_BATERIA WHERE ID_BATERIA = ?";
		List<String> resul = new ArrayList<String>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				resul.add(rs.getString("ID_BATERIA"));
				resul.add(rs.getString("ID_INFO_CARRO"));
				resul.add(rs.getString("NR_BATERIA_CARGA"));
				resul.add(rs.getString("DS_BATERIA_VIDA_UTIL"));
				return resul;
			} else {
				return resul;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
