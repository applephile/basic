package com.green.basic;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC4 {
	
//	@ExceptionHandler(Exception.class)
//	public String catcher(Exception ex) {
//		ex.printStackTrace();
//		return "yoilError";
//	}
	
    @RequestMapping("/getYoilMVC4") //http://localhost:8090/basic/getYoilMVC4?year=2022&month=7&day=aa
    public String main(MyDate date, BindingResult result) { 
    	
    	System.out.println("result = " + result);
    	
    	// 1. 유효성 검사 
    	if(!isValid(date)) {
    		return "yoilError"; // 뷰의 이름을 지정 
    	    
        }
    	
        // 2. 처리
		/* char yoil = getYoil(date); 반환타입 앞에 @ModelAttribute */

    	// 3. model에 저장
		/* model.addAttribute("myDate", date); 매개변수 앞에 @ModelAttribute */
		/* model.addAttribute("yoil", yoil);  반환타입 앞에 @ModelAttribute */        
        
      	// 5. 작업 결과를 보여줄 뷰의 이름을 반환
      	return "yoil";
    }

    private @ModelAttribute("yoil") char getYoil(MyDate date) {
        return getYoil(date.getYear(), date.getMonth(), date.getDay());
    }
    
    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
    }
    
    private boolean isValid(MyDate date) {
        return isValid(date.getYear(), date.getMonth(), date.getDay());
    }
    
    private boolean isValid(int year, int month, int day) {    
    	if(year==-1 || month==-1 || day==-1) 
    		return false;
    	
    	return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크 
    }
}
