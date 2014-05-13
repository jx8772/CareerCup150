package chapter8.question9;

public abstract class Entry {
    protected Directory parent;
    protected long created;
    protected long lastUpdated;
    protected long lastAccessed;
    protected String name;

    public Entry(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        created = System.currentTimeMillis();
    }

    public boolean delete() {
        if(parent == null)
            return false;
        return parent.deleteEntry(this);
    }

    public abstract int size();

    public String getFullPath() {
        if(parent == null) {
            return name;
        } else {
            return parent.getFullPath() + "/" + name;
        }
    }

    public long getCreatedTime() {
        return created;
    }

    public long getLastUpdatedTime() {
        return lastUpdated;
    }

    public long getLastAccessedTime() {
        return lastAccessed;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
