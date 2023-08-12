package br.suanne.Restaurante.dto;

import br.suanne.Restaurante.model.Prato;
public record CardapioResponseDTO(Long id, String titulo, String Descricao, Double Preco) {
    public CardapioResponseDTO(Prato p) { this(p.getId(), p.getTitulo(), p.getDescricao(), p.getPreco());}

}
