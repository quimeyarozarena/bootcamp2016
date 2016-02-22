package com.blog.service;

import com.blog.model.Entry;
import java.util.List;

public interface BlogService {

    public boolean postEntry(Entry entry);

    public boolean deleteExistingEntry(Entry entry);

    public List<Entry> showRecentEntries(int idpost);

}
