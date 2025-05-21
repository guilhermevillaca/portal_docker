package br.com.villaca.portal.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import br.com.villaca.portal.modelo.Autor;
import br.com.villaca.portal.modelo.Categoria;
import br.com.villaca.portal.modelo.Noticia;
import br.com.villaca.portal.modelo.Pessoa;
import br.com.villaca.portal.modelo.Usuario;
import br.com.villaca.portal.repository.AutorRepository;
import br.com.villaca.portal.repository.CategoriaRepository;
import br.com.villaca.portal.repository.NoticiaRepository;
import br.com.villaca.portal.repository.PessoaRepository;
import br.com.villaca.portal.repository.UsuarioRepository;


@Component
public class DataFixture implements CommandLineRunner{

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    NoticiaRepository noticiaRepository;

    @Override
    public void run(String... args) throws Exception {
        

        Categoria categoria = new Categoria();
        categoria.setDescricao("Esportes");
        categoriaRepository.save(categoria);

        Categoria categoria2 = new Categoria();
        categoria.setDescricao("Futebol");
        categoria.setCategoriaPai(categoria2);
        categoriaRepository.save(categoria2);

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Guilherme Villaca");
        pessoa.setEmail("guilherme.villaca@docente.pr.senac.br");
        pessoaRepository.save(pessoa);

        Autor autor = new Autor();
        autor.setBiografia("Professor do Senac");
        autor.setPessoa(pessoa);
        autorRepository.save(autor);

        Pessoa pessoa2 = new Pessoa();
        pessoa.setNome("Luís Guilherme");
        pessoa.setEmail("luisguilherme@gmail.com");
        pessoaRepository.save(pessoa2);

        Usuario usuario = new Usuario();
        usuario.setLogin("luis");
        usuario.setSenha("123456");
        usuario.setPessoa(pessoa2);
        usuarioRepository.save(usuario);

                
        Lorem lorem = LoremIpsum.getInstance();

        Noticia noticia1 = new Noticia();
        noticia1.setAutor(autor);
        noticia1.setTitulo(lorem.getTitle(3));
        noticia1.setConteudo(lorem.getParagraphs(3, 6));
        noticia1.setCategoria(categoria2);
        noticia1.setDataPublicacao(LocalDate.now());
        noticiaRepository.save(noticia1);

    }

}

