/**Classe para o fazer uma consulta completa com base no Numero de Serie no Banco de Dados utilizando a classe Conexao
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {

	private Connection con;
	
	public ConsultaDAO(Connection con) {
		setCon(con);
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	/**Metodo para consultar o Banco de Dados e trazer uma consulta completa
	* @author Luis Felipe
	* @param int - Numero de Serie do objeto Carro no Banco de Dados
	* @return List<String> - com a lista com todos os valores
	*/
	public List<String> listarUm(int nrSerie){
		String sql = "SELECT CA.NR_SERIE, U.NM_COMPLETO,U.DS_EMAIL, U.NR_CPF, TL.NR_DDD, TL.NR_TELEFONE, "
				+ "TO_CHAR(CU.DT_INICIO, 'DD/MM/YYYY') DT_INICIO, CA.NM_MARCA, CA.NM_MODELO, CA.NR_PLACA, "
				+ "INF.NR_PNEU_CALIBRAGEM, INF.DS_PNEU_VIDA_UTIL, INF.DS_SUSPENSAO_VIDA_UTIL, "
				+ "INF.DS_QUILOMETRAGEM, INF.DS_FREIO_VIDA_UTIL, TO_CHAR(INF.DT_ULT_MANUTENCAO, 'DD/MM/YYYY') DT_ULT_MANUTENCAO, "
				+ "MT.DS_MOTOR_VIDA_UTIL, BT.NR_BATERIA_CARGA, BT.DS_BATERIA_VIDA_UTIL "
				+ "FROM T_GS_USUARIO U LEFT JOIN T_GS_TELEFONE TL ON(U.ID_USUARIO = TL.ID_USUARIO) "
				+ "INNER JOIN T_GS_CARRO_USUARIO CU ON(U.ID_USUARIO = CU.ID_USUARIO) "
				+ "INNER JOIN T_GS_CARRO CA ON(CU.ID_CARRO = CA.ID_CARRO) "
				+ "INNER JOIN T_GS_INFO_CARRO INF ON(CA.ID_CARRO = INF.ID_CARRO) "
				+ "INNER JOIN T_GS_MOTOR MT ON(MT.ID_INFO_CARRO = INF.ID_INFO_CARRO) "
				+ "INNER JOIN T_GS_BATERIA BT ON(BT.ID_INFO_CARRO = INF.ID_INFO_CARRO) WHERE CA.NR_SERIE = ?";
		
		List<String> resul = new ArrayList<String>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, nrSerie);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				resul.add(rs.getString("NR_SERIE"));
				resul.add(rs.getString("NM_COMPLETO"));
				resul.add(rs.getString("DS_EMAIL"));
				resul.add(rs.getString("NR_CPF"));
				resul.add(rs.getString("NR_DDD"));
				resul.add(rs.getString("NR_TELEFONE"));
				resul.add(rs.getString("DT_INICIO"));
				resul.add(rs.getString("NM_MARCA"));
				resul.add(rs.getString("NM_MODELO"));
				resul.add(rs.getString("NR_PLACA"));
				resul.add(rs.getString("NR_PNEU_CALIBRAGEM"));
				resul.add(rs.getString("DS_PNEU_VIDA_UTIL"));
				resul.add(rs.getString("DS_SUSPENSAO_VIDA_UTIL"));
				resul.add(rs.getString("DS_QUILOMETRAGEM"));
				resul.add(rs.getString("DS_FREIO_VIDA_UTIL"));
				resul.add(rs.getString("DT_ULT_MANUTENCAO"));
				resul.add(rs.getString("DS_MOTOR_VIDA_UTIL"));
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
