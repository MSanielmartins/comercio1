package comercio_parte;

public class Eletronico extends Produto{

	//atributos
		private int polegada;
		private int memoria_ram;
		private String marca;
		
		//contrutor
		public Eletronico(String nome, int codigo, int polegada, int memoria_ram, String marca) {
			super(nome, codigo);
			
			this.polegada = polegada;
			this.memoria_ram = memoria_ram;
			this.marca = marca;
		}
		
		@Override
		public void listar(boolean produto) {
			System.out.printf("ELETRONICO - %s (cod.: %d || estoque: %d || polegada: %d || memoria_ram: %d || marca: %s || custo de compra: %d || valor de venda: %d)\n"
					, super.getNome(), super.getCodigo(), super.getEstoque(),this.polegada, this.memoria_ram, this.marca ,super.getValor_compra(), super.getValor_venda());
		}

		public int getPolegada() {
			return polegada;
		}

		public void setPolegada(int polegada) {
			this.polegada = polegada;
		}

		public int getMemoria_ram() {
			return memoria_ram;
		}

		public void setMemoria_ram(int memoria_ram) {
			this.memoria_ram = memoria_ram;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}
}
