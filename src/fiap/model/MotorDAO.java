/**Classe para o CRUD dos objetos do tipo Motor no Banco de Dados utilizando a classe Conexao
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotorDAO implements IDAO{
	
	private Connection con;
	private Motor motor;
	
	public MotorDAO(Connection con) {
		setCon(con);
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	/**Metodo para inserir um objeto Motor no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da opera??o 
	*/
	public String inserir(Object obj) {
		motor = (Motor) obj;
		String sql = "INSERT INTO T_GS_MOTOR (ID_MOTOR, ID_INFO_CARRO, DS_MOTOR_VIDA_UTIL) "
				+ "VALUES (?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, motor.getIdMotor());
			ps.setInt(2, motor.getIdInfoCarro());
			ps.setInt(3, motor.getDsMotorVidaUtil());
			if (ps.executeUpdate() > 0) {
				return "Inserido com Sucesso";
			} else {
				return "Erro ao inserir";
			}
			
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para alterar um objeto Motor no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da opera??o 
	*/
	public String alterar(Object obj) {
		motor = (Motor) obj;
		String sql = "UPDATE T_GS_MOTOR SET ID_INFO_CARRO = ?, DS_MOTOR_VIDA_UTIL = ? WHERE ID_MOTOR = ? ";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, motor.getIdInfoCarro());
			ps.setInt(2, motor.getDsMotorVidaUtil());
			ps.setInt(3, motor.getIdMotor());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}
	
	/**Metodo para excluir um objeto Motor no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da opera??o 
	*/
	public String excluir(Object obj) {
		motor = (Motor) obj;
		String sql = "DELETE FROM T_GS_MOTOR WHERE ID_MOTOR = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, motor.getIdMotor());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para consultar o Banco de Dados e trazer um objeto do tipo Motor
	* @author Luis Felipe
	* @param int - id do objeto no Banco de Dados
	* @return List<String> - com a lista com todos os valores do objeto 
	*/
	public List<String> listarUm(int id){
		String sql = "SELECT * FROM T_GS_MOTOR WHERE ID_MOTOR = ?";
		List<String> resul = new ArrayList<String>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				resul.add(rs.getString("ID_MOTOR"));
				resul.add(rs.getString("ID_INFO_CARRO"));
				resul.add(rs.getString("DS_MOTOR_VIDA_UTIL"));
				return resul;
			} else {
				return resul;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
