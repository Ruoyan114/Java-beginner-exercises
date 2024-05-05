package advanced_java_exercise05;

public class SimpleStateMachine {
    private State currentState;

    public SimpleStateMachine() {
        this.currentState = State.STATE_A; // 初始状态
    }

    // 根据当前状态执行动作并转换到新的状态
    public void transition(Event event) {
        switch (currentState) {
            case STATE_A:
                handleStateA(event);
                break;
            case STATE_B:
                handleStateB(event);
                break;
            case STATE_C:
                handleStateC(event);
                break;
            default:
                System.out.println("未知状态");
        }
    }

    private void handleStateA(Event event) {
        System.out.println("当前状态：STATE_A");
        switch (event) {
            case EVENT_1:
                System.out.println("执行STATE_A下EVENT_1的动作");
                currentState = State.STATE_B; // 转换到STATE_B
                break;
            case EVENT_2:
                System.out.println("执行STATE_A下EVENT_2的动作");
                // 在STATE_A下，EVENT_2可能不导致状态转换
                break;
            default:
                System.out.println("在STATE_A中接收到未知事件");
        }
    }

    private void handleStateB(Event event) {
        System.out.println("当前状态：STATE_B");
        switch (event) {
            case EVENT_1:
                System.out.println("执行STATE_B下EVENT_1的动作");
                // 在STATE_B下，EVENT_1可能不导致状态转换
                break;
            case EVENT_2:
                System.out.println("执行STATE_B下EVENT_2的动作");
                currentState = State.STATE_C; // 转换到STATE_C
                break;
            default:
                System.out.println("在STATE_B中接收到未知事件");
        }
    }

    private void handleStateC(Event event) {
        System.out.println("当前状态：STATE_C");
        // 在STATE_C中处理事件...
        // 示例中未添加具体的处理逻辑
    }

    // 枚举类型表示事件
    public enum Event {
        EVENT_1,
        EVENT_2
    }

    public static void main(String[] args) {
        SimpleStateMachine machine = new SimpleStateMachine();
        machine.transition(Event.EVENT_1); //从STATE_A转换到STATE_B
        machine.transition(Event.EVENT_2); // 在STATE_B中，转换到STATE_C
        machine.transition(Event.EVENT_1); // 在STATE_C中，不执行转换
    }
}
