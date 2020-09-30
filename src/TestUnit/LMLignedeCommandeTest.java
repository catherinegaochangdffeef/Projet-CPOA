package TestUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ListMemoire.ListeMemoireLignedeCommandeDAO;
import Metier.CMLignedeCommande;
import dao.DAOFactory;
import dao.DAOFactory.Persistance;

public class LMLignedeCommandeTest {
    private CMLignedeCommande l;
    
    @Before
    public void Setup() throws Exception {
	l =new CMLignedeCommande(1,1,5,3.0);
	ListeMemoireLignedeCommandeDAO.getInstance().create(l);
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------       
	@Test
	public void testSelectExiste() throws Exception {
		
	int id=l.getId_produit();
	
	CMLignedeCommande cLm=ListeMemoireLignedeCommandeDAO.getInstance().getById(id);
	assertNotNull(cLm);
 }
//--------------------------------------------------------------------------------------------------------------------------------------------------    
	@Test
	public void testGetbyId() throws Exception {
		
	    try {
		DAOFactory.getDAOFactory(Persistance.ListMemoire).getLignedeCommandeDAO().getById(l.getId_commande());} catch(Exception e) {
		    fail("Erreur lors de la récupération");
		}
		
	}
}
