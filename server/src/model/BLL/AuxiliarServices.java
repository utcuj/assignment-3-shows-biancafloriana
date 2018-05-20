package model.BLL;

import java.util.List;

public class AuxiliarServices extends GeneralServices  {


    public AuxiliarServices(IDAO IDAO) {
        super(IDAO);
    }

    @Override
    public List read(int idUser) {
        return IDAO.read(idUser);
    }

    @Override
    public int create(Object o) {
        return IDAO.create(o);
    }


    public void execute(Request r) {

        String type = r.getType();
        switch (type){

            case "read":
                List list =this.read((int)r.getData());
                new ServicesHandler().response(list);
                break;
            case "create":
                this.create(r.getData());
                break;
        }
    }
}
