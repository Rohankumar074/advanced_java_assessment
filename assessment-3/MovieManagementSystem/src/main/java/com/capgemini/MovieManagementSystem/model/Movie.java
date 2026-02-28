package com.capgemini.MovieManagementSystem.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String director;
	@Column(nullable = false)
	private String genre;
	@Column(name="release_year",nullable = false)
	private Integer releaseYear;
	@Column(nullable = false)
	@Min(value = 0, message = "Rating must be at least 0")
    @Max(value = 10, message = "Rating cannot exceed 10")
	private Double rating;
	/**
	 * 
	 */
	public Movie() {
		super();
	}
	/**
	 * @param id
	 * @param title
	 * @param director
	 * @param genre
	 * @param releaseYear
	 * @param rating
	 */
	public Movie(Integer id, String title, String director, String genre, Integer releaseYear,
			@Min(value = 0, message = "Rating must be at least 0") @Max(value = 10, message = "Rating cannot exceed 10") Double rating) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.rating = rating;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}
	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * @return the releaseYear
	 */
	public Integer getReleaseYear() {
		return releaseYear;
	}
	/**
	 * @param releaseYear the releaseYear to set
	 */
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}
	/**
	 * @return the rating
	 */
	public Double getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(Double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", director=" + director + ", genre=" + genre + ", releaseYear="
				+ releaseYear + ", rating=" + rating + "]";
	}
	
	

}
