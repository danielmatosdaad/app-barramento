package br.app.barramento.conexaosessao.api;

import br.app.barramento.controlesessao.interfaces.IConexao;
import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.smart.api.infra.AbstractDelegate;
import br.app.smart.api.infra.TipoLocalizador;

public class ConexaoSessaoDelegate extends AbstractDelegate<IConexao> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConexaoSessaoDelegate() {

	}

	public ConexaoSessaoDelegate(TipoAcao acao) {
		super(acao);
	}

	public ConexaoSessaoDelegate(LocalizadorServico<IConexao> localizaServico) {
		super(localizaServico);
	}

	public IConexao getServico() {
		return getLocalizadorServico().getServico();
	}

	public static ConexaoSessaoDelegate getInstancia(TipoAcao acao) {

		LocalizadorServico<IConexao> localizaServico = getLocalizador(acao);

		ConexaoSessaoDelegate delegate = new ConexaoSessaoDelegate(localizaServico);

		return delegate;
	}

	@Override
	public LocalizadorServico<IConexao> getLocalizadorServico(TipoAcao acao) {

		getLocalizador(acao);

		throw new RuntimeException("Acao nao reconhecida");
	}

	private static LocalizadorServico<IConexao> getLocalizador(TipoAcao acao) {
		if (TipoAcao.ABRIR_SESSAO_USUARIO.equals(acao)) {
			LocalizadorServico<IConexao> localizaServico = new LocalizarServicoConexaoSessao<IConexao>(
					TipoLocalizador.REMOTO);

			return localizaServico;
		}

		if (TipoAcao.ABRIR_SESSAO_APLICATIVO.equals(acao)) {
			LocalizadorServico<IConexao> localizaServico = new LocalizarServicoConexaoSessao<IConexao>(
					TipoLocalizador.REMOTO, LocalizarServicoConexaoSessao.REGISTRO_NOME_LOCAL_APLICATIVO,
					LocalizarServicoConexaoSessao.REGISTRO_NOME_REMOTO_APLICATIVO);
			return localizaServico;
		}
		throw new RuntimeException("Acao nao reconhecida");
	}

	@Override
	public void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta, IConexao conexeao)
			throws NegocioException, InfraEstruturaException {
		resposta.setMensagem(Mensagem.ERRO);
		resposta.getMensagem().setErro("Funcionalidade nao implementada:" + acao.getValue());
	}
}
