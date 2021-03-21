package design.demo05builderPattern;

/**
 * Javan 2021.02.21
 */
public class NewCar {
    //    发动机
    private String engine;
    // 底盘
    private String chassis;
    // 车身
    private String body;
    // 电气设备
    private String equipment;

    public NewCar() {
        throw new RuntimeException("can't init");
    }

    private NewCar(Builder builder) {
        engine = builder.engine;
        chassis = builder.chassis;
        body = builder.body;
        equipment = builder.equipment;
    }

    public static final class Builder {
        // 发动机
        private String engine;
        // 底盘
        private String chassis;
        // 车身
        private String body;
        // 电气设备
        private String equipment;

        public Builder() {
        }

        public Builder engine(String val) {
            engine = val;
            return this;
        }

        public Builder chassis(String val) {
            chassis = val;
            return this;
        }

        public Builder body(String val) {
            body = val;
            return this;
        }

        public Builder equipment(String val) {
            equipment = val;
            return this;
        }

        public NewCar build() {
            return new NewCar(this);
        }
    }
}