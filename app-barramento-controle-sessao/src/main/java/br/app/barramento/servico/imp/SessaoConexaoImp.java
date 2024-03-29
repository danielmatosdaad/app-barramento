package br.app.barramento.servico.imp;

import java.util.Date;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import br.app.barramento.controlesessao.dto.SessaoEnvioDTO;
import br.app.barramento.controlesessao.dto.SessaoUsuarioDTO;
import br.app.barramento.controlesessao.interfaces.IConexaoLocal;
import br.app.barramento.controlesessao.interfaces.IConexaoRemote;
import br.app.barramento.controlesessao.interfaces.ISessao;
import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.corporativo.integracao.api.IntegracaoDelegate;
import br.app.repositorio.api.RespositorioDelegate;
import br.app.repositorio.servico.integracao.IRepositorio;
import br.app.repositorio.servico.integracao.IServicoRepositorio;

@Stateful
@Remote(value = IConexaoRemote.class)
@Local(value = IConexaoLocal.class)
public class SessaoConexaoImp implements IConexaoRemote, IConexaoLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ISessao sessao;
	public void init() {
		try {
			Date dataHoraRequisicao = new Date();
			System.out.println(SessaoConexaoImp.class + " : " + dataHoraRequisicao.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ISessao abrirConexao(SessaoEnvioDTO sessaoEnvio) throws NegocioException, InfraEstruturaException {

		if (sessaoEnvio == null) {
			throw new NegocioException("informacoes invalida", new RuntimeException());
		}

		IServicoRepositorio servicoRepositorio = RespositorioDelegate.getIntancia().getServico();
		IRepositorio repositorioServico = servicoRepositorio.getRespositorio();
		this.sessao = new SessaoUsuarioDTO(repositorioServico, sessaoEnvio, Long.valueOf(100000));
		
		

		return this.sessao;
	}

	@Override
	public void fecharConexao(SessaoEnvioDTO sessaoEnvio) throws NegocioException, InfraEstruturaException {
		if (sessaoEnvio == null) {
			throw new NegocioException("informacoes invalida", new RuntimeException());
		}

	}

	@Override
	public RespostaDTO executar(TipoAcao acao, EnvioDTO envio, String nomeRepositorioArtefatoId,
			String nomeCatalogoArtefatoId, String ip, String porta, String login, String senha)
			throws NegocioException, InfraEstruturaException {

		return IntegracaoDelegate
				.getInstancia(nomeRepositorioArtefatoId, nomeCatalogoArtefatoId, ip, porta, login, senha)
				.executar(acao, envio);
	}

}
