package com.sopra.formacion;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sopra.formacion.dao.Direccion;
import com.sopra.formacion.dao.Programador;

public class App {

	public static void main(String[] args) {

		Direccion dir1=new Direccion("Calle Amparo, 7", "Madrid", 28013);
		Direccion dir2=new Direccion("Calle Alcala, 494", "Madrid", 28022);
		
		Programador p1 = new Programador();
		p1.setNombre("David");
		p1.setApellidos("Cuesta");
		p1.setTecnologia("Java");
		p1.setNomina(9000);
		p1.getDireccion().add(dir1);
		p1.getDireccion().add(dir2);
		
		//Antes de este punto los objetos estan en el estado Transient
		Session session = null;
		Transaction tx = null;
		try {
			// 1. Recuperamos una sesion
			session = HibernateUtil.getSessionFactory().openSession();
			// 2. Inicamos transaccion
			tx = session.beginTransaction();
			// 3. Guradamos los objetos
			session.save(p1);
			
			// 4. Commiteamos la sesion y ejecutamos la tx contra la BBDD
			tx.commit();

			session.close();
			// En este punto los objetos pasan a estado Persistent

			session = HibernateUtil.getSessionFactory().openSession();
			Programador prog1 = (Programador) session.get(Programador.class, Long.parseLong("1"));
			session.close();
			
			session = HibernateUtil.getSessionFactory().openSession();
			Programador prog2 = (Programador) session.get(Programador.class, Long.parseLong("1"));
			session.close();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen())
			{
				session.close();
			}
		}

	}
}
