package com.itmei.mobile;

import org.junit.Test;

//import com.cdp.product.security.encode.CdpEncryptUtil;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobileTest {

    @Test
    public void testMobiles(){
        // 不在网的问题

        String[] strings = {"18296137284",
                "15159560629",
                "15880170751",
                "18957953658",
                "18286189923",
                "13601033845",
                "15959367175",
                "18474078937",
                "18579799726",
                "18929253492",
                "18473899424",
                "18374104954",
                "18216464475",
                "18473862164",
                "17155941837",
                "18473437689",
                "18473802464",
                "18474769459",
                "18474767247",
                "18474634370"};
            // 无语音能力的数据
//        String[] strings = {"15584240072",
//                        "18482378436",
//                        "15584216104",
//                        "18702820553",
//                        "15543558014",
//                        "18702814660",
//                        "15504423847",
//                        "15568985834",
//                        "15567746649",
//                        "15708407982",
//                        "15543772945",
//                        "15543451976",
//                        "18781923060",
//                        "15543673441",
//                        "15604434348",
//                        "17056161304",
//                        "17056297997",
//                        "17056460326",
//                        "18473826952",
//                        "17056211070"};
// 欠费的数据
//        String[] strings = {
//                "18870954712",
//                        "18239619200",
//                        "18285501778",
//                        "15779762717",
//                        "17183147949",
//                        "13095704157",
//                        "13083943743",
//                        "17129517874",
//                        "18405376741",
//                        "17152696884",
//                        "17187277511",
//                        "17195808485",
//                        "17187277594",
//                        "17172237431",
//                        "17198295839",
//                        "17183478492",
//                        "17166045274",
//                        "17184650482",
//                        "17195562637",
//                        "17195522876"
//        };
// 正常的数据
//        String[] strings = {
//                "13755819970",
//                        "17338158205",
//                        "18579112681",
//                        "18172995758",
//                        "13805935922",
//                        "13767084896",
//                        "15695906766",
//                        "15260959937",
//                        "18259109570",
//                        "13648160945",
//                        "13631368057",
//                        "18107966866",
//                        "15980264028",
//                        "13960303085",
//                        "13696962600",
//                        "18179867128",
//                        "18581554988",
//                        "13809545784",
//                        "13720878951",
//                        "15892052595"
//        };
        // 长时间关机数据
//        String[] strings = {
//                "17132988048",
//                        "17050596863",
//                        "17056467016",
//                        "17190475054",
//                        "17180509354",
//                        "18482156314",
//                        "18474051531",
//                        "17194219641",
//                        "17050694883",
//                        "17080947554",
//                        "17175423406",
//                        "17056461569",
//                        "15070167566",
//                        "17183129310",
//                        "17056243019",
//                        "17050731006",
//                        "17056211618",
//                        "17050695241",
//                        "17056397800",
//                        "17056398466"
//        };
        //
//        String[] strings = {
//                        "18482156314",
//        };
        for (int i=0;i<strings.length;i++){
            testAMobile(strings[i]);
        }


    }

    public void testAMobile(String mobile){
        //接口地址 没有购买此接口
//        String url = "http://api.chinadatapay.com/trade/user/1985";
        // 移动地址
//        String url = "http://api.chinadatapay.com/communication/message/2069";
        // 全网地址 不能用
        String url = "http://api.chinadatapay.com/communication/personal/2065";
        //请求参数
        Map<String, Object> params = new HashMap<>();
        //输入数据宝提供的 key
        params.put("key", "3553253dbf6eeb7e419bf20ab8aa9c99");
        //输入局被查询手机号码
        params.put("mobile", mobile);
        String result = null;
        try {
            result = post(url, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("mobile:\n"+mobile+"result:\n" + result);

        // 加密处理

//        //秘钥
//        String secretKey = "lgJKiiakuplMXy4s";
//        //入参集合 针对入参 value 值进行加密
//        Map<String, String> param = new HashMap<>();
//        param.put("name", CdpEncryptUtil.aesEncrypt("谢天浩", secretKey));
//        param.put("idcard", CdpEncryptUtil.aesEncrypt("342623198610025939", secretKey));
//        param.put("mobile", CdpEncryptUtil.aesEncrypt("15000639994", secretKey));
//        param.put("timestamp", CdpEncryptUtil.aesEncrypt(System.currentTimeMillis() + "" , secretKey));
//        //获取 sign 签名
//        String sign = CdpSignUtil.sign(param);
//        //返回各种加解密签名结果
//        System.out.println(String.format("入参集合:\n%s", param));
//        System.out.println(String.format("获取 sign 值:\n%s", sign));
//        System.out.print(String.format("返回结果解密:\n%s", CdpDecryptUtil.aesDecrypt("81hwJ3Fzj4De9fNJccustQ==", secretKey)));
//

    }

    public static String post(String url, Map<String, Object> params) throws Exception {
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        return PostHttpRequest(url, pairs);
    }

    public static String PostHttpRequest(String Url, List<NameValuePair> params) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
//超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(300000).setConnectTimeout(300000).build();
        String result = null;
        try {
            HttpPost request = new HttpPost(Url);
            request.setConfig(requestConfig);
            request.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            HttpResponse respones = client.execute(request);
            if (respones.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(respones.getEntity(), "UTF-8"); }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return result;

    }

    private static ArrayList<NameValuePair> covertParams2NVPS(Map<String, Object> params) {
        ArrayList<NameValuePair> pairs = new ArrayList<>();
        if (params == null || params.size() == 0) {
            return pairs; }
        for (Map.Entry<String, Object> param : params.entrySet()) {
            Object value = param.getValue();
            if (value instanceof String[]) {
                String[] values = (String[]) value;
                for (String v : values) {
                    pairs.add(new BasicNameValuePair(param.getKey(), v));
                }
            } else {
                if (value instanceof Integer) {
                    value = Integer.toString((Integer) value);
                } else if (value instanceof Long) {
                    value = Long.toString((Long) value);
                }
                pairs.add(new BasicNameValuePair(param.getKey(), (String) value));
            }
        }
        return pairs;
    }

}
