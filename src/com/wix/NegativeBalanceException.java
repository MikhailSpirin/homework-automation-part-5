package com.wix;

/**
 * Created by mikhails on 31.10.2016
 */
public class NegativeBalanceException extends RuntimeException {

    public NegativeBalanceException() {
        super("This operation leads to negative balance. Operation aborted");
    }
}
