package chapter8.question9;

public class File extends Entry {
    private String content;
    private int size;

    public File(String n, Directory parent, int size) {
        super(n,parent);
        this.size = size;
    }

    public int size() {
        return size;
    }

    public String getContents() {
        return content;
    }

    public void setContents(String content) {
        this.content = content;
    }
}
