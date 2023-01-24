package pi.ishod8.model;

import java.util.List;

public interface Subject {
    public void register(Observer obj);
    public void unregister(Observer obj);
    public void notifyObservers();
    List<Sale> getUpdate(Observer obj);
}
