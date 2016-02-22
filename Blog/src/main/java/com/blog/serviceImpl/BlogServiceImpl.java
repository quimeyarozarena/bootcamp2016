package com.blog.serviceImpl;

import com.blog.db.HibernateConnection;
import com.blog.model.Entry;
import com.blog.model.User;
import com.blog.service.BlogService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;

public class BlogServiceImpl implements BlogService {

    private HibernateConnection hibernateConnection;
    private Session session;

    public BlogServiceImpl() {
        hibernateConnection = new HibernateConnection();
    }

    public Session makeConnection() {
        return hibernateConnection.doHibernateConnection();
    }

    public boolean postEntry(Entry entry) {

        boolean result = false;
        try {
            session = makeConnection();
            session.beginTransaction();
            session.save(entry);
            session.getTransaction().commit();
            session.close();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean deleteExistingEntry(Entry entry) {

        session = makeConnection();
        session.beginTransaction();
        session.delete(entry);
        session.getTransaction().commit();
        session.close();
        return true;

    }

    public List<Entry> showRecentEntries(int idpost) {
        List<Entry> entriesList = new ArrayList<Entry>();

        try {
            session = makeConnection();
            List<Entry> entries1 = (List<Entry>) session
                    .createQuery("select e.user, e.description From Entry e where e.post.postid = '" + idpost + "' ")
                    .list();
            session.close();
            List<Entry> entries = new ArrayList<Entry>();

            Iterator itr = entries1.iterator();
            while (itr.hasNext()) {
                Object[] obj = (Object[]) itr.next();
                Entry entry = new Entry((User) obj[0], String.valueOf(obj[1]));
                entries.add(entry);
            }

            if (entries.size() >= 10) {
                entriesList = entries.subList(0, 9);
            } else {
                for (int x = 0; x < entries.size(); x++) {
                    entriesList.add(entries.get(x));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entriesList;

    }

}
