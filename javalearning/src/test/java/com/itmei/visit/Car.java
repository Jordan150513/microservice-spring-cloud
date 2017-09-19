package com.itmei.visit;

/**
 * Created by qiaodan on 2017/9/11.
 */
public class Car extends CarComponent {

    private boolean broken = false;

    private CarComponent[] components;

    public Car() {

        components = new CarComponent[]{

                new Wheels(), new Engine(), new Brake()

        };

    }

    @Override

    public void accept(Mechanic mechanic) {

        this.broken = false;

        if (mechanic.getName().equals("qualified")) {

            int i = 0;

            while (i < components.length && this.broken == false) {

                CarComponent component = components[i];

                mechanic.visit(component);

                this.broken = component.isBroken();

                i++;

            }

        }

        // if mechanic isn't qualified, we suppose that

        // he isn't able to see breakdowns and so

        // he considers the car as no broken

        // (even if the car is broken)
    }

    @Override

    public boolean isBroken() {

        return this.broken;

    }
}
