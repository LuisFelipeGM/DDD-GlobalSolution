/**Classe de Interface GUI Usuario
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

import fiap.controller.UsuarioController;

@SuppressWarnings({ "serial", "unused" })
public class GUIUsuario extends JPanel {

	private JLabel lbIdUsuario, lbNomeCompleto, lbSenha, lbEmail, lbNrCPF;
	private JLabel lbNrDDI, lbNrDDD, lbNrTelefone, lbStTelefone;
	private JTextField tfIdUsuario, tfNomeCompleto, tfSenha, tfEmail, tfNrCPF;
	private JTextField tfNrDDI, tfNrDDD, tfNrTelefone;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga;
	private JRadioButton rbAtivo, rbInativo;
	private ButtonGroup btGroup;

	public GUIUsuario() {
		inicializarComponentes();
		definirEventos();
	}
	
	/**Metodo para inicializar todos os componentes do GUI Usuario
	* @author Luis Felipe
	* @param null 
	* @return void
	*/
	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);

		// Instanciando Botoes
		btPesquisa = new JButton(new ImageIcon(getClass().getResource("imagens/search_icon.png")));
		btNovo = new JButton(new ImageIcon(getClass().getResource("imagens/new_icon.png")));
		btAtualiza = new JButton(new ImageIcon(getClass().getResource("imagens/update_icon.png")));
		btApaga = new JButton(new ImageIcon(getClass().getResource("imagens/delete_icon.png")));

		// Instanciando Labels
		lbIdUsuario = new JLabel("ID Usuario:");
		lbNomeCompleto = new JLabel("Nome Completo:");
		lbSenha = new JLabel("Senha: ");
		lbEmail = new JLabel("Email: ");
		lbNrCPF = new JLabel("CPF: ");
		lbNrDDI = new JLabel("DDI: ");
		lbNrDDD = new JLabel("DDD:");
		lbNrTelefone = new JLabel("Telefone:");

		// Instanciando Text Field
		tfIdUsuario = new JTextField();
		tfNomeCompleto = new JTextField();
		tfSenha = new JTextField();
		tfEmail = new JTextField();
		tfNrCPF = new JTextField();
		tfNrDDI = new JTextField();
		tfNrDDD = new JTextField();
		tfNrTelefone = new JTextField();

		lbStTelefone = new JLabel("Status Telefone:");
		rbAtivo = new JRadioButton("Ativo");
		rbAtivo.setBackground(getBackground());
		rbInativo = new JRadioButton("Inativo");
		rbInativo.setBackground(getBackground());
		btGroup = new ButtonGroup();
		btGroup.add(rbAtivo);
		btGroup.add(rbInativo);

		lbIdUsuario.setBounds(25, 30, 100, 25);
		tfIdUsuario.setBounds(130, 30, 200, 25);

		lbNomeCompleto.setBounds(25, 65, 100, 25);
		tfNomeCompleto.setBounds(130, 65, 200, 25);
		
		lbEmail.setBounds(25, 100, 100, 25);
		tfEmail.setBounds(130, 100, 200, 25);

		lbSenha.setBounds(25, 135, 100, 25);
		tfSenha.setBounds(130, 135, 200, 25);

		lbNrCPF.setBounds(25, 170, 100, 25);
		tfNrCPF.setBounds(130, 170, 200, 25);

		lbNrDDI.setBounds(25, 205, 100, 25);
		tfNrDDI.setBounds(130, 205, 50, 25);

		lbNrDDD.setBounds(25, 240, 100, 25);
		tfNrDDD.setBounds(130, 240, 50, 25);

		lbNrTelefone.setBounds(25, 275, 100, 25);
		tfNrTelefone.setBounds(130, 275, 200, 25);

		lbStTelefone.setBounds(25, 310, 100, 25);
		rbAtivo.setBounds(35, 345, 100, 25);
		rbInativo.setBounds(35, 380, 100, 25);

		// set Bounds Bot�es
		btPesquisa.setBounds(150, 430, 60, 40);
		btNovo.setBounds(290, 430, 60, 40);
		btAtualiza.setBounds(430, 430, 60, 40);
		btApaga.setBounds(570, 430, 60, 40);

		// Add os elementos
		add(btPesquisa);
		add(btNovo);
		add(btAtualiza);
		add(btApaga);

		add(lbIdUsuario);
		add(lbNomeCompleto);
		add(lbEmail);
		add(lbSenha);
		add(lbNrCPF);
		add(lbNrDDI);
		add(lbNrDDD);
		add(lbNrTelefone);
		add(lbStTelefone);

		add(tfIdUsuario);
		add(tfNomeCompleto);
		add(tfEmail);
		add(tfSenha);
		add(tfNrCPF);
		add(tfNrDDI);
		add(tfNrDDD);
		add(tfNrTelefone);

		add(rbAtivo);
		add(rbInativo);
	}

	/**Metodo para definir os eventos do GUI Usuario
	* @author Luis Felipe
	* @param null 
	* @return void
	*/
	private void definirEventos() {

		btPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioController uc = new UsuarioController();
				List<String> dados = new ArrayList<String>();
				if (tfIdUsuario.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Candidato");
					tfIdUsuario.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdUsuario.getText());
					dados = uc.listaUmUsuario(id);
					if (dados.isEmpty() == false) {
						tfNomeCompleto.setText(dados.get(1));
						tfEmail.setText(dados.get(2));
						tfSenha.setText(dados.get(3));
						tfNrCPF.setText(dados.get(4));
						tfNrDDI.setText(dados.get(6));
						tfNrDDD.setText(dados.get(5));
						tfNrTelefone.setText(dados.get(7));
						if (dados.get(8).equals("A")) {
							rbAtivo.setSelected(true);
						} else if (dados.get(8).equals("I")) {
							rbInativo.setSelected(true);
						} 
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
				}
				

			}
		});

		btNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioController uc = new UsuarioController();
				String status = "";
				if (rbAtivo.isSelected()) {
					status = "A";
				} else if (rbInativo.isSelected()) {
					status = "I";
				} else {
					status = "";
				}
				if (tfIdUsuario.getText().equals("") || tfNomeCompleto.getText().equals("")
						|| tfSenha.getText().equals("") || tfEmail.getText().equals("") || tfNrCPF.getText().equals("")
						|| tfNrDDI.getText().equals("") || tfNrDDD.getText().equals("")
						|| tfNrTelefone.getText().equals("") || status.equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdUsuario.getText());
					int ddi = Integer.parseInt(tfNrDDI.getText());
					int ddd = Integer.parseInt(tfNrDDD.getText());
					int telefone = Integer.parseInt(tfNrTelefone.getText());

					JOptionPane.showMessageDialog(null,
							uc.insereUsuario(id, tfNomeCompleto.getText(), tfEmail.getText(), tfSenha.getText(),
									tfNrCPF.getText(), ddi, ddd, telefone, status));
					
					tfIdUsuario.setText("");
					tfNomeCompleto.setText("");
					tfSenha.setText("");
					tfEmail.setText("");
					tfNrCPF.setText("");
					tfNrDDI.setText("");
					tfNrDDD.setText("");
					tfNrTelefone.setText("");
					rbAtivo.setSelected(true);
					
					
				}

			}
		});

		btAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioController uc = new UsuarioController();
				String status = "";
				if (rbAtivo.isSelected()) {
					status = "A";
				} else if (rbInativo.isSelected()) {
					status = "I";
				} else {
					status = "";
				}
				if (tfIdUsuario.getText().equals("") || tfNomeCompleto.getText().equals("")
						|| tfSenha.getText().equals("") || tfEmail.getText().equals("") || tfNrCPF.getText().equals("")
						|| tfNrDDI.getText().equals("") || tfNrDDD.getText().equals("")
						|| tfNrTelefone.getText().equals("") || status.equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdUsuario.getText());
					int ddi = Integer.parseInt(tfNrDDI.getText());
					int ddd = Integer.parseInt(tfNrDDD.getText());
					int telefone = Integer.parseInt(tfNrTelefone.getText());

					JOptionPane.showMessageDialog(null,
							uc.alteraUsuario(id, tfNomeCompleto.getText(), tfEmail.getText(), tfSenha.getText(),
									tfNrCPF.getText(), ddi, ddd, telefone, status));
					
					tfIdUsuario.setText("");
					tfNomeCompleto.setText("");
					tfSenha.setText("");
					tfEmail.setText("");
					tfNrCPF.setText("");
					tfNrDDI.setText("");
					tfNrDDD.setText("");
					tfNrTelefone.setText("");
					rbAtivo.setSelected(true);
					
					
				}

			}
		});

		btApaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioController uc = new UsuarioController();
				if (tfIdUsuario.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Candidato");
					tfIdUsuario.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdUsuario.getText());
					JOptionPane.showMessageDialog(null, uc.excluiUsuario(id));
					
					tfIdUsuario.setText("");
					tfNomeCompleto.setText("");
					tfSenha.setText("");
					tfEmail.setText("");
					tfNrCPF.setText("");
					tfNrDDI.setText("");
					tfNrDDD.setText("");
					tfNrTelefone.setText("");
					rbAtivo.setSelected(true);
				}
			}
		});

	}
}