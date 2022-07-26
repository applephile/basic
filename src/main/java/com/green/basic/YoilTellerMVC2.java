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

@Controller //프로그램 등록
public class YoilTellerMVC2 {

	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	//매개변수로 값을 넘겨받고 뷰로 전달할 모델 매개변수로 선언함
	@RequestMapping("/getYoilMVC2") //url 연결
    public String main(MyDate date, Model model) throws IOException {
		
		//값 입력에 대한 유효성검사
		if(!isVaild(date)) { 
			return "yoilError"; 
		}

		//실제 처리 메서드 호출
        char yoil = getYoil(date);
        
        model.addAttribute("myDate", date);
        model.addAttribute("yoil", yoil);

        return "yoil";
        
        //보여주고 싶은 뷰 지정
        //return "yoil";  // /WEB-INF/views/yoil.jsp
        
//        response.setContentType("text/html");
//        response.setCharacterEncoding("utf-8");

        // 3. 출력
		/*
		 * System.out.println(year + "년 " + month + "월 " + day + "일은 ");
		 * System.out.println(yoil + "요일입니다.");
		 */
//        PrintWriter out = response.getWriter();
//        
//        out.println(year + "년 " + month + "월 " + day + "일은 ");
//		out.println(yoil + "요일입니다.");
    }
	
	private char getYoil(MyDate date) {
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
	}

	//유효성 검사를 위한 메서드
	private boolean isVaild(MyDate date) {
		return isVaild(date.getYear(), date.getMonth(), date.getDay());
	}

	private boolean isVaild(int year, int month, int day) {
		return true;
	}

	//처리 담당 메서드
	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
	}
}