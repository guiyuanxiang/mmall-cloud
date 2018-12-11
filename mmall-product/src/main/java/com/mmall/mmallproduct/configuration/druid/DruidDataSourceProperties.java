package com.mmall.mmallproduct.configuration.druid;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * @author: gg
 * @date: 2018/12/7 11:10
 */
@Data
@ConfigurationProperties("spring.datasource.druid")
public class DruidDataSourceProperties {

    private Boolean testWhileIdle = true;
    private Boolean testOnBorrow;

    private String validationQuery = "SELECT 1";
    private Boolean useGlobalDataSourceStat;
    private String filters;
    private Long timeBetweenLogStatsMillis;
    private Integer maxSize;
    private Boolean clearFiltersEnable;
    private Boolean resetStatEnable;
    private Integer notFullTimeoutRetryCount;
    private Integer maxWaitThreadCount;
    private Boolean failFast;
    private Boolean phyTimeoutMillis;
    private Long minEvictableIdleTimeMillis = 300000L;
    private Long maxEvictableIdleTimeMillis;
    private Integer initialSize = 5;
    private Integer minIdle = 5;
    private Integer maxActive = 20;
    private Long maxWait = 60000L;
    private Long timeBetweenEvictionRunsMillis = 60000L;
    private Boolean poolPreparedStatements = true;
    private Integer maxPoolPreparedStatementPerConnectionSize = 20;

    //    新增

    private Boolean testOnReturn;
    private String filterClassNames;
    private Long removeAbandonedTimeout;
    private Long transactionQueryTimeout;
    private Long queryTimeout;
    private Boolean filterStatMergeSql;
    private String filterStatDbType;
    private Boolean filterStatLogSlowSql;
    private Long filterStatSlowSqlMillis;
    private Boolean filterWallEnabled;
    private String filterWallDbType;
    private Boolean filterWallConfigDeleteAllow;
    private Boolean filterWallConfigDropTableAllow;



    private Properties connectionProperties = new Properties() {{
        put("druid.stat.mergeSql", "true");
        put("druid.stat.slowSqlMillis", "5000");
    }};

    public Properties toProperties() {
        Properties properties = new Properties();
        notNullAdd(properties, "testWhileIdle", this.testWhileIdle);
        notNullAdd(properties, "testOnBorrow", this.testOnBorrow);
        notNullAdd(properties, "validationQuery", this.validationQuery);
        notNullAdd(properties, "filters", this.filters);
        notNullAdd(properties, "timeBetweenLogStatsMillis", this.timeBetweenLogStatsMillis);
        notNullAdd(properties, "stat.sql.MaxSize", this.maxSize);
        notNullAdd(properties, "clearFiltersEnable", this.clearFiltersEnable);
        notNullAdd(properties, "resetStatEnable", this.resetStatEnable);
        notNullAdd(properties, "notFullTimeoutRetryCount", this.notFullTimeoutRetryCount);
        notNullAdd(properties, "maxWaitThreadCount", this.maxWaitThreadCount);
        notNullAdd(properties, "failFast", this.failFast);
        notNullAdd(properties, "phyTimeoutMillis", this.phyTimeoutMillis);
        notNullAdd(properties, "minEvictableIdleTimeMillis", this.minEvictableIdleTimeMillis);
        notNullAdd(properties, "maxEvictableIdleTimeMillis", this.maxEvictableIdleTimeMillis);
        notNullAdd(properties, "initialSize", this.initialSize);
        notNullAdd(properties, "minIdle", this.minIdle);
        notNullAdd(properties, "maxActive", this.maxActive);
        notNullAdd(properties, "maxWait", this.maxWait);
        notNullAdd(properties, "timeBetweenEvictionRunsMillis", this.timeBetweenEvictionRunsMillis);
        notNullAdd(properties, "poolPreparedStatements", this.poolPreparedStatements);
        notNullAdd(properties, "maxPoolPreparedStatementPerConnectionSize", this.maxPoolPreparedStatementPerConnectionSize);
        notNullAdd(properties, "filterClassNames", this.filterClassNames);
        notNullAdd(properties, "removeAbandonedTimeout", this.removeAbandonedTimeout);
        notNullAdd(properties, "transactionQueryTimeout", this.transactionQueryTimeout);
        notNullAdd(properties, "filterStatMergeSql", this.filterStatMergeSql);
        notNullAdd(properties, "filterStatDbType", this.filterStatDbType);
        notNullAdd(properties, "filterStatLogSlowSql", this.filterStatLogSlowSql);
        notNullAdd(properties, "filterStatSlowSqlMillis", this.filterStatSlowSqlMillis);
        notNullAdd(properties, "filterWallEnabled", this.filterWallEnabled);
        notNullAdd(properties, "filterWallDbType", this.filterWallEnabled);
        notNullAdd(properties, "filterWallConfigDeleteAllow", this.filterWallEnabled);
        notNullAdd(properties, "filterWallConfigDropTableAllow", this.filterWallConfigDropTableAllow);
        return properties;
    }

    private void notNullAdd(Properties properties, String key, Object value) {
        if (value != null) {
            properties.setProperty("druid." + key, value.toString());
        }
    }

}