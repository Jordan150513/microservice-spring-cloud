package com.itmei.adapter;

/**
 * Created by qiaodan on 2017/9/13.
 */
public class HoleMakerImpl implements HoleMaker {
        // client class 用 适配器的地方

        @Override
        public void makeHole(int diameter) {

            HoleMaker maker = new Drill(diameter);
            maker.makeHole(diameter);
        }
}
