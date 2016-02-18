package com.blog.controller;

import com.blog.model.Entry;
import java.util.ArrayList;
import java.util.List;

public class BlogController {

    private List<Entry> entriesList;

    public BlogController() {
        entriesList = new ArrayList<Entry>();
    }

    public Entry postEntry(Entry entry) {

        entriesList.add(entry);

        return entry;
    }

    public boolean deleteExistingEntry(Entry entry) {

        return entriesList.remove(entry);

    }

    public List<Entry> showRecentEntries() {

        List<Entry> entries = new ArrayList<Entry>();
        if (entriesList.size() >= 10) {
            entries = entriesList.subList(0, 9);
        } else {
            for (int x = 0; x < entriesList.size(); x++) {
                entries.add(entriesList.get(x));
            }
        }

        return entries;

    }

}
