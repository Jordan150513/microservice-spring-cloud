package com.itmei.common.util;

/**
 * Created by qiaodan on 2018/5/11.
 */
public class RedisUtil {
//    private JedisSentinelPool jedisPool;//写操作
//    private JedisSentinelPool jedisReadPool;//读操作
//
//    public JedisSentinelPool getJedisReadPool() {
//        return jedisReadPool;
//    }
//
//    public void setJedisReadPool(JedisSentinelPool jedisReadPool) {
//        this.jedisReadPool = jedisReadPool;
//    }
//
//
//    public JedisSentinelPool getJedisPool() {
//        return jedisPool;
//    }
//
//    public void setJedisPool(JedisSentinelPool jedisPool) {
//        this.jedisPool = jedisPool;
//    }
//
//    //返还到连接池
//    public void close(Jedis jedis){
//        if(jedis!=null){
//            jedis.close();
//        }
//    }
//    /**
//     * 向redis存入key和value,并释放连接资源
//     * 如果key已经存在 则覆盖
//     * @param key
//     * @param value
//     * @return 成功 返回OK 失败返回 0
//     */
//    public String set(String key, String value) throws Exception {
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            return jedis.set(key, value);
//
//        }catch (Exception e) {
//            //jedis//过期替换jedis.close();替代
//            e.printStackTrace();
//            return "0";
//        }
//        finally {
//            close(jedis);
//        }
//    }
//    /**
//     * 向缓存中设置对象
//     * @param key
//     * @param value
//     * @return
//     */
//    public String set(String key,Object value){
//        Jedis jedis =null;
//        try{
//            jedis = jedisPool.getResource();
//            return jedis.set(key.getBytes(), SerializationUtil.serialize(value));
//        }catch(Exception e){
//            return "0";
//        }
//        finally{
//            close(jedis);
//        }
//    }
//    /**
//     *  向缓存中设置对象并制定这个键值的有效期
//     * @param key
//     * @param value
//     * @param seconds 单位:秒
//     * @return 成功返回OK 失败和异常返回0
//     */
//    public String set(String key,Object value,int seconds){
//        Jedis jedis =null;
//        try{
//            jedis = jedisPool.getResource();
//            return jedis.setex(key.getBytes(),seconds, SerializationUtil.serialize(value));
//        }catch(Exception e){
//            return "0";
//        }
//        finally{
//            close(jedis);
//        }
//    }
//    /**
//     * 通过key获取储存在redis中的value
//     * 并释放连接
//     * @param key
//     * @return 成功返回value 失败返回null
//     */
//
//    public String get(String key) throws Exception  {
//
//        Jedis jedis = null;
//        String value = null;
//        try {
//            jedis = jedisReadPool.getResource();
//            value= jedis.get(key);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        finally {
//
//            close(jedis);
//        }
//        return value;
//    }
//    /**
//     * 根据key 获取对象
//     * @param key
//     * @return
//     */
//    @SuppressWarnings("unchecked")
//    public Object  getObj(String key){
//        Jedis jedis = null;
//        try {
//            jedis = jedisReadPool.getResource();
//            if(jedis.exists(key.getBytes()))
//                return SerializationUtil.deserialize(jedis.get(key.getBytes()));
//            return null;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }finally{
//            close(jedis);
//        }
//    }
//
//
//
//    /**
//     *  删除指定的key,也可以传入一个包含key的数组
//     * @param keys 一个key  也可以使 string 数组
//     * @return 返回删除成功的个数
//     */
//    public Long del(String...keys){
//        Jedis jedis = null;
//        try {
//            jedis=jedisPool.getResource();
//            return jedis.del(keys);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0L;
//        }finally{
//            close(jedis);
//        }
//
//    }
//    /**
//     *  通过key向指定的value值追加值
//     * @param key
//     * @param str
//     * @return 成功返回 添加后value的长度 失败 返回 添加的 value 的长度  异常返回0L
//     */
//    public Long append(String key,String str){
//        Jedis jedis=null;
//        Long res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.append(key, str);
//        } catch (Exception e) {
//            return 0L;
//        }
//        finally{
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 判断key是否存在
//     * @param key
//     * @return true OR false
//     */
//    public Boolean exists(String key){
//        Jedis jedis = null;
//        try {
//            jedis = jedisReadPool.getResource();
//            return jedis.exists(key);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        } finally {
//            close(jedis);
//        }
//
//    }
//    /**
//     *  设置key value,如果key已经存在则返回0,nx==> not exist
//     * @param key
//     * @param value
//     * @return 成功返回1 如果存在 和 发生异常 返回 0
//     */
//    public Long setnx(String key ,String value){
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            return jedis.setnx(key, value);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0L;
//        } finally {
//            close(jedis);
//        }
//    }
//    /**
//     *  设置key value并制定这个键值的有效期
//     * @param key
//     * @param value
//     * @param seconds 单位:秒
//     * @return 成功返回OK 失败和异常返回null
//     */
//    public String setex(String key,String value,int seconds){
//        Jedis jedis = null;
//        String res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.setex(key, seconds, value);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     *  通过key 和offset 从指定的位置开始将原先value替换
//     *  下标从0开始,offset表示从offset下标开始替换
//     * 如果替换的字符串长度过小则会这样
//     *  example:
//     *  value : bigsea@eee.cn
//     *  str : abc
//     *  从下标7开始替换  则结果为
//     *  RES : bigsea.abc.cn
//     * @param key
//     * @param str
//     * @param offset 下标位置
//     * @return 返回替换后  value 的长度
//     */
//    public Long setrange(String key,String str,int offset){
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            return jedis.setrange(key, offset, str);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0L;
//        } finally {
//            close(jedis);
//        }
//    }
//    /**
//     *  通过批量的key获取批量的value
//     * @param keys string数组 也可以是一个key
//     * @return 成功返回value的集合, 失败返回null的集合 ,异常返回空
//     */
//    public List<String> mget(String...keys){
//        Jedis jedis = null;
//        List<String> values = null;
//        try {
//            jedis = jedisReadPool.getResource();
//            values = jedis.mget(keys);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return values;
//    }
//    /**
//     * 批量的设置key:value,可以一个
//     * example:
//     *   obj.mset(new String[]{"key2","value1","key2","value2"})
//     * @param keysvalues
//     * @return 成功返回OK 失败 异常 返回 null
//     *
//     */
//    public String mset(String...keysvalues){
//        Jedis jedis = null;
//        String res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.mset(keysvalues);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     *  批量的设置key:value,可以一个,如果key已经存在则会失败,操作会回滚
//     *  example:
//     *   obj.msetnx(new String[]{"key2","value1","key2","value2"})
//     * @param keysvalues
//     * @return 成功返回1 失败返回0
//     */
//    public Long msetnx(String...keysvalues){
//        Jedis jedis = null;
//        Long res = 0L;
//        try {
//            jedis = jedisPool.getResource();
//            res =jedis.msetnx(keysvalues);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 设置key的值,并返回一个旧值
//     * @param key
//     * @param value
//     * @return 旧值 如果key不存在 则返回null
//     */
//    public String getset(String key,String value){
//        Jedis jedis = null;
//        String res = null;
//        try {
//            jedis = jedisReadPool.getResource();
//            res = jedis.getSet(key, value);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 通过下标 和key 获取指定下标位置的 value
//     * @param key
//     * @param startOffset 开始位置 从0 开始 负数表示从右边开始截取
//     * @param endOffset
//     * @return 如果没有返回null
//     */
//    public String getrange(String key, int startOffset ,int endOffset){
//        Jedis jedis = null;
//        String res = null;
//        try {
//            jedis = jedisReadPool.getResource();
//            res = jedis.getrange(key, startOffset, endOffset);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     *  通过key 对value进行加值+1操作,当value不是int类型时会返回错误,当key不存在是则value为1
//     * @param key
//     * @return 加值后的结果
//     */
//    public Long incr(String key){
//        Jedis jedis = null;
//        Long res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.incr(key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 通过key给指定的value加值,如果key不存在,则这是value为该值
//     * @param key
//     * @param integer
//     * @return
//     */
//    public Long incrBy(String key,Long integer){
//        Jedis jedis = null;
//        Long res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.incrBy(key, integer);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 对key的值做减减操作,如果key不存在,则设置key为-1
//     * @param key
//     * @return
//     */
//    public Long decr(String key) {
//        Jedis jedis = null;
//        Long res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.decr(key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     *  减去指定的值
//     * @param key
//     * @param integer
//     * @return
//     */
//    public Long decrBy(String key,Long integer){
//        Jedis jedis = null;
//        Long res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.decrBy(key, integer);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 通过key获取value值的长度
//     * @param key
//     * @return 失败返回null
//     */
//    public Long serlen(String key){
//        Jedis jedis = null;
//        Long res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.strlen(key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 通过key给field设置指定的值,如果key不存在,则先创建
//     * @param key
//     * @param field 字段
//     * @param value
//     * @return 如果存在返回0 异常返回null
//     */
//    public Long hset(String key,String field,String value) {
//        Jedis jedis = null;
//        Long res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.hset(key, field, value);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 通过key给field设置指定的值,如果key不存在则先创建,如果field已经存在,返回0
//     * @param key
//     * @param field
//     * @param value
//     * @return
//     */
//    public Long hsetnx(String key,String field,String value){
//        Jedis jedis = null;
//        Long res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.hsetnx(key, field, value);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 通过key同时设置 hash的多个field
//     * @param key
//     * @param hash
//     * @return 返回OK 异常返回null
//     */
//    public String hmset(String key,Map<String, String> hash){
//        Jedis jedis = null;
//        String res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.hmset(key, hash);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 通过key 和 field 获取指定的 value
//     * @param key
//     * @param field
//     * @return 没有返回null
//     */
//    public String hget(String key, String field){
//        Jedis jedis = null;
//        String res = null;
//        try {
//            jedis = jedisReadPool.getResource();
//            res = jedis.hget(key, field);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 通过key 和 fields 获取指定的value 如果没有对应的value则返回null
//     * @param key
//     * @param fields 可以使 一个String 也可以是 String数组
//     * @return
//     */
//    public List<String> hmget(String key,String...fields){
//        Jedis jedis = null;
//        List<String> res = null;
//        try {
//            jedis = jedisReadPool.getResource();
//            res = jedis.hmget(key, fields);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 通过key给指定的field的value加上给定的值
//     * @param key
//     * @param field
//     * @param value
//     * @return
//     */
//    public Long hincrby(String key ,String field ,Long value){
//        Jedis jedis = null;
//        Long res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.hincrBy(key, field, value);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 通过key和field判断是否有指定的value存在
//     * @param key
//     * @param field
//     * @return
//     */
//    public Boolean hexists(String key , String field){
//        Jedis jedis = null;
//        Boolean res = false;
//        try {
//            jedis = jedisReadPool.getResource();
//            res = jedis.hexists(key, field);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 通过key返回field的数量
//     * @param key
//     * @return
//     */
//    public Long hlen(String key){
//        Jedis jedis = null;
//        Long res = null;
//        try {
//            jedis = jedisReadPool.getResource();
//            res = jedis.hlen(key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//
//    }
//    /**
//     * 通过key 删除指定的 field
//     * @param key
//     * @param fields 可以是 一个 field 也可以是 一个数组
//     * @return
//     */
//    public Long hdel(String key ,String...fields){
//        Jedis jedis = null;
//        Long res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.hdel(key, fields);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 通过key返回所有的field
//     * @param key
//     * @return
//     */
//    public Set<String> hkeys(String key){
//        Jedis jedis = null;
//        Set<String> res = null;
//        try {
//            jedis = jedisReadPool.getResource();
//            res = jedis.hkeys(key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 通过key返回所有和key有关的value
//     * @param key
//     * @return
//     */
//    public List<String> hvals(String key){
//        Jedis jedis = null;
//        List<String> res = null;
//        try {
//            jedis = jedisReadPool.getResource();
//            res = jedis.hvals(key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 通过key获取所有的field和value
//     * @param key
//     * @return
//     */
//    public Map<String, String> hgetall(String key){
//        Jedis jedis = null;
//        Map<String, String> res = null;
//        try {
//            jedis = jedisReadPool.getResource();
//            res = jedis.hgetAll(key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 通过key向list头部添加字符串
//     * @param key
//     * @param strs 可以使一个string 也可以使string数组
//     * @return 返回list的value个数
//     */
//    public Long lpush(String key ,String...strs){
//        Jedis jedis = null;
//        Long res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.lpush(key, strs);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 通过key向list尾部添加字符串
//     * @param key
//     * @param strs 可以使一个string 也可以使string数组
//     * @return 返回list的value个数
//     */
//    public Long rpush(String key ,String...strs){
//        Jedis jedis = null;
//        Long res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.rpush(key, strs);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//    /**
//     * 通过key在list指定的位置之前或者之后 添加字符串元素
//     * @param key
//     * @param where LIST_POSITION枚举类型
//     * @param pivot list里面的value
//     * @param value 添加的value
//     * @return
//     */
//    public Long linsert(String key, BinaryClient.LIST_POSITION where,
//                        String pivot, String value){
//        Jedis jedis = null;
//        Long res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.linsert(key, where, pivot, value);
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//
//    /**
//     * 通过key设置list指定下标位置的value
//     * 如果下标超过list里面value的个数则报错
//     * @param key
//     * @param index 从0开始
//     * @param value
//     * @return 成功返回OK
//     */
//    public String lset(String key ,Long index, String value){
//        Jedis jedis = null;
//        String res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.lset(key, index, value);
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//
//    /**
//     * 通过key从对应的list中删除指定的count个 和 value相同的元素
//     * @param key
//     * @param count 当count为0时删除全部
//     * @param value
//     * @return 返回被删除的个数
//     */
//    public Long lrem(String key,long count,String value){
//        Jedis jedis = null;
//        Long res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.lrem(key, count, value);
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//
//    /**
//     * 通过key保留list中从strat下标开始到end下标结束的value值
//     * @param key
//     * @param start
//     * @param end
//     * @return 成功返回OK
//     */
//    public String ltrim(String key ,long start ,long end){
//        Jedis jedis = null;
//        String res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.ltrim(key, start, end);
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//
//    /**
//     * 通过key从list的头部删除一个value,并返回该value
//     * @param key
//     * @return
//     */
//    public String lpop(String key){
//        Jedis jedis = null;
//        String res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.lpop(key);
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//
//    /**
//     * 通过key从list尾部删除一个value,并返回该元素
//     * @param key
//     * @return
//     */
//    public String rpop(String key){
//        Jedis jedis = null;
//        String res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.rpop(key);
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//
//    /**
//     * 通过key从一个list的尾部删除一个value并添加到另一个list的头部,并返回该value
//     * 如果第一个list为空或者不存在则返回null
//     * @param srckey
//     * @param dstkey
//     * @return
//     */
//    public String rpoplpush(String srckey, String dstkey){
//        Jedis jedis = null;
//        String res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.rpoplpush(srckey, dstkey);
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//
//    /**
//     * 通过key获取list中指定下标位置的value
//     * @param key
//     * @param index
//     * @return 如果没有返回null
//     */
//    public String lindex(String key,long index){
//        Jedis jedis = null;
//        String res = null;
//        try {
//            jedis = jedisReadPool.getResource();
//            res = jedis.lindex(key, index);
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//
//    /**
//     * 通过key返回list的长度
//     * @param key
//     * @return
//     */
//    public Long llen(String key){
//        Jedis jedis = null;
//        Long res = null;
//        try {
//            jedis = jedisReadPool.getResource();
//            res = jedis.llen(key);
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//
//    /**
//     * 通过key获取list指定下标位置的value
//     * 如果start 为 0 end 为 -1 则返回全部的list中的value
//     * @param key
//     * @param start
//     * @param end
//     * @return
//     */
//    public List<String> lrange(String key,long start,long end){
//        Jedis jedis = null;
//        List<String> res = null;
//        try {
//            jedis = jedisReadPool.getResource();
//            res = jedis.lrange(key, start, end);
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//
//    /**
//     * 通过key向指定的set中添加value
//     * @param key
//     * @param members 可以是一个String 也可以是一个String数组
//     * @return 添加成功的个数
//     */
//    public Long sadd(String key,String...members){
//        Jedis jedis = null;
//        Long res = null;
//        try {
//            jedis = jedisPool.getResource();
//            res = jedis.sadd(key, members);
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }
//
//    /**
//     * 通过key获取set中所有的value
//     * @param key
//     * @return
//     */
//    public Set<String> smembers(String key){
//        Jedis jedis = null;
//        Set<String> res = null;
//        try {
//            jedis = jedisReadPool.getResource();
//            res = jedis.smembers(key);
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        } finally {
//            close(jedis);
//        }
//        return res;
//    }

}
