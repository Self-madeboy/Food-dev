package com.life.common.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 */
public class Result<T> {

  private long code;

  private String message;

  private T result;


  public Result(long code, String message, T result) {
    this.code = code;
    this.message = message;
    this.result = result;
  }

  /**
   * 成功返回结果
   *
   * @param result
   * @param <T>
   * @return
   */
  public static <T> Result<T> success(T result) {
    return new Result<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), result);
  }

  /**
   * 成功返回空对象
   *
   * @return
   */
  public static <Map> Result<Map> success() {
    return new Result<Map>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),
        (Map) new HashMap<String, String>());
  }

  /**
   * 成功返回结果
   *
   * @param result  获取的数据
   * @param message 提示信息
   * @param <T>
   * @return
   */
  public static <T> Result<T> success(T result, String message) {
    return new Result<T>(ResultCode.SUCCESS.getCode(), message, result);
  }

  /**
   * 失败返回结果
   *
   * @param message 提示信息
   * @param result
   * @param <T>
   * @return
   */
  public static <T> Result<T> failed(String message, T result) {

    return new Result<T>(ResultCode.FAIL.getCode(), message, result);
  }

  /**
   * 失败返回结果
   *
   * @param message
   * @param <T>
   * @return
   */
  public static <T> Result<Map> failed(String message) {
    return new Result<>(ResultCode.FAIL.getCode(), message, new HashMap<String, String>());
  }

  /**
   * 失败返回结果
   *
   * @param <T>
   * @return
   */
  public static <T> Result<Map> failed(IErrorCode errorCode) {
    return new Result<>(errorCode.getCode(), errorCode.getMessage(), new HashMap<String, String>());
  }

  /**
   * 失败返回结果
   *
   * @param message
   * @param <T>
   * @return
   */
  public static <T> Result<T> failed(long code, String message, T result) {
    return new Result<T>(code, message, result);
  }


  public long getCode() {
    return code;
  }

  public void setCode(long code) {
    this.code = code;
  }

  public String getMsg() {
    return message;
  }

  public void setMsg(String msg) {
    this.message = msg;
  }

  public T getResult() {
    return result;
  }

  public void setResult(T result) {
    this.result = result;
  }
}
