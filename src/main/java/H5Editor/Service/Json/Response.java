package H5Editor.Service.Json;

/**
 * Created by MrCJ on 2016/12/19.
 * 返回对象的格式
 */

@lombok.Data
public class Response {
    private static String success;
    private static String info;
    private static Object data;

    private Response(String success, String info, Object data) {
        this.success = success;
        this.info = info;
        this.data = data;
    }

    public static final Response response = new Response(success, info, data);

    // 静态工厂方法
    public static Response getResponse(String s, String i, Object d) {
        success = s;
        info = i;
        data = d;
        return response;
    }
}
