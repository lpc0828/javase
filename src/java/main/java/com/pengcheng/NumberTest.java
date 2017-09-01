package com.pengcheng;

/**
 * Created by pcliu on 16-9-26.
 */
public class NumberTest {

    public static void testInteger() {
        System.out.println("Integer toString test begin >>>>>>>>>>>>>>>>>>");
        //System.out.println(Integer.toString(100, 16));
        System.out.println("Integer toString test end <<<<<<<<<<<<<<<<<<<<");

        System.out.println("Integer IntegerCache test begin >>>>>>>>>>>>>>>>>>");
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        System.out.println(i1 == i2);

        Integer i3 = Integer.parseInt("10");
        Integer i4 = Integer.parseInt("10");
        System.out.println(i3 == i4);

        Integer i5 = 10;
        Integer i6 = 10;
        System.out.println(i5 == i6);

        Integer i7 = Integer.valueOf("10");
        Integer i8 = Integer.valueOf("10");
        System.out.println(i7 == i8);

        Integer ia = Integer.valueOf(10);
        Integer ib = Integer.valueOf(10);
        System.out.println(ia == ib);


        Integer ic = Integer.valueOf(1000);
        Integer id = Integer.valueOf(1000);
        System.out.println(ic == id);
        System.out.println("Integer IntegerCache test end <<<<<<<<<<<<<<<<<<<<");

        Integer aa = new Integer(0);
        Integer bb = new Integer(1000);
        System.out.println(aa.getClass().equals(bb.getClass()));
    }

    public static void main(String[] args) {
        //NumberTest.testInteger();

        String sql = "{call PRO_RETURN_INT_RESULT(?, ?)}";
        System.out.println(sql.matches("^\\{\\s*call\\s+[_|A-Z|0-9|a-z]+\\([?|,| ]+\\)\\s*\\}\\s*$"));

        String reg = "{ call PRO_RETURN_INT_RESULT(?,?) }";
        System.out.println(reg.matches("^\\{\\s*call\\s+[_|A-Z|0-9|a-z]+\\([?|,]+\\)\\s*\\}$"));
    }
}
