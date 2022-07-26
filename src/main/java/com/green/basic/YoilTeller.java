package com.green.basic;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //���α׷� ���
public class YoilTeller {
	
	@RequestMapping("/getYoil")
    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 1. �Է�
		//������Ʈ������ �Ѿ�� �Է°��� ����
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        int yyyy = Integer.parseInt(year);
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);

        // 2. ó��
        //�Է°� ó��
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm - 1, dd);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek);
        
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        // 3. ���
		/*
		 * System.out.println(year + "�� " + month + "�� " + day + "���� ");
		 * System.out.println(yoil + "�����Դϴ�.");
		 */
        PrintWriter out = response.getWriter();
        
        out.println(year + "�� " + month + "�� " + day + "���� ");
		out.println(yoil + "�����Դϴ�.");
    }
}