package org.fisco.bcos.beans;

import lombok.Data;

@Data
public class CopyrightInfo {

    String copyrightId;
    String tag;
    String date;
    String price;
    String owner;
    boolean isOnSale;
}
