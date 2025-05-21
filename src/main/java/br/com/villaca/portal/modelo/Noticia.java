package br.com.villaca.portal.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="noticia")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Noticia {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="titulo")
    private String titulo;

    @Lob
    @Column(name="conteudo")
    private String conteudo;

    @Column(name="data_publicacao")
    private LocalDate dataPublicacao;

    @JoinColumn(name="categoria_id", referencedColumnName="id")
    @ManyToOne
    private Categoria categoria;

    @JoinColumn(name="autor_id", referencedColumnName="id")
    @ManyToOne
    private Autor autor;

}
