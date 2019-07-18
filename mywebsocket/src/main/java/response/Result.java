package response;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 统一接口返回结果封装类
 *
 * @since 2019-06-15
 */
@Slf4j
@Data
public class Result {

    private static final int SUCCESS = 0;
    private static final int FAIL = 1;

    private int code; // 返回是否成功, 0-成功 1或其他值失败; 后面支持自定义返回码
    private boolean success;
    private String message; // 错误时返回的消息
    private Object data;    // 返回的数据

    /**
     * 成功
     *
     * @param data
     */
    private Result(Object data) {
        this.code = SUCCESS;
        this.success = true;
        this.message = "成功!";
        this.data = data;
    }


    /**
     * 成功
     */
    private Result() {
        this.code = SUCCESS;
        this.success = true;
        this.message = "成功!";
    }

    /**
     * 失败, 返回自定义code
     *
     * @param code
     * @param message
     */
    private Result(int code, String message) {
        this.success = false;
        this.code = code;
        this.message = message;
    }

    private Result(String message, Object data) {
        this.code = FAIL;
        this.success = false;
        this.message = message;
        this.data = data;
    }

    /**
     * 失败, 返回自定义code和data
     *
     * @param code
     * @param message
     * @param data
     */
    private Result(int code, String message, Object data) {
        this.success = false;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success(Object data) {
        return new Result(data);
    }

    public static Result success() {
        return new Result();
    }

    public static Result fail(String message) {
        return new Result(FAIL, message);
    }

    public static Result fail(int code, String message) {
        return new Result(code, message);
    }

    public static Result fail(String message, Object data) {
        return new Result(message, data);
    }

    public static Result fail(int code, String message, Object data) {
        return new Result(code, message, data);
    }


}
