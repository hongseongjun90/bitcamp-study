package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.PhotoBoardDao;

public class PhotoBoardDeleteServlet implements Servlet {

  PhotoBoardDao photoBoardDao;

  public PhotoBoardDeleteServlet(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }


  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    out.println("번호? \n!{}!"); // 사용자로부터 한줄의
    int no = Integer.parseInt(in.nextLine());

    if (photoBoardDao.delete(no) > 0) { // 삭제했다면,
      out.println("게시글을 삭제했습니다.");

    } else {
      out.println("해당 번호의 게시글이 없습니다.");
    }
  }
}