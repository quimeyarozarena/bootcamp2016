import com.blog.controller.BlogController;
import com.blog.model.Entry;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Entry e = new Entry(01, "quimeyarozarena", "hola", new Date());

        List<Entry> entriesList = new ArrayList<Entry>();
        entriesList.add(e);

        BlogController bc = new BlogController();
        bc.postEntry(e);
        bc.showRecentEntries();
    }

}
