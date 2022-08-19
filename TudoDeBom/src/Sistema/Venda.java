package Sistema;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
/**
 * 
 * - Tela para fazer uma nova venda 
 * 
 * @author Eduardo Silva
 * 
 */
public class Venda extends JFrame {
	private JTextField textCpf;
	private JTextField textCodigoProduto;
	private JTextField textQuantidade;
	private JTextField textRetorno;
	
	
	

	private JPanel contentPane;
	
	private String textCarrinho;
	private int quantEstoque;
	private static String cpf;
	private static String nome;
	private static String email;
	
	private static double valor;
	private static JTextField textField_nome;
	private static JTextField textField_email;
	private static JTextField textField_carrinho;
	
	public void setTextCpf(String textCpf) {
		this.textCpf.setText(textCpf);
	}
	public void setTextCodigoProduto(String textCodigoProduto) {
		this.textCodigoProduto.setText(textCodigoProduto);
	}
	public void setTextQuantidade(String textQuantidade) {
		this.textQuantidade.setText(textQuantidade);
	}
	public void setTextRetorno(String textRetorno) {
		this.textRetorno.setText(textRetorno);
	}
	public void setTextCarrinho(String textCarrinho) {
		Venda.textField_carrinho.setText(textCarrinho);
	}
	

	public static void setNome(String nome) {
		Venda.textField_nome.setText(nome);
	}
	public static void setEmail(String email) {
		Venda.textField_email.setText(email);
	}
	public void setCpf(String cpf) {
		Venda.cpf = cpf;
	}

