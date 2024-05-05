package advanced_java_exercise05;

import jdk.jfr.Event;

/*
下面是一个Java代码示例，展示如何使用枚举类型在switch语句中进行条件判断，实现一个简单的状态机。
 */
public enum State {
    STATE_A,
    STATE_B,
    STATE_C
}

/*
在这个例子中，我们定义了一个State枚举来表示状态机的不同状态，以及一个Event枚举来表示可能触发状态转换的事件。
SimpleStateMachine类维护了一个currentState变量来跟踪当前状态，并提供了一个transition方法来根据当前状态和
传入的事件执行相应的动作并可能转换到新的状态。transition方法内部使用switch语句根据当前状态调用不同的处理逻辑。
每个处理逻辑内部又使用另一个switch语句根据事件执行具体的动作，并可能更新当前状态。
在main方法中，我们创建了一个SimpleStateMachine实例，并通过transition方法模拟了状态转换的过程。
 */