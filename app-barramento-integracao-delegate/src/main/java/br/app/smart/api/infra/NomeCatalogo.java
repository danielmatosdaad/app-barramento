package br.app.smart.api.infra;

public enum NomeCatalogo {

	APP_PMT("APP_PMT");

	private String value;

	private NomeCatalogo(String value) {

		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
