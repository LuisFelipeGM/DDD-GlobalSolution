package fiap.model;

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
		this.dsMotorVidaUtil = dsMotorVidaUtil;
	}

}
