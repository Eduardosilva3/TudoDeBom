

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Sistema.ClienteTela;
import Sistema.Estoque;
import Sistema.HistoricoBancoDados;
import Sistema.ListaCompleta;
import Sistema.ListaDetalhes;
import Sistema.Venda;


//import Sistema.*;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.JButton;

/**
 * JFrame responsável pela tela principal da aplicação 
 * @author Katryn
 * 
 * */

public class DashPrincipal extends JFrame {
	private JPanel desktop;
	/**
	 * Ícones do Menu Principal
	 */
	private static final long serialVersionUID = 1L;
	private Image img_logo = new ImageIcon(DashPrincipal.class.getResource("Imagens/pharmacy.png")).getImage()
			.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private Image img_sair = new ImageIcon(DashPrincipal.class.getResource("Imagens/sair.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_historico = new ImageIcon(DashPrincipal.class.getResource("Imagens/historico.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_medicamentos = new ImageIcon(DashPrincipal.class.getResource("Imagens/medicamentos.png"))
			.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_vendas = new ImageIcon(DashPrincipal.class.getResource("Imagens/vendas.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_clientes = new ImageIcon(DashPrincipal.class.getResource("Imagens/clientes.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashPrincipal frame = new DashPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DashPrincipal() {
		setBackground(new Color(47, 79, 79));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 954, 514);
		// setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel paneMenu = new JPanel();
		paneMenu.setBackground(new Color(47, 79, 79));
		paneMenu.setBounds(0, 0, 293, 475);
		contentPane.add(paneMenu);
		
		ClienteTela telaCliente = new ClienteTela();
		ListaCompleta listaCompleta = new ListaCompleta();
		ListaDetalhes listaDetalhes = new ListaDetalhes();
		Venda vendas = new Venda();

		/**
		 * Logo principal
		 */
		paneMenu.setLayout(null);
		JLabel lblIconeLogo = new JLabel("");
		lblIconeLogo.setBounds(10, 11, 247, 132);
		lblIconeLogo.setHorizontalAlignment(SwingConstants.CENTER);
		paneMenu.add(lblIconeLogo);
		lblIconeLogo.setIcon(new ImageIcon(img_logo));
		
		/**
		 * Menu Cliente
		 */

		JPanel paneClientes = new JPanel();
		paneClientes.setBounds(0, 145, 293, 40);
		paneClientes.setBackground(new Color(0, 139, 139));
		paneMenu.add(paneClientes);
		paneClientes.setLayout(null);
		JLabel lblClientes = new JLabel("");
		lblClientes.setBounds(43, 1, 40, 40);
		paneClientes.add(lblClientes);
		lblClientes.setIcon(new ImageIcon(img_clientes));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar.setBounds(105, 1, 192, 39);
		paneClientes.add(menuBar);

		JMenu mnNewMenu = new JMenu("CLIENTE");
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 206, 209));
		desktopPane.setBounds(293, 0, 645, 475);
		contentPane.add(desktopPane);
		desktopPane.setLayout(new CardLayout(0, 0));
		mnNewMenu.setFont(new Font("Dialog", Font.BOLD, 13));
		mnNewMenu.setForeground(new Color(0, 139, 139));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Atualização");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCliente.setVisible(true);
				desktopPane.add(telaCliente);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		/**
		 * Menu Medicamentos
		 */

		JPanel paneMedicamentos = new JPanel();
		paneMedicamentos.setForeground(new Color(0, 139, 139));
		paneMedicamentos.setBounds(0, 186, 293, 40);
		paneMedicamentos.setBackground(new Color(0, 128, 128));
		paneMenu.add(paneMedicamentos);

		paneMedicamentos.setLayout(null);

		JLabel lblMedicamentos = new JLabel("");
		lblMedicamentos.setBounds(40, 1, 40, 40);
		paneMedicamentos.add(lblMedicamentos);
		lblMedicamentos.setIcon(new ImageIcon(img_medicamentos));

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(104, 1, 192, 39);
		paneMedicamentos.add(menuBar_1);

		JMenu mnNewMenu_1 = new JMenu("MEDICAMENTOS");
		mnNewMenu_1.setForeground(new Color(0, 139, 139));
		mnNewMenu_1.setFont(new Font("Dialog", Font.BOLD, 13));
		menuBar_1.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listagem");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCliente.dispose();
				listaDetalhes.dispose();
				listaDetalhes.setVisible(false);
				//vendas.setVisible(true);
				HistoricoBancoDados bd = new HistoricoBancoDados();
				bd.conectar();
				bd.baixandoProdutos();
				Estoque.estoque();
				
				//desktopPane.add(vendas);				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);

		/**
		 * Menu vendas 
		 */
		
		JPanel paneVendas = new JPanel();
		paneVendas.setBounds(0, 227, 293, 40);
		paneVendas.setBackground(new Color(0, 139, 139));
		paneMenu.add(paneVendas);

		
		paneVendas.setLayout(null);

		JLabel lblVendas = new JLabel("");
		lblVendas.setBounds(38, 0, 40, 40);
		paneVendas.add(lblVendas);
		lblVendas.setIcon(new ImageIcon(img_vendas));

		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setFont(new Font("Dialog", Font.BOLD, 13));
		menuBar_2.setBounds(103, 1, 190, 39);
		paneVendas.add(menuBar_2);

		JMenu mnNewMenu_2 = new JMenu("VENDAS");
		mnNewMenu_2.setForeground(new Color(0, 139, 139));
		mnNewMenu_2.setFont(new Font("Dialog", Font.BOLD, 13));
		menuBar_2.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Nova Venda");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCliente.dispose();
				listaDetalhes.dispose();
				listaDetalhes.setVisible(false);
				//vendas.setVisible(true);
				vendas.vendaTela();
				//desktopPane.add(vendas);				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		/**
		 * Menu Histórico
		 */

		JPanel paneHistorico = new JPanel();
		paneHistorico.setBounds(0, 268, 293, 40);
		paneHistorico.setBackground(new Color(0, 139, 139));
		paneMenu.add(paneHistorico);
		paneHistorico.setLayout(null);

		JLabel lblHistorico = new JLabel("");
		lblHistorico.setBounds(39, 0, 40, 40);
		paneHistorico.add(lblHistorico);
		lblHistorico.setIcon(new ImageIcon(img_historico));

		JMenuBar menuBar_3 = new JMenuBar();
		menuBar_3.setBounds(103, 0, 190, 39);
		paneHistorico.add(menuBar_3);

		JMenu mnNewMenu_3 = new JMenu("HISTÓRICO");
		mnNewMenu_3.setFont(new Font("Dialog", Font.BOLD, 13));
		mnNewMenu_3.setForeground(new Color(0, 139, 139));
		menuBar_3.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Todos os Registros");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoricoBancoDados bd = new HistoricoBancoDados();
				bd.consultarHistorio();
				ListaDetalhes.detalhesPedidos();
				listaDetalhes.dispose();
				
				
				vendas.dispose();
			
				
				
			
			}		
		});
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		/**
		 * Menu Sair
		 */

		JPanel paneSair = new JPanel();
		paneSair.setBounds(0, 309, 293, 40);
		paneSair.setBackground(new Color(0, 139, 139));
		paneMenu.add(paneSair);
		paneSair.setLayout(null);

		JLabel lblSair = new JLabel("");
		lblSair.setBounds(35, 0, 40, 40);
		paneSair.add(lblSair);
		lblSair.setIcon(new ImageIcon(img_sair));

		JMenuBar menuBar_2_1 = new JMenuBar();
		menuBar_2_1.setForeground(new Color(0, 139, 139));
		menuBar_2_1.setFont(new Font("Dialog", Font.BOLD, 13));
		menuBar_2_1.setBounds(103, 1, 190, 39);
		paneSair.add(menuBar_2_1);

		JMenu mnNewMenu_4 = new JMenu("SAIR");
		mnNewMenu_4.setForeground(new Color(0, 139, 139));
		mnNewMenu_4.setFont(new Font("Dialog", Font.BOLD, 13));
		menuBar_2_1.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("SAIR");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção",
						JOptionPane.YES_NO_OPTION);
				if (sair == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}

		});
		mnNewMenu_4.add(mntmNewMenuItem_5);
		
		JButton btnNewButton = new JButton("VOLTAR");
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				telaCliente.dispose();
				listaDetalhes.dispose();
				
				vendas.dispose();
				desktopPane.disable();
				
				
			}
		});
		btnNewButton.setBounds(204, 425, 79, 23);
		paneMenu.add(btnNewButton);
		
		
	}
	
	
}
