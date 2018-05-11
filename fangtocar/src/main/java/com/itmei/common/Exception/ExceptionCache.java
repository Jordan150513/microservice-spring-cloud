package com.itmei.common.Exception;

import org.springframework.stereotype.Component;

/**
 * Created by qiaodan on 2018/5/11.
 */
@Component
public class ExceptionCache {
//    @Autowired
//    private RedisUtil redisUtil;
//    @Autowired
//    private MailService mailService;
//
//    private static Logger logger = LoggerFactory.getLogger("接口异常邮件监控");
//
//    @Value("${http.error.cachekey}")
//    private String cacheKey;
//    @Value("${http.error.to}")
//    private  String mailto;
//    @Value("${http.error.title}")
//    private String errorTitle;//异常邮件主题
//    //线程信号量，控制同时 最多同时运行线程数
//    private Semaphore semaphore = new Semaphore(200,true);
//
//    /**
//     * 取所有本次缓存的api
//     *
//     * @return
//     */
//    public Set<String> getErrorApiList() {
//        Set<String> keyList = redisUtil.smembers(cacheKey);
//        return keyList==null? Collections.emptySet():keyList;
//    }
//
//    /**
//     * 添加异常信息到缓存
//     */
//    public void addExceptionToList(ErrorInfo errorInfo) {
//        try {
//            redisUtil.sadd(cacheKey, errorInfo.getUrl());// 把api错误信息放到集合
//            redisUtil.rpush(cacheKey + ":" + errorInfo.getUrl() + ":list", errorInfo.getMessage() +"\n  RequestMap:"+errorInfo.getUrl()+" \n 接口参数： " + JacksonUtil.toJSON(errorInfo.getData())); // 添加异常列表，返回记录数
//            if (redisUtil.incr(cacheKey + ":" + errorInfo.getUrl() + ":count") > 10) {
//                sendUrgentEmail(errorInfo.getUrl());
//                // DecreaseApiCount(errorInfo.getUrl());
//            } else {//
//                DecreaseApiCount(errorInfo.getUrl());
//            }
//        } catch (Exception e) {
//            logger.error("减小接口计数方法异常" + e.getLocalizedMessage());
//            redisUtil.decr(cacheKey + ":" + errorInfo.getUrl() + ":count");
//            return;
//        }
//    }
//
//    /**
//     * 异常记数到60秒时减1
//     * @param api
//     */
//    public void DecreaseApiCount(String api) {
//        new Thread() {
//            public void run() {
//                boolean canRun = false;
//                try {
//                    canRun = semaphore.tryAcquire(60, TimeUnit.SECONDS); //取线程运行准许信号，60S超时返回 false
//                } catch (Exception e) {
//                    System.out.println("异常计数线程中断！ api：" + api);
//                }
//                if (canRun) {
//                    try {
//                        String coun = redisUtil.get(cacheKey + ":" + api + ":count"); //判断是否发邮件后被清理了，如果已经没有记数，则不等待直接退出线程
//                        if (coun == null || Integer.parseInt(coun) <= 0) {
//                            //如果已经发过邮件，已经被清理不必等待了
//                        } else {
//                            Thread.sleep(60000); //ms 毫秒
//                            if (redisUtil.decr(cacheKey + ":" + api + ":count") < 0) {
//                                redisUtil.incr(cacheKey + ":" + api + ":count"); //如果这个键已经到0了，需要保持为0
//                            }
//                        }
//                    } catch (Exception e) {
//                        logger.error("接口异常计数错误：" + e.getLocalizedMessage());
//                    }
//                    finally {
//                        semaphore.release();//释放占用信号
//                    }
//                } else { //60秒超时或线程中断 直接减1
//                    if (redisUtil.decr(cacheKey + ":" + api + ":count") < 0) {
//                        redisUtil.incr(cacheKey + ":" + api + ":count"); //如果这个键已经到0了，需要保持为0
//                    }
//                }
//            }
//        }.start();
//    }
//
//    /**
//     * 清空api短时异常统计值
//     */
//    public void CleanApiCount() {
//        Set<String> keys=getErrorApiList();
//        if(keys==null||keys.isEmpty()) { //无数据不处理
//            return;
//        }
//        String allKey[]=new String[keys.size()];
//        int i=0;
//        for (String set:keys){
//            allKey[i]=cacheKey+":"+set+":count";
//            i++;
//        }
//        redisUtil.del(allKey);//cacheKey + ":" + key + ":count"); //如果这个键已经到0了，需要保持为0
//    }
//
//    /**
//     * 定时发送邮件 20分钟
//     */
//    @Scheduled(cron = "0 0/20 * * * ?")
//    public void sendEmail() {
//        new Thread(){
//            public void run(){
//                Set<String> keys = getErrorApiList();  //取已添加缓存的接口
//                boolean hasValue=false;
//                StringBuilder stringBuilder = new StringBuilder(errorTitle+"家居接口异常邮件 \n");// + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//                for (String key : keys) {
//                    List<String> erlist = redisUtil.lrange(cacheKey + ":" +key+":list", 0, -1); //取接口本次的报错信息
//                    if (erlist != null && !erlist.isEmpty()) {
//                        hasValue=true;
//                        stringBuilder.append("接口：" + key+" \n ==============================================\n");
//                        for (String msg : erlist) {         //如果有信息，存入字符串中
//                            stringBuilder.append(msg+"\n-----------------------------------------\n");
//                        }
//                        stringBuilder.append("===== 结束  ==============================================\n\n");
//                        redisUtil.ltrim(cacheKey + ":" +key+":list",erlist.size(),-1);  //把取出的错误清理掉
//                    }
//                    //  errList.put(key,)
//                }
//                try {
//                    if(hasValue) {
//                        mailService.sendSimpleMailAsync(mailto.split(","), errorTitle+"接口异常邮件监控", stringBuilder.toString());
//                        CleanApiCount();//清理异常统计
//                    }
//                }catch (Exception e){
//                    logger.error("接口异常邮件发送异常！"+e.getLocalizedMessage()+"\n"+stringBuilder.toString());
//                }
//            }
//        }.start();
//    }
//
//    /**
//     * 发送紧急邮件
//     */
//    public void sendUrgentEmail(String exception) {
//        StringBuilder stringBuilder = new StringBuilder("家居异常紧急邮件 \n");// + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//        try {
//            List<String> erlist = redisUtil.lrange(cacheKey + ":" +exception+":list", 0, -1); //取接口本次的报错信息
//            if (erlist != null && !erlist.isEmpty()) {
//                stringBuilder.append("接口：" + exception+" \n ==============================================\n");
//                for (String msg : erlist) {         //如果有信息，存入字符串中
//                    stringBuilder.append(msg+"\n-----------------------------------------\n");
//                }
//                stringBuilder.append(" End  ==============================================\n\n");
//                redisUtil.ltrim(cacheKey + ":" +exception+":list",erlist.size(),-1);  //把取出的错误清理掉
//                redisUtil.del(cacheKey + ":" +exception+":count");   ///删除计数，不然会一直在
//            }
//            mailService.sendSimpleMailAsync(mailto.split(","), "接口异常紧急邮件", stringBuilder.toString());
//        }catch (Exception e){
//            logger.error("接口异常邮件发送异常！"+e.getLocalizedMessage()+"\n"+stringBuilder.toString());
//        }
//    }
}
