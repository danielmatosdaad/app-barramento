package br.app.barramento.controlesessao.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import br.app.barramento.controlesessao.interfaces.ISessao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.repositorio.servico.integracao.IRepositorio;

public class SessaoDTO implements ISessao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, String> cabecalho;
	private Map<String, String> dados;
	private IRepositorio repositorio;
	private SessaoEnvioDTO requisicaoOriginal;
	private Date datahoraAberturaSessao;
	private Long tempoMaximoSessaoMilSegundos;

	public SessaoDTO(IRepositorio repositorio, SessaoEnvioDTO requisicaoOriginal, Long tempoMaximoSessaoMilSegundos) {
		try {
			this.repositorio = repositorio;
			this.requisicaoOriginal = requisicaoOriginal;
			this.datahoraAberturaSessao = new Date();
			this.tempoMaximoSessaoMilSegundos = tempoMaximoSessaoMilSegundos;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public SessaoDTO() {

	}

	@Override
	public Map<String, String> getCabecalho() {
		return cabecalho;
	}

	@Override
	public Map<String, String> getDados() {
		return dados;
	}

	@Override
	public IRepositorio getRepositorioServico() throws InfraEstruturaException, NegocioException {

		return repositorio;
	}

	public SessaoEnvioDTO getRequisicaoOriginal() {
		return requisicaoOriginal;
	}

	@Override
	public boolean isSessaoValida() {
		return true;
	}

}
