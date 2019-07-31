package com.leixindi.start;

import com.leixindi.operation.Operation;

/**
 * 系统的启动类
 */
public class StartSystem {
    public static void main(String[] args) {
        Operation operation = new Operation();
        operation.showMainMenu();
    }
}
