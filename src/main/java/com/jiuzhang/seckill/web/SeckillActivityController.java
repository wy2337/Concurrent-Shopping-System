package com.jiuzhang.seckill.web;

import com.jiuzhang.seckill.db.dao.SeckillActivityDao;
import com.jiuzhang.seckill.db.po.SeckillActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
public class SeckillActivityController {
    @RequestMapping("/addSeckillActivity")
    public String addSeckillActivity() {
        return "add_activity";
    }
    @Autowired
    private SeckillActivityDao seckillActivityDao;
    @ResponseBody


    @RequestMapping("/addSeckillActivityAction")
    public String addSeckillActivityAction(
            @RequestParam("name") String name,
            //提交表单之后就会返回一个成功页面：
                   // 3.5.2 活动列表页面
                   // 将如下代码复制到 SeckillActivityController 中：
            @RequestParam("commodityId") long commodityId,
    @RequestParam("seckillPrice") BigDecimal seckillPrice,
    @RequestParam("oldPrice") BigDecimal oldPrice,
    @RequestParam("seckillNumber") long seckillNumber,
    @RequestParam("startTime") String startTime,
    @RequestParam("endTime") String endTime,
            Map<String, Object>resultMap

) throws ParseException {
        startTime = startTime.substring(0, 10) + startTime.substring(11);
        endTime = endTime.substring(0, 10) + endTime.substring(11);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-ddhh:mm");
        SeckillActivity seckillActivity = new SeckillActivity();
        seckillActivity.setName(name);
        seckillActivity.setCommodityId(commodityId);
        seckillActivity.setSeckillPrice(seckillPrice);
        seckillActivity.setOldPrice(oldPrice);
        seckillActivity.setTotalStock(seckillNumber);
        seckillActivity.setAvailableStock(new Integer("" + seckillNumber));
        seckillActivity.setLockStock(0L);
        seckillActivity.setActivityStatus(1);
        seckillActivity.setStartTime(format.parse(startTime));
        seckillActivity.setEndTime(format.parse(endTime));
        seckillActivityDao.inertSeckillActivity(seckillActivity);
        resultMap.put("seckillActivity", seckillActivity);
        return "add_success";
    }
    @RequestMapping("/seckills")
    public String activityList(Map<String, Object> resultMap) {
        List<SeckillActivity> seckillActivities =
                seckillActivityDao.querySeckillActivitysByStatus(1);
        resultMap.put("seckillActivities", seckillActivities);
        return "seckill_activity";
    }

}



