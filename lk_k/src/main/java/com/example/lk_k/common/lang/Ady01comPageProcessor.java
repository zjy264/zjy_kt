package com.example.lk_k.common.lang;

import com.example.lk_k.controller.KtController;
import com.example.lk_k.mapper.KtMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>description</b>：第一个爬虫示例，爬去动作片列表信息 <br>
 * <b>time</b>：2019/4/20 10:58 <br>
 * <b>author</b>：ready likun_557@163.com
 */
@Slf4j
public class Ady01comPageProcessor implements PageProcessor {
//    @Update("truncate table m_kt")
//    void delete();
    public static List<String> list1=new ArrayList<String>();
    public static List<String> list2=new ArrayList<String>();
    public static List<String> list3=new ArrayList<String>();
    public static List<LocalDate> list4=new ArrayList<LocalDate>();
    public static List<String> list5=new ArrayList<String>();
    public static List<String> list6=new ArrayList<String>();
    @Autowired
    KtMapper ktMapper;
    @Override
    public void process(Page page) {
        int sum=0;
        if (KtController.controller==1){
            for (int i=0;i<20;i++){
                String xp1="/html/body/div[2]/div[1]/div["+(i+1)+"]/a/div[1]/p/span[2]/text()";//shorttitle
                String xp2="/html/body/div[2]/div[1]/div["+(i+1)+"]/a/div[2]/div/h3/text()";//mainp
                String xp3="/html/body/div[2]/div[1]/div["+(i+1)+"]/a/div[1]/div/img/@data-src";//pic  ok
                String xp4="/html/body/div[2]/div[1]/div["+(i+1)+"]/a/div[2]/div/span/@data-origindate";//data  ok
                String xp5="/html/body/div[2]/div[1]/div["+(i+1)+"]/a/div[2]/div/div/span[2]/@data-origincount";//zan
                String xp6="/html/body/div[2]/div[1]/div["+(i+1)+"]/a/div[2]/div/div/span[1]/@data-origincount";//pinlun
                String shorttitle=page.getHtml().xpath(xp1).toString();
                String mainp=page.getHtml().xpath(xp2).toString();
                String pic=page.getHtml().xpath(xp3).toString();
                String data=page.getHtml().xpath(xp4).toString();
                String zan=page.getHtml().xpath(xp5).toString();
                String pinlun=page.getHtml().xpath(xp6).toString();
                list1.add(shorttitle);
                list2.add(mainp);
                list3.add(pic);
                list4.add(LocalDate.parse(data.substring(0,10)));
                list5.add(zan);
                list6.add(pinlun);
            }
            for (int i=0;i<20;i++){
                System.out.print(sum+++" , ");
                System.out.print(list1.get(i)+" , ");
                System.out.print(list2.get(i)+" , ");
                System.out.print(list3.get(i)+" , ");
                System.out.print(list4.get(i)+" , ");
                System.out.print(list5.get(i)+" , ");
                System.out.print(list6.get(i)+" 。 ");
                System.out.println();
            }
        }else if(KtController.controller==2){
            for (int i=0;i<20;i++){
                String xp1="/html/body/div[2]/div[1]/div["+(i+6)+"]/a/div[1]/p/span[2]/text()";//shorttitle
                String xp2="/html/body/div[2]/div[1]/div["+(i+6)+"]/a/div[2]/h3/@data-origintext";//mainp
                String xp3="/html/body/div[2]/div[1]/div["+(i+6)+"]/a/div[1]/div/img/@data-src";//pic  ok
                String xp4="/html/body/div[2]/div[1]/div["+(i+6)+"]/a/div[3]/span/@data-origindate";//data  ok
                String xp5="/html/body/div[2]/div[1]/div["+(i+6)+"]/a/div[3]/div/span[2]/@data-origincount";//zan
                String xp6="/html/body/div[2]/div[1]/div["+(i+6)+"]/a/div[3]/div/span[1]/@data-origincount";//pinlun
                String shorttitle1=page.getHtml().xpath(xp1).toString();
                String mainp1=page.getHtml().xpath(xp2).toString();
                String pic1=page.getHtml().xpath(xp3).toString();
                String data1=page.getHtml().xpath(xp4).toString();
                String zan1=page.getHtml().xpath(xp5).toString();
                String pinlun1=page.getHtml().xpath(xp6).toString();
                list1.add(shorttitle1);
                list2.add(mainp1);
                list3.add(pic1);
                list4.add(LocalDate.parse(data1.substring(0,10)));
                list5.add(zan1);
                list6.add(pinlun1);
            }
            for (int i=0;i<20;i++){
                    System.out.print(sum+++" , ");
                    System.out.print(list1.get(i)+" , ");
                    System.out.print(list2.get(i)+" , ");
                    System.out.print(list3.get(i)+" , ");
                    System.out.print(list4.get(i)+" , ");
                    System.out.print(list5.get(i)+" , ");
                    System.out.print(list6.get(i)+" 。 ");
                    System.out.println();
            }
        }else  if (KtController.controller==3){
            for (int i=0;i<20;i++){
                String xp1="/html/body/div[2]/div[1]/div["+(i+1)+"]/a/div[1]/p/span[2]/text()";//shorttitle
                String xp2="/html/body/div[2]/div[1]/div["+(i+1)+"]/a/div[2]/div/h3/text()";//mainp
                String xp3="/html/body/div[2]/div[1]/div["+(i+1)+"]/a/div[1]/div/img/@data-src";//pic  ok
                String xp4="/html/body/div[2]/div[1]/div["+(i+1)+"]/a/div[2]/div/span/@data-origindate";//data  ok
                String xp5="/html/body/div[2]/div[1]/div["+(i+1)+"]/a/div[2]/div/div/span[2]/@data-origincount";//zan
                String xp6="/html/body/div[2]/div[1]/div["+(i+1)+"]/a/div[2]/div/div/span[1]/@data-origincount";//pinlun
                String shorttitle=page.getHtml().xpath(xp1).toString();
                String mainp=page.getHtml().xpath(xp2).toString();
                String pic=page.getHtml().xpath(xp3).toString();
                String data=page.getHtml().xpath(xp4).toString();
                String zan=page.getHtml().xpath(xp5).toString();
                String pinlun=page.getHtml().xpath(xp6).toString();
                list1.add(shorttitle);
                list2.add(mainp);
                list3.add(pic);
                list4.add(LocalDate.parse(data.substring(0,10)));
                list5.add(zan);
                list6.add(pinlun);
            }
            for (int i=0;i<20;i++){
                System.out.print(sum+++" , ");
                System.out.print(list1.get(i)+" , ");
                System.out.print(list2.get(i)+" , ");
                System.out.print(list3.get(i)+" , ");
                System.out.print(list4.get(i)+" , ");
                System.out.print(list5.get(i)+" , ");
                System.out.print(list6.get(i)+" 。 ");
                System.out.println();
            }
        }
//        LocalDate endOfFeb = LocalDate.parse("2014-02-28");
        System.out.println("-------------开始-------");
    }

    @Override
    public Site getSite() {
        return Site.me().setSleepTime(1000).setRetryTimes(3);
    }
}