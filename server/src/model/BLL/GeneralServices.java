package model.BLL;

import java.util.List;

public abstract class GeneralServices {

    protected IDAO IDAO;

    protected GeneralServices(IDAO IDAO){
        this.IDAO = IDAO;
    }

    public abstract List read(int idShow);
    public abstract int create(Object o);
}
