/**
 * 系统的管理者，单例的用户
 * 表示正在使用的用户
 */
package crossfarm.manager;

public class Farmer {
    private double money;

    private Farmer() {
        //
        this.money = 0;
    }

    public static Farmer getInstance() {
        throw new RuntimeException("Not Implemented.");
    }
}
