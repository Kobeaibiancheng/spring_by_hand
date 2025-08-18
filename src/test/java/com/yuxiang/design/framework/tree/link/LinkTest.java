package com.yuxiang.design.framework.tree.link;


import com.yuxiang.design.framework.link.chain.BusinessLinkedList;
import com.yuxiang.design.framework.link.chain.LinkedList;
import com.yuxiang.design.framework.link.example.EmployeeInformationRuleFilterFactory;
import com.yuxiang.design.framework.link.example.TradeSettlementRuleFilterFactory;
import com.yuxiang.design.framework.link.example.entity.TradeSettlementRuleCommandEntity;
import com.yuxiang.design.framework.link.example.entity.TradeSettlementRuleFilterBackEntity;
import com.yuxiang.design.framework.link.example.entity.UserInformationEntity;
import com.yuxiang.design.framework.link.example.entity.UserInformationRuleFilterBackEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
public class LinkTest {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Person{
        private String name;
        private int age;
    }


    @Test
    public void linkTest(){
        LinkedList<Person> linkedList = new LinkedList<>("职位链");
        linkedList.addFirst(new Person("老板",50));
        linkedList.addFirst(new Person("老板娘",45));
        linkedList.printLinkList();
        linkedList.add(new Person("研发部主管",35));
        linkedList.add(new Person("人事部主管",35));
        linkedList.printLinkList();
        linkedList.remove(new Person("人事部主管",35));
        linkedList.printLinkList();
        linkedList.addLast(new Person("员工1",23));
        linkedList.addLast(new Person("员工2",24));
        linkedList.addLast(new Person("员工3",25));
        linkedList.addLast(new Person("员工4",26));
        linkedList.printLinkList();
    }


    @Resource
    private BusinessLinkedList<TradeSettlementRuleCommandEntity, TradeSettlementRuleFilterFactory.DynamicContext, TradeSettlementRuleFilterBackEntity> tradeSettlementRuleFilter;



    @Test
    public void tradeRuleFilterTest(){
        TradeSettlementRuleFilterBackEntity tradeSettlementRuleFilterBackEntity = tradeSettlementRuleFilter.apply(
                TradeSettlementRuleCommandEntity.builder()
                        .source("国家地理")
                        .outTradeNo("12345678")
                        .outTradeTime(new Date())
                        .build(),
                new TradeSettlementRuleFilterFactory.DynamicContext());
    }


    @Resource
    private BusinessLinkedList<UserInformationEntity, EmployeeInformationRuleFilterFactory.DynamicContext, UserInformationRuleFilterBackEntity> employeeInformationRuleFilter;


    @Resource
    private UserInformationEntity userInformationEntity;

    @Test
    public  void employeeInformationFilterTest(){

        System.out.println(userInformationEntity);



        UserInformationRuleFilterBackEntity ret = employeeInformationRuleFilter.apply(
                UserInformationEntity.builder()
                        .id("1")
                        .name("wangyuxiang")
                        .phone("1351111111")
                        .email("1244838148@qq.com")
                        .age(25).address("陕西西安")
                        .job("学生").build(),
                        new EmployeeInformationRuleFilterFactory.DynamicContext());
    }
}
