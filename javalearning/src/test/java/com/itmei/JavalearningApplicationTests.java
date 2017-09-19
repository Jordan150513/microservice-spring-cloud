package com.itmei;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.itmei.adapter.HoleMaker;
import com.itmei.adapter.HoleMakerImpl;
import com.itmei.builder.Programmer;
import com.itmei.command.Administrator;
import com.itmei.command.Server;
import com.itmei.command.StartApache;
import com.itmei.command.StartTomcat;
import com.itmei.composite.*;
import com.itmei.decoration.BlackCoffee;
import com.itmei.decoration.Coffee;
import com.itmei.decoration.MilkDecorator;
import com.itmei.decoration.SugarDecorator;
import com.itmei.factory.Meal;
import com.itmei.observer.PageOpener;
import com.itmei.observer.Register;
import com.itmei.prototype.*;
import com.itmei.proxy.Gunman;
import com.itmei.proxy.LazyStudent;
import com.itmei.proxyfactory.BeforeConstructAdvice;
import com.itmei.proxyfactory.Construction;
import com.itmei.proxyfactory.House;
import com.itmei.template.EcologicalHouse;
import com.itmei.template.HouseAbstract;
import com.itmei.template.SeaHouse;
import com.itmei.visit.*;
import com.swetake.util.Qrcode;
import jp.sourceforge.qrcode.exception.DecodingFailedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavalearningApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void numbers() {
        // 记得看过一个文章 100 之内的 做了缓存 所以两个变量是一样的，但是100 之外的 是没有做缓存，两个变量是不相等的。。。但是为啥 不是呢？

//        int a = 100;
//        int b = 100;
//        int c = 10000;
//        int d = 10000;

        // 上下两种情况是不一样的

        Integer a = 100;
        Integer b = 100;
        Integer c = 10000;
        Integer d = 10000;

        // 这里是两个对象的指针进行判断的 判断的是对象的指针
        System.out.println(a == b);
        System.out.println(c == d);

        // equals 判断的是对象的值 类型和value
        System.out.println(a.equals(b));
        System.out.println(c.equals(d));
    }

    @Test
    public void seperateWithRegu() {

//		'1231231321'.replace(/(\d)(?=(\d{4})+(?!\d))/g, '$1' + ',');
        String string = "123456789";
        // 二狗给的最原始版本的正则表达式 js的语法
//		String pattern = "/(\\d)(?=(\\d{4})+(?!\\d))/g";
        // 正向预查 反向预查
        String pattern = "(\\d)(?=(\\d{3})+(?!\\d))";
        String str1 = "123456789";
        System.out.print(str1.replaceAll(pattern, "$1" + ","));
        System.out.print("\n");

    }

    @Test
    public void testGroup() {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }
    }

    // Date 和 Calendar 之间的转换 并且 实现月日等加减，可以自己实现进位 退位
    @Test
    public void testDateCanlender() {

        long current = System.currentTimeMillis();
        long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();
//		Date startDate = (Date)new Timestamp(zero);

        Date startDate = new Date();
        startDate.setHours(0);
        startDate.setMinutes(0);
        startDate.setSeconds(0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("00000000000000000   " + dateFormat.format(startDate));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.MONTH, 6);

        Date endDate = calendar.getTime(); // 设置结束时间
        endDate.setHours(23);
        endDate.setMinutes(59);
        endDate.setSeconds(59);
        System.out.println("00000000000000000   " + dateFormat.format(endDate));
    }

    @Test
    public void sortMethod() throws IOException {
        // quick sort
        // 需要考虑周全的两点：
        // 1、临近的元素交换之后，游标不会有相等相遇的情况出现就越过彼此了会出现左边游标大于了右边的游标
        // 2、交换之后 两端向各自方向更新游标
        int[] dataArr = {1, 45, 3, 67, 90, 9, 33, 68, 2, 6, 88, 22, 6};

        System.out.println("you input numbers: ");
        this.printNumbers(dataArr);
        // 开始位置和结束位置
        int start = 0;
        int end = dataArr.length - 1;
        quickSort(start, end, dataArr);

    }

    public void quickSort(int start, int end, int[] dataArr) {
        // 基准
        int p = start;
        // 游标变量
        int i = start;
        int j = end;

        while (i < j) {
            while (dataArr[j] >= dataArr[p] && i < j) {
                j--;
            }
            while (dataArr[i] <= dataArr[p] && i < j) {
                i++;
            }
            if (i < j) {
                int tmp = dataArr[i];
                dataArr[i] = dataArr[j];
                dataArr[j] = tmp;
                i++;// 这里经常忘记操作
                j--;
            }
        }
        if (i >= j) {// 这里需要考虑周全，有可能两个临近的元素交换了之后，两个越过彼此
            // 一次排序结束了
            int tmp = dataArr[p];
            dataArr[p] = dataArr[j];
            dataArr[j] = tmp;
            printNumbers(dataArr);
            p = j;
        }
        // 进行分两边递归的快排
        if (start < p - 1) {
            quickSort(start, p - 1, dataArr);
        }
        if (p + 1 < end) {
            quickSort(p + 1, end, dataArr);
        }
        System.out.println("finally:");
        printNumbers(dataArr);
    }


    public void printNumbers(int[] dataArr) {
        for (int i = 0; i < dataArr.length; i++) {
            System.out.print(dataArr[i] + " ");
            System.out.println("");
        }
    }


    // 回文判断
    @Test
    public void testPalindrome() {

        char[] a = {'a', 'b', 'c', 'd', 'e', 'd', 'c', 'b', 'a'};
        char[] stack = new char[10];
        int top = 0;

        int mid = a.length / 2;

        for (int i = 0; i < mid; i++) {
            int tmp = a[i];
            stack[top++] = a[i];
        }

        boolean isPalindrome = true;
        for (int j = mid + 1; j < a.length - 1; j++) {
            char left = a[j];
            char right = stack[top--];
            if (left == right) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("the char arr is a Palindrome");
        } else {
            System.out.println("the char arr is not a Palindrome");
        }
    }


    // 小猫钓鱼demo
    public void catFish() {
        int[] a = {2, 4, 1, 2, 5, 6};
        int[] b = {3, 1, 3, 5, 6, 4};


        int[] stack = new int[15];
        int top = 0;

        do {

        } while (a.length > 0 && b.length > 0);
    }


    // String 是不可变类  明明是可变的哇？
    @Test
    public void testString() {
        String string = "unmutable";
        System.out.println(string);
        string = string + " changed";
        System.out.println(string);
    }

    @Test
    public void testInteger() {
        System.out.println("refresh equal:");

        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);  // true
        System.out.println(f3 == f4);  //false

        System.out.println("Integer and int");

        Integer a = new Integer(3);
        Integer b = 3;
        int c = 3;
        System.out.println(a == b);
        System.out.println(a == c);
    }

    @Test
    public void testABHello() {
        A ab = new B();
        ab = new B();
        System.out.println(ab);
    }

    // binary search 二分查找
    @Test
    public void testBinarySearch() {
        System.out.println("binarySearch: ");
        Integer[] intArr = {1, 2, 3, 4, 5, 7, 22, 30, 39, 44, 67, 90, 123, 245, 678, 1000};
        int location = binarySearch(intArr, 22);
        System.out.println("location: " + location);
    }

    public <T extends Comparable<T>> int binarySearch(T[] x, T key) {
        return binarySearch(x, 0, x.length - 1, key);
    }

    public <T extends Comparable<T>> int binarySearch(T[] x, int low, int high, T key) {
        if (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (key.compareTo(x[mid]) == 0) {
                return mid;
            } else if (key.compareTo(x[mid]) < 0) {
                return binarySearch(x, low, mid - 1, key);
            } else {
                return binarySearch(x, mid + 1, high, key);
            }
        }
        return -1;
    }


    // while 循环实现  这个如何使用？
    public <T> int binarySearch(T[] x, T key, Comparator<T> comp) {
        int low = 0;
        int high = x.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = comp.compare(x[mid], key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 测试 代理模式 第一种 lazyStudent没有办法做一些事情 让gunman帮他做了一些 他做不到的事情

    @Test
    public void testProxy() {
        LazyStudent lazyStudent = new LazyStudent("ergouzi");
        Gunman gunman = new Gunman(lazyStudent);
        gunman.answerTheQuestions();
    }

    // 测试 代理 第二种 代理工厂
    // 代理是封装真实对象的对象。例如，如果您尝试调用Waiter bean，那么您将调用该Bean的代理，其行为方式完全相同。
    @Test
    public void testProxyFactory() {

        // 指定代理的 具体对象类 接口的具体实现类
        ProxyFactory factory = new ProxyFactory(new House());
        // 指定代理 的接口
        factory.addInterface(Construction.class);
        // 指定面向编程的 增强点 可以预先做一些操作
        factory.addAdvice(new BeforeConstructAdvice());
        factory.setExposeProxy(true);
        //  接口对象
        Construction construction = (Construction) factory.getProxy();
        construction.construct();
        assertTrue("Construction is illegal. "
                + "Supervisor didn't give a permission to build "
                + "the house", construction.isPermitted());

    }

    // 代理模式： A无法完成某个操作 让B去帮A做这个操作

    @Test
    public void testEquals() {

        System.out.println("Object new String() equals and == ");
        Object s1 = new String("Hello");
        Object s2 = new String("Hello");

        if (s1 == s2) {
            System.out.println("s1 and s2 are ==");
        } else if (s1.equals(s2)) {
            System.out.println("s1 and s2 are equals()");
        }

        System.out.println("constant String equals and == ");

        Object s3 = "Hello";
        Object s4 = "Hello";

        if (s3 == s4) {
            System.out.println("s3 and s4 are ==");
        } else if (s3.equals(s4)) {
            System.out.println("s3 and s4 are equals()");
        }
    }

    // 二维码测试
    @Test
    public void testQRCode() {

        /**
         *    QRcode 二维码生成测试
         *    QRCodeUtil.QRCodeCreate("http://blog.csdn.net/u014266877", "E://qrcode.jpg", 15, "E://icon.png");
         */
//         QRCodeCreate("http://www.baidu.com", "E://qrcode.jpg", 15, "E://miao.JPEG");

        /**
         *     QRcode 二维码解析测试
         *    String qrcodeAnalyze = QRCodeUtil.QRCodeAnalyze("E://qrcode.jpg");
         */
        String qrcodeAnalyze = QRCodeAnalyze("E://qrcode.jpg");
        System.out.println(qrcodeAnalyze);
        /**
         * ZXingCode 二维码生成测试
         * QRCodeUtil.zxingCodeCreate("http://blog.csdn.net/u014266877", 300, 300, "E://zxingcode.jpg", "jpg");
         */

//         try {
//             zxingCodeCreate("http://blog.csdn.net/u014266877", 300, 300, "E://zxingcode.jpg", "jpg");
//         }catch (WriterException e){
//             e.printStackTrace();
//             System.out.println(e.getMessage());
//         }

        /**
         * ZxingCode 二维码解析
         *    String zxingAnalyze =  QRCodeUtil.zxingCodeAnalyze("E://zxingcode.jpg").toString();
         */

//         try {
//             String zxingAnalyze =  zxingCodeAnalyze("E://zxingcode.jpg").toString();
//         }catch (Exception e){
//             e.printStackTrace();
//             System.out.println(e.getMessage());
//         }


        System.out.println("success");
    }


    //二维码颜色
    private static final int BLACK = 0xFF000000;
    //二维码颜色
    private static final int WHITE = 0xFFFFFFFF;

    public static void zxingCodeCreate(String text, int width, int height, String outPutPath, String imageType) throws WriterException {
        Map<EncodeHintType, String> his = new HashMap<EncodeHintType, String>();
        //设置编码字符集
        his.put(EncodeHintType.CHARACTER_SET, "utf-8");
        try {
            //1、生成二维码
            BitMatrix encode = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, his);

            //2、获取二维码宽高
            int codeWidth = encode.getWidth();
            int codeHeight = encode.getHeight();

            //3、将二维码放入缓冲流
            BufferedImage image = new BufferedImage(codeWidth, codeHeight, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < codeWidth; i++) {
                for (int j = 0; j < codeHeight; j++) {
                    //4、循环将二维码内容定入图片
                    image.setRGB(i, j, encode.get(i, j) ? BLACK : WHITE);
                }
            }
            File outPutImage = new File(outPutPath);
            //如果图片不存在创建图片
            if (!outPutImage.exists())
                outPutImage.createNewFile();
            //5、将二维码写入图片
            ImageIO.write(image, imageType, outPutImage);
        } catch (WriterException e) {
            e.printStackTrace();
            System.out.println("二维码生成失败");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("生成二维码图片失败");
        }
    }

    /**
     * <span style="font-size:18px;font-weight:blod;">二维码解析</span>
     *
     * @param analyzePath 二维码路径
     * @return
     * @throws IOException
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Object zxingCodeAnalyze(String analyzePath) throws Exception {
        MultiFormatReader formatReader = new MultiFormatReader();
        Object result = null;
        try {
            File file = new File(analyzePath);
            if (!file.exists()) {
                return "二维码不存在";
            }
            BufferedImage image = ImageIO.read(file);
            BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            result = formatReader.decode(binaryBitmap, hints);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * <span style="font-size:18px;font-weight:blod;">QRCode 方式生成二维码</span>
     *
     * @param content  二维码内容
     * @param imgPath  二维码生成路径
     * @param version  二维码版本
     * @param logoPath 是否生成Logo图片    为NULL不生成
     */
    public static void QRCodeCreate(String content, String imgPath, int version, String logoPath) {
        try {
            Qrcode qrcodeHandler = new Qrcode();
            //设置二维码排错率，可选L(7%) M(15%) Q(25%) H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小
            qrcodeHandler.setQrcodeErrorCorrect('M');
            //N代表数字,A代表字符a-Z,B代表其他字符
            qrcodeHandler.setQrcodeEncodeMode('B');
            //版本1为21*21矩阵，版本每增1，二维码的两个边长都增4；所以版本7为45*45的矩阵；最高版本为是40，是177*177的矩阵
            qrcodeHandler.setQrcodeVersion(version);
            //根据版本计算尺寸
            int imgSize = 67 + 12 * (version - 1);
            byte[] contentBytes = content.getBytes("gb2312");
            BufferedImage bufImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);
            Graphics2D gs = bufImg.createGraphics();
            gs.setBackground(Color.WHITE);
            gs.clearRect(0, 0, imgSize, imgSize);
            // 设定图像颜色 > BLACK
            gs.setColor(Color.BLACK);
            // 设置偏移量 不设置可能导致解析出错
            int pixoff = 2;
            // 输出内容 > 二维码
            if (contentBytes.length > 0 && contentBytes.length < 130) {
                boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
                for (int i = 0; i < codeOut.length; i++) {
                    for (int j = 0; j < codeOut.length; j++) {
                        if (codeOut[j][i]) {
                            gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                        }
                    }
                }
            } else {
                System.err.println("QRCode content bytes length = " + contentBytes.length + " not in [ 0,130 ]. ");
            }
           /* 判断是否需要添加logo图片 */
            if (logoPath != null) {
                File icon = new File(logoPath);
                if (icon.exists()) {
                    int width_4 = imgSize / 4;
                    int width_8 = width_4 / 2;
                    int height_4 = imgSize / 4;
                    int height_8 = height_4 / 2;
                    Image img = ImageIO.read(icon);
                    gs.drawImage(img, width_4 + width_8, height_4 + height_8, width_4, height_4, null);
                    gs.dispose();
                    bufImg.flush();
                } else {
                    System.out.println("Error: login图片还在在！");
                }

            }


            gs.dispose();
            bufImg.flush();
            //创建二维码文件
            File imgFile = new File(imgPath);
            if (!imgFile.exists())
                imgFile.createNewFile();
            //根据生成图片获取图片
            String imgType = imgPath.substring(imgPath.lastIndexOf(".") + 1, imgPath.length());
            // 生成二维码QRCode图片
            ImageIO.write(bufImg, imgType, imgFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * <span style="font-size:18px;font-weight:blod;">QRCode二维码解析</span>
     *
     * @param codePath 二维码路径
     * @return 解析结果
     */
    public static String QRCodeAnalyze(String codePath) {
        File imageFile = new File(codePath);
        BufferedImage bufImg = null;
        Result result = null;
        try {
            if (!imageFile.exists())
                return "二维码不存在";
//            bufImg = ImageIO.read(imageFile);
//
//            QRCodeDecoder decoder = new QRCodeDecoder();
//            decodedData = new String(decoder.decode(new ImageUtil(bufImg)), "gb2312");

            BufferedImage image;
            image = ImageIO.read(new File(codePath));
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } catch (DecodingFailedException dfe) {
            System.out.println("Error: " + dfe.getMessage());
            dfe.printStackTrace();
        } catch (NotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return result.toString();
    }

    // 组合模式 demo
    @Test
    public void testComposite() {
        TextTagComposite composite = new PTag();

        composite.addTag(new SpanTag());

        composite.addTag(new EmTag());

        // sample client code

        composite.startWrite();

        for (TextTag leaf : composite.getTags()) {

            leaf.startWrite();

            leaf.endWrite();

        }

        composite.endWrite();

        assertTrue("Composite should contain 2 tags but it contains " + composite.getTags().size(), composite.getTags().size() == 2);

    }

    @Test
    public void testForBreak() {
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                break;
            }
            System.out.println("i " + i);

        }
    }

    // for循环中 continue 和 break 的使用
    @Test
    public void testForBreak2() {
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                continue;
            }
            System.out.println("i " + i);

        }
    }


    @Test
    public void testForBreak3() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i : arr) {
            if (i == 4) {
                continue;
            }
            System.out.println("i " + i);
        }
    }

    @Test
    public void testForBreak4() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i : arr) {
            if (i == 4) {
                break;
            }
            System.out.println("i " + i);
        }
    }

    // 模板类的实现 demo
    @Test
    public void testTemplate() {
        HouseAbstract house = new SeaHouse();
        house.construct();

        HouseAbstract ecologicalHouse = new EcologicalHouse();
        ecologicalHouse.construct();
    }

    @Test
    public void testSpringEL() {

//        Writer writer = new Writer();
//
//        writer.setName("Writer's name");
//
//        StandardEvaluationContext modifierContext = new StandardEvaluationContext(subscriberContext);
//
//        modifierContext.setVariable("name", "Overriden writer's name");
//
//        parser.parseExpression("name = #name").getValue(modifierContext);
//
//        System.out.println("writer's name is : " + writer.getName());
    }

    // 建设者模式 Builder 内部类 实现
    @Test
    public void testBuilder() {

        // 内部类
        Programmer programmer = new Programmer.ProgrammerBuilder()
                .setFirstName("F")
                .setLastName("L")
                .setCity("City")
                .setZipCode("0000A")
                .setAddress("Street 39")
                .setLanguages(new String[]{"bash", "Perl"})
                .setProjects(new String[]{"Linux kernel"})
                .build();
        System.out.println(programmer.toString());
        assertTrue("Programmer should be 'F L' but was '" + programmer + "'", programmer.toString().equals("F L"));

    }

    // 工厂 模式的 实现 demo  ??????
    @Test
    public void testFactory() {
        Meal fruit = Meal.valueOf("banana");

        Meal vegetable = Meal.valueOf("carrot");

        assertTrue("Banana should be a fruit but is " + fruit.getType(), fruit.getType().equals("fruit"));

        assertTrue("Carrot should be a vegetable but is " + vegetable.getType(), vegetable.getType().equals("vegetable"));
    }

    // 下厨房 统计原材料的集合

    @Test
    public void testString11(){
        String constructDate = "2017/09/08 12:00:00";
        if (constructDate.contains("/")){
            constructDate = constructDate.replaceAll("/","-");
        }
        System.out.println(constructDate);
    }

    @Test
    public void testCountIngredient() {
        String fileName = "Ingredients.txt";
        try (FileReader fr = new FileReader(fileName)) {
            try (BufferedReader bfr = new BufferedReader(fr)) {

                String line = null;

                Set<String> ingredientSet = new HashSet<String>();
                HashMap<String,Integer> ingredientMap = new HashMap<String,Integer>();

                while ((line = bfr.readLine()) != null) {
                    System.out.println(line);

                    String[] ingredientArr = line.split(" ");
                    System.out.println(ingredientArr.toString()+" "+ingredientArr.length);

                    for (int i = 0;i<ingredientArr.length;i++){

                        ingredientSet.add(ingredientArr[i]);

                        Integer count = 0;
                        if (ingredientMap.size()>0) {
                            System.out.println(ingredientMap.size());

                            try{
                                // count == null Exception
                                count =  ingredientMap.get(ingredientArr[i]);
                                System.out.println("count :"+count);
                                count = count==null?0:count;
                            }catch(Exception e){
                                count = 0;
                            }

                        }
                        // map Exception
                        ingredientMap.put(ingredientArr[i],count+1);
                        System.out.println("ingredientMap.size:");
                        System.out.println(ingredientMap.size());
                    }

                }
                System.out.println("result:");

                System.out.println("ingredientSet.size:"+ingredientSet.size());
                System.out.println(ingredientSet.toString());

                System.out.println("ingredientMap.size:"+ingredientMap.size());
                System.out.println(ingredientMap);

            }catch (Exception e){
                System.out.println("Exception 1");
                System.out.println(e.getMessage());
            }

        }catch (Exception e){
            System.out.println("Exception 2");
            System.out.println(e.getMessage());
        }

    }

    // command 命令模式
    @Test
    public void testCommand(){

        Administrator admin = new Administrator();
        Server server = new Server();
        // start Apache
        admin.setCommand(new StartApache(server));
        admin.typeEnter();

        // start Tomcat
        admin.setCommand(new StartTomcat(server));
        admin.typeEnter();

        // check executed commands
        int executed = server.getExecutedCommands().size();

        assertTrue("Two commands should be executed but only "+

                executed+ " were", executed == 2);

    }

    // 访问者模式  ？？
    @Test
    public void testVisitor(){

        // CarComponent 是抽象父类 Car 子类
        CarComponent car = new Car();
        // 接口Mechanic 汽车技术修理工人  QualifiedMechanic：实现接口的一个类
        Mechanic mechanic = new QualifiedMechanic();

        car.accept(mechanic);

        assertTrue("After qualified mechanics visit, the car should be broken",

                car.isBroken());
        // 接口Mechanic 汽车技术修理工人  NonQualifiedMechanic：实现接口的一个类
        Mechanic nonqualifiedMechanic = new NonQualifiedMechanic();
        // 免检的
        car.accept(nonqualifiedMechanic);

        assertFalse("Car shouldn't be broken becase non qualified mechanic " +

                " can't see breakdowns", car.isBroken());

    }

    // test 适配器模式 分各种不同的情况 不同的情况 做同一事情的结果不一样
    @Test
    public void testAdapter(){
        HoleMaker maker = new HoleMakerImpl();
        maker.makeHole(1);
        maker.makeHole(2);
        maker.makeHole(30);
        maker.makeHole(40);
    }

    // test 装饰者模式 ： 这种设计模式的主要作用是为给定的对象添加补充角色 复合各种角色成分
    @Test
    public void testDecoration(){
        Coffee sugarMilkCoffee=new MilkDecorator(new SugarDecorator(new BlackCoffee()));
        System.out.println(sugarMilkCoffee.getPrice());
        System.out.println(sugarMilkCoffee.makeMoreCandied());
    }

    // protoType 原型 模式

    @Test
    public void testProtoType(){
        com.itmei.prototype.Robot robot1 = new com.itmei.prototype.Robot("robotA");
        com.itmei.prototype.Robot robot2 = null;
        try {
            robot2 = (com.itmei.prototype.Robot)robot1.clone();
        }catch (Exception e){
            System.out.println("clone failed!");
        }

        System.out.println(robot1);
        System.out.println(robot1.getName());
        System.out.println(robot2);
        System.out.println(robot2.getName());

        robot2.setName("RobotB");

        System.out.println(robot1);
        System.out.println(robot1.getName());
        System.out.println(robot2);
        System.out.println(robot2.getName());
    }

    // observer 观察者模式
    @Test
    public void testObserver(){
        // 第一个观察者
       com.itmei.observer.Observer pageOpener = new PageOpener();
       // 第二个观察者
        com.itmei.observer.Observer register = new Register();

        // 被观察的
        com.itmei.observer.Button btn = new com.itmei.observer.Button();
        btn.addListener(pageOpener);
        btn.addListener(register);
        // 这个行为里 触发被观察的 行为
        btn.clickOn();

        assertTrue("Button should be clicked but it wasn't",
                btn.wasClicked());

        assertTrue("Page opener should be informed about click but it wasn't",
                pageOpener.wasInformed());

        assertTrue("Register should be informed about click but it wasn't",
                register.wasInformed());

    }
}
