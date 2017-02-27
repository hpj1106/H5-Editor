package H5Editor.Service.Json;

/**
 * Created by MrCJ on 2016/12/19.
 * 返回对象的格式
 */

@lombok.Data
public class Response {
    private String success;
    private String info;
    private Object data;

    public Response(String success, String info, Object data) {
        this.success = success;
        this.info = info;
        this.data = data;
    }
}
