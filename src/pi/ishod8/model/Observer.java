package pi.ishod8.model;

import java.util.List;

public interface Observer {
    void update();
    void setSubjects(List<Subject> sub);


}
