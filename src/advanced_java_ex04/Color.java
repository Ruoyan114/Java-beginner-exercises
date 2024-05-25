package advanced_java_ex04;
/*
下面是一个Java代码示例，定义了一个表示颜色的枚举类型Color，并实现了一个根据枚举值返回描述的方法。
 */
public enum Color {
    RED("红色"),
    GREEN("绿色"),
    BLUE("蓝色"),
    YELLOW("黄色"),
    ORANGE("橙色"),
    PURPLE("紫色");

    private final String description;

    // 枚举的构造器是私有的，防止外部代码创建枚举实例
    private Color(String description) {
        this.description = description;
    }

    // 获取枚举值的描述
    public String getDescription() {
        return description;
    }

    // 示例方法，根据枚举值返回描述
    public static String getDescriptionByColor(Color color) {
        if (color != null) {
            return color.getDescription();
        } else {
            return "未知颜色";
        }
    }

    public static void main(String[] args) {
        // 使用枚举并打印起描述
        System.out.println(Color.RED.getDescription()); // 输出: 红色
        System.out.println(Color.GREEN.getDescription()); // 输出: 绿色

        // 使用静态方法根据枚举值获取描述
        System.out.println(Color.getDescriptionByColor(Color.BLUE)); // 输出: 蓝色
        System.out.println(Color.getDescriptionByColor(null)); // 输出: 未知颜色
    }
}

/*
在这个例子中，Color枚举定义了几种颜色，每种颜色都有一个与之关联的描述。枚举的构造器是私有的，以确保枚举类型的实例只能由枚举常量本身创建。
getDescription方法返回当前枚举常量的描述。getDescriptionByColor是一个静态方法，它接受一个Color枚举值作为参数，并返回相应的描述。
如果传入的枚举值为null，则返回"未知颜色"。
在main方法中，我们展示了如何使用枚举常量并打印其描述，以及如何使用静态方法根据枚举值获取描述。

 */