	/**
	 * Launch the application.
	 */
	public static void vendaTela() {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Venda frame = new Venda();
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
	public Venda() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 689, 452);
		getContentPane().setLayout(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(38, 38, 582, 343);
		getContentPane().add(contentPane);
		
		JLabel lblNome = new JLabel("CPF do  cliente  :");
		lblNome.setBounds(10, 11, 110, 14);
		contentPane.add(lblNome);
		
		textCpf = new JTextField((String) null);
		textCpf.setColumns(10);
		textCpf.setBounds(153, 8, 141, 20);
		contentPane.add(textCpf);
		
		JLabel lblNewLabel = new JLabel("Codigo do Produto");
		lblNewLabel.setBounds(10, 130, 129, 14);
		contentPane.add(lblNewLabel);
		
		textCodigoProduto = new JTextField();
		textCodigoProduto.setColumns(10);
		textCodigoProduto.setBounds(153, 127, 86, 20);
		contentPane.add(textCodigoProduto);
		/**
		 * 
		 * - Botão para exibir informações do produto em estoque
		 * 
		 * @author Eduardo Silva
		 * 
		 */
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto consulta = new Produto();
				
				
				
				
				int codigo = Integer.parseInt(textCodigoProduto.getText());
				consulta.consultaProduto(codigo);
				String nome = consulta.getNome_remedio();
				quantEstoque = consulta.getQuantEstoque();
				double valorSemDesonto = consulta.getValor_remedio();
				int idGenerico = consulta.getFlag_generico();
				String valorDesconto = "Não se aplica!";
				double valorDescontoReal = 0;
				
				if(idGenerico == 1) {
					valorDescontoReal = valorSemDesonto * 0.80;
					valorDesconto = String.format("%.2f", valorDescontoReal);
					valor = valorDescontoReal;
					
					
				}else {
					valor = valorSemDesonto;
				}
				
				
				
				textRetorno.setText(String.format("Produto: %s | Quantidade em Estoque: %d | Valor Unitario: %.2f | Valor com Desconto:%s ", nome, quantEstoque, valorSemDesonto, valorDesconto));
				
				textCarrinho = String.format("Produto: %s | Valor Unitario: %.2f", nome, valor);
			}
		});
		btnBuscar.setBounds(260, 126, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblNewLabel_1 = new JLabel("Produto");
		lblNewLabel_1.setBounds(260, 160, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		lblNewLabel_2.setBounds(10, 211, 93, 14);
		contentPane.add(lblNewLabel_2);
		
		textQuantidade = new JTextField();
		textQuantidade.setColumns(10);
		textQuantidade.setBounds(113, 208, 26, 20);
		contentPane.add(textQuantidade);
		/**
		 * 
		 * - - Botão para adicionar produto ao carrinho
		 * 
		 * @author Eduardo Silva
		 * 
		 */
		JButton btnAdicionarCarrinho = new JButton("Adicionar ao carrinho");
		btnAdicionarCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pedidoQuantidade;
				cpf = textCpf.getText();
				
				while(true) {
					
					if(textCpf.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Digite o CPF!");
						break;
					}else if(textRetorno.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Selecione o produto;");
						break;
					}else if(textQuantidade.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Selecione a Quantidade;");
						break;
					}
					
					pedidoQuantidade = Integer.parseInt(textQuantidade.getText());
					
					if(pedidoQuantidade > quantEstoque) {
						JOptionPane.showMessageDialog(null, "Estoque Insuficiente;");
						break;
					}
					quantEstoque = quantEstoque - pedidoQuantidade;
					//instancia do objeto carrinho
					
					
					Carrinho carrinho = new Carrinho(textCpf.getText(), textCodigoProduto.getText(), textCarrinho , quantEstoque, pedidoQuantidade, valor);
					
					
					// chamando função para adicionar no carrinho
					String adicionar = carrinho.adicionandoCarrinho();
					textField_carrinho.setText(String.valueOf(Carrinho.getCarrinho().size()));
					JOptionPane.showMessageDialog(null, adicionar);
					break;
				}
				
				
				
			}
		});
		btnAdicionarCarrinho.setBounds(10, 255, 185, 23);
		contentPane.add(btnAdicionarCarrinho);
		
		JButton btnVerCarrinho = new JButton("Visualizar Carrinho");
		btnVerCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarrinhoView carrinho = new CarrinhoView();
				carrinho.exibirCarrinho();
			}
		});
		btnVerCarrinho.setBounds(320, 255, 149, 23);
		contentPane.add(btnVerCarrinho);
		
		textRetorno = new JTextField();
		textRetorno.setEditable(false);
		textRetorno.setColumns(10);
		textRetorno.setBounds(10, 180, 569, 20);
		contentPane.add(textRetorno);
		/**
		 * 
		 * - - Botão para buscar dados do cliente
		 * 
		 * @author Eduardo Silva
		 * 
		 */
		JButton btnNewButton = new JButton("Buscar Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoricoBancoDados bd = new HistoricoBancoDados();
				//formatando e validando cpf
				String cpfFormato = "";
				 if(textCpf.getText().contains(".")) {
					 cpfFormato = textCpf.getText();
				 }else {
				    cpfFormato = textCpf.getText().substring(0, 3) + "." + textCpf.getText().substring(3, 6) + "." + textCpf.getText().substring(6, 9) + "-" +textCpf.getText().substring(9, 11);
				 }
				
				bd.conectar();
				bd.baixandoCliente();
				bd.baixandoProdutos();
				
				
				
				
				
				List<String> cpf = new ArrayList<String>(HistoricoBancoDados.getListaCpf());
				
				boolean teste = false;
				for(int i =0; i < cpf.size(); i++) {
					 
					if(cpf.get(i).equals(cpfFormato)) {
						
						bd.buscarCliente(cpfFormato);
						JLabel lblemail = new JLabel();
						lblemail.setText(email);
						lblemail.setBounds(53, 77, 197, 14);
						contentPane.add(lblemail);
						teste = true;
						break;
					}
				}
				
				if(teste == false) {
					JOptionPane.showMessageDialog(null, "Cliente não cadastrado!");
				}
			}
		});
		btnNewButton.setBounds(330, 7, 122, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Nome: ");
		lblNewLabel_3.setBounds(10, 52, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("E-mail:");
		lblNewLabel_4.setBounds(10, 77, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_nome = new JTextField();
		textField_nome.setEditable(false);
		textField_nome.setColumns(10);
		textField_nome.setBounds(46, 49, 336, 20);
		contentPane.add(textField_nome);
		
		textField_email = new JTextField();
		textField_email.setEditable(false);
		textField_email.setColumns(10);
		textField_email.setBounds(46, 74, 336, 20);
		contentPane.add(textField_email);
		
		textField_carrinho = new JTextField();
		textField_carrinho.setEditable(false);
		textField_carrinho.setColumns(10);
		textField_carrinho.setBounds(264, 256, 46, 20);
		contentPane.add(textField_carrinho);

	}
}
