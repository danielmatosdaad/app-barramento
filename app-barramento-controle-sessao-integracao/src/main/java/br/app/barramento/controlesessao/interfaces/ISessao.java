package br.app.barramento.controlesessao.interfaces;

import java.util.Map;

import br.app.barramento.controlesessao.dto.SessaoEnvioDTO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.repositorio.servico.integracao.IRepositorio;

public interface ISessao {

	public Map<String, String> getCabecalho();

	public Map<String, String> getDados();

	public IRepositorio getRepositorioServico() throws InfraEstruturaException, NegocioException;

	public SessaoEnvioDTO getRequisicaoOriginal();

	public boolean isSessaoValida();
	
}
