package com.sist.ex0905_dept.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "com.sist.ex0905_dept.mapper")
public class DbConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
        //위의 @Bean이라고 명시했기 때문에 빈객체를 만들기 위해 한번 호출함!
        //SqlSessionFactory를 생성하는 객체를 만들자
        SqlSessionFactoryBean sBean = new SqlSessionFactoryBean();
        sBean.setDataSource(ds);
        // Sql문장들(mapper)을 인식하기 위해 mapper들이 있는 위치를 지정하자!
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
         sBean.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/**/*.xml"));
         return sBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
