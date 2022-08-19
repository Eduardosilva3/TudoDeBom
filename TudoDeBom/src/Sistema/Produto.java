package Sistema;
import java.util.HashMap;
/**
 * 
 * - Classe para ler e enviar informações dos produtos que estão no estoque.
 * 
 * @author Eduardo Silva
 * 
 */
public class Produto {
	private String nome_remedio;
	private int quantEstoque;
	private double valor_remedio;
	private int flag_generico;
	
	
	public int getFlag_generico() {
		return flag_generico;
	}

	
	public Produto(String nome_remedio, int quantEstoque, double valor_remedio, int flag_generico) {
		super();
		this.nome_remedio = nome_remedio;
		this.quantEstoque = quantEstoque;
		this.valor_remedio = valor_remedio;
		this.flag_generico = flag_generico;
	}
	
	


	public Produto() {
		super();
	}


	@Override
	
	public String toString() {
		String format = String.format("produto [nome_remedio=" + nome_remedio + ", quantEstoque=" + quantEstoque + ", valor_remedio="
				+ valor_remedio + "]");
		return format;
	}

	public String getNome_remedio() {
		return nome_remedio;
	}

	public int getQuantEstoque() {
		return quantEstoque;
	}

	public double getValor_remedio() {
		return valor_remedio;
	}
	/**
	 * 
	 * - Função para ler e consultar produtos no banco de dados e adicionar em uma lista
	 * 
	 * @author Eduardo Silva
	 * 
	 */
	public void consultaProduto(int codigo) {
		
		HistoricoBancoDados bd = new HistoricoBancoDados();
		
		HashMap<Integer, Produto> listaProdutos = new HashMap<>(bd.getListaProdutos());
		
		
		
		
		nome_remedio = listaProdutos.get(codigo).getNome_remedio();
		quantEstoque =  listaProdutos.get(codigo).getQuantEstoque();
		
		valor_remedio = listaProdutos.get(codigo).getValor_remedio();
		flag_generico = listaProdutos.get(codigo).getFlag_generico();
		
		
		
		
	}
}
