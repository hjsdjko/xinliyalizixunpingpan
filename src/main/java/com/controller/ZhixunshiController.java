
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
 * 咨询师
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhixunshi")
public class ZhixunshiController {
    private static final Logger logger = LoggerFactory.getLogger(ZhixunshiController.class);

    private static final String TABLE_NAME = "zhixunshi";

    @Autowired
    private ZhixunshiService zhixunshiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    //注册表service
    @Autowired
    private YonghuService yonghuService;


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
        params.put("zhixunshiDeleteStart",1);params.put("zhixunshiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = zhixunshiService.queryPage(params);

        //字典表数据转换
        List<ZhixunshiView> list =(List<ZhixunshiView>)page.getList();
        for(ZhixunshiView c:list){
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
        ZhixunshiEntity zhixunshi = zhixunshiService.selectById(id);
        if(zhixunshi !=null){
            //entity转view
            ZhixunshiView view = new ZhixunshiView();
            BeanUtils.copyProperties( zhixunshi , view );//把实体数据重构到view中
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
    public R save(@RequestBody ZhixunshiEntity zhixunshi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhixunshi:{}",this.getClass().getName(),zhixunshi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhixunshiEntity> queryWrapper = new EntityWrapper<ZhixunshiEntity>()
            .eq("username", zhixunshi.getUsername())
            .or()
            .eq("zhixunshi_phone", zhixunshi.getZhixunshiPhone())
            .or()
            .eq("zhixunshi_id_number", zhixunshi.getZhixunshiIdNumber())
            .andNew()
            .eq("zhixunshi_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhixunshiEntity zhixunshiEntity = zhixunshiService.selectOne(queryWrapper);
        if(zhixunshiEntity==null){
            zhixunshi.setZhixunshiDelete(1);
            zhixunshi.setCreateTime(new Date());
            zhixunshi.setPassword("123456");
            zhixunshiService.insert(zhixunshi);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式或者身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhixunshiEntity zhixunshi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zhixunshi:{}",this.getClass().getName(),zhixunshi.toString());
        ZhixunshiEntity oldZhixunshiEntity = zhixunshiService.selectById(zhixunshi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ZhixunshiEntity> queryWrapper = new EntityWrapper<ZhixunshiEntity>()
            .notIn("id",zhixunshi.getId())
            .andNew()
            .eq("username", zhixunshi.getUsername())
            .or()
            .eq("zhixunshi_phone", zhixunshi.getZhixunshiPhone())
            .or()
            .eq("zhixunshi_id_number", zhixunshi.getZhixunshiIdNumber())
            .andNew()
            .eq("zhixunshi_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhixunshiEntity zhixunshiEntity = zhixunshiService.selectOne(queryWrapper);
        if("".equals(zhixunshi.getZhixunshiPhoto()) || "null".equals(zhixunshi.getZhixunshiPhoto())){
                zhixunshi.setZhixunshiPhoto(null);
        }
        if(zhixunshiEntity==null){
            zhixunshiService.updateById(zhixunshi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式或者身份证号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZhixunshiEntity> oldZhixunshiList =zhixunshiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ZhixunshiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ZhixunshiEntity zhixunshiEntity = new ZhixunshiEntity();
            zhixunshiEntity.setId(id);
            zhixunshiEntity.setZhixunshiDelete(2);
            list.add(zhixunshiEntity);
        }
        if(list != null && list.size() >0){
            zhixunshiService.updateBatchById(list);
        }

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
            List<ZhixunshiEntity> zhixunshiList = new ArrayList<>();//上传的东西
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
                            ZhixunshiEntity zhixunshiEntity = new ZhixunshiEntity();
//                            zhixunshiEntity.setUsername(data.get(0));                    //账户 要改的
//                            //zhixunshiEntity.setPassword("123456");//密码
//                            zhixunshiEntity.setZhixunshiName(data.get(0));                    //咨询师姓名 要改的
//                            zhixunshiEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            zhixunshiEntity.setZhixunshiPhoto("");//详情和图片
//                            zhixunshiEntity.setZhixunshiIdNumber(data.get(0));                    //身份证号 要改的
//                            zhixunshiEntity.setZhixunshiPhone(data.get(0));                    //联系方式 要改的
//                            zhixunshiEntity.setZhixunshiEmail(data.get(0));                    //电子邮箱 要改的
//                            zhixunshiEntity.setZhixunshiCongye(data.get(0));                    //从业时长 要改的
//                            zhixunshiEntity.setZhixunshiShanchang(data.get(0));                    //擅长 要改的
//                            zhixunshiEntity.setZhixunshiContent("");//详情和图片
//                            zhixunshiEntity.setZhixunshiDelete(1);//逻辑删除字段
//                            zhixunshiEntity.setCreateTime(date);//时间
                            zhixunshiList.add(zhixunshiEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //身份证号
                                if(seachFields.containsKey("zhixunshiIdNumber")){
                                    List<String> zhixunshiIdNumber = seachFields.get("zhixunshiIdNumber");
                                    zhixunshiIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhixunshiIdNumber = new ArrayList<>();
                                    zhixunshiIdNumber.add(data.get(0));//要改的
                                    seachFields.put("zhixunshiIdNumber",zhixunshiIdNumber);
                                }
                                //联系方式
                                if(seachFields.containsKey("zhixunshiPhone")){
                                    List<String> zhixunshiPhone = seachFields.get("zhixunshiPhone");
                                    zhixunshiPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> zhixunshiPhone = new ArrayList<>();
                                    zhixunshiPhone.add(data.get(0));//要改的
                                    seachFields.put("zhixunshiPhone",zhixunshiPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<ZhixunshiEntity> zhixunshiEntities_username = zhixunshiService.selectList(new EntityWrapper<ZhixunshiEntity>().in("username", seachFields.get("username")).eq("zhixunshi_delete", 1));
                        if(zhixunshiEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhixunshiEntity s:zhixunshiEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //身份证号
                        List<ZhixunshiEntity> zhixunshiEntities_zhixunshiIdNumber = zhixunshiService.selectList(new EntityWrapper<ZhixunshiEntity>().in("zhixunshi_id_number", seachFields.get("zhixunshiIdNumber")).eq("zhixunshi_delete", 1));
                        if(zhixunshiEntities_zhixunshiIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhixunshiEntity s:zhixunshiEntities_zhixunshiIdNumber){
                                repeatFields.add(s.getZhixunshiIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //联系方式
                        List<ZhixunshiEntity> zhixunshiEntities_zhixunshiPhone = zhixunshiService.selectList(new EntityWrapper<ZhixunshiEntity>().in("zhixunshi_phone", seachFields.get("zhixunshiPhone")).eq("zhixunshi_delete", 1));
                        if(zhixunshiEntities_zhixunshiPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhixunshiEntity s:zhixunshiEntities_zhixunshiPhone){
                                repeatFields.add(s.getZhixunshiPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhixunshiService.insertBatch(zhixunshiList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ZhixunshiEntity zhixunshi = zhixunshiService.selectOne(new EntityWrapper<ZhixunshiEntity>().eq("username", username));
        if(zhixunshi==null || !zhixunshi.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(zhixunshi.getZhixunshiDelete() != 1)
            return R.error("账户已被删除");
        String token = tokenService.generateToken(zhixunshi.getId(),username, "zhixunshi", "咨询师");
        R r = R.ok();
        r.put("token", token);
        r.put("role","咨询师");
        r.put("username",zhixunshi.getZhixunshiName());
        r.put("tableName","zhixunshi");
        r.put("userId",zhixunshi.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ZhixunshiEntity zhixunshi, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<ZhixunshiEntity> queryWrapper = new EntityWrapper<ZhixunshiEntity>()
            .eq("username", zhixunshi.getUsername())
            .or()
            .eq("zhixunshi_id_number", zhixunshi.getZhixunshiIdNumber())
            .or()
            .eq("zhixunshi_phone", zhixunshi.getZhixunshiPhone())
            .andNew()
            .eq("zhixunshi_delete", 1)
            ;
        ZhixunshiEntity zhixunshiEntity = zhixunshiService.selectOne(queryWrapper);
        if(zhixunshiEntity != null)
            return R.error("账户或者联系方式或者身份证号已经被使用");
        zhixunshi.setZhixunshiDelete(1);
        zhixunshi.setCreateTime(new Date());
        zhixunshiService.insert(zhixunshi);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        ZhixunshiEntity zhixunshi = zhixunshiService.selectById(id);
        zhixunshi.setPassword("123456");
        zhixunshiService.updateById(zhixunshi);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        ZhixunshiEntity zhixunshi = zhixunshiService.selectOne(new EntityWrapper<ZhixunshiEntity>().eq("username", username));
        if(zhixunshi!=null){
            zhixunshi.setPassword("123456");
            boolean b = zhixunshiService.updateById(zhixunshi);
            if(!b){
               return R.error();
            }
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrZhixunshi(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ZhixunshiEntity zhixunshi = zhixunshiService.selectById(id);
        if(zhixunshi !=null){
            //entity转view
            ZhixunshiView view = new ZhixunshiView();
            BeanUtils.copyProperties( zhixunshi , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = zhixunshiService.queryPage(params);

        //字典表数据转换
        List<ZhixunshiView> list =(List<ZhixunshiView>)page.getList();
        for(ZhixunshiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhixunshiEntity zhixunshi = zhixunshiService.selectById(id);
            if(zhixunshi !=null){


                //entity转view
                ZhixunshiView view = new ZhixunshiView();
                BeanUtils.copyProperties( zhixunshi , view );//把实体数据重构到view中

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
    public R add(@RequestBody ZhixunshiEntity zhixunshi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zhixunshi:{}",this.getClass().getName(),zhixunshi.toString());
        Wrapper<ZhixunshiEntity> queryWrapper = new EntityWrapper<ZhixunshiEntity>()
            .eq("username", zhixunshi.getUsername())
            .or()
            .eq("zhixunshi_id_number", zhixunshi.getZhixunshiIdNumber())
            .or()
            .eq("zhixunshi_phone", zhixunshi.getZhixunshiPhone())
            .andNew()
            .eq("zhixunshi_delete", 1)
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhixunshiEntity zhixunshiEntity = zhixunshiService.selectOne(queryWrapper);
        if(zhixunshiEntity==null){
            zhixunshi.setZhixunshiDelete(1);
            zhixunshi.setCreateTime(new Date());
        zhixunshi.setPassword("123456");
        zhixunshiService.insert(zhixunshi);

            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式或者身份证号已经被使用");
        }
    }

}
