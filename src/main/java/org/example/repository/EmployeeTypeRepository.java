package org.example.repository;

import org.example.entity.EmployeeType;
import org.example.entity.RoomComfortEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeTypeRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(EmployeeType employeeType) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employeeType);
        transaction.commit();
        session.close();
    }

    public EmployeeType getById(int id) {
        Session session = sessionFactory.openSession();
        Query<EmployeeType> query = session.createQuery("FROM EmployeeType where id =:id", EmployeeType.class);
        query.setParameter("id", id);
        EmployeeType employeeType = query.getSingleResult();
        session.close();
        return employeeType;
    }

    public List<EmployeeType> getList() {
        Session session = sessionFactory.openSession();
        Query<EmployeeType> query = session.createQuery("FROM EmployeeType ", EmployeeType.class);
        List<EmployeeType> list = query.getResultList();
        session.close();
        return list;
    }
    public void delete(EmployeeType entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }
}
