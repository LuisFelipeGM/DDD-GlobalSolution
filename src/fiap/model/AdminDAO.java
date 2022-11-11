/**Classe para o CRUD dos objetos do tipo Admin no Banco de Dados utilizando a classe Conexao
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO implements IDAO{
	
	private Connection con;
	private Admin admin;
	
	public AdminDAO(Connection con) {
		setCon(con);
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	/**Metodo para inserir um objeto Admin no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da operação 
	*/
	public String inserir(Object obj) {
		admin = (Admin) obj;
		String sql = "INSERT INTO T_GS_ADMIN (ID_ADMIN, NM_ADMIN, DS_EMAIL, DS_SENHA) "
				+ "VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, admin.getIdAdmin());
			ps.setString(2, admin.getNmAdmin());
			ps.setString(3, admin.getDsEmail());
			ps.setString(4, admin.getDsSenha());
			if (ps.executeUpdate() > 0) {
				return "Inserido com Sucesso";
			} else {
				return "Erro ao inserir";
			}
			
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para alterar um objeto Admin no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da operação 
	*/
	public String alterar(Object obj) {
		admin = (Admin) obj;
		String sql = "UPDATE T_GS_ADMIN SET NM_ADMIN = ?, DS_EMAIL = ?, DS_SENHA = ? WHERE ID_ADMIN = ? ";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, admin.getNmAdmin());
			ps.setString(2, admin.getDsEmail());
			ps.setString(3, admin.getDsSenha());
			ps.setInt(4, admin.getIdAdmin());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}
	/**Metodo para excluir um objeto Admin no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da operação 
	*/
	public String excluir(Object obj) {
		admin = (Admin) obj;
		String sql = "DELETE FROM T_GS_ADMIN WHERE ID_ADMIN = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, admin.getIdAdmin());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para consultar o Banco de Dados e trazer um objeto do tipo Admin
	* @author Luis Felipe
	* @param int - id do objeto no Banco de Dados
	* @return List<String> - com a lista com todos os valores do objeto
	*/
	public List<String> listarUm(int id){
		String sql = "SELECT * FROM T_GS_ADMIN WHERE ID_ADMIN = ?";
		List<String> resul = new ArrayList<String>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				resul.add(rs.getString("ID_ADMIN"));
				resul.add(rs.getString("NM_ADMIN"));
				resul.add(rs.getString("DS_EMAIL"));
				resul.add(rs.getString("DS_SENHA"));
				return resul;
			} else {
				return resul;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
