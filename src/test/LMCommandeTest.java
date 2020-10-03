package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import dao.DAOFactory;
import dao.DAOFactory.Persistance;
import ListMemoire.ListeMemoireCommandeDAO;
import ListMemoire.ListeMemoireProduitDAO;
import Metier.CMCommande;


public class LMCommandeTest {
private CMCommande c;
    
    @Before
    public void Setup() throws Exception {
	c =new CMCommande(1, "01-01-2020",1 );
	ListeMemoireCommandeDAO.getInstance().create(c);
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------       
	@Test
	public void testSelectExiste() throws Exception {
		
	int id=c.getId();
	
	CMCommande cLm=ListeMemoireCommandeDAO.getInstance().getById(id);
	assertNotNull(cLm);
 }
//--------------------------------------------------------------------------------------------------------------------------------------------------    
	@Test
	public void testGetbyId() throws Exception {
		
	    try {
		DAOFactory.getDAOFactory(Persistance.ListMemoire).getCommandeDAO().getById(c.getId());} catch(Exception e) {
		    fail("Erreur lors de la r�cup�ration");
		}
		
	}
//--------------------------------------------------------------------------------------------------------------------------------------------------    
	@Test
	public void testCreate() throws Exception {
			
		//assertEquals(c.getId(),1);
		assertEquals(c.getId(),1);
		assertEquals(c.getId_client(),1);
		assertEquals(c.getDate_commande(), 01-01-2020); //pas s�re que la date doit �tre appel� comme ca 

		}	
	//--------------------------------------------------------------------------------------------------------------------------------------------------    
	@Test
	public void testDelete() throws Exception {
		
		assertTrue((ListeMemoireCommandeDAO.getInstance().delete(c)), "");
		int id = c.getId();

		try {
		DAOFactory.getDAOFactory(Persistance.ListMemoire).getCommandeDAO().getById(id);
		fail("La commande existe toujours");
		}catch(Exception e){
		    ;
		}
		
		try {
		ListeMemoireCommandeDAO.getInstance().delete(c);
		fail("La commande existe toujours");
		}
		catch (Exception e){
		    ;
		}	
	}
	
}
