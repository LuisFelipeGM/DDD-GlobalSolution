package fiap.view;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import fiap.controller.UsuarioController;

@SuppressWarnings({ "serial", "unused" })
public class GUIUsuario extends JPanel{
	
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
	
	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		
		//Instanciando Botoes 
		btPesquisa = new JButton(new ImageIcon(getClass().getResource("imagens/search_icon.png")));
		btNovo = new JButton(new ImageIcon(getClass().getResource("imagens/new_icon.png")));
		btAtualiza = new JButton(new ImageIcon(getClass().getResource("imagens/update_icon.png")));
		btApaga = new JButton(new ImageIcon(getClass().getResource("imagens/delete_icon.png")));
		
		//Instanciando Labels
		lbIdUsuario = new JLabel("ID Usuario:");
		lbNomeCompleto = new JLabel("Nome Completo:");
		lbSenha = new JLabel("Senha: ");
		lbEmail = new JLabel("Email: ");
		lbNrCPF = new JLabel("CPF: ");
		lbNrDDI = new JLabel("DDI: ");
		lbNrDDD = new JLabel("DDD:");
		lbNrTelefone = new JLabel("Telefone:");
		
		//Instanciando Text Field
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
		
		lbSenha.setBounds(25, 100, 100, 25);
		tfSenha.setBounds(130, 100, 200, 25);
		
		lbEmail.setBounds(25, 135, 100, 25);
		tfEmail.setBounds(130, 135, 200, 25);
		
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
		
	
		
		//set Bounds Bot�es
		btPesquisa.setBounds(150, 430, 60, 40);
		btNovo.setBounds(290, 430, 60, 40);
		btAtualiza.setBounds(430, 430, 60, 40);
		btApaga.setBounds(570, 430, 60, 40);
		
		//Add os elementos
		add(btPesquisa);
		add(btNovo);
		add(btAtualiza);
		add(btApaga);
		
		add(lbIdUsuario);
		add(lbNomeCompleto);
		add(lbSenha);
		add(lbEmail);
		add(lbNrCPF);
		add(lbNrDDI);
		add(lbNrDDD);
		add(lbNrTelefone);
		add(lbStTelefone);
		
		add(tfIdUsuario);
		add(tfNomeCompleto);
		add(tfSenha);
		add(tfEmail);
		add(tfNrCPF);
		add(tfNrDDI);
		add(tfNrDDD);
		add(tfNrTelefone);
		
		add(rbAtivo);
		add(rbInativo);
	}
	
	private void definirEventos() {

		btPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		btNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		btAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		btApaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		
	}
}