package org.example.repository;

import org.example.entity.ProfileEntity;
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
public class ConvenientRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(RoomComfortEntity roomComfortEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(roomComfortEntity);
        transaction.commit();
        session.close();
    }

    public RoomComfortEntity getById(int id) {
        Session session = sessionFactory.openSession();
        Query<RoomComfortEntity> query = session.createQuery("FROM RoomComfortEntity where id =:id", RoomComfortEntity.class);
        query.setParameter("id", id);
        RoomComfortEntity student = query.getSingleResult();
        session.close();
        return student;
    }

    public List<RoomComfortEntity> getList() {
        Session session = sessionFactory.openSession();
        Query<RoomComfortEntity> query = session.createQuery("FROM RoomComfortEntity ", RoomComfortEntity.class);
        List<RoomComfortEntity> list = query.getResultList();
        session.close();
        return list;
    }
    public void delete(RoomComfortEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }
}
