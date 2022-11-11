/**
 * Classe para objetos do tipo Motor
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.model;

import javax.swing.JOptionPane;

public class Motor {

	private int idMotor;
	private int idInfoCarro;
	private int dsMotorVidaUtil;

	public Motor() {
	}

	public Motor(int idMotor, int idInfoCarro, int dsMotorVidaUtil) {
		this.idMotor = idMotor;
		this.idInfoCarro = idInfoCarro;
		this.dsMotorVidaUtil = dsMotorVidaUtil;
	}

	public int getIdMotor() {
		return idMotor;
	}

	public void setIdMotor(int idMotor) {
		this.idMotor = idMotor;
	}

	public int getIdInfoCarro() {
		return idInfoCarro;
	}

	public void setIdInfoCarro(int idInfoCarro) {
		this.idInfoCarro = idInfoCarro;
	}

	public int getDsMotorVidaUtil() {
		return dsMotorVidaUtil;
	}

	public void setDsMotorVidaUtil(int dsMotorVidaUtil) {
		try {
			if (dsMotorVidaUtil > 0 && dsMotorVidaUtil < 1000000000) {
				this.dsMotorVidaUtil = dsMotorVidaUtil;
			} else {
				throw new Exception("Valor Invalido!\nColoque apenas 9 caracteres na Vida Util do Motor");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
