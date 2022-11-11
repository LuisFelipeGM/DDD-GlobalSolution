package fiap.view;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import fiap.controller.UsuarioController;

@SuppressWarnings({ "serial", "unused" })
public class GUIInfoCarro extends JPanel{
	
	private JLabel lbIdInfoCarro, lbIdCarro, lbNrPneuCalibragem, lbPneuVidaUtil, lbSuspensaoVidaUtil;
	private JLabel lbQuilometragem, lbFreioVidaUtil, lbDtUltManutencao;
	private JTextField tfIdInfoCarro, tfIdCarro, tfNrPneuCalibragem, tfPneuVidaUtil, tfSuspensaoVidaUtil;
	private JTextField tfQuilometragem, tfFreioVidaUtil, tfDtUltManutencao;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga;

	
	public GUIInfoCarro() {
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
		lbIdInfoCarro = new JLabel("ID Info Carro:");
		lbIdCarro = new JLabel("ID Carro:");
		lbNrPneuCalibragem = new JLabel("Calibragem Pneu: ");
		lbPneuVidaUtil = new JLabel("Pneu Vida Útil: ");
		lbSuspensaoVidaUtil = new JLabel("Suspensão Vida Útil: ");
		lbQuilometragem = new JLabel("Quilometragem: ");
		lbFreioVidaUtil = new JLabel("Freio Vida Util:");
		lbDtUltManutencao = new JLabel("Data Última Manutenção:");
		
		//Instanciando Text Field
		tfIdInfoCarro = new JTextField();
		tfIdCarro = new JTextField();
		tfNrPneuCalibragem = new JTextField();
		tfPneuVidaUtil = new JTextField();
		tfSuspensaoVidaUtil = new JTextField();
		tfQuilometragem = new JTextField();
		tfFreioVidaUtil = new JTextField();
		tfDtUltManutencao = new JTextField();
			
		
		lbIdInfoCarro.setBounds(25, 30, 100, 25);
		tfIdInfoCarro.setBounds(130, 30, 200, 25);
		
		lbIdCarro.setBounds(25, 65, 100, 25);
		tfIdCarro.setBounds(130, 65, 200, 25);
		
		lbNrPneuCalibragem.setBounds(25, 100, 150, 25);
		tfNrPneuCalibragem.setBounds(140, 100, 200, 25);
		
		lbPneuVidaUtil.setBounds(25, 135, 100, 25);
		tfPneuVidaUtil.setBounds(130, 135, 200, 25);
		
		lbSuspensaoVidaUtil.setBounds(25, 170, 150, 25);
		tfSuspensaoVidaUtil.setBounds(160, 170, 200, 25);
		
		lbQuilometragem.setBounds(25, 205, 100, 25);
		tfQuilometragem.setBounds(130, 205, 200, 25);
		
		lbFreioVidaUtil.setBounds(25, 240, 100, 25);
		tfFreioVidaUtil.setBounds(130, 240, 200, 25);
		
		lbDtUltManutencao.setBounds(25, 275, 150, 25);
		tfDtUltManutencao.setBounds(180, 275, 200, 25);
		
	
		
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
		
		add(lbIdInfoCarro);
		add(lbIdCarro);
		add(lbNrPneuCalibragem);
		add(lbPneuVidaUtil);
		add(lbSuspensaoVidaUtil);
		add(lbQuilometragem);
		add(lbFreioVidaUtil);
		add(lbDtUltManutencao);
		
		add(tfIdInfoCarro);
		add(tfIdCarro);
		add(tfNrPneuCalibragem);
		add(tfPneuVidaUtil);
		add(tfSuspensaoVidaUtil);
		add(tfQuilometragem);
		add(tfFreioVidaUtil);
		add(tfDtUltManutencao);
		
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