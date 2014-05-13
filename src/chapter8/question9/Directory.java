package chapter8.question9;
import java.util.ArrayList;

public class Directory extends Entry {
    protected ArrayList<Entry> contents;

    public Directory(String name, Directory parent) {
        super(name, parent);
        contents = new ArrayList<Entry>();
    }

    public ArrayList<Entry> getContents() {
        return contents;
    }

    public int size() {
        int size = 0;
        for(Entry e : contents) {
            size += e.size();
        }
        return size;
    }

    public int numberofFiles() {
        int count = 0;
        for(Entry e : contents) {
            if(e instanceof Directory) {
                count++;
                Directory d = (Directory)e;
                count+= d.numberofFiles();
            } else if (e instanceof File) {
                count++;
            }
        }
        return count;
    }

    public boolean deleteEntry(Entry entry) {
        return contents.remove(entry);
    }

    public void addEntry(Entry entry) {
        contents.add(entry);
    }
}
