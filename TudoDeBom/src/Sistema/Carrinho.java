package Sistema;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * - Objeto para adicionar produtos ao carrinho
 * 
 * @author Eduardo  Silva
 * 
 */
public class Carrinho {
	private String cpf;
	private String idProduto;
	private String produto;
	private int quantidadeRestante;
	private int quantPedido;
	private double valorTotal;
	private static List<Carrinho> carrinho = new ArrayList<Carrinho>();

	public double getValorTotal() {
		return valorTotal;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public int getQuantidadeRestante() {
		return quantidadeRestante;
	}

	@Override
	public String toString() {
		return "IDProduto=" + idProduto + "| Produto= " + produto + "| Estoque após Pedido = " + quantidadeRestante
				+ " Pedido Solicitado =" + quantPedido;
	}

	public Carrinho() {
		super();
	}

	public Carrinho(String cpf, String idProduto, String produto, int quantidadeRestante, int quantPedido,
			double valorTotal) {
		super();
		this.cpf = cpf;
		this.idProduto = idProduto;
		this.produto = produto;
		this.quantidadeRestante = quantidadeRestante;
		this.quantPedido = quantPedido;
		this.valorTotal = valorTotal;
	}

	public static List<Carrinho> getCarrinho() {
		return carrinho;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getQuantPedido() {
		return quantPedido;
	}

	public void setQuantPedido(int quantPedido) {
		this.quantPedido = quantPedido;
	}
	
	/**
	 * 
	 * - metodo para adicionar produtos ao carrinho
	 * 
	 * @author Eduardo  Silva
	 * 
	 */

	public String adicionandoCarrinho() {
		carrinho.add(new Carrinho(cpf, idProduto, produto, quantidadeRestante, quantPedido, valorTotal));
		return "Produto adicionado com sucesso!";
	}

	public void removerProduto(int i) {

		carrinho.remove(i);
	}

	public void setCarrinho(List<Carrinho> carrinho) {
		this.carrinho = new ArrayList<Carrinho>(carrinho);
	}

}
