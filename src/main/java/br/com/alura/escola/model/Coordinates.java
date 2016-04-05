package br.com.alura.escola.model;

import br.com.alura.escola.service.CoordinatesService;

public class Coordinates {
	private final String type = "Point";
	private final double[] coordinates;
	private final String endereco;


	public Coordinates(String endereco) {
		this.endereco = endereco;
		this.coordinates = CoordinatesService.getCoordinates(endereco);
	}

}
