package com.ypxx.manage.config;

import com.ypxx.manage.common.utils.UserUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * Created by xuwei on 2018/10/8.
 */
@Configuration
public class UserIDAuditor implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        return Optional.of(UserUtils.getUser().getId());
    }
}
