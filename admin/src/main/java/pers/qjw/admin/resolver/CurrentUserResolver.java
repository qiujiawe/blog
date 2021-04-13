package pers.qjw.admin.resolver;

import com.google.common.base.Strings;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import pers.qjw.admin.annotations.CurrentUser;
import pers.qjw.admin.config.Constants;
import pers.qjw.admin.model.BlogUser;

public class CurrentUserResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        // 如果参数类型为 User 并且有 CurrentUser 注解则注入
        return methodParameter.getParameterType().isAssignableFrom(BlogUser.class) &&
                methodParameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) {
        // 取出拦截器(TokenInterceptor类)存在REQUEST作用域里的用户phone
        String name = (String) nativeWebRequest.getAttribute(Constants.CURRENT_USER_NAME, RequestAttributes.SCOPE_REQUEST);
        String icon = (String) nativeWebRequest.getAttribute(Constants.CURRENT_USER_ICON, RequestAttributes.SCOPE_REQUEST);
        if (!Strings.isNullOrEmpty(name) && !Strings.isNullOrEmpty(icon)) {
            BlogUser blogUser = new BlogUser();
            blogUser.setIcon(icon);
            blogUser.setName(name);
            return blogUser;
        }
        return null;
    }
}
