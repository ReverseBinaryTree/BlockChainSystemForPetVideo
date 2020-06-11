package org.fisco.bcos.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.channel.event.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Event;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int256;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
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
public class MarketContract extends Contract {
    public static final String[] BINARY_ARRAY = {"6080604052600060045534801561001557600080fd5b506125c4806100256000396000f3006080604052600436106100ba576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806330c060d0146100bf57806336351c7c14610116578063473e3e181461016357806352c0d75e14610232578063542a22741461029557806365eb205d14610318578063711288051461035b5780637f5f2635146103de57806393dc5046146104215780639ef22dad14610464578063a4630c8a1461048f578063b4ce65eb146104fc575b600080fd5b3480156100cb57600080fd5b50610100600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061055d565b6040518082815260200191505060405180910390f35b34801561012257600080fd5b50610161600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610651565b005b34801561016f57600080fd5b50610230600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610831565b005b34801561023e57600080fd5b50610293600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610ce6565b005b3480156102a157600080fd5b50610316600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611ce3565b005b34801561032457600080fd5b50610359600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611dab565b005b34801561036757600080fd5b506103dc600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611def565b005b3480156103ea57600080fd5b5061041f600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506120d1565b005b34801561042d57600080fd5b50610462600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050612115565b005b34801561047057600080fd5b50610479612159565b6040518082815260200191505060405180910390f35b34801561049b57600080fd5b506104ba60048036038101908080359060200190929190505050612165565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561050857600080fd5b50610547600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506121a7565b6040518082815260200191505060405180910390f35b6000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b3b246c48360006040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200192505050600060405180830381600087803b15801561062957600080fd5b505af115801561063d573d6000803e3d6000fd5b5050505061064a826123d7565b9050919050565b6000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16639b96eece846040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15801561071057600080fd5b505af1158015610724573d6000803e3d6000fd5b505050506040513d602081101561073a57600080fd5b81019080805190602001909291905050509050600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b46310f6848484016040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050600060405180830381600087803b15801561081457600080fd5b505af1158015610828573d6000803e3d6000fd5b50505050505050565b600080600060046000815480929190600101919050555042846004546040516020018084815260200183805190602001908083835b60208310151561088b5780518252602082019150602081019050602083039250610866565b6001836020036101000a03801982511681845116808217855250505050505090500182815260200193505050506040516020818303038152906040526040518082805190602001908083835b6020831015156108fc57805182526020820191506020810190506020830392506108d7565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020600190049250829150429050600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16639635779483878460008b60006040518763ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001806020018681526020018581526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183151515158152602001828103825287818151815260200191508051906020019080838360005b83811015610a60578082015181840152602081019050610a45565b50505050905090810190601f168015610a8d5780820380516001836020036101000a031916815260200191505b50975050505050505050600060405180830381600087803b158015610ab157600080fd5b505af1158015610ac5573d6000803e3d6000fd5b50505050600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663bddb2f5987846040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050600060405180830381600087803b158015610bba57600080fd5b505af1158015610bce573d6000803e3d6000fd5b505050507fe23c4aab2b6030deba0b6dba97c8a9a7f45db8f204eb71f27070b25a057165f682878784604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001838152602001828103825284818151815260200191508051906020019080838360005b83811015610ca1578082015181840152602081019050610c86565b50505050905090810190601f168015610cce5780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a1505050505050565b6000806000806060600080600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16639b96eece8a6040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b158015610dae57600080fd5b505af1158015610dc2573d6000803e3d6000fd5b505050506040513d6020811015610dd857600080fd5b81019080805190602001909291905050509650600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16634da86921896040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b158015610ea857600080fd5b505af1158015610ebc573d6000803e3d6000fd5b505050506040513d6020811015610ed257600080fd5b8101908080519060200190929190505050955085871015610f92577fc9e36e491b8f30e7c25ea7cba54a616daa680b7f3305ee798e54d8f8a0afb14c89896001604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001935050505060405180910390a1611cd8565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663d9d8d59e896040518263ffffffff","167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15801561104f57600080fd5b505af1158015611063573d6000803e3d6000fd5b505050506040513d602081101561107957600080fd5b81019080805190602001909291905050509450600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16639b96eece866040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15801561114957600080fd5b505af115801561115d573d6000803e3d6000fd5b505050506040513d602081101561117357600080fd5b81019080805190602001909291905050509350600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663ab296619896040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b15801561124357600080fd5b505af1158015611257573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f82011682018060405250602081101561128157600080fd5b81019080805164010000000081111561129957600080fd5b828101905060208101848111156112af57600080fd5b81518560018202830111640100000000821117156112cc57600080fd5b50509291905050509250600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663be068c44898b6040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050600060405180830381600087803b1580156113c757600080fd5b505af11580156113db573d6000803e3d6000fd5b50505050600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b3b246c48960006040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200192505050600060405180830381600087803b1580156114a957600080fd5b505af11580156114bd573d6000803e3d6000fd5b50505050889150600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166307f2d438428a868a8a886040518763ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808781526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001806020018581526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825286818151815260200191508051906020019080838360005b838110156116155780820151818401526020810190506115fa565b50505050905090810190601f1680156116425780820380516001836020036101000a031916815260200191505b50975050505050505050602060405180830381600087803b15801561166657600080fd5b505af115801561167a573d6000803e3d6000fd5b505050506040513d602081101561169057600080fd5b81019080805190602001909291905050509050600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b214dcd4868a6040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050600060405180830381600087803b15801561179457600080fd5b505af11580156117a8573d6000803e3d6000fd5b50505050600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663bddb2f598a8a6040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050600060405180830381600087803b15801561189d57600080fd5b505af11580156118b1573d6000803e3d6000fd5b50505050600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166384a372738a836040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050600060405180830381600087803b15801561197a57600080fd5b505af115801561198e573d6000803e3d6000fd5b50505050600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166384a3727386836040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050600060405180830381600087803b158015611a5757600080fd5b505af1158015611a6b573d6000803e3d6000fd5b50505050600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b46310f68a888a036040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050600060405180830381600087803b158015611b3657600080fd5b505af1158015611b4a573d6000803e3d6000fd5b50505050600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b46310f6868887016040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050600060405180830381600087803b158015611c1557600080fd5b505af1158015611c29573d6000803e3d6000fd5b50505050611c36886123d7565b507fc9e36e491b8f30e7c25ea7cba54a616daa680b7f3305ee798e54d8f8a0afb14c89896000604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001935050505060405180910390a15b505050505050505050565b82600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505050565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b214dcd484836040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050600060405180830381600087803b158015611ee057600080fd5b505af1158015611ef4573d6000803e3d6000fd5b50505050600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663bddb2f5983836040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001925050506000604051808303816000","87803b158015611fe957600080fd5b505af1158015611ffd573d6000803e3d6000fd5b505050507f20e2c82fbd5c060505a997fd579a5007620a7debb21519da42e88fd01a60fa5b838383604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001935050505060405180910390a1505050565b80600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b80600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b60008080549050905090565b6000808281548110151561217557fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b6000808390806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b3b246c48460016040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200192505050600060405180830381600087803b1580156122d857600080fd5b505af11580156122ec573d6000803e3d6000fd5b50505050600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16631695834184846040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050600060405180830381600087803b1580156123b557600080fd5b505af11580156123c9573d6000803e3d6000fd5b505050506000905092915050565b60008060008091505b60008054905082101561253b576000828154811015156123fc57fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff16141561252e578190505b60016000805490500381101561250f5760006001820181548110151561248057fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166000828154811015156124ba57fe5b9060005260206000200160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550808060010191505061245e565b60008054809190600190036125249190612547565b5060009250612540565b81806001019250506123e0565b600192505b5050919050565b81548183558181111561256e5781836000526020600020918201910161256d9190612573565b5b505050565b61259591905b80821115612591576000816000905550600101612579565b5090565b905600a165627a7a723058202b6a626bb1263b2f592127c9f0bd8ffe2c24853b9d4a96e20adac36fe669b85c0029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"copyrightId\",\"type\":\"address\"}],\"name\":\"pullCopyright\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"user\",\"type\":\"address\"},{\"name\":\"amount\",\"type\":\"uint256\"}],\"name\":\"recharge\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"user\",\"type\":\"address\"},{\"name\":\"tag\",\"type\":\"string\"},{\"name\":\"hashOfVedio\",\"type\":\"string\"}],\"name\":\"createCopyrightAndGiveTo\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"buyer\",\"type\":\"address\"},{\"name\":\"copyrightId\",\"type\":\"address\"}],\"name\":\"buyCopyright\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"accountAddr\",\"type\":\"address\"},{\"name\":\"copyrightsAddr\",\"type\":\"address\"},{\"name\":\"transactionAddr\",\"type\":\"address\"}],\"name\":\"setInterfaces\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"copyrightsAddr\",\"type\":\"address\"}],\"name\":\"setCopyrightsInterface\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"fromWho\",\"type\":\"address\"},{\"name\":\"toWho\",\"type\":\"address\"},{\"name\":\"copyrightId\",\"type\":\"address\"}],\"name\":\"giveTo\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"accountAddr\",\"type\":\"address\"}],\"name\":\"setAccountInterface\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"transactionAddr\",\"type\":\"address\"}],\"name\":\"setTransactionInterface\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getCopyrightsOnSaleNum\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"index\",\"type\":\"uint256\"}],\"name\":\"getAddressOfCopyrightsOnSale\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"copyrightId\",\"type\":\"address\"},{\"name\":\"price\",\"type\":\"uint256\"}],\"name\":\"pushCopyright\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"copyrightId\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"owner\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"tag\",\"type\":\"string\"},{\"indexed\":false,\"name\":\"date\",\"type\":\"uint256\"}],\"name\":\"CreateCopyrightAndGiveTo\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"buyer\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"copyrightId\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"code\",\"type\":\"int256\"}],\"name\":\"BuyCopyrightEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"fromWho\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"toWho\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"copyrightId\",\"type\":\"address\"}],\"name\":\"GiveTo\",\"type\":\"event\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_PULLCOPYRIGHT = "pullCopyright";

    public static final String FUNC_RECHARGE = "recharge";

    public static final String FUNC_CREATECOPYRIGHTANDGIVETO = "createCopyrightAndGiveTo";

    public static final String FUNC_BUYCOPYRIGHT = "buyCopyright";

    public static final String FUNC_SETINTERFACES = "setInterfaces";

    public static final String FUNC_SETCOPYRIGHTSINTERFACE = "setCopyrightsInterface";

    public static final String FUNC_GIVETO = "giveTo";

    public static final String FUNC_SETACCOUNTINTERFACE = "setAccountInterface";

    public static final String FUNC_SETTRANSACTIONINTERFACE = "setTransactionInterface";

    public static final String FUNC_GETCOPYRIGHTSONSALENUM = "getCopyrightsOnSaleNum";

    public static final String FUNC_GETADDRESSOFCOPYRIGHTSONSALE = "getAddressOfCopyrightsOnSale";

    public static final String FUNC_PUSHCOPYRIGHT = "pushCopyright";

    public static final Event CREATECOPYRIGHTANDGIVETO_EVENT = new Event("CreateCopyrightAndGiveTo", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event BUYCOPYRIGHTEVENT_EVENT = new Event("BuyCopyrightEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Int256>() {}));
    ;

    public static final Event GIVETO_EVENT = new Event("GiveTo", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    @Deprecated
    protected MarketContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MarketContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MarketContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MarketContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> pullCopyright(String copyrightId) {
        final Function function = new Function(
                FUNC_PULLCOPYRIGHT, 
                Arrays.<Type>asList(new Address(copyrightId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void pullCopyright(String copyrightId, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_PULLCOPYRIGHT, 
                Arrays.<Type>asList(new Address(copyrightId)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String pullCopyrightSeq(String copyrightId) {
        final Function function = new Function(
                FUNC_PULLCOPYRIGHT, 
                Arrays.<Type>asList(new Address(copyrightId)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getPullCopyrightInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_PULLCOPYRIGHT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public Tuple1<BigInteger> getPullCopyrightOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_PULLCOPYRIGHT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> recharge(String user, BigInteger amount) {
        final Function function = new Function(
                FUNC_RECHARGE, 
                Arrays.<Type>asList(new Address(user),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void recharge(String user, BigInteger amount, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_RECHARGE, 
                Arrays.<Type>asList(new Address(user),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String rechargeSeq(String user, BigInteger amount) {
        final Function function = new Function(
                FUNC_RECHARGE, 
                Arrays.<Type>asList(new Address(user),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getRechargeInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_RECHARGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> createCopyrightAndGiveTo(String user, String tag, String hashOfVedio) {
        final Function function = new Function(
                FUNC_CREATECOPYRIGHTANDGIVETO, 
                Arrays.<Type>asList(new Address(user),
                new Utf8String(tag),
                new Utf8String(hashOfVedio)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void createCopyrightAndGiveTo(String user, String tag, String hashOfVedio, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CREATECOPYRIGHTANDGIVETO, 
                Arrays.<Type>asList(new Address(user),
                new Utf8String(tag),
                new Utf8String(hashOfVedio)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String createCopyrightAndGiveToSeq(String user, String tag, String hashOfVedio) {
        final Function function = new Function(
                FUNC_CREATECOPYRIGHTANDGIVETO, 
                Arrays.<Type>asList(new Address(user),
                new Utf8String(tag),
                new Utf8String(hashOfVedio)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<String, String, String> getCreateCopyrightAndGiveToInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_CREATECOPYRIGHTANDGIVETO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple3<String, String, String>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue(), 
                (String) results.get(2).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> buyCopyright(String buyer, String copyrightId) {
        final Function function = new Function(
                FUNC_BUYCOPYRIGHT, 
                Arrays.<Type>asList(new Address(buyer),
                new Address(copyrightId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void buyCopyright(String buyer, String copyrightId, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_BUYCOPYRIGHT, 
                Arrays.<Type>asList(new Address(buyer),
                new Address(copyrightId)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String buyCopyrightSeq(String buyer, String copyrightId) {
        final Function function = new Function(
                FUNC_BUYCOPYRIGHT, 
                Arrays.<Type>asList(new Address(buyer),
                new Address(copyrightId)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, String> getBuyCopyrightInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_BUYCOPYRIGHT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, String>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setInterfaces(String accountAddr, String copyrightsAddr, String transactionAddr) {
        final Function function = new Function(
                FUNC_SETINTERFACES, 
                Arrays.<Type>asList(new Address(accountAddr),
                new Address(copyrightsAddr),
                new Address(transactionAddr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setInterfaces(String accountAddr, String copyrightsAddr, String transactionAddr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETINTERFACES, 
                Arrays.<Type>asList(new Address(accountAddr),
                new Address(copyrightsAddr),
                new Address(transactionAddr)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setInterfacesSeq(String accountAddr, String copyrightsAddr, String transactionAddr) {
        final Function function = new Function(
                FUNC_SETINTERFACES, 
                Arrays.<Type>asList(new Address(accountAddr),
                new Address(copyrightsAddr),
                new Address(transactionAddr)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<String, String, String> getSetInterfacesInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETINTERFACES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple3<String, String, String>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue(), 
                (String) results.get(2).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setCopyrightsInterface(String copyrightsAddr) {
        final Function function = new Function(
                FUNC_SETCOPYRIGHTSINTERFACE, 
                Arrays.<Type>asList(new Address(copyrightsAddr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setCopyrightsInterface(String copyrightsAddr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETCOPYRIGHTSINTERFACE, 
                Arrays.<Type>asList(new Address(copyrightsAddr)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setCopyrightsInterfaceSeq(String copyrightsAddr) {
        final Function function = new Function(
                FUNC_SETCOPYRIGHTSINTERFACE, 
                Arrays.<Type>asList(new Address(copyrightsAddr)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getSetCopyrightsInterfaceInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETCOPYRIGHTSINTERFACE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> giveTo(String fromWho, String toWho, String copyrightId) {
        final Function function = new Function(
                FUNC_GIVETO, 
                Arrays.<Type>asList(new Address(fromWho),
                new Address(toWho),
                new Address(copyrightId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void giveTo(String fromWho, String toWho, String copyrightId, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_GIVETO, 
                Arrays.<Type>asList(new Address(fromWho),
                new Address(toWho),
                new Address(copyrightId)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String giveToSeq(String fromWho, String toWho, String copyrightId) {
        final Function function = new Function(
                FUNC_GIVETO, 
                Arrays.<Type>asList(new Address(fromWho),
                new Address(toWho),
                new Address(copyrightId)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<String, String, String> getGiveToInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_GIVETO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple3<String, String, String>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue(), 
                (String) results.get(2).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setAccountInterface(String accountAddr) {
        final Function function = new Function(
                FUNC_SETACCOUNTINTERFACE, 
                Arrays.<Type>asList(new Address(accountAddr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setAccountInterface(String accountAddr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETACCOUNTINTERFACE, 
                Arrays.<Type>asList(new Address(accountAddr)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setAccountInterfaceSeq(String accountAddr) {
        final Function function = new Function(
                FUNC_SETACCOUNTINTERFACE, 
                Arrays.<Type>asList(new Address(accountAddr)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getSetAccountInterfaceInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETACCOUNTINTERFACE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setTransactionInterface(String transactionAddr) {
        final Function function = new Function(
                FUNC_SETTRANSACTIONINTERFACE, 
                Arrays.<Type>asList(new Address(transactionAddr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setTransactionInterface(String transactionAddr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETTRANSACTIONINTERFACE, 
                Arrays.<Type>asList(new Address(transactionAddr)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setTransactionInterfaceSeq(String transactionAddr) {
        final Function function = new Function(
                FUNC_SETTRANSACTIONINTERFACE, 
                Arrays.<Type>asList(new Address(transactionAddr)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getSetTransactionInterfaceInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETTRANSACTIONINTERFACE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<BigInteger> getCopyrightsOnSaleNum() {
        final Function function = new Function(FUNC_GETCOPYRIGHTSONSALENUM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getAddressOfCopyrightsOnSale(BigInteger index) {
        final Function function = new Function(FUNC_GETADDRESSOFCOPYRIGHTSONSALE, 
                Arrays.<Type>asList(new Uint256(index)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> pushCopyright(String copyrightId, BigInteger price) {
        final Function function = new Function(
                FUNC_PUSHCOPYRIGHT, 
                Arrays.<Type>asList(new Address(copyrightId),
                new Uint256(price)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void pushCopyright(String copyrightId, BigInteger price, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_PUSHCOPYRIGHT, 
                Arrays.<Type>asList(new Address(copyrightId),
                new Uint256(price)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String pushCopyrightSeq(String copyrightId, BigInteger price) {
        final Function function = new Function(
                FUNC_PUSHCOPYRIGHT, 
                Arrays.<Type>asList(new Address(copyrightId),
                new Uint256(price)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getPushCopyrightInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_PUSHCOPYRIGHT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public Tuple1<BigInteger> getPushCopyrightOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_PUSHCOPYRIGHT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public List<CreateCopyrightAndGiveToEventResponse> getCreateCopyrightAndGiveToEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(CREATECOPYRIGHTANDGIVETO_EVENT, transactionReceipt);
        ArrayList<CreateCopyrightAndGiveToEventResponse> responses = new ArrayList<CreateCopyrightAndGiveToEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            CreateCopyrightAndGiveToEventResponse typedResponse = new CreateCopyrightAndGiveToEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.copyrightId = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.owner = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.tag = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.date = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerCreateCopyrightAndGiveToEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(CREATECOPYRIGHTANDGIVETO_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerCreateCopyrightAndGiveToEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(CREATECOPYRIGHTANDGIVETO_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<BuyCopyrightEventEventResponse> getBuyCopyrightEventEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(BUYCOPYRIGHTEVENT_EVENT, transactionReceipt);
        ArrayList<BuyCopyrightEventEventResponse> responses = new ArrayList<BuyCopyrightEventEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            BuyCopyrightEventEventResponse typedResponse = new BuyCopyrightEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.buyer = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.copyrightId = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.code = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerBuyCopyrightEventEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(BUYCOPYRIGHTEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerBuyCopyrightEventEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(BUYCOPYRIGHTEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<GiveToEventResponse> getGiveToEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(GIVETO_EVENT, transactionReceipt);
        ArrayList<GiveToEventResponse> responses = new ArrayList<GiveToEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            GiveToEventResponse typedResponse = new GiveToEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.fromWho = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.toWho = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.copyrightId = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerGiveToEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(GIVETO_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerGiveToEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(GIVETO_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    @Deprecated
    public static MarketContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MarketContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MarketContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MarketContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MarketContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MarketContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MarketContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MarketContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MarketContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MarketContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MarketContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MarketContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<MarketContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MarketContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MarketContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MarketContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class CreateCopyrightAndGiveToEventResponse {
        public Log log;

        public String copyrightId;

        public String owner;

        public String tag;

        public BigInteger date;
    }

    public static class BuyCopyrightEventEventResponse {
        public Log log;

        public String buyer;

        public String copyrightId;

        public BigInteger code;
    }

    public static class GiveToEventResponse {
        public Log log;

        public String fromWho;

        public String toWho;

        public String copyrightId;
    }
}
