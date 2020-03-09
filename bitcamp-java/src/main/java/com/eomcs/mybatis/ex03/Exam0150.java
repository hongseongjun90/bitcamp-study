// // dynamic sql 다루기 - <where> 사용 전: 조건이 빠졌을 때 문제 발생 해결책
package com.eomcs.mybatis.ex03;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0150 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex03/mybatis-config.xml");
    SqlSessionFactory factory = //
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    // 실행 예:
    // => 복합 검색하기, 여러개의 조건을 합쳐서 검색하기
    // 제목+내용 검색하는 방법

    // SQL Mapper 에 여러개의 파라미터 값을 넘길 때 주로 Map을 사용한다.s
    HashMap<String, Object> params = new HashMap<>();

    Scanner keyScan = new Scanner(System.in);

    System.out.print("번호? ");
    String value = keyScan.nextLine();
    if (value.length() > 0) {
      params.put("no", value);
    }

    System.out.print("제목? ");
    value = keyScan.nextLine();
    if (value.length() > 0) {
      params.put("title", value);
    }

    System.out.print("내용? ");
    value = keyScan.nextLine();
    if (value.length() > 0) {
      params.put("content", value);
    }

    keyScan.close();

    List<Board> list = sqlSession.selectList("BoardMapper.select6", params);

    // select5의 문제점
    // => no 값이 없을 경우 잘못된 SQL문을 생성한다.
    // => 생성된 SQL 문 예:
    // ### SQL: select board_id, title, contents, created_date, view_count
    // from x_board
    // where

    // 1=0 <== or 앞에 실행에 영향을 끼치지 않는 최소한의 조건문 삽입 ★

    // or title like concat('%', ?, '%') <= or 앞에 조건문이 없다. 즉 no값이 빠졌다.
    // or contents like concat('%', ?, '%')

    for (Board board : list) {
      System.out.printf("%d, %s, %s, %s, %d\n", //
          board.getNo(), //
          board.getTitle(), //
          board.getContent(), //
          board.getRegisteredDate(), //
          board.getViewCount());
    }

    sqlSession.close();
  }

}

