package com.itmei.excelloperator;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiaodan on 2017/11/1.
 */
public class ExcellOperator {

    @Test
    public void readFromExcel() {
        jxl.Workbook readwb = null;

        try {

            //构建Workbook对象, 只读Workbook对象
            //直接从本地文件创建Workbook
            InputStream instream = new FileInputStream("E:/工作文档/0元购活动统计数据/10月31日0元抢信息汇总.xls");
            readwb = Workbook.getWorkbook(instream);

            //Sheet的下标是从0开始
            //获取第一张Sheet表
            Sheet readsheet = readwb.getSheet(0);

            //获取Sheet表中所包含的总列数
            int rsColumns = readsheet.getColumns();
            //获取Sheet表中所包含的总行数
            int rsRows = readsheet.getRows();

            List<String> companyids = new ArrayList<String>();
            List<String> aids = new ArrayList<String>();

            //获取指定单元格的对象引用
            for (int i = 0; i < rsRows; i++) {
                for (int j = 0; j < rsColumns; j++) {
                    Cell cell = readsheet.getCell(j, i);
                    System.out.print(cell.getContents() + " ");

                    if (j==0&&cell.getContents().equals("companyid")){
                        companyids.add(readsheet.getCell(1, i).getContents());
                    }else if (j==0&&cell.getContents().equals("aid")){
                       aids.add(readsheet.getCell(1, i).getContents());
                    }
                }
                System.out.println();
            }
            System.out.println("companyids:");
            System.out.println(companyids.toString());
            System.out.println();
            System.out.println("aids:");
            System.out.println(aids.toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
