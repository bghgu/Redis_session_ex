package com.example.demo.config;

/**
 * Created by ds on 2018-03-26.
 */

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 스프링의 Dispatcher 서블릿이 컨트롤러를 호출할 때 전, 후에 끼어듭니다.
 * 그러므로 스프링 컨텍스트 내부에 존재하게 됩니다.
 * 인터셉터는 여러개를 사용할 수 있으며, 실행 순서는 <mvc:interceptors> 에 나오는 순서 입니다.
 * 인터셉터를 주로 사용하는 곳은 로그인 체크, 권한 체크, 프로그램 실행시간 계산 작업 로그 처리, 업로드 파일 처리 등에 많이 사용됩니다.
 */

@Component
public class Interceptor extends HandlerInterceptorAdapter {

    /**
     * 컨트롤러 메소드 실행 직전에 수행
     * true 를 반환하면 계속 진행이 되고  false 를 리턴하면 실행 체인(다른 인터셉터, 컨트롤러 실행)이 중지되고 반환
     * 필터의 응답 처리가 있다면 그것은 실행이 된다.
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        return true;
    }
}
