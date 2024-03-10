package com.moetez.test;

import com.moetez.dao.EmployeeDao;
import com.moetez.entities.Employee;
import com.moetez.entities.Employee;
public class EmployeeTest {
public static void main(String[] args) {
//créer un objet client
Employee c = new Employee();
c.setNom("Ghariani");
c.setPrenom("Moetez");
c.setSalaire(1400);
//ajouter l'objet client à la BD
EmployeeDao cltDao = new EmployeeDao();
cltDao.ajouter(c);
System.out.println("Appel de la méthode listerTous");
for (Employee cl : cltDao.listerTous())
System.out.println(cl.getCode()+" "+cl.getNom()+" "+cl.getPrenom()+" "+cl.getSalaire());
System.out.println("Appel de la méthode listerParNom");
for (Employee cl : cltDao.listerParNom("Ghar"))

System.out.println(cl.getCode()+" "+cl.getNom()+" "+cl.getPrenom());

//tester les autres méthodes de la classe ClientDao
System.out.println("Appel de la méthode Modifier *******");
System.out.println("Avant la modification *******");

for (Employee cl : cltDao.listerTous())
	 System.out.println(cl.getCode()+" "+cl.getNom()+" "+cl.getPrenom());

Employee employeeModifie = cltDao.consulter(new Employee(), 2); // Remplacez 1 par l'ID du client que vous souhaitez modifier
if (employeeModifie != null) {
   employeeModifie.setNom("Ahmed");
   employeeModifie.setPrenom("lala");
   employeeModifie.setSalaire(1000);
   cltDao.modifier(employeeModifie);
} else {
   System.out.println("Client non trouvé pour modifier!");
}
System.out.println("Apres la modification *******");

System.out.println("affichage de tout les clients");
 for (Employee cl : cltDao.listerTous())
	 System.out.println(cl.getCode()+" "+cl.getNom()+" "+cl.getPrenom());

 System.out.println("Appel de la méthode Supprimer *******");
 System.out.println("Avant la Supression *******");

 System.out.println("affichage de tout les clients");
 for (Employee cl : cltDao.listerTous())
	 System.out.println(cl.getCode()+" "+cl.getNom()+" "+cl.getPrenom());

Employee EmployeeASupprimer = cltDao.consulter(new Employee(), 2); 
if (EmployeeASupprimer != null) {
  cltDao.supprimer(EmployeeASupprimer);
} else {
   System.out.println("Client non trouvé pour supprmier!");
}
System.out.println("Apres la Supression *******");

System.out.println("affichage de tout les clients");
for (Employee cl : cltDao.listerTous())
	 System.out.println(cl.getCode()+" "+cl.getNom()+" "+cl.getPrenom());




}}