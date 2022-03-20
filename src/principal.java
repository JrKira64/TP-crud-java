	
							/*
							 * *************************************
							 * 									    *
							 * 			:) MAIN PROGRAM				*
							 * 				  TP POO			    *
							 * 									    *
							 * *************************************/


//Class in other package (Name of package : Classes)

import classes.Etudiant;

//Librairies ....

import org.mariadb.jdbc.Driver;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class principal {

	public static void main(String[] args) throws Exception {
		
		// Connection through my external file (conf.properties)
		
		Properties props = new Properties();
		
		// Test and close with try{...}
		try (FileInputStream fis = new FileInputStream("conf.properties")){
			props.load(fis);
		}
	
		Class.forName( props.getProperty("jdbc.driver.class") );
		
		String url = props.getProperty("jdbc.url");
		String login = props.getProperty("jdbc.login");
		String password = props.getProperty("jdbc.password");
		
		DriverManager.getConnection(url,login,password);
		
		// OK .... Let's begin ... Connection etablished succefully ... xD
		
		Etudiant etud = new Etudiant();
		Scanner sc = new Scanner(System.in);
		Scanner ins = new Scanner(System.in);
		
				etud.Menu();
				
				int choice= sc.nextInt();
				switch(choice) {
					case 4 :
						try (Connection connection = DriverManager.getConnection(url,login,password)){

							String strSql = "SELECT * FROM Etudiant";
							
							try( Statement statement = connection.createStatement() ){
								
								 try(ResultSet resultset = statement.executeQuery(strSql)){
										while(resultset.next()) {
											
											int rsidUser = resultset.getInt("idEtud");
											String rsnom = resultset.getString("nom");
											String rsprenom = resultset.getString("prenom");
											int rsage = resultset.getInt("age");
											String rsdate = resultset.getString("Annee");

											System.out.printf("%d : %s %s %d %s\n",rsidUser,rsnom,rsprenom,rsage,rsdate);	
								 }

							}
						}
						
					}
					break;
					
					case 3 :
						try (Connection connection = DriverManager.getConnection(url,login,password)){
							
							Scanner d = new Scanner(System.in);
							
							
							System.out.println("Entrer la date");
							
							int date = d.nextInt();
							
							String strSql = "SELECT * FROM Etudiant WHERE Annee='" + date + "'";
							
							try( Statement statement = connection.createStatement() ){
								
								 try(ResultSet resultset = statement.executeQuery(strSql)){
										while(resultset.next()) {
											
											int rsidUser = resultset.getInt("idEtud");
											String rsnom = resultset.getString("nom");
											String rsprenom = resultset.getString("prenom");
											int rsage = resultset.getInt("age");
											String rsdate = resultset.getString("Annee");

											System.out.printf("%d : %s %s %d %s\n",rsidUser,rsnom,rsprenom,rsage,rsdate);	
								 }

							}
						}
						
					}
					break;
					
					
					case 2:
						System.out.println(" What\'s the id of the student? ");
						int idsearch = sc.nextInt();
						try (Connection connection = DriverManager.getConnection(url,login,password)){

							String strSql = "SELECT * FROM Etudiant";
							
							try( Statement statement = connection.createStatement() ){
								
								 try(ResultSet resultset = statement.executeQuery(strSql)){
										while(resultset.next()) {
											
											int rsidUser = resultset.getInt("idEtud");
											
												if( idsearch==rsidUser ) {
													String delSql = "DELETE FROM Etudiant WHERE idEtud="+idsearch;
													try( Statement statementdel = connection.createStatement() ){
														statementdel.executeUpdate(delSql);
														System.out.println("Already delete!");
														
													}
												}

										}

							}
						}
						
					}
					
					break;
						
					case 1 :
						
						System.out.println(" What's the name of the student ? ");
						String nameStudent = ins.nextLine();
						
						System.out.println(" What's the surname of the student ? ");
						String surnameStudent = ins.nextLine();
						
						System.out.println(" What's the school year ? ");
						String yearStudent = ins.nextLine();
						
						System.out.println(" How old's the student ? ");
						int ageStudent = ins.nextInt();
						
						
						try (Connection connection = DriverManager.getConnection(url,login,password)){
							
							try( Statement statement = connection.createStatement() ){
								String strSql = "SELECT * FROM Etudiant";
								 try(ResultSet resultset = statement.executeQuery(strSql)){
											
									 String insertSql="insert into Etudiant(nom,prenom,age,Annee) values('" + nameStudent + "','" + surnameStudent + "','" + ageStudent + "','" + yearStudent + "')";
			
										try( Statement statementinsert = connection.createStatement() ){
										statementinsert.executeUpdate(insertSql);
										System.out.println("Operation done !");
									}
												


							}
						}
						
					}
					break;
					
						
		}
		
}
}