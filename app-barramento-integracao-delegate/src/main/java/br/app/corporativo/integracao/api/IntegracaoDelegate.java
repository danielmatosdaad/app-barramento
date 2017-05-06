package br.app.corporativo.integracao.api;

import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.IService;
import br.app.barramento.integracao.dto.IServiceIntegracao;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.smart.api.infra.AbstractDelegate;
import br.app.smart.api.infra.TipoLocalizador;

public class IntegracaoDelegate extends AbstractDelegate<IServiceIntegracao> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IntegracaoDelegate() {
	}

	private IntegracaoDelegate(LocalizadorServico<IServiceIntegracao> localizaServico) {
		super(localizaServico);
	}

	public static IntegracaoDelegate getInstancia() {

		LocalizadorServico<IServiceIntegracao> localizaServico = new LocalizarServicoIntegracao<IServiceIntegracao>(
				TipoLocalizador.REMOTO);
		IntegracaoDelegate delegate = new IntegracaoDelegate(localizaServico);
		return delegate;
	}

	@Override
	public LocalizadorServico<IServiceIntegracao> getLocalizadorServico(TipoAcao acao) {

		LocalizadorServico<IServiceIntegracao> localizaServico = new LocalizarServicoIntegracao<IServiceIntegracao>(
				TipoLocalizador.REMOTO);

		return localizaServico;
	}

	@Override
	public void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta,IServiceIntegracao servico)
			throws NegocioException, InfraEstruturaException {
		RespostaDTO resp = servico.executar(acao, envio);
		
		resposta.setMensagem(resp.getMensagem());
		resposta.setId(resp.getId());
		resposta.setListaResultado(resp.getListaResultado());
		resposta.setResultado(resp.getResultado());
	}

}
