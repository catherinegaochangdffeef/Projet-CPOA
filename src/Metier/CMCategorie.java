package Metier;


public class CMCategorie {
	private int id;
	private String titre,visuel;
	
	public CMCategorie (String titre,String visuel)
	{
		this(-1,titre,visuel);
	}

	public CMCategorie(int idCategorie,String titre,String visuel)
	{
		this.setId(idCategorie);
		this.setTitre(titre);
		this.setVisuel(visuel);
	}
public CMCategorie(int id) {
	this.setId(id);
	}

//-------------------------------------------------	
	public int getId() 
	{
		return this.id;
	}
	public void setId(int idCategorie)
	{
		this.id=idCategorie;
	}
//------------------------------------------------	
	public String getTitre()
	{
		return this.titre;
	}
	public void setTitre(String titre)
	{   
		/*if(titre==null|| titre.trim().length()==0)
		{
			throw new IllegalArgumentException("Titre de la cat�gorie!");
		}*/
		this.titre=titre;
	}
//-------------------------------------------------
	public String getVisuel()
	{
		return this.visuel;
	}
	public void setVisuel(String visuel)
	{
		this.visuel=visuel;
	}
//--------------------------------------------------
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CMCategorie other = (CMCategorie) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
