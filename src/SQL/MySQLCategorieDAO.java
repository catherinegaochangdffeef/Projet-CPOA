package SQL;
import java.sql.*;
import java.util.ArrayList;
import dao.CategorieDAO;
import Metier.CMCategorie;
public class MySQLCategorieDAO implements CategorieDAO {
	
public CMCategorie getById(int id_categorie) throws SQLException{
		
		CMCategorie categorie = null;
		
		Connection cnx = Connexion.creeConnexion();
		PreparedStatement req =cnx.prepareStatement("select * from Categorie where id_categorie = ?");
		req.setInt(1, id_categorie);
		
		
		ResultSet res = req.executeQuery();
		
		while (res.next()) {
			categorie= new CMCategorie(id_categorie, res.getString(2), res.getString(3));
			
		}
		cnx.close();
		req.close();
		res.close();
		
		return categorie;

	}

public CMCategorie getByTitre(String titre)throws SQLException{
	CMCategorie categorie= null;
	Connection cnx=Connexion.creeConnexion();
	PreparedStatement req= cnx.prepareStatement("select * from Categorie where titre = ?");
	req.setString(1, titre);
	
	ResultSet res = req.executeQuery();
	while (res.next()) {
		categorie= new CMCategorie(res.getInt(1),titre, res.getString(3));
		
	}
	cnx.close();
	req.close();
	res.close();
	
	return categorie;
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------------------------------------------		
	public boolean create(CMCategorie c) throws  SQLException{
		//
		Connection cnx = Connexion.creeConnexion();
			PreparedStatement req = cnx.prepareStatement("INSERT INTO Categorie (titre,visuel) values (?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
				req.setString(1, c.getTitre());
				req.setString(2, c.getVisuel());
				int nbLignes = req.executeUpdate();
				ResultSet res = req.getGeneratedKeys();
				int clef;
				if(res.next()) {
					clef = res.getInt(1);
					c.setId(clef);
						
				}
				
				cnx.close();
				req.close();
				res.close();
				
				return nbLignes==1;
		}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------		
	public boolean update(CMCategorie c) throws SQLException {
        int nbLignes =0;
        Connection cnx = Connexion.creeConnexion();
        PreparedStatement req = cnx.prepareStatement("update Categorie set titre=?, visuel = ? where id_categorie=?");
        req.setInt(3, c.getId());
        req.setString(1,c.getTitre());
        req.setString(2,c.getVisuel());
        nbLignes = req.executeUpdate();
        cnx.close();
        req.close();
    return nbLignes==1;
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------	
	public boolean delete(CMCategorie c) {
		try {
	    	Connection cnx = Connexion.creeConnexion();
		PreparedStatement req = cnx.prepareStatement("delete from Categorie where id_categorie=?");
		req.setInt(1,c.getId());
		
		
		
		int nbLignes = req.executeUpdate();
		

		cnx.close();
		req.close();
		
		return nbLignes==1;
	    	}catch(Exception e) {
	    	    return false;
	    	}
  
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------		
	private static MySQLCategorieDAO instance;
	private MySQLCategorieDAO() {}
	public static MySQLCategorieDAO getInstance() {
		if (instance==null) {
			instance = new MySQLCategorieDAO();
		}
		return instance;
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Override
	public ArrayList<CMCategorie> findAll() throws Exception {
	ArrayList<CMCategorie> cate = new ArrayList<CMCategorie>();
		
		
		Connection MaConnection = Connexion.creeConnexion();
		PreparedStatement req = MaConnection.prepareStatement("select * from Categorie ");
		
		
		
		ResultSet res = req.executeQuery();
		
		while (res.next()) {
			cate.add(new CMCategorie(res.getInt("id_categorie"), res.getString("titre"), res.getString("visuel")));
			
		}
		req.close();
		res.close();
		return cate;
	}
}