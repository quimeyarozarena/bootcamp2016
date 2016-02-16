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

        boolean flag = false;
        if (entriesList.contains(entry)) {
            entriesList.remove(entry);
            flag = true;

        }

        return flag;

    }

    public List<Entry> showRecentEntries() {

        List<Entry> entries = new ArrayList<Entry>();

        for (int x = 0; x <= 10; x++) {
            entries.add(entriesList.get(x));
        }

        return entries;

    }

}
