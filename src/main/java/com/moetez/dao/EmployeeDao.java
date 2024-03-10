package com.moetez.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.moetez.entities.Employee;
import com.moetez.util.JPAutil;
//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)
public class EmployeeDao {
private EntityManager entityManager=JPAutil.getEntityManager("MonProjetJPA_EMPLOYEE");
//méthode ajouter d'une entité à la bd
public void ajouter(Employee e)
{
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.persist(e);


tx.commit();
}
//méthode modifier d'une entité à partir de la bd
public void modifier(Employee e)
{
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.merge(e);
tx.commit();
}
//méthode Supprimer d'une entité à partir de la bd
public void supprimer(Employee e)
{
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
e=entityManager.merge(e); // important
entityManager.remove(e);
tx.commit();
}
//méthode Consulter d'une entité à partir de la bd
public Employee consulter(Employee e,Object id)
{
return entityManager.find(e.getClass(), id);
}
//méthode pour lister tous les objets à partir de la bd
public List<Employee> listerTous() {
List<Employee> employees =
entityManager.createQuery(
"select e from Employee e").getResultList();

return employees;
}
//méthode pour lister tous les client dont le nom contient un
//texte donné en paramètre (pnom)
public List<Employee> listerParNom(String nom) {List<Employee> employees
=entityManager.createQuery( "select e from Employee e where e.nom like :pnom")
.setParameter("pnom","%"+nom+"%").getResultList();

return employees; }}