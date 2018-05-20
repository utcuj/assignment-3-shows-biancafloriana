package model.BLL;

import java.io.Serializable;

public class Request implements Serializable {

    private String type;
    private String serviceName;
    private Object data;

    public Request(String type, String serviceName, Object data) {
        this.type = type;
        this.serviceName = serviceName;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
