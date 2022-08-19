package Sistema;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

/**
 * 
 * - Classe para visualizar o carrinho
 * 
 * @author Eduardo  Silva
 * 
 */


public class CarrinhoView extends JFrame {
	
	private JPanel contentPane;
	private static List<Carrinho> carrinho;
	public boolean fecharJanela;
	private static double valorTotal;
	private JTextField textField_valorTotal;
	/**
	 * Launch the application.
	 */
	public void exibirCarrinho() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarrinhoView frame = new CarrinhoView();
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
	public CarrinhoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768,525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Carrinho do cliente");
		lblNewLabel.setBounds(341, 28, 234, 35);
		contentPane.add(lblNewLabel);
		//baixando lista de carrinho da classe carrinho
		Carrinho lista = new Carrinho();
		carrinho = new  ArrayList<Carrinho>(lista.getCarrinho());
		
		DefaultListModel<Carrinho> model = new DefaultListModel<Carrinho>();
		
		/**
		 * 
		 * - Estrutura de repetiçºao para baixar a lista
		 * 
		 * @author Eduardo  Silva
		 * 
		 */
		
		for (int i = 0; i < carrinho.size(); i++) {
		     model.addElement(carrinho.get(i));
		     valorTotal = valorTotal + carrinho.get(i).getValorTotal() * carrinho.get(i).getQuantPedido();
		     
		     
		    
		    
		}
		JList<Carrinho> list = new JList<Carrinho>(model);
		
		JPanel panel = new JPanel();
		panel.setBounds(45, 108, 688, 284);
		contentPane.add(panel);
		
		
		panel.add(list);
		/**
		 * 
		 * - Botao para remover  produtos do carrinho
		 * 
		 * @author Eduardo Silva
		 * 
		 */
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				model.remove(list.getSelectedIndex());
				carrinho.clear();
				
				for(int i = 0; i < model.size(); i++) {
					carrinho.add(model.get(i));
					
					
				}
				lista.setCarrinho(carrinho);
				
				//lista.removerProduto(list.getSelectedIndex());
				
				list.setModel(model);
				
			}
		});
		btnNewButton.setBounds(66, 74, 89, 23);
		contentPane.add(btnNewButton);
		/**
		 * 
		 * - Botao para adicionar mais produto ao carrinho
		 * 
		 * @author Eduardo  Silva
		 * 
		 */
		JButton btnNewButton_1 = new JButton("Adicionar mais produtos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Venda vd = new Venda();
				
				valorTotal = valorTotal * 0;
				vd.setTextCarrinho(String.valueOf(model.getSize()));
				dispose();
			}
		});
		btnNewButton_1.setBounds(311, 74, 179, 23);
		contentPane.add(btnNewButton_1);
		/**
		 * 
		 * - Botao para finalizar a compra e lança as informações no historico do banco de dados
		 * 
		 * @author Eduardo  Silva
		 * 
		 */
		JButton btnNewButton_2 = new JButton("Finalizar compra");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoricoBancoDados bd = new HistoricoBancoDados();
				bd.conectar();
				
				JOptionPane.showMessageDialog(null, "Finalizando Compra...");
				
				bd.inserirInformacoes(carrinho.get(0).getCpf(), carrinho, valorTotal);
				bd.atualizarEstoque(carrinho);
				JOptionPane.showMessageDialog(null, "Compra Finalizada com Sucesso.");
				carrinho.clear();
				lista.setCarrinho(carrinho);
				fecharJanela = true;
				Venda vd = new Venda();
				
				vd.dispose();
				vd.setCpf("");
				vd.setTextCarrinho("");
				vd.setTextCodigoProduto("");
				vd.setTextQuantidade("");
				vd.setTextRetorno("");
				
				dispose();
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton_2.setBounds(583, 74, 150, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Valor Total: R$ ");
		lblNewLabel_1.setBounds(548, 402, 89, 23);
		contentPane.add(lblNewLabel_1);
		
		textField_valorTotal = new JTextField();
		textField_valorTotal.setText(String.format("%.2f", valorTotal));
		textField_valorTotal.setEditable(false);
		textField_valorTotal.setBounds(632, 403, 86, 20);
		contentPane.add(textField_valorTotal);
		textField_valorTotal.setColumns(10);
	}

	public static List<Carrinho> getCarrinho() {
		return carrinho;
	}
}
