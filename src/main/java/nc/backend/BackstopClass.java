package nc.backend;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class BackstopClass {
    @Getter
    @Setter
    public String id;
    @Getter
    @Setter
    public ArrayList<Scenario> scenarios;
}
