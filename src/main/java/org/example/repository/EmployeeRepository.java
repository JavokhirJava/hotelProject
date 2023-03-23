package org.example.repository;

import org.example.entity.EmployeeEntity;
import org.example.entity.RoomEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(EmployeeEntity employeeEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employeeEntity);
        transaction.commit();
        session.close();
    }

    public EmployeeEntity getById(int id) {
        Session session = sessionFactory.openSession();
        Query<EmployeeEntity> query = session.createQuery("FROM EmployeeEntity where id =:id", EmployeeEntity.class);
        query.setParameter("id", id);
        EmployeeEntity student = query.getSingleResult();
        session.close();
        return student;
    }

    public List<EmployeeEntity> getList() {
        Session session = sessionFactory.openSession();
        Query<EmployeeEntity> query = session.createQuery("FROM EmployeeEntity ", EmployeeEntity.class);
        List<EmployeeEntity> list = query.getResultList();
        session.close();
        return list;
    }
    public void delete(EmployeeEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void updateRoom(EmployeeEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }
}
