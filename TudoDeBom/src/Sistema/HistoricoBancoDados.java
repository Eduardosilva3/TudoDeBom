package Sistema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * @author Eduardo  Silva
 * */


public class HistoricoBancoDados {
	private static List<String> produtoRetorno = new ArrayList<>();
	private static List<ConsultaHistorico> listaHistorico = new ArrayList<>();
	private static HashMap<Integer, Produto> listaProdutos = new HashMap<>();
	private static List<String> listaCpf = new ArrayList<>();
	private static List<String> estoque = new ArrayList<>();
	private Connection connection = null;
	private java.sql.Statement statement = null;
	private ResultSet resultset = null;
	 
	
	
	public static List<String> getEstoque() {
		return estoque;
	}
	public static List<String> getListaCpf() {
		return listaCpf;
	}
	public static List<String> getProdutoRetorno() {
		return produtoRetorno;
	}
	public HashMap<Integer, Produto> getListaProdutos() {
		return listaProdutos;
	}
	
	

	public static List<ConsultaHistorico> getListaHistorico() {
		return listaHistorico;
	}
	
	public void conectar() {

		String servidor = "jdbc:mysql://farmacia-ibm.mysql.database.azure.com:3306/ibm_farmacia?serverTimezone=UTC";
		String usuario = "Grupo6_IBM@farmacia-ibm";
		String senha = "group6_1234";
		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
	}

