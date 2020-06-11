package org.fisco.bcos.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple5;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class AccountContract extends Contract {
    public static final String[] BINARY_ARRAY = {"608060405234801561001057600080fd5b50611475806100206000396000f3006080604052600436106100db576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063035db10e146100e0578063141153ba1461012d5780635ed75180146101845780635fd4b08a146101e557806380578309146102a157806384a37273146102f85780639b96eece14610345578063b214dcd41461039c578063b46310f6146103ff578063bddb2f591461044c578063d83e06b8146104af578063e783a1e614610506578063f0d4bc5c14610567578063f512d934146105f0578063fbcbc0f11461067d575b600080fd5b3480156100ec57600080fd5b5061012b600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610755565b005b34801561013957600080fd5b5061016e600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506107c4565b6040518082815260200191505060405180910390f35b34801561019057600080fd5b506101cf600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610812565b6040518082815260200191505060405180910390f35b3480156101f157600080fd5b50610226600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610875565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561026657808201518184015260208101905061024b565b50505050905090810190601f1680156102935780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156102ad57600080fd5b506102e2600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610ac2565b6040518082815260200191505060405180910390f35b34801561030457600080fd5b50610343600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610b10565b005b34801561035157600080fd5b50610386600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610b7f565b6040518082815260200191505060405180910390f35b3480156103a857600080fd5b506103fd600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610bca565b005b34801561040b57600080fd5b5061044a600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610d70565b005b34801561045857600080fd5b506104ad600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610dba565b005b3480156104bb57600080fd5b506104f0600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610e63565b6040518082815260200191505060405180910390f35b34801561051257600080fd5b50610551600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610eb1565b6040518082815260200191505060405180910390f35b34801561057357600080fd5b506105ee600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610f14565b005b3480156105fc57600080fd5b5061063b600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050611090565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561068957600080fd5b506106be600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611113565b6040518080602001868152602001858152602001848152602001838152602001828103825287818151815260200191508051906020019080838360005b838110156107165780820151818401526020810190506106fb565b50505050905090810190601f1680156107435780820380516001836020036101000a031916815260200191505b50965050505050505060405180910390f35b6000808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206004018190806001815401808255809150509060018203906000526020600020016000909192909190915055505050565b60008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600301805490509050919050565b60008060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206004018281548110151561086257fe5b9060005260206000200154905092915050565b606061087f61122e565b6000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060a06040519081016040529081600082018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156109625780601f1061093757610100808354040283529160200191610962565b820191906000526020600020905b81548152906001019060200180831161094557829003601f168201915b5050505050815260200160018201548152602001600282018054806020026020016040519081016040528092919081815260200182805480156109fa57602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190600101908083116109b0575b5050505050815260200160038201805480602002602001604051908101604052809291908181526020018280548015610a5257602002820191906000526020600020905b815481526020019060010190808311610a3e575b5050505050815260200160048201805480602002602001604051908101604052809291908181526020018280548015610aaa57602002820191906000526020600020905b815481526020019060010190808311610a96575b50505050508152505090508060000151915050919050565b60008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600401805490509050919050565b6000808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206003018190806001815401808255809150509060018203906000526020600020016000909192909190915055505050565b60008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101549050919050565b60008060008060008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206002019250600091505b8280549050821015610d68578373ffffffffffffffffffffffffffffffffffffffff168383815481101515610c4857fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610d5b578190505b6001838054905003811015610d41578260018201815481101515610cb357fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168382815481101515610cec57fe5b9060005260206000200160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508080600101915050610c93565b82805480919060019003610d55919061125e565b50610d69565b8180600101925050610c17565b5b5050505050565b806000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101819055505050565b6000808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206002018190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505050565b60008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201805490509050919050565b60008060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060030182815481101515610f0157fe5b9060005260206000200154905092915050565b60a060405190810160405280828152602001600081526020016000604051908082528060200260200182016040528015610f5d5781602001602082028038833980820191505090505b5081526020016000604051908082528060200260200182016040528015610f935781602001602082028038833980820191505090505b5081526020016000604051908082528060200260200182016040528015610fc95781602001602082028038833980820191505090505b508152506000808473ffffffffffffffffffffffffff","ffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600082015181600001908051906020019061102792919061128a565b5060208201518160010155604082015181600201908051906020019061104e92919061130a565b50606082015181600301908051906020019061106b929190611394565b506080820151816004019080519060200190611088929190611394565b509050505050565b60008060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201828154811015156110e057fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905092915050565b606060008060008060008060008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209050806000018160010154826002018054905083600301805490508460040180549050848054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156112135780601f106111e857610100808354040283529160200191611213565b820191906000526020600020905b8154815290600101906020018083116111f657829003601f168201915b50505050509450955095509550955095505091939590929450565b60a06040519081016040528060608152602001600081526020016060815260200160608152602001606081525090565b8154818355818111156112855781836000526020600020918201910161128491906113e1565b5b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106112cb57805160ff19168380011785556112f9565b828001600101855582156112f9579182015b828111156112f85782518255916020019190600101906112dd565b5b50905061130691906113e1565b5090565b828054828255906000526020600020908101928215611383579160200282015b828111156113825782518260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055509160200191906001019061132a565b5b5090506113909190611406565b5090565b8280548282559060005260206000209081019282156113d0579160200282015b828111156113cf5782518255916020019190600101906113b4565b5b5090506113dd91906113e1565b5090565b61140391905b808211156113ff5760008160009055506001016113e7565b5090565b90565b61144691905b8082111561144257600081816101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690555060010161140c565b5090565b905600a165627a7a7230582088158b25723148ee78f0d1515865fa81d280fffd3690ea48355e489a702c25b00029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"user\",\"type\":\"address\"},{\"name\":\"requestionId\",\"type\":\"uint256\"}],\"name\":\"addRequestions\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"user\",\"type\":\"address\"}],\"name\":\"getTransactionsNum\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"user\",\"type\":\"address\"},{\"name\":\"index\",\"type\":\"uint256\"}],\"name\":\"getRequestionId\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"user\",\"type\":\"address\"}],\"name\":\"getName\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"user\",\"type\":\"address\"}],\"name\":\"getRequestionsNum\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"user\",\"type\":\"address\"},{\"name\":\"transactionId\",\"type\":\"uint256\"}],\"name\":\"addTransaction\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"ad\",\"type\":\"address\"}],\"name\":\"getBalanceOf\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"owner\",\"type\":\"address\"},{\"name\":\"copytightsId\",\"type\":\"address\"}],\"name\":\"removeCopyright\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"ad\",\"type\":\"address\"},{\"name\":\"balance\",\"type\":\"uint256\"}],\"name\":\"setBalanceOf\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"user\",\"type\":\"address\"},{\"name\":\"copyrightsId\",\"type\":\"address\"}],\"name\":\"addCopyright\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"user\",\"type\":\"address\"}],\"name\":\"getCopyrightsNum\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"user\",\"type\":\"address\"},{\"name\":\"index\",\"type\":\"uint256\"}],\"name\":\"getTransactionId\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"ad\",\"type\":\"address\"},{\"name\":\"name\",\"type\":\"string\"}],\"name\":\"addAccount\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"user\",\"type\":\"address\"},{\"name\":\"index\",\"type\":\"uint256\"}],\"name\":\"getCopyrights\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"user\",\"type\":\"address\"}],\"name\":\"getAccount\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_ADDREQUESTIONS = "addRequestions";

    public static final String FUNC_GETTRANSACTIONSNUM = "getTransactionsNum";

    public static final String FUNC_GETREQUESTIONID = "getRequestionId";

    public static final String FUNC_GETNAME = "getName";

    public static final String FUNC_GETREQUESTIONSNUM = "getRequestionsNum";

    public static final String FUNC_ADDTRANSACTION = "addTransaction";

    public static final String FUNC_GETBALANCEOF = "getBalanceOf";

    public static final String FUNC_REMOVECOPYRIGHT = "removeCopyright";

    public static final String FUNC_SETBALANCEOF = "setBalanceOf";

    public static final String FUNC_ADDCOPYRIGHT = "addCopyright";

    public static final String FUNC_GETCOPYRIGHTSNUM = "getCopyrightsNum";

    public static final String FUNC_GETTRANSACTIONID = "getTransactionId";

    public static final String FUNC_ADDACCOUNT = "addAccount";

    public static final String FUNC_GETCOPYRIGHTS = "getCopyrights";

    public static final String FUNC_GETACCOUNT = "getAccount";

    @Deprecated
    protected AccountContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AccountContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AccountContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AccountContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> addRequestions(String user, BigInteger requestionId) {
        final Function function = new Function(
                FUNC_ADDREQUESTIONS, 
                Arrays.<Type>asList(new Address(user),
                new Uint256(requestionId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void addRequestions(String user, BigInteger requestionId, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ADDREQUESTIONS, 
                Arrays.<Type>asList(new Address(user),
                new Uint256(requestionId)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String addRequestionsSeq(String user, BigInteger requestionId) {
        final Function function = new Function(
                FUNC_ADDREQUESTIONS, 
                Arrays.<Type>asList(new Address(user),
                new Uint256(requestionId)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getAddRequestionsInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ADDREQUESTIONS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public RemoteCall<BigInteger> getTransactionsNum(String user) {
        final Function function = new Function(FUNC_GETTRANSACTIONSNUM, 
                Arrays.<Type>asList(new Address(user)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getRequestionId(String user, BigInteger index) {
        final Function function = new Function(FUNC_GETREQUESTIONID, 
                Arrays.<Type>asList(new Address(user),
                new Uint256(index)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getName(String user) {
        final Function function = new Function(FUNC_GETNAME, 
                Arrays.<Type>asList(new Address(user)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> getRequestionsNum(String user) {
        final Function function = new Function(FUNC_GETREQUESTIONSNUM, 
                Arrays.<Type>asList(new Address(user)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> addTransaction(String user, BigInteger transactionId) {
        final Function function = new Function(
                FUNC_ADDTRANSACTION, 
                Arrays.<Type>asList(new Address(user),
                new Uint256(transactionId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void addTransaction(String user, BigInteger transactionId, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ADDTRANSACTION, 
                Arrays.<Type>asList(new Address(user),
                new Uint256(transactionId)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String addTransactionSeq(String user, BigInteger transactionId) {
        final Function function = new Function(
                FUNC_ADDTRANSACTION, 
                Arrays.<Type>asList(new Address(user),
                new Uint256(transactionId)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getAddTransactionInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ADDTRANSACTION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> getBalanceOf(String ad) {
        final Function function = new Function(
                FUNC_GETBALANCEOF, 
                Arrays.<Type>asList(new Address(ad)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void getBalanceOf(String ad, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_GETBALANCEOF, 
                Arrays.<Type>asList(new Address(ad)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String getBalanceOfSeq(String ad) {
        final Function function = new Function(
                FUNC_GETBALANCEOF, 
                Arrays.<Type>asList(new Address(ad)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getGetBalanceOfInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_GETBALANCEOF, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public Tuple1<BigInteger> getGetBalanceOfOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_GETBALANCEOF, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> removeCopyright(String owner, String copytightsId) {
        final Function function = new Function(
                FUNC_REMOVECOPYRIGHT, 
                Arrays.<Type>asList(new Address(owner),
                new Address(copytightsId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void removeCopyright(String owner, String copytightsId, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_REMOVECOPYRIGHT, 
                Arrays.<Type>asList(new Address(owner),
                new Address(copytightsId)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String removeCopyrightSeq(String owner, String copytightsId) {
        final Function function = new Function(
                FUNC_REMOVECOPYRIGHT, 
                Arrays.<Type>asList(new Address(owner),
                new Address(copytightsId)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, String> getRemoveCopyrightInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_REMOVECOPYRIGHT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, String>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setBalanceOf(String ad, BigInteger balance) {
        final Function function = new Function(
                FUNC_SETBALANCEOF, 
                Arrays.<Type>asList(new Address(ad),
                new Uint256(balance)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setBalanceOf(String ad, BigInteger balance, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETBALANCEOF, 
                Arrays.<Type>asList(new Address(ad),
                new Uint256(balance)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setBalanceOfSeq(String ad, BigInteger balance) {
        final Function function = new Function(
                FUNC_SETBALANCEOF, 
                Arrays.<Type>asList(new Address(ad),
                new Uint256(balance)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getSetBalanceOfInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETBALANCEOF, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> addCopyright(String user, String copyrightsId) {
        final Function function = new Function(
                FUNC_ADDCOPYRIGHT, 
                Arrays.<Type>asList(new Address(user),
                new Address(copyrightsId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void addCopyright(String user, String copyrightsId, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ADDCOPYRIGHT, 
                Arrays.<Type>asList(new Address(user),
                new Address(copyrightsId)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String addCopyrightSeq(String user, String copyrightsId) {
        final Function function = new Function(
                FUNC_ADDCOPYRIGHT, 
                Arrays.<Type>asList(new Address(user),
                new Address(copyrightsId)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, String> getAddCopyrightInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ADDCOPYRIGHT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, String>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public RemoteCall<BigInteger> getCopyrightsNum(String user) {
        final Function function = new Function(FUNC_GETCOPYRIGHTSNUM, 
                Arrays.<Type>asList(new Address(user)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getTransactionId(String user, BigInteger index) {
        final Function function = new Function(FUNC_GETTRANSACTIONID, 
                Arrays.<Type>asList(new Address(user),
                new Uint256(index)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> addAccount(String ad, String name) {
        final Function function = new Function(
                FUNC_ADDACCOUNT, 
                Arrays.<Type>asList(new Address(ad),
                new Utf8String(name)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void addAccount(String ad, String name, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ADDACCOUNT, 
                Arrays.<Type>asList(new Address(ad),
                new Utf8String(name)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String addAccountSeq(String ad, String name) {
        final Function function = new Function(
                FUNC_ADDACCOUNT, 
                Arrays.<Type>asList(new Address(ad),
                new Utf8String(name)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, String> getAddAccountInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ADDACCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, String>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public RemoteCall<String> getCopyrights(String user, BigInteger index) {
        final Function function = new Function(FUNC_GETCOPYRIGHTS, 
                Arrays.<Type>asList(new Address(user),
                new Uint256(index)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Tuple5<String, BigInteger, BigInteger, BigInteger, BigInteger>> getAccount(String user) {
        final Function function = new Function(FUNC_GETACCOUNT, 
                Arrays.<Type>asList(new Address(user)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple5<String, BigInteger, BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple5<String, BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple5<String, BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<String, BigInteger, BigInteger, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    @Deprecated
    public static AccountContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AccountContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AccountContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AccountContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AccountContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AccountContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AccountContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AccountContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AccountContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AccountContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AccountContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AccountContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AccountContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AccountContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AccountContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AccountContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
