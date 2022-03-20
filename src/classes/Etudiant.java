package classes;

public class Etudiant implements Menu{

	// attributs privates ...
	
	private String nom;
	private String prenom;
	private int age;
	private String date;
	
	//Constructor ... no parameters ... 
	
	public Etudiant() {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.date = date;
	}
	
	//Getters ... reading private values
	
	public String getnom() {
		return this.nom;
	}
	
	public String getprenom() {
		return this.prenom;
	}
	
	public int getage() {
		return this.age;
	}
	
	public String getdate() {
		return this.date;
	}
	
	//Setter .... setting values who're private
	
	public void setnom(String nom) {
		this.nom = nom;
	}
	
	public void setprenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setage(int age) {
		this.age = age;
	}
	
	public void setdate(String date) {
		this.date = date;
	}
	
	//Menu .... coming from my interface .... Please don't change my signature :-(
	
	public void Menu(){
		System.out.println("1- Save a new Student\n2- Delete a Student\n3- Show the students of a year\n4- Show all the students");
	}
	
							
							/*
							 * *************************************
							 * 									    *
							 * 			xD FINISHED					*
							 * 									    *
							 * 									    *
							 * *************************************/
}
