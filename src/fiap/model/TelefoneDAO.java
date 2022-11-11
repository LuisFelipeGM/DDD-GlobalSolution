/**Classe para o CRUD dos objetos do tipo Telefone no Banco de Dados utilizando a classe Conexao
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TelefoneDAO implements IDAO{
	
	private Connection con;
	private Telefone telefone;
	
	public TelefoneDAO(Connection con) {
		setCon(con);
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	/**Metodo para inserir um objeto Telefone no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da operação 
	*/
	public String inserir(Object obj) {
		telefone = (Telefone) obj;
		String sql = "INSERT INTO T_GS_TELEFONE (ID_TELEFONE, ID_USUARIO, NR_DDI, NR_DDD, NR_TELEFONE, ST_TELEFONE) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, telefone.getIdTelefone());
			ps.setInt(2, telefone.getIdUsuario());
			ps.setInt(3, telefone.getNrDDI());
			ps.setInt(4, telefone.getNrDDD());
			ps.setInt(5, telefone.getNrTelefone());
			ps.setString(6, telefone.getStTelefone());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
			
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para alterar um objeto Telefone no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da operação 
	*/
	public String alterar(Object obj) {
		telefone = (Telefone) obj;
		String sql = "UPDATE T_GS_TELEFONE SET NR_DDI = ?, NR_DDD = ?, NR_TELEFONE = ?, ST_TELEFONE = ? WHERE ID_TELEFONE = ? ";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, telefone.getNrDDI());
			ps.setInt(2, telefone.getNrDDD());
			ps.setInt(3, telefone.getNrTelefone());
			ps.setString(4, telefone.getStTelefone());
			ps.setInt(5, telefone.getIdTelefone());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}
	
	/**Metodo para excluir um objeto Telefone no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da operação 
	*/
	public String excluir(Object obj) {
		telefone = (Telefone) obj;
		String sql = "DELETE FROM T_GS_TELEFONE WHERE ID_TELEFONE = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, telefone.getIdTelefone());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para consultar o Banco de Dados e trazer um objeto do tipo Telefone
	* @author Luis Felipe
	* @param int - id do objeto no Banco de Dados
	* @return List<String> - com a lista com todos os valores do objeto
	*/
	public List<String> listarUm(int id){
		String sql = "SELECT * FROM T_GS_USUARIO WHERE ID_USUARIO = ?";
		List<String> resul = new ArrayList<String>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				resul.add(rs.getString("ID_TELEFONE"));
				resul.add(rs.getString("ID_USUARIO"));
				resul.add(rs.getString("NR_DDI"));
				resul.add(rs.getString("NR_DDD"));
				resul.add(rs.getString("NR_TELEFONE"));
				resul.add(rs.getString("ST_TELEFONE"));
				return resul;
			} else {
				return resul;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
