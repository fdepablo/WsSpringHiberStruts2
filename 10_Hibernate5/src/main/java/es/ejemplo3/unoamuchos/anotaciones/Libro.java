package es.ejemplo3.unoamuchos.anotaciones;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="libros")
public class Libro {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String titulo;
    
    @ManyToOne
    private Autor autor;
       
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		//Ojo aqui, hay que parar esto porque si no dará un StackOverflowError
		//si pintamos el libro con el autor, ese autor tiene libros, que a su vez
		//ese autor tiene libros, y así hasta el infinito, por eso ponemos 
		//'autor.getNombre()' en vez de 'autor'
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor.getNombre()
				+ "]";
	}    
    
}
