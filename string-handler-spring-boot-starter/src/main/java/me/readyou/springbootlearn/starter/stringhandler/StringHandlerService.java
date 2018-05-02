package me.readyou.springbootlearn.starter.stringhandler;

/**
 * Created by wuxinlong on 18/5/2.
 */
// 这是我们要提供的Service，但这里并不需要@service的注解
public class StringHandlerService {
    private int handleType;

    public StringHandlerService(int handleType) {
        this.handleType = handleType;
    }

    public String doHandle(String str) {
        if (str == null) {
            return null;
        }

        switch (handleType) {
            case 1:
                return str.toLowerCase();
            case 2:
                return str.toUpperCase();
            default:
                return str.toUpperCase();
        }
    }
}
