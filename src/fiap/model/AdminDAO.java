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
