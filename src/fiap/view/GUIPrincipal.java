/**Classe de Interface GUI Principal
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class GUIPrincipal extends JFrame {
	private Container contentPane;
	private JMenuBar mnBarra;
	private JMenu mnArquivo, mnUsuarios, mnCarros, mnNrSerie;
	private JMenuItem miSair, miUsuario, miEmpresa, miAdmin, miCarro, miCarroUsuario, miInfoCarro, miMotor, miBateria, miNrSerie;

	
	public GUIPrincipal() {
		inicializarComponentes();
		definirEventos();
	}
	
	/**Metodo para inicializar todos os componentes do GUI Principal
	* @author Luis Felipe
	* @param null 
	* @return void
	*/
	private void inicializarComponentes() {
		setTitle("Janela Principal");
		setBounds(0, 0, 800, 600);
		contentPane = getContentPane();
		
		mnBarra = new JMenuBar();
		mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		mnUsuarios= new JMenu("Usuarios");
		mnUsuarios.setMnemonic('U');
		mnCarros = new JMenu("Carro");
		mnCarros.setMnemonic('C');
		mnNrSerie = new JMenu("Consulta");
		mnNrSerie.setMnemonic('S');
		
		
		
		
		miSair = new JMenuItem("Sair", new ImageIcon(getClass().getResource("exit_icon.png")));
		miUsuario = new JMenuItem("Usuario");
		miEmpresa = new JMenuItem("Empresa");
		miAdmin = new JMenuItem("Administrador");
		miCarro = new JMenuItem("Carro");
		miCarroUsuario = new JMenuItem("Carro Usuario");
		miInfoCarro = new JMenuItem("Informacoes");
		miMotor = new JMenuItem("Motor");
		miBateria = new JMenuItem("Bateria");
		miNrSerie = new JMenuItem("Consulta Completa");
		
		setJMenuBar(mnBarra);
		mnBarra.add(mnArquivo);
		mnBarra.add(mnUsuarios);
		mnBarra.add(mnCarros);
		mnBarra.add(mnNrSerie);
		
		mnArquivo.add(miSair);
		
		mnUsuarios.add(miUsuario);
		mnUsuarios.add(miEmpresa);
		mnUsuarios.add(miAdmin);
		
		mnCarros.add(miCarro);
		mnCarros.add(miCarroUsuario);
		mnCarros.add(miInfoCarro);
		mnCarros.add(miMotor);
		mnCarros.add(miBateria);
		
		mnNrSerie.add(miNrSerie);
		
		
	}
	
	/**Metodo para definir os eventos do GUI Principal
	* @author Luis Felipe
	* @param null 
	* @return void
	*/
	private void definirEventos() {
		miSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		miUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIUsuario usuario = new GUIUsuario();
				contentPane.removeAll();
				contentPane.add(usuario);
				contentPane.validate();
			}
		});
		
		miEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIEmpresa empresa = new GUIEmpresa();
				contentPane.removeAll();
				contentPane.add(empresa);
				contentPane.validate();
			}
		});
		
		miAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIAdmin admin = new GUIAdmin();
				contentPane.removeAll();
				contentPane.add(admin);
				contentPane.validate();
			}
		});
		
		miCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUICarro carro = new GUICarro();
				contentPane.removeAll();
				contentPane.add(carro);
				contentPane.validate();
			}
		});
		
		miCarroUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUICarroUsuario carroUsuario = new GUICarroUsuario();
				contentPane.removeAll();
				contentPane.add(carroUsuario);
				contentPane.validate();
			}
		});
		
		miInfoCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIInfoCarro infoCarro = new GUIInfoCarro();
				contentPane.removeAll();
				contentPane.add(infoCarro);
				contentPane.validate();
			}
		});
		
		miMotor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMotor motor = new GUIMotor();
				contentPane.removeAll();
				contentPane.add(motor);
				contentPane.validate();
			}
		});
		miBateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIBateria bateria = new GUIBateria();
				contentPane.removeAll();
				contentPane.add(bateria);
				contentPane.validate();
			}
		});
		miNrSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUINrSerie nrSerie = new GUINrSerie();
				contentPane.removeAll();
				contentPane.add(nrSerie);
				contentPane.validate();
			}
		});	
	}
	
	public static void main(String[] args) {
		GUIPrincipal frame = new GUIPrincipal();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width) / 2,
				(tela.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}
}