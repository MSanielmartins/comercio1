package comercio_parte;

public class Periferico extends Produto{

	private String cor;
	

	public Periferico(String nome, int codigo, String cor) {
		super(nome, codigo);
		this.cor = cor;
	}

	@Override
	public void listar(boolean produto) {
		System.out.printf("PERIFERICO -  %s (cod.: %d || estoque: %d || atributos: %s || custo de compra: %d || valor de venda: %d)\n"
				, super.getNome(), super.getCodigo(), super.getEstoque(), this.cor, super.getValor_compra(), super.getValor_venda());
			}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
}
