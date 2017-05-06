package br.app.barramento.controlesessao.api;

import br.app.barramento.controlesessao.interfaces.IControleSessao;
import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

@SuppressWarnings("hiding")
public class LocalizarServicoControleSessao<IControleSessao> extends AbstractLocalizadorServico<IControleSessao> {

	private static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	public static final String REGISTRO_NOME_LOCAL_USUARIO = "remoto.controle.sessao.usuario";
	public static final String REGISTRO_NOME_REMOTO_USUARIO = "local.controle.sessao.usuario";
	
	public LocalizarServicoControleSessao(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao, REGISTRO_NOME_REMOTO_USUARIO, REGISTRO_NOME_LOCAL_USUARIO, LOCALIZACAO_SERVICO);
	}
	
	public LocalizarServicoControleSessao(TipoLocalizador tipoLocalizacao, String registroNomeLocal,
			String registroNomeRemoto) {
		super(tipoLocalizacao, registroNomeLocal, registroNomeRemoto,
				LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoControleSessao() {
		super(TipoLocalizador.LOCAL, REGISTRO_NOME_LOCAL_USUARIO, REGISTRO_NOME_REMOTO_USUARIO, LOCALIZACAO_SERVICO);
	}

}
