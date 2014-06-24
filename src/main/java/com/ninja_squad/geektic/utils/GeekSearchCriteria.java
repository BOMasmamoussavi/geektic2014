package com.ninja_squad.geektic.utils;

	public class GeekSearchCriteria {
		private String nom;
		private String genre;
		private String nomCentre;
		
		public GeekSearchCriteria(String nom, String genre, String nomCentre)  {
			this.nom = nom;
			this.genre = genre;
			this.nomCentre = nomCentre;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getNomCentre() {
			return nomCentre;
		}

		public void setNomCentre(String nomCentre) {
			this.nomCentre = nomCentre;
		}

		
}
