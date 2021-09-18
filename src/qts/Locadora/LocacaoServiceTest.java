package qts.Locadora;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import qts.Locadora.exception.JogoSemEstoqueException;
import qts.Locadora.service.LocacaoService;
import qts.Locadora.util.DataUtil;


public class LocacaoServiceTest {
	@Test
		public void teste() throws Exception{
			
		Cliente cliente = new Cliente("Antonio");
		Jogo jogo = new Jogo("Harry Potter",15.00, 0);
			
		LocacaoService locacaoService = new LocacaoService();
		Locacao locacao;
			
		locacao = locacaoService.alugarJogo(cliente, jogo);
			
		Assert.assertTrue(locacao.getJogo().getNome().equals(jogo.getNome()));
		Assert.assertTrue(locacao.getCliente().getNome().equals(cliente.getNome()));
		Assert.assertTrue("Erro no valor do jogo", locacao.getValor()==jogo.getValor());
		Assert.assertTrue(new DataUtil().verificarDatasIguais(locacao.getRetirada(),new Date()));
	}
	@Test (expected = JogoSemEstoqueException.class)
	public void testSemEstoque() throws Exception{
		Cliente cliente = new Cliente("Antonio");
		Jogo jogo = new Jogo("Harry Potter", 15.00, 0);
		
		LocacaoService locacaoService = new LocacaoService();
		Locacao locacao;
		locacao = locacaoService.alugarJogo(cliente, jogo);
	}
}
