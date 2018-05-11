package com.itmei.common.util;

import org.springframework.stereotype.Component;

/**
 * Created by qiaodan on 2018/5/11.
 */
@Component
public class RedisServiceUtil {
//    private static Logger logger = LogManager.getLogger(RedisServiceUtil.class);
//    @Value("${jedis.writehost}")
//    private static String WRITEHOST;
//    @Value("${jedis.readhost}")
//    private static String READHOST;
//    @Value("${jedis.port}")
//    private static int PORT;
//    @Value("${jedis.password}")
//    private static String PASSWORD;
//    @Value("${jedis.maxTotal}")
//    private static int MAX_TOTAL;
//    @Value("${jedis.maxIdle}")
//    private static int MAX_IDLE;
//    @Value("${jedis.maxWaitMillis}")
//    private static int MAX_WAIT;
//    @Value("${jedis.soTimeOut}")
//    private static int TIMEOUT;
//    @Value("${jedis.testOnBorrow}")
//    private static boolean TEST_ON_BORROW;
//
//    private static JedisPool jedisPoolRead = null;
//    private static JedisPool jedisPoolWrite = null;
//
//    private static Jedis jedisRead = null;
//    private static Jedis jedisWrite = null;
//    /**
//     * 初始化Redis连接池
//     */
//    static {
//        try {
//            init();
//        } catch (Exception e) {
//            logger.error("初始化Redis出错，" + e);
//        }
//    }
//    /**
//     * 初始化连接池
//     *
//     * @see [类、类#方法、类#成员]
//     */
//    private synchronized static void init() {
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxIdle(MAX_IDLE);
//        config.setMaxWaitMillis(MAX_WAIT);
//        config.setTestOnBorrow(TEST_ON_BORROW);
//        config.setMaxTotal(MAX_TOTAL);
//        jedisPoolRead = new JedisPool(config, READHOST, PORT, TIMEOUT, PASSWORD);
//        jedisPoolWrite = new JedisPool(config, WRITEHOST, PORT, TIMEOUT, PASSWORD);
//    }
//    /**
//     * 获取Jedis实例
//     *
//     * @return
//     */
//    private static Jedis getReadJedis() {
//        try {
//            if (jedisRead != null) {
//                jedisRead = jedisPoolRead.getResource();
//            } else {
//                init();
//                jedisRead = jedisPoolRead.getResource();
//            }
//        } catch (Exception e) {
//            logger.error("获取Redis实例出错，" + e);
//        }
//        return jedisRead;
//    }
//    /**
//     * 获取Jedis实例
//     *
//     * @return
//     */
//    private static Jedis getWriteJedis() {
//        try {
//            if (jedisWrite != null) {
//                jedisWrite = jedisPoolWrite.getResource();
//            } else {
//                init();
//                jedisWrite = jedisPoolWrite.getResource();
//            }
//        } catch (Exception e) {
//            logger.error("获取Redis实例出错，" + e);
//        }
//        return jedisWrite;
//    }
//    /**
//     * 设置单个值
//     *
//     * @param key
//     * @param value
//     * @return
//     */
//    public static String set(String key, String value) {
//        return set(key, value, null);
//    }
//    /**
//     * 设置单个值，并设置超时时间
//     *
//     * @param key
//     *            键
//     * @param value
//     *            值
//     * @param timeout
//     *            超时时间（秒）
//     * @return
//     * @see [类、类#方法、类#成员]
//     */
//    public static String set(String key, String value, Integer timeout) {
//        String result = null;
//
//        Jedis jedis = RedisServiceUtil.getWriteJedis();
//        if (jedis == null) {
//            return result;
//        }
//        try {
//            result = jedis.set(key, value);
//            if (null != timeout) {
//                jedis.expire(key, timeout);
//            }
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        } finally {
//            if (null != jedis) {
//                jedis.close();
//            }
//        }
//        return result;
//    }
//    /**
//     * 获取单个值
//     *
//     * @param key
//     * @return
//     */
//    public static String get(String key) {
//        String result = null;
//        Jedis jedis = RedisServiceUtil.getReadJedis();
//        if (jedis == null) {
//            return result;
//        }
//        try {
//            result = jedis.get(key);
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        } finally {
//            if (null != jedis) {
//                jedis.close();
//            }
//        }
//        return result;
//    }
//    /**
//     * 删除redis中数据
//     *
//     * @param key
//     * @return
//     * @see [类、类#方法、类#成员]
//     */
//    public static boolean del(String key) {
//        Boolean result = Boolean.FALSE;
//        Jedis jedis = RedisServiceUtil.getWriteJedis();
//        if (null == jedis) {
//            return Boolean.FALSE;
//        }
//        try {
//            jedis.del(key);
//        } catch (Exception e) {
//            logger.error("删除redis数据出错，" + e);
//        } finally {
//            if (null != jedis) {
//                jedis.close();
//            }
//        }
//        return result;
//    }
//    /**
//     * 追加
//     *
//     * @param key
//     * @param value
//     * @return
//     * @see [类、类#方法、类#成员]
//     */
//    public static Long append(String key, String value) {
//        Long result = Long.valueOf(0);
//        Jedis jedis = RedisServiceUtil.getWriteJedis();
//        if (null == jedis) {
//            return result;
//        }
//        try {
//            result = jedis.append(key, value);
//        } catch (Exception e) {
//            logger.error("追加redis数据出错，" + e);
//        } finally {
//            if (null != jedis) {
//                jedis.close();
//            }
//        }
//        return result;
//    }
//    /**
//     * 检测是否存在
//     *
//     * @param key
//     * @return
//     * @see [类、类#方法、类#成员]
//     */
//    public static Boolean exists(String key) {
//        Boolean result = Boolean.FALSE;
//        Jedis jedis =  RedisServiceUtil.getReadJedis();
//        if (null == jedis) {
//            return result;
//        }
//        try {
//            result = jedis.exists(key);
//        } catch (Exception e) {
//            logger.error("检查是否存在出错：，" + e);
//        } finally {
//            if (null != jedis) {
//                jedis.close();
//            }
//        }
//        return result;
//    }

}
