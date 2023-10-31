package comercio_parte;

public class Produto {

	//atributos
		private String nome;
		private int estoque;
		private int codigo;
		private int valor_compra;
		private int valor_venda;
		private String categoria;
		private boolean comprado;
		private boolean vendido;

		// construtor
		public Produto(String nome, int codigo) {
			this.nome = nome;
			this.codigo  = codigo;;
		}
			
		public void listar(boolean produto) {
			 System.out.println("nome = " + nome + ", estoque = " + estoque + ", codigo = " + codigo + ", valor_compra = "
					+ valor_compra + ", valor_venda = " + valor_venda + ", categoria = " + categoria);
			 
		}

		// getters and setters
		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}


		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getEstoque() {
			return estoque;
		}

		public void setEstoque(int estoque) {
			this.estoque = estoque;
		}

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public int getValor_compra() {
			return valor_compra;
		}

		public void setValor_compra(int valor_compra) {
			this.valor_compra = valor_compra;
		}

		public int getValor_venda() {
			return valor_venda;
		}

		public void setValor_venda(int valor_venda) {
			this.valor_venda = valor_venda;
		}
		public boolean isComprado() {
			return comprado;
		}

		public void setComprado(boolean comprado) {
			this.comprado = comprado;
		}

		public boolean isVendido() {
			return vendido;
		}

		public void setVendido(boolean vendido) {
			this.vendido = vendido;
		}
}
