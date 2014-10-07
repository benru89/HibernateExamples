package com.sopra.formacion;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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
		
		// Antes de este punto los objetos estan en el estado Transient

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

			// En este punto los objetos pasan a estado Persistent

			Query q = session.createQuery("From Programador");
			
			@SuppressWarnings("unchecked")
			List<Programador> resultList = q.list();
			
			System.out.println("NÃºmero de programadores:" + resultList.size());
			for (Programador next : resultList) {
				System.out.println("Siguiente empleado: " + next.getApellidos() + ", " + next.getNombre());
			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			// Y aqui los objetos se convierten en Detached
		}

	}
}
