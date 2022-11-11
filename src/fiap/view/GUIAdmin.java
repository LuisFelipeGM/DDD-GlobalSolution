package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import fiap.controller.EmpresaController;

@SuppressWarnings({ "serial", "unused" })
public class GUIAdmin extends JPanel{
	
	private JLabel lbIdAdmin, lbNomeAdmin, lbSenha, lbEmail;
	private JTextField tfIdAdmin, tfNomeAdmin, tfSenha, tfEmail;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga;
	
	public GUIAdmin() {
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
		lbIdAdmin = new JLabel("ID Admin:");
		lbNomeAdmin = new JLabel("Nome Admin:");
		lbSenha = new JLabel("Senha: ");
		lbEmail = new JLabel("Email: ");
		
		//Instanciando Text Field
		tfIdAdmin = new JTextField();
		tfNomeAdmin = new JTextField();
		tfSenha = new JTextField();
		tfEmail = new JTextField();
		
		
		lbIdAdmin.setBounds(25, 30, 100, 25);
		tfIdAdmin.setBounds(130, 30, 200, 25);
		
		lbNomeAdmin.setBounds(25, 65, 100, 25);
		tfNomeAdmin.setBounds(130, 65, 200, 25);
		
		lbSenha.setBounds(25, 100, 100, 25);
		tfSenha.setBounds(130, 100, 200, 25);
		
		lbEmail.setBounds(25, 135, 100, 25);
		tfEmail.setBounds(130, 135, 200, 25);
				
		
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
		
		add(lbIdAdmin);
		add(lbNomeAdmin);
		add(lbSenha);
		add(lbEmail);
		
		add(tfIdAdmin);
		add(tfNomeAdmin);
		add(tfSenha);
		add(tfEmail);

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