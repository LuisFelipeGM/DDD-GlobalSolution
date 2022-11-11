package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import fiap.controller.EmpresaController;

@SuppressWarnings({ "serial", "unused" })
public class GUIMotor extends JPanel{
	
	private JLabel lbIdMotor, lbIdInfoCarro, lbMotorVidaUtil;
	private JTextField tfIdMotor, tfIdInfoCarro, tfMotorVidaUtil;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga;
	
	public GUIMotor() {
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