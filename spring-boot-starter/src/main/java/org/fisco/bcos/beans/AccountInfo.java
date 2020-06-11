package org.fisco.bcos.beans;

import lombok.Data;

import java.util.List;

@Data
public class AccountInfo {
    String name;
    String balance;

    List<String>copyrightsId;
    List<String>transactionsId;
    List<String>reverseId;

}
