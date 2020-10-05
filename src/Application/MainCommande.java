package Application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

import Metier.CMClient;
import Metier.CMCommande;
import Metier.CMProduit;
import dao.DAOFactory;
import dao.DAOFactory.Persistance;

public class MainCommande {
public static void main() {
		
	Scanner scanner=new Scanner(System.in);
	System.out.println("Voulez vous travailler sur MySQL ou sur ListMemoire? (1)ListMemoire , (2) MySQL :");
	int option=scanner.nextInt();
	
	if(option==1) {	
		DAOFactory daos =DAOFactory.getDAOFactory(Persistance.ListMemoire);
		
		System.out.println("Commande");
		System.out.println("Choisir une m�thode");
		System.out.println("1.Ajouter 2:Modifier 3:Supprimer 4: Afficher");
		int p=scanner.nextInt();
		if(p==1) {
			System.out.println("Ajouter");
			System.out.println ("date_commande=(yyyy/MM/dd)");
			String date=scanner.next();
			 DateTimeFormatter formatage = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			    LocalDate dateDebut = LocalDate.parse(date, formatage);
			System.out.println ("id_client");
			int idcl=scanner.nextInt();
			
				CMCommande co;
				try {
					co = new CMCommande(dateDebut,daos.getClientDAO().getById(idcl), new HashMap<CMProduit, Integer>());
			daos.getCommandeDAO().create(co);
			MainLignedecommande.main(co);
			} catch (Exception e) {
				System.out.println("ce commande n'exist pas!");
				e.printStackTrace();
			}
			
				}
		else if (p==2) {
			System.out.println("Modifier");
			System.out.println("id_commande=");
			int id=scanner.nextInt();
			System.out.println ("date_commande=(yyyy/MM/dd)");
			String date=scanner.next();
			 DateTimeFormatter formatage = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			    LocalDate dateDebut = LocalDate.parse(date, formatage);
			System.out.println ("id_client");
			int idcl=scanner.nextInt();		
			try {
				CMClient idc=daos.getClientDAO().getById(idcl);
				daos.getCommandeDAO().update(new CMCommande(id,dateDebut,idc));
			} catch (Exception e) {				
				e.printStackTrace();
			}
			main();
		}
		else if (p==3) {
			System.out.println("Supprimer");
			System.out.println("id_commande=");
			int id=scanner.nextInt();			
			try {
				daos.getCommandeDAO().delete(new CMCommande(id));
			} catch (Exception e) {				
				e.printStackTrace();
			}
			main();
			
	}
		else if(p==4){
			try {
				for(int i=0;i<daos.getCommandeDAO().findAll().size();i++){
					System.out.println("id: "+daos.getCommandeDAO().findAll().get(i).getId()+" ||| date: "+daos.getCommandeDAO().findAll().get(i).getDateCommande().toString()+" ||| client: "+daos.getCommandeDAO().findAll().get(i).getIdClient2());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			main();
			}
		else {
			Main.main(null);
			}
	
	
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------		
	else if(option==2) {
		DAOFactory daos =DAOFactory.getDAOFactory(Persistance.MYSQL);
		
		System.out.println("Commande");
		System.out.println("Choisir une m�thode");
		System.out.println("1.Ajouter 2:Modifier 3:Supprimer 4: Afficher");
		int p=scanner.nextInt();
		if(p==1) {
			System.out.println("Ajouter");
			System.out.println ("date_commande=(yyyy/MM/dd)");
			String date=scanner.next();
			 DateTimeFormatter formatage = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			    LocalDate dateDebut = LocalDate.parse(date, formatage);
			System.out.println ("id_client");
			int idcl=scanner.nextInt();
			
				CMCommande co;
				try {
					co = new CMCommande(dateDebut,daos.getClientDAO().getById(idcl), new HashMap<CMProduit, Integer>());
			daos.getCommandeDAO().create(co);
			MainLignedecommande.main(co);
			} catch (Exception e) {
				System.out.println("ce commande n'exist pas!");
				e.printStackTrace();
			}
			
				}
		else if (p==2) {
			System.out.println("Modifier");
			System.out.println("id_commande=");
			int id=scanner.nextInt();
			System.out.println ("date_commande=(yyyy/MM/dd)");
			String date=scanner.next();
			 DateTimeFormatter formatage = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			    LocalDate dateDebut = LocalDate.parse(date, formatage);
			System.out.println ("id_client");
			int idcl=scanner.nextInt();		
			
			try {
				CMClient idc=daos.getClientDAO().getById(idcl);
				daos.getCommandeDAO().update(new CMCommande(id,dateDebut,idc));
			} catch (Exception e) {				
				e.printStackTrace();
			}
			main();
		}
		else if (p==3) {
			System.out.println("Supprimer");
			System.out.println("id_commande=");
			int id=scanner.nextInt();			
			try {
				daos.getCommandeDAO().delete(new CMCommande(id));
			} catch (Exception e) {				
				e.printStackTrace();
			}
			main();
			
	}
		else if(p==4){
			try {
				for(int i=0;i<daos.getCommandeDAO().findAll().size();i++){
					System.out.println("id: "+daos.getCommandeDAO().findAll().get(i).getId()+" ||| date: "+daos.getCommandeDAO().findAll().get(i).getDateCommande().toString()+" ||| client: "+daos.getCommandeDAO().findAll().get(i).getIdClient2());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			main();
			}
		else {
			Main.main(null);
			}
}}}
