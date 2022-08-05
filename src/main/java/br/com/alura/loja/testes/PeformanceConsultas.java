package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class PeformanceConsultas {

	
	
	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		//Pedido pedido = em.find(Pedido.class,1l);
		//PedidoDao pedidoDao = new PedidoDao(em);
		//Pedido pedido = pedidoDao.buscarPedidoComCliente(1l);
		//Categoria cat =  em.find(Categoria.class, 1L);
		
		//System.out.println(pedido.getData());
		//System.out.println(pedido.getItens().size());
		//System.out.println(cat.getNome());
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto prod = produtoDao.buscarProdutoComCategoria(1L);
		List<Produto> produtos = produtoDao.buscarProdutosPorCategoria(1L);
		//Produto prod = produtoDao.buscarPorId(1L);
		em.close();
		
		produtos.forEach(p -> System.out.println(p.getNome() + "-" + p.getCategoria().getNome()));
		
		//System.out.println(prod.getNome());
		//System.out.println(prod.getCategoria().getNome());
	}
	
	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");
		
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("2000"), celulares);
		Produto celular2 = new Produto("Iphone 13", "128 GB Preto ", new BigDecimal("8000"), celulares);
		Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("8000"), videogames);
		Produto macbook = new Produto("Macbook", "Macboo pro retina", new BigDecimal("14000"), informatica);
		
		Cliente cliente = new Cliente("Rodrigo", "123456");
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(celular, 10));
		pedido.adicionarItem(new ItemPedido(videogame, 40));
		
		Pedido pedido2 = new Pedido(cliente);
		pedido2.adicionarItem(new ItemPedido(macbook, 2));
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		PedidoDao pedidoDao = new PedidoDao(em);
		
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		categoriaDao.cadastrar(videogames);
		categoriaDao.cadastrar(informatica);
		
		produtoDao.cadastrar(celular);
		produtoDao.cadastrar(celular2);
		produtoDao.cadastrar(videogame);
		produtoDao.cadastrar(macbook);
		
		clienteDao.cadastrar(cliente);
		
		pedidoDao.cadastrar(pedido);
		pedidoDao.cadastrar(pedido2);
		
		em.getTransaction().commit();
		em.close();
	}
}
