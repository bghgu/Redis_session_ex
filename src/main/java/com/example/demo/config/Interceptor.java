package com.example.demo.config;

/**
 * Created by ds on 2018-03-26.
 */

import com.example.demo.domain.mysql.USER;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
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

    @Autowired
    LoginService loginService;

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
        USER user = (USER) session.getAttribute("login");
        if(user == null) {
            Cookie cookie = WebUtils.getCookie(request, "loginCookie");
            if(cookie != null) {
                String sessionId = cookie.getValue();
                USER obj = loginService.findBySessionId(sessionId);
                if(obj != null) {
                    session.setAttribute("login", obj);
                    return true;
                }
            }
            response.sendRedirect("login");
            return false;
        }
        return true;
    }

    /**
     * 컨트롤러 메소드 실행 직후에 실행
     * View 페이지가 렌더링 되기전에 ModelAndView 객체를 조작 가능
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * View 페이지가 렌더링 되고 난 후 에 실행
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    /**
     * Servlet 3.0 부터 비동기 요청이 가능
     * 비동기 요청시 postHandle와 afterCompletion 은 실행되지 않고, 이 메소드가 실행
     * @param request
     * @param response
     * @param handler
     * @throws Exception
     */
    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    }

}
