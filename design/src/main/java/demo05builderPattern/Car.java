package demo05builderPattern;

import lombok.Getter;
import lombok.Setter;

/**
 * Javan 2021.02.21
 */
@Getter
@Setter
public class Car {
    //    发动机
    private String engine;
    // 底盘
    private String chassis;
    // 车身
    private String body;
    // 电气设备
    private String equipment;

    public Car(String engine, String chassis, String body, String equipment) {
        this.engine = engine;
        this.chassis = chassis;
        this.body = body;
        this.equipment = equipment;
    }
}