package pers.qjw.admin.service.impl;

import com.google.common.base.Strings;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pers.qjw.admin.config.Constants;
import pers.qjw.admin.exception.UserIllegalArgumentException;
import pers.qjw.admin.mapper.BlogUserDynamicSqlSupport;
import pers.qjw.admin.mapper.BlogUserMapper;
import pers.qjw.admin.model.BlogUser;
import pers.qjw.admin.service.TokenService;
import pers.qjw.admin.util.EncryptionUtil;
import pers.qjw.admin.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
@AllArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final BlogUserMapper blogUserMapper;

    @Override
    public String createToken(String name, String password) {
        if (Strings.isNullOrEmpty(name) ||
                Strings.isNullOrEmpty(password) ||
                name.length() < 4 ||
                name.length() > 12 ||
                password.length() < 6 ||
                password.length() > 18
        ) {
            throw new UserIllegalArgumentException(HttpStatus.BAD_REQUEST,"用户账号或密码错误");
        }
        Optional<BlogUser> optional = blogUserMapper.selectOne(c -> c.where(BlogUserDynamicSqlSupport.name,isEqualTo(name)));
        if (optional.isPresent()) {
            BlogUser blogUser = optional.get();
            if (Objects.equals(EncryptionUtil.decryption(blogUser.getPassword()),password)) {
                Map<String,Object> userInfo = new HashMap<>();
                userInfo.put(Constants.CURRENT_USER_NAME,blogUser.getName());
                userInfo.put(Constants.CURRENT_USER_ICON,blogUser.getIcon());
                return JwtUtil.createToken(userInfo);
            }
        }
        throw new UserIllegalArgumentException(HttpStatus.BAD_REQUEST,"用户账号或密码错误");
    }
}
