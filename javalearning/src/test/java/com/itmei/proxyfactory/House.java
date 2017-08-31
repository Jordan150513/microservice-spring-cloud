package com.itmei.proxyfactory;

import com.itmei.proxyfactory.Construction;

/**
 * Created by qiaodan on 2017/8/30.
 */
public class House implements Construction {
    private boolean permitted = false;

    @Override
    public boolean isPermitted() {

        return this.permitted;

    }

    @Override
    public void construct() {

        System.out.println("I'm constructing a house");

    }

    @Override
    public void givePermission() {

        System.out.println("Permission is given to construct a simple house");

        this.permitted = true;

    }
}
