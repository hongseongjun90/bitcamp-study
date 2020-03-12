package com.eomcs.reflect.ex06.b;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.printf("%s()가 호출됨!\n", method.getName());
    // 메서드 이름이 알고 싶으면 method.getname() 하면된다.
    return null;
  }


}