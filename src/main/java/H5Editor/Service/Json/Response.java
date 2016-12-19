package H5Editor.Service.Json;

/**
 * Created by MrCJ on 2016/12/19.
 */

@lombok.Data
public class Response {
    private String success;
    private String info;
    public Object data;
}
