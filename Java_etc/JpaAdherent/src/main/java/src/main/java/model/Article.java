package src.main.java.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="article")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING, length=2)
@SequenceGenerator(name="seqArticle", sequenceName="seq_article", initialValue=50, allocationSize=1)

public abstract class Article {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqArticle")
	@Column(name="id_article")
	private Integer numeroArticle;
	@Column(name="nb_disques", nullable=false)
	private Integer nbDisques;
	@ManyToOne
	@JoinColumn(name="article_id")
	private Adherent emprunteur;
	@ManyToOne
	@JoinColumn(name="id_movie")
	private Film film;
	@Version
	private int version;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emprunteur == null) ? 0 : emprunteur.hashCode());
		result = prime * result + ((film == null) ? 0 : film.hashCode());
		result = prime * result + ((nbDisques == null) ? 0 : nbDisques.hashCode());
		result = prime * result + ((numeroArticle == null) ? 0 : numeroArticle.hashCode());
		result = prime * result + version;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (emprunteur == null) {
			if (other.emprunteur != null)
				return false;
		} else if (!emprunteur.equals(other.emprunteur))
			return false;
		if (film == null) {
			if (other.film != null)
				return false;
		} else if (!film.equals(other.film))
			return false;
		if (nbDisques == null) {
			if (other.nbDisques != null)
				return false;
		} else if (!nbDisques.equals(other.nbDisques))
			return false;
		if (numeroArticle == null) {
			if (other.numeroArticle != null)
				return false;
		} else if (!numeroArticle.equals(other.numeroArticle))
			return false;
		if (version != other.version)
			return false;
		return true;
	}

	public Article() {
	
	}

	/**
	 * @param numeroArticle
	 * @param nbDisques
	 */
	public Article(Integer numeroArticle, Integer nbDisques) {
		super();
		this.numeroArticle = numeroArticle;
		this.nbDisques = nbDisques;
	}

	
	/**
	 * @param nbDisques
	 * @param emprunteur
	 * @param film
	 */
	public Article(Integer nbDisques, Adherent emprunteur, Film film) {
		super();
		this.nbDisques = nbDisques;
		this.emprunteur = emprunteur;
		this.film = film;
	}

	public Article(Integer nbDisques) {
		super();
		this.nbDisques = nbDisques;
	}

	public Integer getNumeroArticle() {
		return numeroArticle;
	}

	public void setNumeroArticle(Integer numeroArticle) {
		this.numeroArticle = numeroArticle;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
	
}
