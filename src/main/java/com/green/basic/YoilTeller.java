package com.green.basic;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //프로그램 등록
public class YoilTeller {
	
	@RequestMapping("/getYoil")
    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 1. 입력
		//쿼리스트링에서 넘어온 입력값을 받음
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        int yyyy = Integer.parseInt(year);
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);

        // 2. 처리
        //입력값 처리
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm - 1, dd);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = " 일월화수목금토".charAt(dayOfWeek);
        
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        // 3. 출력
		/*
		 * System.out.println(year + "년 " + month + "월 " + day + "일은 ");
		 * System.out.println(yoil + "요일입니다.");
		 */
        PrintWriter out = response.getWriter();
        
        out.println(year + "년 " + month + "월 " + day + "일은 ");
		out.println(yoil + "요일입니다.");
    }
}