package pers.qjw.admin.interceptor;

import com.google.common.base.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import pers.qjw.admin.annotations.Authorization;
import pers.qjw.admin.config.Constants;
import pers.qjw.admin.exception.NotLoggedInException;
import pers.qjw.admin.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        boolean isLogin = false;
        String token = request.getHeader(Constants.AUTHORIZATION);
        if (!Strings.isNullOrEmpty(token) && !"null".equals(token)) {
            Map<String,Object> userInfo;
            try {
                userInfo = JwtUtil.parsing(token);
                request.setAttribute(Constants.CURRENT_USER_NAME,userInfo.get(Constants.CURRENT_USER_NAME));
                request.setAttribute(Constants.CURRENT_USER_ICON,userInfo.get(Constants.CURRENT_USER_ICON));
                isLogin = true;
            } catch (Exception ignored) {}
        }
        if (!isLogin) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            if (!Objects.isNull(method.getAnnotation(Authorization.class))) {
                throw new NotLoggedInException(HttpStatus.UNAUTHORIZED,"需要先进行登录");
            }
        }
        return true;
    }

}
