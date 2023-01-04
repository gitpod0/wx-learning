package com.tencent.wxcloudrun.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InitDataBase {
    @Value(value = "${spring.datasource.username}")
    private String userName;
    @Value(value = "${spring.datasource.password}")
    private String password;
    @Value(value = "${spring.datasource.url}")
    private String url;
    

    @PostConstruct
    public void init() throws SQLException{
            // 创建ScriptRunner，用于执行SQL脚本，如果想要初始化后创建数据库，那么一开始在此处初始化的时候需要连接一个已经存在的数据。
        try(Connection conn = DriverManager.getConnection(url, userName, password);){
           
            ScriptRunner runner = new ScriptRunner(conn);
            // 执行SQL脚本
            runner.runScript(Resources.getResourceAsReader("db.sql"));
        }catch (Exception e){
           
        }
    }
}