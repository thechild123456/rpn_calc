package com.example.springbootdemo.config;

import com.example.springbootdemo.model.User;
import com.example.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // 检查数据库是否为空
        if (userRepository.count() == 0) {
            // 创建示例用户数据
            User user1 = new User();
            user1.setName("张三");
            user1.setEmail("zhangsan@example.com");
            user1.setAge(28);
            user1.setCreatedAt(LocalDateTime.now());
            user1.setUpdatedAt(LocalDateTime.now());
            
            User user2 = new User();
            user2.setName("李四");
            user2.setEmail("lisi@example.com");
            user2.setAge(32);
            user2.setCreatedAt(LocalDateTime.now());
            user2.setUpdatedAt(LocalDateTime.now());
            
            User user3 = new User();
            user3.setName("王五");
            user3.setEmail("wangwu@example.com");
            user3.setAge(25);
            user3.setCreatedAt(LocalDateTime.now());
            user3.setUpdatedAt(LocalDateTime.now());
            
            User user4 = new User();
            user4.setName("赵六");
            user4.setEmail("zhaoliu@example.com");
            user4.setAge(35);
            user4.setCreatedAt(LocalDateTime.now());
            user4.setUpdatedAt(LocalDateTime.now());
            
            User user5 = new User();
            user5.setName("孙七");
            user5.setEmail("sunqi@example.com");
            user5.setAge(29);
            user5.setCreatedAt(LocalDateTime.now());
            user5.setUpdatedAt(LocalDateTime.now());
            
            // 保存示例数据
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            userRepository.save(user4);
            userRepository.save(user5);
            
            System.out.println("示例用户数据已初始化完成！");
        }
    }
}