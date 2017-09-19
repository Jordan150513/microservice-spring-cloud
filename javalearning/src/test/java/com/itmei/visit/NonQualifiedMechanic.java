package com.itmei.visit;

/**
 * Created by qiaodan on 2017/9/11.
 */
public class NonQualifiedMechanic implements Mechanic{
    @Override

    public void visit(CarComponent element) {

        element.setBroken(true);

    }

    @Override

    public String getName() {

        return "unqualified";

    }
}
