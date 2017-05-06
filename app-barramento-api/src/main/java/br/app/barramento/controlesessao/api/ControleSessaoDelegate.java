package br.app.barramento.controlesessao.api;

import br.app.barramento.controlesessao.interfaces.IControleSessao;
import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.smart.api.infra.AbstractDelegate;
import br.app.smart.api.infra.TipoLocalizador;

public class ControleSessaoDelegate extends AbstractDelegate<IControleSessao> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControleSessaoDelegate() {
	}
	public ControleSessaoDelegate(LocalizadorServico<IControleSessao> localizaServico) {
		super(localizaServico);
	}
	

	public static ControleSessaoDelegate getInstancia() {

		LocalizadorServico<IControleSessao> localizaServico = new LocalizarServicoControleSessao<IControleSessao>(
				TipoLocalizador.REMOTO);
		ControleSessaoDelegate delegate = new ControleSessaoDelegate(localizaServico);
		
		return delegate;
	}
	
	@Override
	public LocalizadorServico<IControleSessao> getLocalizadorServico(TipoAcao acao) {

		if (TipoAcao.EXECUTAR.equals(acao)) {
			LocalizadorServico<IControleSessao> localizaServico = new LocalizarServicoControleSessao<IControleSessao>(
					TipoLocalizador.REMOTO);

			return localizaServico;
		}
		throw new RuntimeException("Acao nao reconhecida");
	}

	@Override
	public void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta,IControleSessao servico)
			throws NegocioException, InfraEstruturaException {
		resposta.setMensagem(Mensagem.ERRO);
		resposta.getMensagem().setErro("Funcionalidade nao implementada:" + acao.getValue());
	}

}
