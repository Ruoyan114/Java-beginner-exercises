package advanced_java_ex19;

/*
在Java中，你可以使用枚举类型作为集合中的元素，这样可以提供类型安全的集合，确保集合中只包含预定义的枚举值。
下面是一个使用枚举和集合的例子，其中枚举类型代表一周的几天，并且我们将实现基于枚举值的集合操作。
 */

import java.util.EnumSet;
import java.util.Set;

// 定义枚举类型Weekday
enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumSetExample {
    public static void main(String[] args) {
        // 使用EnumSet来创建Weekday的集合
        Set<Weekday> weekdays = EnumSet.noneOf(Weekday.class); // 创建一个空的EnumSet

        // 添加元素到集合中
        weekdays.add(Weekday.MONDAY);
        weekdays.add(Weekday.TUESDAY);
        weekdays.add(Weekday.WEDNESDAY);

        // 输出集合中的元素
        System.out.println("Weekdays in the set: " + weekdays);

        // 检查集合中是否包含某个元素
        boolean containsThursday = weekdays.contains(Weekday.THURSDAY);
        System.out.println("Does the set contain THURSDAY? " + containsThursday);

        // 从集合中移除元素
        weekdays.remove(Weekday.TUESDAY);
        System.out.println("Weekdays after removing TUESDAY: " + weekdays);

        // 使用EnumSet的静态方法创建具有特定元素的集合
        Set<Weekday> workdays = EnumSet.of(Weekday.MONDAY, Weekday.TUESDAY,
                Weekday.WEDNESDAY, Weekday.THURSDAY, Weekday.FRIDAY);
        System.out.println("Workdays: " + workdays);

        // 集合之间的操作，例如交集
        Set<Weekday> weekend = EnumSet.of(Weekday.SATURDAY, Weekday.SUNDAY);
        Set<Weekday> commonDays = EnumSet.copyOf(workdays);
        commonDays.retainAll(weekend); // 保留两个集合的交集
        System.out.println("Common days between workdays and weekend: " + commonDays);
    }
}
/*
在这个例子中，我们首先定义了一个Weekday的枚举类型，然后使用EnumSet来创建和操作Weekday类型的集合。
EnumSet是Java中专门为枚举类型设计的集合类，它提供了比常规Set实现更高效的存储和查找性能。
我们使用EnumSet.noneOf来创建一个空的集合，使用add方法来添加元素，使用contains方法来检查元素是否存在于集合中，
使用remove方法来移除元素。此外，我们还展示了如何使用EnumSet的静态方法of来创建一个包含特定元素的集合，
以及如何使用retainAll方法来获取两个集合的交集。
EnumSet不仅提供了高效的存储和查找性能，还确保了集合中只包含预定义的枚举值，从而提供了类型安全的集合操作。
 */
