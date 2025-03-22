package homework.facade;

public class Client {
    public static void main(String[] args) {
        Police police = new Police();
        police.turnOnAll();
    }
}

abstract class Switch {
    boolean status = false;

    void on() {
        status = true;
        System.out.println("打开 " + getClass().getSimpleName());
    }

    void off() {
        status = false;
        System.out.println("关闭 " + getClass().getSimpleName());
    }
}

class Alarm extends Switch {
}

class Camera extends Switch {
}

class Light extends Switch {
}

class Sensor extends Switch {
}

class Police {
    private Alarm alarm;
    private Camera camera;
    private Light light;
    private Sensor sensor;

    public Police() {
        alarm = new Alarm();
        camera = new Camera();
        light = new Light();
        sensor = new Sensor();
    }

    public void turnOnAll() {
        alarm.on();
        camera.on();
        light.on();
        sensor.on();
    }

    public void turnOffAll() {
        alarm.off();
        camera.off();
        light.off();
        sensor.off();
    }
}

