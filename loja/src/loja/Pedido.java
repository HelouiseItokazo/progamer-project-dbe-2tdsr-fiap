package loja;

import java.math.BigDecimal;

public class Pedido implements PedidoInterface {
	
	private BigDecimal valor;
	private int quantidadeDeItens;
	private Situacao situacao;
	public PedidoHandler handler;
	
	@Override
	public String getEndereco() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Rua 123, São Paulo - SP";
	}
	
	@Override
	public void abrirChamado() {
		this.situacao.abrirChamado(this);
	}

	public Pedido(BigDecimal valor) {
		super();
		this.valor = valor;
		this.quantidadeDeItens = 1;
		this.situacao = new Aberto();
		this.handler = new PedidoHandler();
	}

	public Pedido(BigDecimal valor, int quantidadeDeItens) {
		super();
		this.valor = valor;
		this.quantidadeDeItens = quantidadeDeItens;
		this.handler = new PedidoHandler();
		this.situacao = new Aberto();
	}

	@Override
	public int getQuantidadeDeItens() {
		return quantidadeDeItens;
	}

	@Override
	public BigDecimal getValor() {
		return valor;
	}
	
	@Override
	public void pagar() {
		this.situacao.pagar(this);
	}
	
	@Override
	public void entregar() {
		this.situacao.entregar(this);
	}
	
	@Override
	public void cancelar() {
		this.situacao.cancelar(this);
	}
	
	@Override
	public void reabrir() {
		this.situacao.reabrir(this);
	}

	@Override
	public void setSituacao(Situacao situacao) {
		handler.notifyAll(this);;
		this.situacao = situacao;
	}

	@Override
	public Situacao getSituacao() {
		return situacao;
	}
	
	

}
