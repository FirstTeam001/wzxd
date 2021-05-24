package com.dt.demo30;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.dt.demo30.entity.Info;
import com.dt.demo30.mapper.InfoMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstDemo {

    @Autowired
    InfoMapper infoMapper;

   @Test
    public void sl(){
       System.out.println("------------------");
         List<Info> list =infoMapper.selectList(null);
      // Assert.assertEquals(16,list.size());
       list.forEach(System.out::println);

   }




    //查询名称以 王字开头的数据


    //3.查询一条名称为王紫轩的数据
    @Test
    public void s2(){
        LambdaQueryWrapper<Info> lambdaWrapper =new QueryWrapper<Info>()
                .lambda();
        lambdaWrapper.eq(Info::getName,"ghr");
        Info info =  infoMapper.selectOne(lambdaWrapper);
        System.out.println(info);

    }

    //1.查询前5条数据，、
    @Test
    public void s3(){
        LambdaQueryWrapper<Info> lambdaWrapper =new QueryWrapper<Info>()
                .lambda();
       lambdaWrapper.le(Info::getId,8);
      List<Info> list =  infoMapper.selectList(lambdaWrapper);
      list.forEach(System.out::println);
    }

    //查询名称中带h的数据
    @Test
    public void s4(){
        LambdaQueryWrapper<Info> lambdaWrapper =new QueryWrapper<Info>()
                .lambda();
       lambdaWrapper.like(Info::getName,"h");
       List<Info> list =  infoMapper.selectList(lambdaWrapper);
       list.forEach(System.out::println);
    }

    //查询名称为www或带y的数据
    @Test
    public void s5(){
        LambdaQueryWrapper<Info> lambdaWrapper =new QueryWrapper<Info>()
                .lambda();
       lambdaWrapper.like(Info::getName,"www").or().like(Info::getName,"y");
        List<Info> list =  infoMapper.selectList(lambdaWrapper);
        list.forEach(System.out::println);
    }

    //统计名称为www的数据条数
    @Test
    public void s6(){
       LambdaQueryWrapper<Info> lambdaWrapper =new QueryWrapper<Info>()
               .lambda();
               lambdaWrapper.eq(Info::getName,"www");
               int c = infoMapper.selectCount(lambdaWrapper);
        System.out.println(c);
    //    QueryWrapper<Info> wrapper = new QueryWrapper<>();
     //   wrapper.eq("name","www");
     //   int c  =  infoMapper.selectCount(wrapper);
    //    System.out.println(c);
    }

    //将名称为ghr的数据替换其名称为ght
    @Test
    public void s7(){
        LambdaQueryWrapper<Info> lambdaWrapper = new QueryWrapper<Info>()
                .lambda();
        lambdaWrapper.eq(Info::getName,"ghr");
        Info info =new Info();
        info.setName("ght");
        infoMapper.update(info,lambdaWrapper);
    }

    //查询名称以 轩 字结尾的数据
    @Test
    public void s8(){
        LambdaQueryWrapper<Info> lambdaWrapper = new QueryWrapper<Info>()
                .lambda();
                lambdaWrapper.likeLeft(Info::getName,"轩");
      //  QueryWrapper<Info> wrapper = new QueryWrapper<>();
     //   wrapper.likeLeft("name","轩");
        List<Info> list = infoMapper.selectList(lambdaWrapper);
       list.forEach(System.out::println);

    }

    //删除id为14的数据
    @Test
    public void  s9(){
       infoMapper.deleteById(14);
    }

    //将id为15的数据的名称修改为wdk,age + 1
    @Test
    public void s10(){
      Info info =  infoMapper.selectById(15);
        LambdaQueryWrapper<Info> lambdaWrapper = new QueryWrapper<Info>()
                .lambda();
      lambdaWrapper.eq(Info::getId,15);
      Info info1 =new Info();
      info1.setName("wdk");
      info1.setAge(info.getAge()+1);
      infoMapper.update(info1,lambdaWrapper);
    }

    //2.查询名称为www的数据，按id倒序
    @Test
    public void s11() {
        LambdaQueryWrapper<Info> lambdaWrapper = new QueryWrapper<Info>()
                .lambda();
        lambdaWrapper.like(Info::getName, "www");
        lambdaWrapper.orderByDesc(Info::getId);
        List<Info> list = infoMapper.selectList(lambdaWrapper);
        list.forEach(System.out::println);


    }
}
