package br.app.barramento.controlesessao.interfaces;

import br.app.barramento.controlesessao.dto.SessaoEnvioDTO;
import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.IService;
import br.app.barramento.integracao.dto.IServiceIntegracao;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;

public interface IConexao extends IService {

	public ISessao abrirConexao(SessaoEnvioDTO sessaoEnvio) throws NegocioException, InfraEstruturaException;

	public RespostaDTO executar(TipoAcao acao, EnvioDTO envio, String nomeRepositorioArtefatoId, String nomeCatalogoArtefatoId, String ip,
			String porta, String login, String senha) throws NegocioException, InfraEstruturaException;

	public void fecharConexao(SessaoEnvioDTO sessaoEnvio) throws NegocioException, InfraEstruturaException;

}
