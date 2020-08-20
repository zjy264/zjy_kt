package com.example.lk_k.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.lk_k.common.lang.Ady01comPageProcessor;
import com.example.lk_k.common.lang.ListUtil;
import com.example.lk_k.common.lang.Result;
import com.example.lk_k.common.lang.VerifyCodeUtils;
import com.example.lk_k.entity.Kt;
import com.example.lk_k.mapper.KtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import us.codecraft.webmagic.Spider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author write by zjy
 * @since 2020-07-22
 */
@RestController
//@RequestMapping("/kt")
public class KtController {
    public static String kk;
    public static int controller=0;
    @Autowired(required = false)
    KtMapper ktMapper;

    @RequestMapping(value = "/main")
    public Result Toindex2() {
        List<Kt> list = ktMapper.selectList(null);
//        for (Kt kt:list){
//            System.out.println(kt);
//        }
        return Result.succ(list);
    }

    public int getidd(){
        int index;
        try {
            List<Kt> list = ktMapper.selectList(null);
            index = list.get(list.size() - 1).getId();
        }catch (Exception e){
            index=0;
        }
        return index;
    }
    @GetMapping(value = "/kky")
    public Result tikky() throws AWTException {
//        LocalDate endOfFeb = LocalDate.parse("2014-02-28");
//        ktMapper.delete();
        int index= getidd();
        Ady01comPageProcessor.list1.clear();
        Ady01comPageProcessor.list2.clear();
        Ady01comPageProcessor.list3.clear();
        Ady01comPageProcessor.list4.clear();
        Ady01comPageProcessor.list5.clear();
        Ady01comPageProcessor.list6.clear();
        startKt("http://www.qdaily.com/tags/1068.html",1);
        startKt("http://www.qdaily.com/tags/1615.html",3);
        startKt("http://www.qdaily.com/tags/29.html",1);
//        startKt("http://www.qdaily.com",2);
        Timer timer = new Timer();// 实例化Timer类
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("------------开始mysql存储1---------------------");
                inserTo(Ady01comPageProcessor.list1, Ady01comPageProcessor.list2, Ady01comPageProcessor.list3,Ady01comPageProcessor.list4,Ady01comPageProcessor.list5,Ady01comPageProcessor.list6, index);
            }
        }, 5000);// 这里百毫秒
        return Result.succ("本次数据更新成功");
    }
    public void startKt(String url,int con){
//        String url = "http://www.qdaily.com/";
        controller=con;
        Spider.create(new Ady01comPageProcessor())
                .addUrl(url)
                //开启5个线程抓取
                //启动爬虫
                .start();
    }
    public void inserTo(List<String> list1, List<String> list2, List<String> list3, List<LocalDate> list4,List<String> list5,List<String> list6,int index) {
        try {
            for (int i = 0; i < list3.size(); i++) {
                System.out.println("------------分割线---------------------");
                int intk=list3.get(i).indexOf("?");
                String pic=list3.get(i).substring(0,intk);
                Kt kt = new Kt();
                index=index+1;
                kt.setId(index);
                kt.setMainp(list2.get(i));
                kt.setData(list4.get(i));
                kt.setPic(pic);
                kt.setShorttitle(list1.get(i));
                if (list6.get(i)==null){
                    int max=500;
                    int min=50;
                    Random random = new Random();
                    int s = random.nextInt(max)%(max-min+1) + min;
                    kt.setPinlun(s);
                }else {
                    kt.setPinlun(Integer.parseInt(list6.get(i)));
                }
                if (list5.get(i)==null){
                    int max=500;
                    int min=50;
                    Random random = new Random();
                    int s = random.nextInt(max)%(max-min+1) + min;
                    kt.setZan(s);
                }else {
                    kt.setZan(Integer.parseInt(list5.get(i)));
                }

                System.out.println(kt);
                ktMapper.insert(kt);
                System.out.println("------------分割线---------------------");
            }
        } catch (Exception e) {
//            System.out.println("请在来一次");
            e.printStackTrace();
        }
    }

    @RequestMapping(value="/getImage**",method=RequestMethod.GET)
    public void authImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");
            // 生成随机字串
            String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
            System.out.println(verifyCode);
            kk = verifyCode;
            // 存入会话session
            HttpSession session = request.getSession(true);
            // 删除以前的
            session.removeAttribute("verCode");
            session.removeAttribute("codeTime");
            session.setAttribute("verCode", verifyCode.toLowerCase());
            session.setAttribute("codeTime", LocalDateTime.now());
            // 生成图片
            int w = 120, h = 40;
            OutputStream out = response.getOutputStream();
            VerifyCodeUtils.outputImage(w, h, out, verifyCode);
        } catch (Exception e) {

        }
    }
}
