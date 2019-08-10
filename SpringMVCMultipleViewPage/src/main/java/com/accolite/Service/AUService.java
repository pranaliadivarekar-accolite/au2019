package com.accolite.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.accolite.Entity.Mst_Admin;
import com.accolite.Entity.Mst_User;
import com.accolite.Hibernate.HibernateUtil;

@Service
public class AUService {

	Session session = HibernateUtil.getSessionFactory().openSession();

	//Save user
	public void addUser(String firstName, String lastName, String userName, String password) {

		Mst_User user = new Mst_User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserName(userName);
		user.setUserPassword(password);
		user.setAttempts(0);
		user.setBlocked(false);
		user.setTypeOfUser('U');

		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.flush();
	}

	public String findUser(String userName, String password) {
		Criteria crit = session.createCriteria(Mst_User.class);
		crit.add(Restrictions.eq("userName", userName));
		session.beginTransaction();
		
		//Check if user is present or not
		if (crit.list() == null || crit.list().isEmpty())
			return "error_page";

		Mst_User user = (Mst_User) crit.list().get(0);
		System.out.println(user.getFirstName());


		String returnString;

		if (user.getAttempts() < 3) {
			if (user.getUserPassword().equals(password)) {
				user.setAttempts(0);
				returnString = "hello";
			} else {
				user.setAttempts(user.getAttempts() + 1);
				returnString = "Welcome";

			}
		} else if (user.getAttempts() == 12) {
			//block the user permanently
			user.setBlocked(true);
			returnString = "Welcome";
		} else if (user.getAttempts() % 3 == 0) {
			//Set exponential lock
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MINUTE, (int) (1 * Math.pow(2, user.getAttempts() / 3 - 10)));
			user.setWaitTime(cal);
			user.setAttempts(user.getAttempts() + 1);
			returnString = "Welcome";
		} else {
			if (user.getWaitTime().after(Calendar.getInstance()))
				returnString = "Welcome";
			else {
				if (user.getUserPassword().equals(password)) {
					user.setAttempts(0);
					returnString = "hello";
				} else {
					user.setAttempts(user.getAttempts() + 1);
					returnString = "Welcome";
				}
			}
		}

		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.flush();
		return returnString;
	}

	public String loginAdmin(String adminName, String password) {
		Criteria critAdmin = session.createCriteria(Mst_Admin.class);
		critAdmin.add(Restrictions.eq("adminName", adminName));
		critAdmin.add(Restrictions.eq("adminPassword", password));
		if (critAdmin.list() == null || critAdmin.list().isEmpty())
			return "error_page";

		List<Mst_User> userList = getUserList();
		return "AdminIndex";
	}

	public List<Mst_User> getUserList() {
		String hql = "from Mst_User";
		Query query = session.createQuery(hql);
		List<Mst_User> userList = query.list();

		return userList;
	}

	public String unlockUser(String userListString) {
		try {
			String[] userId = userListString.split(",");
			List<Integer> userIdList = new ArrayList<Integer>();
			for (int i = 0; i < userId.length; i++) {
				userIdList.add(Integer.parseInt(userId[i]));
			}
			
			//Get users
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			Criteria crit = session.createCriteria(Mst_User.class);
			crit.add(Restrictions.in("id", userIdList));

			//unlock users
			List<Mst_User> userList = crit.list();
			userList.stream().forEach(x -> {
				x.setBlocked(false);
				x.setAttempts(0);
			});


			for (Mst_User user : userList) {
				session.saveOrUpdate(user);
			}
			transaction.commit();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return "AdminIndex";
	}
}
