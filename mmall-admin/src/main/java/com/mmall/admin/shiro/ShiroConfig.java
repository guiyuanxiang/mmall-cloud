package com.mmall.admin.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author gg
 * @version ShiroConfig.java, v 0.1 2018-05-31 16:02 caofy
 */
@Configuration
public class ShiroConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroConfig.class);

    private static final int EXPIRE_TIME = 3600;

    static final long SESSION_EXPIRE_TIME = EXPIRE_TIME * 1000;

    private static final int TIMEOUT = 20000;


    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public ShiroFilterFactoryBean createShiroFilter(@Qualifier("securityManager") SecurityManager securityManager) {
        LOGGER.info("createShiroFilter start");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/admin/login");
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 配置不会被拦截的链接 顺序判断 anon:不做任何校验 authc:必须登录 perms:必须有权限
        filterChainDefinitionMap.put("/admin/login", "anon");
        filterChainDefinitionMap.put("/admin/logout", "logout");
        filterChainDefinitionMap.put("/api/common/**", "anon");
        filterChainDefinitionMap.put("/druid/**", "anon");
        filterChainDefinitionMap.put("/api/cache/**", "anon");
        filterChainDefinitionMap.put("/api/transform/**", "anon");
        filterChainDefinitionMap.put("/api/shop/getShopMenu", "authc");
        filterChainDefinitionMap.put("/resource/menu", "authc");
        LOGGER.info("filterChainDefinitionMap=" + filterChainDefinitionMap);
        filterChainDefinitionMap.put("/**", "perms");
        Map<String, Filter> filters = new HashMap<>(16);
        Filter loginFilter = new LoginFormFilter();
        Filter permsFilter = new PermsFilter();
        //自定义的登陆校验filter
        filters.put("authc", loginFilter);
        //自定义的权限filter
        filters.put("perms", permsFilter);
        //此处使用自定义的拦截器,autho默认使用FormAuthenticationFilter拦截器
        shiroFilterFactoryBean.setFilters(filters);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        LOGGER.info("createShiroFilter end");

        return shiroFilterFactoryBean;
    }


    @Bean("securityManager")
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        // 自定义缓存实现 使用redis
        securityManager.setCacheManager(cacheManager());
        // 自定义session管理 使用redis
        securityManager.setSessionManager(sessionManager());
        SecurityUtils.setSecurityManager(securityManager);
        return securityManager;
    }


    /**
     * 身份认证realm; (自定义账号密码校验；以及加载权限等)
     */
    @Bean(name = "myShiroRealm")
    public AdminShiroRealm myShiroRealm() {
        return new AdminShiroRealm();
    }


    /**
     * 配置shiro redisManager
     * 使用的是shiro-redis开源插件
     *
     * @return RedisManager
     */
    private RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setExpire(EXPIRE_TIME);
        redisManager.setTimeout(TIMEOUT);
        redisManager.setPassword(password);
        return redisManager;
    }

    /**
     * cacheManager 缓存 redis实现
     * 使用的是shiro-redis开源插件
     *
     * @return RedisCacheManager
     */
    private RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }


    /**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     * 使用的是shiro-redis开源插件
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        String sessionCacheKeyPrefix = "session:";
        redisSessionDAO.setKeyPrefix(sessionCacheKeyPrefix);
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    /**
     * shiro session的管理
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionValidationInterval(1800000);
        return sessionManager;
    }


    /**
     * 这里需要设置一个cookie的名称  原因就是会跟原来的session的id值重复的
     *
     * @return SimpleCookie
     */
    @Bean
    public SimpleCookie simpleCookie() {
        String cookieCacheKeyPrefix = "cookie:";
        return new SimpleCookie(cookieCacheKeyPrefix);
    }


    /**
     * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;
     *
     * @param securityManager SecurityManager
     * @return AuthorizationAttributeSourceAdvisor
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor =
                new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
