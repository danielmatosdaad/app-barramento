package br.app.smart.api.infra;

import java.util.EnumSet;

public enum TipoLocalizador {

	LOCAL("local"), REMOTO("remoto");

	private TipoLocalizador(String value) {
		this.value = value;
	}

	private String value;

	public static TipoLocalizador getLocalizador(String value) {

		if (value != null) {

			EnumSet<TipoLocalizador> values = EnumSet.allOf(TipoLocalizador.class);
			for (TipoLocalizador tipoLocalizador : values) {
				if (tipoLocalizador.getValue().equals(value)) {
					return tipoLocalizador;
				}
			}

		}
		return TipoLocalizador.REMOTO;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
