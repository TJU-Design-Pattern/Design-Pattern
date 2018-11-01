package crossfarm.menu;

public interface Iterator {
    public abstract boolean hasNext();
    public abstract Object next();
    public abstract void setIndex(int index);
}