	public boolean estaConectado() {
		if (this.connection != null) {
			return true;
		} else {
			return false;
		}
	}	
	/**
	 * 
	 * - Função para adicionar as informações da compra ao historico do banco de dados
	 * 
	 * @author Eduardo Silva
	 * 
	 */
	public void inserirInformacoes(String cpf, List<Carrinho> listaCarrinho, double valorTotal) {
		// formatando cpf para o formato padrão antes de inserir ao banco de dados
		
		String cpfFormato = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" +cpf.substring(9, 11);
		// inserindo data e hora da compra no banco de dados
		
		String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		
		
		try {
			String query = String.format("insert into historico_transacoes (historico_cpf, valor_total, data_compra) values ('%s', '%.2f', '%s')", cpfFormato,valorTotal, date);
			
			this.statement.executeUpdate(query);
			
			String retornoId = "SELECT LAST_INSERT_ID()";
			
			this.resultset = this.statement.executeQuery(retornoId);
			this.statement=this.connection.createStatement();
			
			if(resultset != null && resultset.next()){
				retornoId = resultset.getString("LAST_INSERT_ID()");
            }
			
			query = "create table pedido_"+retornoId+ "(id_item int not null auto_increment primary key, produto_lista varchar(200) not null);";
			
			this.statement.executeUpdate(query);
			
			for(int i =0; i < listaCarrinho.size(); i++) {
				String item = String.format("%s | Quantidade: %d", listaCarrinho.get(i).getProduto(), listaCarrinho.get(i).getQuantPedido());
				String queryPedido = String.format("insert into pedido_%s (produto_lista) values ('%s')",retornoId,item );
				this.statement.executeUpdate(queryPedido);
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}
	/**
	 * 
	 * - Função para ler os produtos em estoque no banco de dados
	 * 
	 * @author Eduardo Silva
	 * 
	 */
public void baixandoProdutos() {
		
		try {
			
			String query = "select * from estoque";
			this.resultset = this.statement.executeQuery(query);
			this.statement=this.connection.createStatement();
			
			while(this.resultset.next()) {
				
				
				
				String meuID = resultset.getString("id_produto");
				String nomeP= resultset.getString("nome_produto");
				
				String quant = resultset.getString("qtd_produto");
				double valor= resultset.getDouble("valor_unit");
				int idGenerico = resultset.getInt("generic_value");
				int id = Integer.parseInt(meuID);
				int quantEstoque = Integer.parseInt(quant);
				String generico = "";
				
				if(idGenerico ==  1) {
					generico = "Generico";
					
				}else {
					generico = "N/ Generico";
				}
				
				
				
				listaProdutos.put(id, new Produto(nomeP, quantEstoque,valor, idGenerico ));
				estoque.add(String.format("ID: %s | Produo: %s | Quantidade: %d | Valor: %.2f | Tipo: %s",meuID, nomeP, quantEstoque,valor, generico));
				
				
				
				
				
				
				
			}
			}catch(Exception e ) {
				System.out.println("Erro"+e.getMessage());
			}
	}

/**
 * 
 * - Função para atualizar o estoque após a compra de produtos
 * 
 * @author Eduardo Silva
 * 
 */
	public void atualizarEstoque(List<Carrinho> carrinho) {
		
		
		try {
			
			for(int i = 0; i < carrinho.size(); i++) {
				
				String query = String.format("update estoque set qtd_produto = %s where id_produto in(%s)", carrinho.get(i).getQuantidadeRestante(), carrinho.get(i).getIdProduto());
				
				this.statement.executeUpdate(query);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * 
	 * - Função para consultar o historico de transações de venda e compra
	 * 
	 * @author Eduardo Silva
	 * 
	 */
	public void consultarHistorio() {
		conectar();
		listaHistorico.clear();
		
		try {
			
			String query = "select p.id_pedido, p.historico_cpf, p.valor_total, p.data_compra, m.nome_cliente from historico_transacoes as p inner join clientes as m on(p.historico_cpf = m.cpf_cliente);";
			this.resultset = this.statement.executeQuery(query);
			this.statement=this.connection.createStatement();
			
			while(this.resultset.next()) {
				String meuID = resultset.getString("id_pedido");
				String cpf= resultset.getString("historico_cpf");
				
				

				
				String nome = resultset.getString("nome_cliente");
				String data = resultset.getString("data_compra");
				
				
				
				
				listaHistorico.add(new ConsultaHistorico(meuID, cpf, nome, resultset.getString("valor_total"), data));
				
				
				
				
				
				

				}
			}catch(Exception e ) {
				System.out.println("Erro"+e.getMessage());
			}
	}
	
	/**
	 * 
	 * - Função para exibir os detalhes de cada compra de acordo com o id.
	 * 
	 * @author Eduardo Silva
	 * 
	 */
	public void exibirDetalhesCompleto(String id) {
		conectar();
			try {
			
				String query = String.format("select * from pedido_%s", id);
				this.resultset = this.statement.executeQuery(query);
				this.statement=this.connection.createStatement();
			
					while(this.resultset.next()) {
				
				
				
							String meuID = resultset.getString("id_item");
							String nomeP= resultset.getString("produto_lista");
				
							String item = "ID Item: "+meuID +" " + nomeP;
				
				
							produtoRetorno.add(item);
				
				
				
					}
					
				}catch(Exception e ) {
				System.out.println("Erro"+e.getMessage());
			}
		
	}
	
	/**
	 * 
	 * - Função bara ler e baixar os dados do cliente para ser efetuado a venda
	 * 
	 * @author Eduardo Silva
	 * 
	 */
	public void baixandoCliente() {
		try {
			
			
			
			String query = "select * from clientes";
			
			
			this.resultset = this.statement.executeQuery(query);
			this.statement=this.connection.createStatement();
			
			
			
			
			while(this.resultset.next()) {
			
			listaCpf.add(resultset.getString("cpf_cliente"));
			
			
			}
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"erro"+e);
		}
		
	}
	
	/**
	 * 
	 * - Função para ler o nome e e-mail do cliente e adicionar na tela de venda
	 * 
	 * @author Eduardo Silva
	 * 
	 */
	
	public void buscarCliente(String cpf) {
		try {
			String query = String.format("select * from clientes where cpf_cliente = '%s'", cpf);
			this.resultset = this.statement.executeQuery(query);
			this.statement=this.connection.createStatement();
			
			
			
			
			while(this.resultset.next()) {
				
				Venda.setNome(resultset.getString("nome_cliente"));
				Venda.setEmail(resultset.getString("email_cliente"));
				
			
			
			}
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"erro"+e);
		}
	}
}
