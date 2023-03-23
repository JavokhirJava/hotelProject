package org.example.repository;

import org.example.entity.RoomComfortEntity;
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
public class RoomRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(RoomEntity roomEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(roomEntity);
        transaction.commit();
        session.close();
    }

    public RoomEntity getById(int id) {
        Session session = sessionFactory.openSession();
        Query<RoomEntity> query = session.createQuery("FROM RoomEntity where id =:id", RoomEntity.class);
        query.setParameter("id", id);
        RoomEntity student = query.getSingleResult();
        session.close();
        return student;
    }

    public List<RoomEntity> getList() {
        Session session = sessionFactory.openSession();
        Query<RoomEntity> query = session.createQuery("FROM RoomEntity ", RoomEntity.class);
        List<RoomEntity> list = query.getResultList();
        session.close();
        return list;
    }
    public void delete(RoomEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void updateRoom(RoomEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }
}
