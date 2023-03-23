package org.example.repository;

import org.example.entity.GuestEntity;
import org.example.entity.PassportEntity;
import org.example.entity.RoomEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public void save(GuestEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }
    public List<GuestEntity> getList() {
        Session session = sessionFactory.openSession();
        Query<GuestEntity> query = session.createQuery("FROM GuestEntity ", GuestEntity.class);
        List<GuestEntity> list = query.getResultList();
        session.close();
        return list;
    }
}
