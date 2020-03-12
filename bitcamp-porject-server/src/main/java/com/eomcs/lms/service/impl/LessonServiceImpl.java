package com.eomcs.lms.service.impl;

import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

public class LessonServiceImpl implements LessonService {

  LessonDao lessonDao;

  public LessonServiceImpl(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public Lesson get(int no) throws Exception {

    // 이 메서드는 별도의 작업을 하지 않는다.
    // 그냥 DAO의 메서드를 호출하여 리턴 받은 값을 그대로 다시 리턴할 뿐이다.
    // 이렇게 아무런 일도 안하는 메서드를 만든 이유는?
    // => Servlet 에서 Service 객체를 사용하도록 구조를 변경하였다.
    // => 프로그래밍의 일관성을 위해 해당 구조에 맞춘것이다.
    // => Servlet에서 어떤 경우에는 DAO를 직접 사용하고,
    // 또 어떤 경우에는 Service를 사용한다면
    // 일관성이 없어 유지보수가 어려워진다.
    // => 때로는 아무런 일도 하지 않는 서비스 클래스를 정의하더라도
    // 프로그래밍의 일관성 때문임을 기억하라.
    //
    return lessonDao.findByNo(no);
  }
}