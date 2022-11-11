/**Classe de Interface GUI Motor
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import fiap.controller.MotorController;

@SuppressWarnings({ "serial", "unused" })
public class GUIMotor extends JPanel{
	
	private JLabel lbIdMotor, lbIdInfoCarro, lbMotorVidaUtil;
	private JTextField tfIdMotor, tfIdInfoCarro, tfMotorVidaUtil;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga;
	
	public GUIMotor() {
		inicializarComponentes();
		definirEventos();
	}
	
	/**Metodo para inicializar todos os componentes do GUI Motor
	* @author Luis Felipe
	* @param null 
	* @return void
	*/
	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		
		//Instanciando Botoes 
		btPesquisa = new JButton(new ImageIcon(getClass().getResource("imagens/search_icon.png")));
		btNovo = new JButton(new ImageIcon(getClass().getResource("imagens/new_icon.png")));
		btAtualiza = new JButton(new ImageIcon(getClass().getResource("imagens/update_icon.png")));
		btApaga = new JButton(new ImageIcon(getClass().getResource("imagens/delete_icon.png")));
		
		//Instanciando Labels
		lbIdMotor = new JLabel("ID Motor:");
		lbIdInfoCarro = new JLabel("ID Info Carro:");
		lbMotorVidaUtil = new JLabel("Motor Vida Util: ");
		
		//Instanciando Text Field
		tfIdMotor = new JTextField();
		tfIdInfoCarro = new JTextField();
		tfMotorVidaUtil = new JTextField();
		
		
		lbIdMotor.setBounds(25, 30, 100, 25);
		tfIdMotor.setBounds(130, 30, 200, 25);
		
		lbIdInfoCarro.setBounds(25, 65, 100, 25);
		tfIdInfoCarro.setBounds(130, 65, 200, 25);
		
		lbMotorVidaUtil.setBounds(25, 100, 100, 25);
		tfMotorVidaUtil.setBounds(130, 100, 200, 25);
				
		
		//set Bounds Botoes
		btPesquisa.setBounds(150, 430, 60, 40);
		btNovo.setBounds(290, 430, 60, 40);
		btAtualiza.setBounds(430, 430, 60, 40);
		btApaga.setBounds(570, 430, 60, 40);
		
		//Add os elementos
		add(btPesquisa);
		add(btNovo);
		add(btAtualiza);
		add(btApaga);
		
		add(lbIdMotor);
		add(lbIdInfoCarro);
		add(lbMotorVidaUtil);
		
		add(tfIdMotor);
		add(tfIdInfoCarro);
		add(tfMotorVidaUtil);

	}
	
	private void definirEventos() {

		btPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MotorController mc = new MotorController();
				List<String> dados = new ArrayList<String>();
				if (tfIdMotor.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Motor");
					tfIdMotor.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdMotor.getText());
					dados = mc.listaUmMotor(id);
					if (dados.isEmpty() == false) {
						tfIdInfoCarro.setText(dados.get(1));
						tfMotorVidaUtil.setText(dados.get(2));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
				}
			}
		});
		
		btNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MotorController mc = new MotorController();
				if (tfIdMotor.getText().equals("") || tfIdInfoCarro.getText().equals("") || 
						tfMotorVidaUtil.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int idMotor = Integer.parseInt(tfIdMotor.getText());
					int idInfoCarro = Integer.parseInt(tfIdInfoCarro.getText());
					int MotorVidaUtil = Integer.parseInt(tfMotorVidaUtil.getText());
					
					JOptionPane.showMessageDialog(null, mc.insereMotor(idMotor, idInfoCarro, MotorVidaUtil));
					
					tfIdMotor.setText("");
					tfIdInfoCarro.setText("");
					tfMotorVidaUtil.setText("");

				}
				
			}
		});
		
		btAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MotorController mc = new MotorController();
				if (tfIdMotor.getText().equals("") || tfIdInfoCarro.getText().equals("") || 
						tfMotorVidaUtil.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int idMotor = Integer.parseInt(tfIdMotor.getText());
					int idInfoCarro = Integer.parseInt(tfIdInfoCarro.getText());
					int MotorVidaUtil = Integer.parseInt(tfMotorVidaUtil.getText());
					
					JOptionPane.showMessageDialog(null, mc.alteraMotor(idMotor, idInfoCarro, MotorVidaUtil));
					
					tfIdMotor.setText("");
					tfIdInfoCarro.setText("");
					tfMotorVidaUtil.setText("");

				}
				
			}
		});
		
		/**Metodo para definir os eventos do GUI Motor
		* @author Luis Felipe
		* @param null 
		* @return void
		*/
		btApaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MotorController mc = new MotorController();
				if (tfIdMotor.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Motor");
				} else {
					int idMotor = Integer.parseInt(tfIdMotor.getText());
					
					JOptionPane.showMessageDialog(null, mc.excluiMotor(idMotor));
					
					tfIdMotor.setText("");
					tfIdInfoCarro.setText("");
					tfMotorVidaUtil.setText("");

				}
			}
		});
		
		
		
	}
}