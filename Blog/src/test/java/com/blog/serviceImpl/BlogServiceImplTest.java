package com.blog.serviceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.blog.db.HibernateConnection;
import com.blog.model.Entry;
import com.blog.model.Post;
import com.blog.model.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

public class BlogServiceImplTest {

    private static BlogServiceImpl blogController;
    private static Session sessionMocked;
    private static HibernateConnection hibernateConnectionMocked;
    private static Entry entry1;
    private static User user1;
    private static List<Entry> entries;
    private static Post post;

    @BeforeClass
    public static void setUp() {

        blogController = new BlogServiceImpl();
        sessionMocked = mock(Session.class);
        hibernateConnectionMocked = mock(HibernateConnection.class);

        post = new Post("Post1", "first Post", new Date());
        user1 = new User("Quimey", "Arozarena", "quimeyarozarena", "quimeyArozarena@gmail.com");

        entry1 = new Entry(user1, post, "first entry", new Date());

        entries = new ArrayList<Entry>();
        entries.add(entry1);
        user1.setEntries(entries);
        post.setEntriesPost(entries);

        when(hibernateConnectionMocked.doHibernateConnection()).thenReturn(sessionMocked);
    }

    @Test
    public void postEntryTest() {

        assertTrue(blogController.postEntry(entry1));

    }

    @Test
    public void deleteExistingEntryTest() {

        assertTrue(blogController.deleteExistingEntry(entry1));
    }

    @Test
    public void showRecentEntriesTest() {

        List<Entry> entries = blogController.showRecentEntries(11);

        assertEquals(entry1.getDescription(), entries.get(0).getDescription());
        assertEquals(entry1.getUser().getUsername(), entries.get(0).getUser().getUsername());

    }

}
