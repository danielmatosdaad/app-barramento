package br.app.barramento.controlesessao.interfaces;

import br.app.barramento.controlesessao.dto.SessaoEnvioDTO;
import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.IServiceIntegracao;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;

public interface IConexao extends IServiceIntegracao<EnvioDTO, RespostaDTO> {

	public ISessao abrirConexao(SessaoEnvioDTO sessaoEnvio) throws NegocioException, InfraEstruturaException;

	public void fecharConexao(SessaoEnvioDTO sessaoEnvio) throws NegocioException, InfraEstruturaException;

}
