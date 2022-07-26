package com.green.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //���α׷� ���
public class YoilTellerMVC {

	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	//�Ű������� ���� �Ѱܹް� ��� ������ �� �Ű������� ������
	@RequestMapping("/getYoilMVC") //url ����
    public ModelAndView main(@RequestParam(required=true) int year, 
    						@RequestParam(required=true) int month, 
    						@RequestParam(required=true) int day) throws IOException {
		
		ModelAndView mv = new ModelAndView();
		//�� �Է¿� ���� ��ȿ���˻�
		/*
		 * if(!isVaild(year, month, day)) { return "yoilError"; }
		 */

		//���� ó�� �޼��� ȣ��
        char yoil = getyoil(year, month, day);
        
        //ó���� ����� mv�� ����
        mv.addObject("year", year);
        mv.addObject("month", month);
        mv.addObject("day", day);
        mv.addObject("yoil", yoil);

        mv.setViewName("yoil");
        
        return mv;
        //�����ְ� ���� �� ����
        //return "yoil";  // /WEB-INF/views/yoil.jsp
        
//        response.setContentType("text/html");
//        response.setCharacterEncoding("utf-8");

        // 3. ���
		/*
		 * System.out.println(year + "�� " + month + "�� " + day + "���� ");
		 * System.out.println(yoil + "�����Դϴ�.");
		 */
//        PrintWriter out = response.getWriter();
//        
//        out.println(year + "�� " + month + "�� " + day + "���� ");
//		out.println(yoil + "�����Դϴ�.");
    }
	
	//��ȿ�� �˻縦 ���� �޼���
	private boolean isVaild(int year, int month, int day) {
		// TODO Auto-generated method stub
		return false;
	}

	//ó�� ��� �޼���
	private char getyoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " �Ͽ�ȭ�������".charAt(dayOfWeek);
	}
}