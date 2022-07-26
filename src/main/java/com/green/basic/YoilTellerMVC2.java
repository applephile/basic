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
public class YoilTellerMVC2 {

	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	//�Ű������� ���� �Ѱܹް� ��� ������ �� �Ű������� ������
	@RequestMapping("/getYoilMVC2") //url ����
    public String main(MyDate date, Model model) throws IOException {
		
		//�� �Է¿� ���� ��ȿ���˻�
		if(!isVaild(date)) { 
			return "yoilError"; 
		}

		//���� ó�� �޼��� ȣ��
        char yoil = getYoil(date);
        
        model.addAttribute("myDate", date);
        model.addAttribute("yoil", yoil);

        return "yoil";
        
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
	
	private char getYoil(MyDate date) {
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
	}

	//��ȿ�� �˻縦 ���� �޼���
	private boolean isVaild(MyDate date) {
		return isVaild(date.getYear(), date.getMonth(), date.getDay());
	}

	private boolean isVaild(int year, int month, int day) {
		return true;
	}

	//ó�� ��� �޼���
	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " �Ͽ�ȭ�������".charAt(dayOfWeek);
	}
}