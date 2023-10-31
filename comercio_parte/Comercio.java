package comercio_parte;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Comercio {

	// atributos
		private double saldo;
		private List<Produto> produtos = new ArrayList<>();
	// construtor
	 	public Comercio() {
			this.saldo = 1000;
			getGuardarInformacaoTxt();
		}
		
		public void listar_produtos() {
			if(produtos.isEmpty()) {
				System.out.println("A lista esta vazia, NENHUM produto cadastrado!!!");
			}
			else {
				System.out.println("\nSaldo: " + this.saldo + " R$");
				
				for(Produto produto:produtos) {		
					System.out.printf("%s (cod.: %d || estoque: %d || categoria: %s || custo de compra: %d || valor de venda: %d)\n"
							, produto.getNome(),produto.getCodigo(), produto.getEstoque(), produto.getCategoria(), produto.getValor_compra(), produto.getValor_venda() );
				}
			}
		}
		
		public void listar_produtos_categoria(int opcao_categoria) {
			
			String categoria  = "";
			if(opcao_categoria == 1) {
				categoria = "Eletronico";
			}
			else if(opcao_categoria == 2) {
				categoria  = "Periferico";
			}
			if(produtos.isEmpty()) {
				System.out.println("A lista esta vazia, NENHUM produto cadastrado!!!");
			}
			else {
				System.out.println("Saldo : " + this.saldo + " R$");
				for(Produto produto : produtos) {
					if(produto.getCategoria().equals(categoria)) {
					produto.listar(true);
					}
				}
			}
		}
		
		public void cadastrar_produto(String nome,int codigo, int categoria, int custo_compra, int custo_venda, int polegada, int memoria_ram, String marca, String cor) {
			
			boolean codigo_existente = false;
			
			for(Produto produto:produtos){
				if(produto.getCodigo() == codigo) {
					System.out.println("codigo ja existente!! ");
					codigo_existente = true;
				}
			}
			
			if(codigo_existente == false) {
				
			if(categoria == 1) {
				
				Eletronico e1 = new Eletronico(nome, codigo, polegada, memoria_ram, marca);
				e1.setValor_compra(custo_compra);
				e1.setValor_venda(custo_venda);
				e1.setCategoria("Eletronico");
				produtos.add(e1);
			}		
			else if(categoria == 2) {
				Periferico p1 = new Periferico(nome, codigo, cor);
				p1.setValor_compra(custo_compra);
				p1.setValor_venda(custo_venda);
				p1.setCategoria("Periferico");
				produtos.add(p1);
			}	
			}	
		}
		
		public void adicionar_estoque(int codigo, int estoque) {
			
			boolean codigo_existente = false;
			
			for(Produto produto:produtos) {
				if(codigo == produto.getCodigo()) {
					

					if(this.saldo >= produto.getValor_compra() * estoque) {				
						produto.setEstoque(produto.getEstoque() + estoque);
						System.out.println("Adicionado com SUCESSO!!!");					
						this.saldo -= produto.getValor_compra() * estoque;	
						produto.setComprado(true);
					}
					else {
						System.out.println("Saldo insuficiente");
					}
					
					codigo_existente = true;
				}			
			}				
			
			if(codigo_existente == false) {
				System.out.println("Este codigo NAO existe!!!");
			}
			}
		
		public void removerProduto(int codigo, String confirmar_remocao) {
			
	        boolean existe_codigo = false;
	        Produto p = null;
	         for(Produto produto : produtos) {
	             if(codigo == produto.getCodigo()) {
	                 existe_codigo = true;
	                 p = produto;
	             }
	         }
	         if(existe_codigo == true) {
	        	 
	        	 if(confirmar_remocao.equals("s")) {
	             produtos.remove(p);
	             System.out.println("Removido com SUCESSO!!!");
	             }
	        	 else if(confirmar_remocao.equals("n")) {
	        		 System.out.println("Remocao cancelada!!!");
	      
	        	 }
	        	 else {
	        		 System.out.println("Opcao invalida!");
	        	 }
	         }
	         else {
	        	 System.out.println("O codigo digitado nao existe!!!");
	         }
		}
		
		public void vender_estoque(int codigo, int estoque) {
			
			boolean codigo_existe = false;
			for(Produto produto:produtos) {
				if(codigo == produto.getCodigo()) {			
						
					if(produto.getEstoque() == 0) {
						System.out.println("Nenhum estoque deste produto");
					}
					else if(estoque > produto.getEstoque()) {
						System.out.println("Nao temos esta quantidade de estoque");
						System.out.println("Quantidade disponivel : " + produto.getEstoque());
					}				
					else{
						this.saldo += produto.getValor_venda() * estoque;
						produto.setEstoque(produto.getEstoque() - estoque);
						produto.setVendido(true);
						System.out.println("Produto Vendido com SUCESSO!!!");
					}
					codigo_existe = true;
				}
			}
			if(codigo_existe == false) {
				System.out.println("Este codigo NAO existe!!!");
			}
		}
		
		public void relatorio() {
			System.out.println("== RELATORIO ==");
			System.out.println("");
			System.out.println("lucro: " + ( this.saldo -1000));
			System.out.print("Produtos Vendido: ");
			for(Produto produto : produtos) {
				if(produto.isVendido() == true) {
				System.out.print(produto.getNome() + " || ");
				}
			}
			System.out.print("\nProdutos Comprados: ");
			for(Produto produto : produtos) {
				if(produto.isComprado() == true) {
				System.out.print(produto.getNome() + " || ");
				}
			}
		} 
		
		//guarda informacoes do txt
		public void guardar_informacao_txt( List<Produto> produto) {
			try {
				PrintWriter writer = new PrintWriter("arquivo.txt");
				for(Produto produtoo : produtos) {
					writer.write(produtoo.getNome() + "," + produtoo.getCodigo() + ","+ produtoo.getCategoria() + "," + produtoo.getValor_compra() + "," + produtoo.getValor_venda() + "\n");
				}
				writer.close();
			}
			catch(FileNotFoundException e) {
				System.out.println("Arquivo nao encontrado");
			}
		}
		
		// ler o arquivo.txt
		public ArrayList<Produto> getGuardarInformacaoTxt(){
			
			ArrayList<Produto> produtoss = new ArrayList<Produto>();
			File arquivo = new File("arquivo.txt");
			
			try {
				Scanner sc = new Scanner(arquivo);
				while( sc.hasNextLine()) {
					String[] produto = sc.nextLine().split(",");
					Produto produto_lista = new Produto(produto[0] ,Integer.parseInt(produto[1]));
					produto_lista.setCategoria(produto[2]);
					produto_lista.setValor_compra(Integer.parseInt(produto[3]));
					produto_lista.setValor_venda(Integer.parseInt(produto[4]));
					produtos.add(produto_lista);
					
				}
				for(Produto produtoo : produtoss) {
					produtos.add(produtoo);
				}
				sc.close();
			}
			catch (FileNotFoundException e) {
				System.out.println("Arquivo nao encontrado!!!");
			}
			return produtoss;
		}
		
		// metodos getters and setters
		public double getSaldo() {
			return saldo;
		}
		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}

		public List<Produto> getProdutos() {
			return produtos;
		}

		public void setProdutos(List<Produto> produtos) {
			this.produtos = produtos;
		}

}
