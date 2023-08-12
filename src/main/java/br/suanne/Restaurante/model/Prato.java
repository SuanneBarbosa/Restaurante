package br.suanne.Restaurante.model;

import br.suanne.Restaurante.dto.CardapioRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prato {
    private static Long idBase = 0L;
    public String titulo;
    public String descricao;
    public Double preco;
    public Long id;


    public Prato(CardapioRequestDTO data){
        this.titulo = data.titulo();
        this.descricao = data.descricao();
        this.preco = data.preco();
        this.id = idBase++;
    }

}
