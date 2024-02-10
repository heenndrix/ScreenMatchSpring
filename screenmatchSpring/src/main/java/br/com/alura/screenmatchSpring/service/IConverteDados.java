package br.com.alura.screenmatchSpring.service;

public interface IConverteDados {

    <T> T oberterDados(String json, Class<T> classe);

}
