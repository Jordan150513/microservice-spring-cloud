package com.itmei.visit;

/**
 * Created by qiaodan on 2017/9/11.
 */
public class Brake extends CarComponent {
    @Override

    public void accept(Mechanic mechanic) {

        mechanic.visit(this);

    }
}
