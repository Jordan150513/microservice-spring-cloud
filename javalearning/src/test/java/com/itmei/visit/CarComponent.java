package com.itmei.visit;

/**
 * Created by qiaodan on 2017/9/11.
 */
public abstract class CarComponent {
    protected boolean broken;

    public abstract void accept(Mechanic mechanic);

    public void setBroken(boolean broken) {

        this.broken = broken;

    }

    public boolean isBroken() {

        return this.broken;

    }
}
