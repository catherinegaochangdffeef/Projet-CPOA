package Metier;
//import java.util.Scanner;
//import dao.DAOFactory;

public class CMProduit {
	private int idProduit;
	private String nom, description, visuel;
	private float tarif;
	private CMCategorie idCMCategorie;
	private int idCategorie;
	public CMProduit(String nom, String description, float tarif, String visuel, CMCategorie idCategorie ){
		this(-1,nom,description,tarif,visuel,idCategorie);
	}
	
	public CMProduit(int idProduit,String nom, String description, float tarif, String visuel, CMCategorie idCMCategorie) {
		this.setIdProduit(idProduit);
		this.setNom(nom);
		this.setDescription(description);
		this.setTarif(tarif);
		this.setVisuel(visuel);
		this.setIdCMCategorie(idCMCategorie);
		}
	
	public CMProduit(int idProduit,String nom, String description, float tarif, String visuel, int idCategorie) {
		this.setIdProduit(idProduit);
		this.setNom(nom);
		this.setDescription(description);
		this.setTarif(tarif);
		this.setVisuel(visuel);
		this.setIdCategorie(idCategorie);
		}
	public CMProduit(int idProduit) {
		this.setIdProduit(idProduit);
		}
	
	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	
	public CMCategorie getIdCMCategorie(){
		return idCMCategorie;
	}
	public void setIdCMCategorie(CMCategorie idCMCategorie) {
		this.idCMCategorie=idCMCategorie;
	}
	
	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVisuel() {
		return visuel;
	}

	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}

	public float getTarif() {
		return tarif;
	}

	public void setTarif(float tarif) {
		this.tarif = tarif;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CMProduit other = (CMProduit) obj;
		if (idProduit != other.idProduit)
			return false;
		return true;
	}

	
}
