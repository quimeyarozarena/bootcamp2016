package com.blog.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.blog.model.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class BlogControllerTest {

    private static BlogController blogControllerMocked;
    private static Entry entry1;
    private static Entry entry2;

    @BeforeClass
    public static void setUp() {

        blogControllerMocked = mock(BlogController.class);

        entry1 = new Entry(1, "quimey", "first entry", new Date());
        entry2 = new Entry(2, "quimey", "second entry", new Date());

        when(blogControllerMocked.postEntry(entry1)).thenReturn(entry1);
        when(blogControllerMocked.postEntry(entry2)).thenReturn(entry2);
        when(blogControllerMocked.deleteExistingEntry(entry2)).thenReturn(true);
        when(blogControllerMocked.showRecentEntries()).thenReturn(Arrays.asList(entry1, entry2));
    }

    @Test
    public void postEntryTest() {

        Entry entry = blogControllerMocked.postEntry(entry1);
        Entry entryTwo = blogControllerMocked.postEntry(entry2);

        assertEquals(entry.getId(), entry1.getId());
        assertEquals(entryTwo.getId(), entry2.getId());

    }

    @Test
    public void deleteExistingEntryTest() {

        assertTrue(blogControllerMocked.deleteExistingEntry(entry2));
    }

    @Test
    public void showRecentEntriesTest() {

        List<Entry> entries = blogControllerMocked.showRecentEntries();

        List<Entry> entriesMock = new ArrayList<Entry>();
        entriesMock.add(entry1);
        entriesMock.add(entry2);

        for (int x = 0; x <= 1; x++) {

            assertEquals(entries.get(x), entriesMock.get(x));

        }

    }

}
