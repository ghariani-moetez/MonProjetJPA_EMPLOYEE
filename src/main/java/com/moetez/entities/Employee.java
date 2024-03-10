package com.moetez.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Employee implements Serializable{
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY)
//pour autoincrement
private int code;
private String nom;
private String prenom;
private double salaire;
public int getCode() {
return code;
}
public void setCode(int code) {
this.code = code;
}
public String getNom() {
return nom;
}
public void setNom(String nom) {
this.nom = nom;
}
public String getPrenom() {
return prenom;
}
public void setPrenom(String prenom) {
this.prenom = prenom;
}
public double getSalaire() {
	return salaire;
}
public void setSalaire(double salaire) {
	this.salaire = salaire;
}

}