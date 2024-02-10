package br.com.alura.screenmatchSpring;

import br.com.alura.screenmatchSpring.model.DadosEpisodios;
import br.com.alura.screenmatchSpring.model.DadosSerie;
import br.com.alura.screenmatchSpring.service.ConsumoApi;
import br.com.alura.screenmatchSpring.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();

		var json = consumoApi.obeterDados("https://www.omdbapi.com/?t=breaking+bad&apikey=b2a43954");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.oberterDados(json, DadosSerie.class);
		System.out.println(dados);
		json = consumoApi.obeterDados("https://www.omdbapi.com/?t=breaking+bad&Season=1&episode=1&apikey=b2a43954");
		DadosEpisodios dadosEpisodios = conversor
				.oberterDados(json, DadosEpisodios.class);
		System.out.println(dadosEpisodios);

	}
}
