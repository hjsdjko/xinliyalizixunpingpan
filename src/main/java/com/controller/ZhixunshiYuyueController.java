
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 咨询师预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhixunshiYuyue")
public class ZhixunshiYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(ZhixunshiYuyueController.class);

    private static final String TABLE_NAME = "zhixunshiYuyue";

    @Autowired
    private ZhixunshiYuyueService zhixunshiYuyueService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    //注册表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ZhixunshiService zhixunshiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("咨询师".equals(role))
            params.put("zhixunshiId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = zhixunshiYuyueService.queryPage(params);

        //字典表数据转换
        List<ZhixunshiYuyueView> list =(List<ZhixunshiYuyueView>)page.getList();
        for(ZhixunshiYuyueView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhixunshiYuyueEntity zhixunshiYuyue = zhixunshiYuyueService.selectById(id);
        if(zhixunshiYuyue !=null){
            //entity转view
            ZhixunshiYuyueView view = new ZhixunshiYuyueView();
            BeanUtils.copyProperties( zhixunshiYuyue , view );//把实体数据重构到view中
            //级联表 咨询师
            //级联表
            ZhixunshiEntity zhixunshi = zhixunshiService.selectById(zhixunshiYuyue.getZhixunshiId());
            if(zhixunshi != null){
            BeanUtils.copyProperties( zhixunshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "zhixunshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setZhixunshiId(zhixunshi.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZhixunshiYuyueEntity zhixunshiYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhixunshiYuyue:{}",this.getClass().getName(),zhixunshiYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("咨询师".equals(role))
            zhixunshiYuyue.setZhixunshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ZhixunshiYuyueEntity> queryWrapper = new EntityWrapper<ZhixunshiYuyueEntity>()
            .eq("zhixunshi_id", zhixunshiYuyue.getZhixunshiId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhixunshiYuyueEntity zhixunshiYuyueEntity = zhixunshiYuyueService.selectOne(queryWrapper);
        if(zhixunshiYuyueEntity==null){
            zhixunshiYuyue.setInsertTime(new Date());
            zhixunshiYuyue.setCreateTime(new Date());
            zhixunshiYuyueService.insert(zhixunshiYuyue);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhixunshiYuyueEntity zhixunshiYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zhixunshiYuyue:{}",this.getClass().getName(),zhixunshiYuyue.toString());
        ZhixunshiYuyueEntity oldZhixunshiYuyueEntity = zhixunshiYuyueService.selectById(zhixunshiYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("咨询师".equals(role))
//            zhixunshiYuyue.setZhixunshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ZhixunshiYuyueEntity> queryWrapper = new EntityWrapper<ZhixunshiYuyueEntity>()
            .notIn("id",zhixunshiYuyue.getId())
            .andNew()
            .eq("zhixunshi_id", zhixunshiYuyue.getZhixunshiId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhixunshiYuyueEntity zhixunshiYuyueEntity = zhixunshiYuyueService.selectOne(queryWrapper);
        if(zhixunshiYuyueEntity==null){
            zhixunshiYuyueService.updateById(zhixunshiYuyue);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZhixunshiYuyueEntity> oldZhixunshiYuyueList =zhixunshiYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        zhixunshiYuyueService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ZhixunshiYuyueEntity> zhixunshiYuyueList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZhixunshiYuyueEntity zhixunshiYuyueEntity = new ZhixunshiYuyueEntity();
//                            zhixunshiYuyueEntity.setZhixunshiId(Integer.valueOf(data.get(0)));   //咨询师 要改的
//                            zhixunshiYuyueEntity.setZhixunshiYuyueTime(sdf.parse(data.get(0)));          //预约时间 要改的
//                            zhixunshiYuyueEntity.setZhixunshiYuyueText(data.get(0));                    //备注 要改的
//                            zhixunshiYuyueEntity.setInsertTime(date);//时间
//                            zhixunshiYuyueEntity.setCreateTime(date);//时间
                            zhixunshiYuyueList.add(zhixunshiYuyueEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        zhixunshiYuyueService.insertBatch(zhixunshiYuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = zhixunshiYuyueService.queryPage(params);

        //字典表数据转换
        List<ZhixunshiYuyueView> list =(List<ZhixunshiYuyueView>)page.getList();
        for(ZhixunshiYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhixunshiYuyueEntity zhixunshiYuyue = zhixunshiYuyueService.selectById(id);
            if(zhixunshiYuyue !=null){


                //entity转view
                ZhixunshiYuyueView view = new ZhixunshiYuyueView();
                BeanUtils.copyProperties( zhixunshiYuyue , view );//把实体数据重构到view中

                //级联表
                    ZhixunshiEntity zhixunshi = zhixunshiService.selectById(zhixunshiYuyue.getZhixunshiId());
                if(zhixunshi != null){
                    BeanUtils.copyProperties( zhixunshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZhixunshiId(zhixunshi.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ZhixunshiYuyueEntity zhixunshiYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zhixunshiYuyue:{}",this.getClass().getName(),zhixunshiYuyue.toString());
        Wrapper<ZhixunshiYuyueEntity> queryWrapper = new EntityWrapper<ZhixunshiYuyueEntity>()
            .eq("zhixunshi_id", zhixunshiYuyue.getZhixunshiId())
            .eq("zhixunshi_yuyue_text", zhixunshiYuyue.getZhixunshiYuyueText())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhixunshiYuyueEntity zhixunshiYuyueEntity = zhixunshiYuyueService.selectOne(queryWrapper);
        if(zhixunshiYuyueEntity==null){
            zhixunshiYuyue.setInsertTime(new Date());
            zhixunshiYuyue.setCreateTime(new Date());
        zhixunshiYuyueService.insert(zhixunshiYuyue);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
