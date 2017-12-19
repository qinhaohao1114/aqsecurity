package com.aq.common.beans;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

@Data
public class ResultBean<T> implements Serializable {

  private static final long serialVersionUID = 1L;



  public static final int NO_PERMISSION = 2;

  private String msg = "success";

  private int code = Integer.valueOf(HttpStatus.OK.toString());

  private T data;

  public ResultBean() {
    super();
  }

  public ResultBean(T data,HttpStatus status) {
    this.data = data;
    this.code = getCode(status);
  }

  public ResultBean(Throwable e) {
    this.msg = e.toString();
    this.code =getCode(HttpStatus.INTERNAL_SERVER_ERROR)  ;
  }

  private int getCode(HttpStatus status){

    return Integer.valueOf(status.toString());
  }

  public int getCode() {
    return code;
  }

  public void setCode(HttpStatus code) {
    this.code = getCode(code);
  }
}