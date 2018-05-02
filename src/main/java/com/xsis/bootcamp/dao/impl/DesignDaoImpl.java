package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.DesignDao;
import com.xsis.bootcamp.model.Design;
import com.xsis.bootcamp.util.SessionHibernate;

@Repository
public class DesignDaoImpl extends SessionHibernate implements DesignDao {
	Log log = LogFactory.getLog(super.getClass());
	
	@Override
	public Design getByCode(String dCode) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from t_promotion where code = :dCode";
		Query query = session.createQuery(hql);
		query.setString("dCode", dCode);
		if (query.list().size() > 0) {
			return (Design) query.list().get(0);
		} else {
			return null;
		}
	}

	@Override
	public void insert(Design design) throws Exception {
		this.log.debug(new StringBuilder().append("Inserting").append(design).toString());
		getSession().save(design);
	}

	@Override
	public void update(Design design) throws Exception {
		this.log.debug(new StringBuilder().append("Updating").append(design).toString());
		getSession().merge(design);
	}

	@Override
	public void delete(Design design) throws Exception {
		this.log.debug(new StringBuilder().append("Deleting").append(design).toString());
		getSession().delete(design);
	}

	@SuppressWarnings("unchecked")
	public Collection<Design> listAll() throws Exception {
		String query = new StringBuilder().append("from Design").toString();
		return getSession().createQuery(query).list();
	}

<<<<<<< HEAD
	@Override
	public Design getByCode(String dCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
=======
}
>>>>>>> e3fd0fc297b7f8e754e4e8310b71161e68bf5fd1
