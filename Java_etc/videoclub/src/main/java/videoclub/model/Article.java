package videoclub.model;

import javax.persistence.*;

@Entity
@Table(name = "article")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@SequenceGenerator(name = "seqArticle", sequenceName = "seq_article", initialValue = 1, allocationSize = 1)
public abstract class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqArticle")
	@Column(name = "id_article")
	private Integer id;
	@Version
	private int version;
	@Column(name = "nb_disques")
	private Integer nbDisques;
	@ManyToOne
	@JoinColumn(name = "id_adherent")
	private Adherent emprunteur;
	@ManyToOne
	@JoinColumn(name = "id_film")
	private Film film;

	public Article() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNbDisques() {
		return nbDisques;
	}

	public void setNbDisques(Integer nbDisques) {
		this.nbDisques = nbDisques;
	}

	public Adherent getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Adherent emprunteur) {
		this.emprunteur = emprunteur;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

}
