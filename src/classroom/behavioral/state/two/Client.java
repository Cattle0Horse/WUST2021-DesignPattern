package classroom.behavioral.state.two;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/28 16:54
 * @description :
 */
public class Client {
    public static void main(String[] args) {
        Door aDoor = new Door();
        aDoor.getState();
        aDoor.click();
        aDoor.getState();
        aDoor.complete();
        aDoor.getState();
        aDoor.timeout();
        aDoor.getState();
    }
}

class Door {
    public final DoorState CLOSED = new DoorClosed(this);
    public final DoorState OPENING = new DoorOpening(this);
    public final DoorState OPEN = new DoorOpen(this);
    public final DoorState CLOSING = new DoorClosing(this);
    public final DoorState STAY_OPEN = new DoorStayOpen(this);
    private DoorState state = CLOSED;

    // 设置传输门当前状态
    public void setState(DoorState state) {this.state = state;}

    public void getState() { // 根据当前状态输出对应的状态字符串
        System.out.println(state.getClass().getName());
    }

    // 发生click事件时进行状态转换
    public void click() {
        state.click();
    }

    // 发生timeout事件时进行状态转换
    public void timeout() {
        state.timeout();
    }

    // 发生complete事件时进行状态转换
    public void complete() {
        state.complete();
    }
}

abstract class DoorState {  // 定义所有状态类的基类
    protected Door door;

    public DoorState(Door door) {this.door = door;}

    // 发生click事件时进行状态转换
    public void click() {}

    // 发生timeout事件时进行状态转换
    public void timeout() {}

    // 发生complete事件时进行状态转换
    public void complete() {}
}

class DoorClosed extends DoorState {  // 定义一个基本的Closed状态
    public DoorClosed(Door door) {super(door);}

    @Override
    public void click() {
        door.setState(door.OPENING);
    }
    // DoorClosed类的其余代码省略
}

class DoorOpening extends DoorState {  // 定义一个基本的Opening状态
    public DoorOpening(Door door) {super(door);}

    @Override
    public void click() {
        door.setState(door.CLOSING);
    }

    @Override
    public void complete() {
        door.setState(door.OPEN);
    }
    // DoorOpening类的其余代码省略
}

class DoorOpen extends DoorState {  // 定义一个基本的Open状态
    public DoorOpen(Door door) {super(door);}

    @Override
    public void click() {
        door.setState(door.STAY_OPEN);
    }

    @Override
    public void timeout() {
        door.setState(door.CLOSING);
    }
    // DoorOpen类的其余代码省略
}

class DoorClosing extends DoorState {  // 定义一个基本的Closing状态
    public DoorClosing(Door door) {super(door);}

    @Override
    public void click() {
        door.setState(door.OPENING);
    }

    @Override
    public void complete() {
        door.setState(door.CLOSED);
    }
    // DoorClosing类的其余代码省略
}

class DoorStayOpen extends DoorState {  // 定义一个基本的StayOpen状态
    public DoorStayOpen(Door door) {super(door);}

    @Override
    public void click() {
        door.setState(door.CLOSING);
    }
    // DoorStayOpen的其余代码省略
}
