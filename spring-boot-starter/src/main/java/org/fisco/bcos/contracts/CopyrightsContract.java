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
import org.fisco.bcos.web3j.abi.datatypes.Bool;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple6;
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
public class CopyrightsContract extends Contract {
    public static final String[] BINARY_ARRAY = {"608060405234801561001057600080fd5b50610e45806100206000396000f3006080604052600436106100af576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806316958341146100b457806344f924c2146101015780634da869211461015c57806396357794146101b3578063a111babd1461024e578063a92b55911461029b578063ab296619146103d6578063b3b246c414610492578063bd87c095146104e1578063be068c4414610538578063d9d8d59e1461059b575b600080fd5b3480156100c057600080fd5b506100ff600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919050505061061e565b005b34801561010d57600080fd5b5061015a600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001919091929391929390505050610668565b005b34801561016857600080fd5b5061019d600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506106be565b6040518082815260200191505060405180910390f35b3480156101bf57600080fd5b5061024c600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019082018035906020019190919293919293908035906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803515159060200190929190505050610709565b005b34801561025a57600080fd5b50610299600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610948565b005b3480156102a757600080fd5b506102dc600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610992565b604051808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001806020018681526020018581526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183151515158152602001828103825287818151815260200191508051906020019080838360005b8381101561039657808201518184015260208101905061037b565b50505050905090810190601f1680156103c35780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390f35b3480156103e257600080fd5b50610417600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610afa565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561045757808201518184015260208101905061043c565b50505050905090810190601f1680156104845780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561049e57600080fd5b506104df600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803515159060200190929190505050610bdd565b005b3480156104ed57600080fd5b50610522600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610c3a565b6040518082815260200191505060405180910390f35b34801561054457600080fd5b50610599600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610c85565b005b3480156105a757600080fd5b506105dc600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610d09565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b806000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600301819055505050565b81816000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010191906106b8929190610d74565b50505050565b60008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600301549050919050565b866000808973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555085856000808a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010191906107d9929190610d74565b50836000808973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020181905550826000808973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060030181905550816000808973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060040160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550806000808973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060040160146101000a81548160ff02191690831515021790555050505050505050565b806000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201819055505050565b6000606060008060008060008060008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681600101826002015483600301548460040160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168560040160149054906101000a900460ff16848054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610add5780601f10610ab257610100808354040283529160200191610add565b820191906000526020600020905b815481529060010190602001808311610ac057829003601f168201915b505050505094509650965096509650965096505091939550919395565b60606000808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610bd15780601f10610ba657610100808354040283529160200191610bd1565b820191906000526020600020905b815481529060010190602001808311610bb457829003601f168201915b50505050509050919050565b806000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060040160146101000a81548160ff0219169083151502179055505050565b60008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201549050919050565b806000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060040160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505050565b60008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060040160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610db557803560ff1916838001178555610de3565b82800160010185558215610de3579182015b82811115610de2578235825591602001919060010190610dc7565b5b509050610df09190610df4565b5090565b610e1691905b80821115610e12576000816000905550600101610dfa565b5090565b905600a165627a7a723058203ee8d707f2eeaadb079b6d9338cfe56660b911daad8024059b19046b792b27a60029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"copId\",\"type\":\"address\"},{\"name\":\"price\",\"type\":\"uint256\"}],\"name\":\"setCopyrightPrice\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"copId\",\"type\":\"address\"},{\"name\":\"tag\",\"type\":\"string\"}],\"name\":\"setCopyrightTag\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"copId\",\"type\":\"address\"}],\"name\":\"getCopyrightPrice\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"copId\",\"type\":\"address\"},{\"name\":\"tag\",\"type\":\"string\"},{\"name\":\"date\",\"type\":\"uint256\"},{\"name\":\"price\",\"type\":\"uint256\"},{\"name\":\"owner\",\"type\":\"address\"},{\"name\":\"isOnSale\",\"type\":\"bool\"}],\"name\":\"createCopyright\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"copId\",\"type\":\"address\"},{\"name\":\"date\",\"type\":\"uint256\"}],\"name\":\"setDate\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"copId\",\"type\":\"address\"}],\"name\":\"getCopyrightInfo\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"copId\",\"type\":\"address\"}],\"name\":\"getCopyrightTag\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"copId\",\"type\":\"address\"},{\"name\":\"isOnSale\",\"type\":\"bool\"}],\"name\":\"setOnSale\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"copId\",\"type\":\"address\"}],\"name\":\"getCopyrightDate\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"copId\",\"type\":\"address\"},{\"name\":\"newOwner\",\"type\":\"address\"}],\"name\":\"setCopyrightOwner\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"copId\",\"type\":\"address\"}],\"name\":\"getCopyrightOwner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_SETCOPYRIGHTPRICE = "setCopyrightPrice";

    public static final String FUNC_SETCOPYRIGHTTAG = "setCopyrightTag";

    public static final String FUNC_GETCOPYRIGHTPRICE = "getCopyrightPrice";

    public static final String FUNC_CREATECOPYRIGHT = "createCopyright";

    public static final String FUNC_SETDATE = "setDate";

    public static final String FUNC_GETCOPYRIGHTINFO = "getCopyrightInfo";

    public static final String FUNC_GETCOPYRIGHTTAG = "getCopyrightTag";

    public static final String FUNC_SETONSALE = "setOnSale";

    public static final String FUNC_GETCOPYRIGHTDATE = "getCopyrightDate";

    public static final String FUNC_SETCOPYRIGHTOWNER = "setCopyrightOwner";

    public static final String FUNC_GETCOPYRIGHTOWNER = "getCopyrightOwner";

    @Deprecated
    protected CopyrightsContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CopyrightsContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CopyrightsContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CopyrightsContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> setCopyrightPrice(String copId, BigInteger price) {
        final Function function = new Function(
                FUNC_SETCOPYRIGHTPRICE, 
                Arrays.<Type>asList(new Address(copId),
                new Uint256(price)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setCopyrightPrice(String copId, BigInteger price, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETCOPYRIGHTPRICE, 
                Arrays.<Type>asList(new Address(copId),
                new Uint256(price)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setCopyrightPriceSeq(String copId, BigInteger price) {
        final Function function = new Function(
                FUNC_SETCOPYRIGHTPRICE, 
                Arrays.<Type>asList(new Address(copId),
                new Uint256(price)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getSetCopyrightPriceInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETCOPYRIGHTPRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setCopyrightTag(String copId, String tag) {
        final Function function = new Function(
                FUNC_SETCOPYRIGHTTAG, 
                Arrays.<Type>asList(new Address(copId),
                new Utf8String(tag)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setCopyrightTag(String copId, String tag, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETCOPYRIGHTTAG, 
                Arrays.<Type>asList(new Address(copId),
                new Utf8String(tag)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setCopyrightTagSeq(String copId, String tag) {
        final Function function = new Function(
                FUNC_SETCOPYRIGHTTAG, 
                Arrays.<Type>asList(new Address(copId),
                new Utf8String(tag)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, String> getSetCopyrightTagInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETCOPYRIGHTTAG, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, String>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public RemoteCall<BigInteger> getCopyrightPrice(String copId) {
        final Function function = new Function(FUNC_GETCOPYRIGHTPRICE, 
                Arrays.<Type>asList(new Address(copId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> createCopyright(String copId, String tag, BigInteger date, BigInteger price, String owner, Boolean isOnSale) {
        final Function function = new Function(
                FUNC_CREATECOPYRIGHT, 
                Arrays.<Type>asList(new Address(copId),
                new Utf8String(tag),
                new Uint256(date),
                new Uint256(price),
                new Address(owner),
                new Bool(isOnSale)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void createCopyright(String copId, String tag, BigInteger date, BigInteger price, String owner, Boolean isOnSale, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CREATECOPYRIGHT, 
                Arrays.<Type>asList(new Address(copId),
                new Utf8String(tag),
                new Uint256(date),
                new Uint256(price),
                new Address(owner),
                new Bool(isOnSale)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String createCopyrightSeq(String copId, String tag, BigInteger date, BigInteger price, String owner, Boolean isOnSale) {
        final Function function = new Function(
                FUNC_CREATECOPYRIGHT, 
                Arrays.<Type>asList(new Address(copId),
                new Utf8String(tag),
                new Uint256(date),
                new Uint256(price),
                new Address(owner),
                new Bool(isOnSale)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple6<String, String, BigInteger, BigInteger, String, Boolean> getCreateCopyrightInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_CREATECOPYRIGHT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple6<String, String, BigInteger, BigInteger, String, Boolean>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue(), 
                (BigInteger) results.get(2).getValue(), 
                (BigInteger) results.get(3).getValue(), 
                (String) results.get(4).getValue(), 
                (Boolean) results.get(5).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setDate(String copId, BigInteger date) {
        final Function function = new Function(
                FUNC_SETDATE, 
                Arrays.<Type>asList(new Address(copId),
                new Uint256(date)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setDate(String copId, BigInteger date, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETDATE, 
                Arrays.<Type>asList(new Address(copId),
                new Uint256(date)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setDateSeq(String copId, BigInteger date) {
        final Function function = new Function(
                FUNC_SETDATE, 
                Arrays.<Type>asList(new Address(copId),
                new Uint256(date)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getSetDateInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETDATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public RemoteCall<Tuple6<String, String, BigInteger, BigInteger, String, Boolean>> getCopyrightInfo(String copId) {
        final Function function = new Function(FUNC_GETCOPYRIGHTINFO, 
                Arrays.<Type>asList(new Address(copId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}));
        return new RemoteCall<Tuple6<String, String, BigInteger, BigInteger, String, Boolean>>(
                new Callable<Tuple6<String, String, BigInteger, BigInteger, String, Boolean>>() {
                    @Override
                    public Tuple6<String, String, BigInteger, BigInteger, String, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<String, String, BigInteger, BigInteger, String, Boolean>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (Boolean) results.get(5).getValue());
                    }
                });
    }

    public RemoteCall<String> getCopyrightTag(String copId) {
        final Function function = new Function(FUNC_GETCOPYRIGHTTAG, 
                Arrays.<Type>asList(new Address(copId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setOnSale(String copId, Boolean isOnSale) {
        final Function function = new Function(
                FUNC_SETONSALE, 
                Arrays.<Type>asList(new Address(copId),
                new Bool(isOnSale)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setOnSale(String copId, Boolean isOnSale, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETONSALE, 
                Arrays.<Type>asList(new Address(copId),
                new Bool(isOnSale)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setOnSaleSeq(String copId, Boolean isOnSale) {
        final Function function = new Function(
                FUNC_SETONSALE, 
                Arrays.<Type>asList(new Address(copId),
                new Bool(isOnSale)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, Boolean> getSetOnSaleInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETONSALE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, Boolean>(

                (String) results.get(0).getValue(), 
                (Boolean) results.get(1).getValue()
                );
    }

    public RemoteCall<BigInteger> getCopyrightDate(String copId) {
        final Function function = new Function(FUNC_GETCOPYRIGHTDATE, 
                Arrays.<Type>asList(new Address(copId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setCopyrightOwner(String copId, String newOwner) {
        final Function function = new Function(
                FUNC_SETCOPYRIGHTOWNER, 
                Arrays.<Type>asList(new Address(copId),
                new Address(newOwner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setCopyrightOwner(String copId, String newOwner, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETCOPYRIGHTOWNER, 
                Arrays.<Type>asList(new Address(copId),
                new Address(newOwner)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setCopyrightOwnerSeq(String copId, String newOwner) {
        final Function function = new Function(
                FUNC_SETCOPYRIGHTOWNER, 
                Arrays.<Type>asList(new Address(copId),
                new Address(newOwner)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, String> getSetCopyrightOwnerInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETCOPYRIGHTOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, String>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public RemoteCall<String> getCopyrightOwner(String copId) {
        final Function function = new Function(FUNC_GETCOPYRIGHTOWNER, 
                Arrays.<Type>asList(new Address(copId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static CopyrightsContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CopyrightsContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CopyrightsContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CopyrightsContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CopyrightsContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CopyrightsContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CopyrightsContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CopyrightsContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CopyrightsContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CopyrightsContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CopyrightsContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CopyrightsContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<CopyrightsContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CopyrightsContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CopyrightsContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CopyrightsContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
