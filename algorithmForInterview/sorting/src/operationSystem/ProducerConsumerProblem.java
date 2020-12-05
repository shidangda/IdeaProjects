package operationSystem;

/*
public class ProducerConsumerProblem {
    int mutex=1;  //表示缓冲区临界资源，初始为1
    int empty=n;  //表示缓冲池中空缓冲区数目，初始为n
    int full=0;  //表示缓冲池中满缓冲区数目，初始为0

    public void producer(){
        produce an item on nextp;
        P(empty);  //关键是P(empty)必须在P(mutex)之前，P(full)同理
        P(mutex);
        add nextp to buffer;
        V(mutex);
        V(full);
    }

    public void consumer(){
        P(full);
        P(mutex);
        remove an item from buffer;
        V(mutex);
        V(full);
        consume the item;
    }

}


 */