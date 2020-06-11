package org.fisco.bcos.beans;

import lombok.Data;

@Data
public class TransactionInfo {
    String timestamp;
    String copyrightId;
    String copyrightTag;
    String price;
    String sellerAddress;
    String buyerAddress;
    String transactionId;
    boolean isReversing;
    boolean isReversed;
    boolean reverseResult;
}