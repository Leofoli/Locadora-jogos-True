package qts.Locadora.service;
import java.util.Date;

import qts.Locadora.Cliente;
import qts.Locadora.Jogo;

import qts.Locadora.Locacao;
import qts.Locadora.util.DataUtil;
public class LocacaoService {
	private final int diasPadrao = 5;
	public int testePublic;
	int testeDefault;
	
	public Locacao alugarJogo(Cliente cliente, Jogo jogo) throws Exception
	{
		if(jogo.getQtsestoque()==0) {
			throw new qts.Locadora.exception.JogoSemEstoqueException();
		}
		Locacao locacao = new Locacao();
		locacao.setCliente(cliente);
		locacao.setJogo(jogo);
		locacao.setValor(jogo.getValor());
		locacao.setRetirada(new Date());
		
		Date devolucao = new DataUtil().addDias(new Date(), diasPadrao);
		locacao.setDevolucao(devolucao);
		return locacao;
	}
}
