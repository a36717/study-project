package com.studyProject.demos.DesignPattern.Creational.Singleton;

import com.studyProject.demos.DesignPattern.Creational.Singleton.Hungry.StaticCodeBlock;
import com.studyProject.demos.DesignPattern.Creational.Singleton.Hungry.StaticConst;
import com.studyProject.demos.DesignPattern.Creational.Singleton.Lazy.DoubleCheck;
import com.studyProject.demos.DesignPattern.Creational.Singleton.Lazy.StaticInternalClass;
import com.studyProject.demos.DesignPattern.Creational.Singleton.Lazy.SynchronizationMethod;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

//单例模式
public class Client implements Singleton {
    public static Map<String, Pair<Singleton,Singleton>> commonMap=new HashMap();
    public static Map<String, Pair<Singleton,Singleton>> serializeMap =new HashMap();
    public static Map<String, Pair<Singleton,Singleton>> cloneMap=new HashMap();
    public static void main(String[] args) throws Exception {
        commonInit();
        serializeInit();
        cloneInit();
        System.out.println("普通对象");
        check(commonMap);
        System.out.println("序列化对象");
        check(serializeMap);
        System.out.println("克隆对象");
        System.out.println("SingletonEnum:枚举类不能重写clone方法");
        check(cloneMap);
        System.out.println("反射安全");
        Class<?> c1 = SingletonEnum.class;
        Constructor<?> declaredConstructor = c1.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Class<?> c2 = StaticInternalClass.class;
        Constructor<?> declaredConstructor2 = c2.getDeclaredConstructor();
        declaredConstructor2.setAccessible(true);
        System.out.println(StaticInternalClass.getInstance()==declaredConstructor.newInstance());
    }

    private static void check(Map<String, Pair<Singleton, Singleton>> commonMap) {
        for (Map.Entry<String, Pair<Singleton, Singleton>> entry : commonMap.entrySet()) {
            String key = entry.getKey();
            Pair<Singleton, Singleton> value = entry.getValue();
            System.out.println(key+":"+(value.getLeft()==value.getRight()));
        }
    }

    private static void cloneInit() throws Exception {
        cloneMap.put("StaticCodeBlock",Pair.of(StaticCodeBlock.getInstance(),(Singleton) StaticCodeBlock.getInstance().clone()));
        cloneMap.put("StaticConst",Pair.of(StaticConst.getInstance(),(Singleton) StaticConst.getInstance().clone()));
        cloneMap.put("DoubleCheck",Pair.of(DoubleCheck.getInstance(),(Singleton) DoubleCheck.getInstance().clone()));
        cloneMap.put("StaticInternalClass",Pair.of(StaticInternalClass.getInstance(),(Singleton) StaticInternalClass.getInstance().clone()));
        cloneMap.put("SynchronizationMethod",Pair.of(SynchronizationMethod.getInstance(),(Singleton) SynchronizationMethod.getInstance().clone()));

    }

    private static void serializeInit() throws Exception {
        ObjectOutputStream outputSingletonEnum = new ObjectOutputStream(new FileOutputStream("singletonEnum"));
        outputSingletonEnum.writeObject(SingletonEnum.INSTANCE);
        File singletonEnumFile = new File("singletonEnum");
        ObjectInputStream inputSingletonEnum = new ObjectInputStream(new FileInputStream(singletonEnumFile));
        serializeMap.put("SingletonEnum",Pair.of(SingletonEnum.INSTANCE,(Singleton) inputSingletonEnum.readObject()));

        ObjectOutputStream outputStaticCodeBlock = new ObjectOutputStream(new FileOutputStream("StaticCodeBlock"));
        outputStaticCodeBlock.writeObject(StaticCodeBlock.getInstance());
        File StaticCodeBlockFile = new File("StaticCodeBlock");
        ObjectInputStream inputStaticCodeBlock = new ObjectInputStream(new FileInputStream(StaticCodeBlockFile));
        serializeMap.put("StaticCodeBlock",Pair.of(StaticCodeBlock.getInstance(),(Singleton) inputStaticCodeBlock.readObject()));

        ObjectOutputStream outputStaticConst = new ObjectOutputStream(new FileOutputStream("StaticConst"));
        outputStaticConst.writeObject(StaticConst.getInstance());
        File StaticConstFile = new File("StaticConst");
        ObjectInputStream inputStaticConst = new ObjectInputStream(new FileInputStream(StaticConstFile));
        serializeMap.put("StaticConst",Pair.of(StaticConst.getInstance(),(Singleton) inputStaticConst.readObject()));

        ObjectOutputStream outputDoubleCheck = new ObjectOutputStream(new FileOutputStream("DoubleCheck"));
        outputDoubleCheck.writeObject(DoubleCheck.getInstance());
        File DoubleCheckFile = new File("DoubleCheck");
        ObjectInputStream inputDoubleCheck = new ObjectInputStream(new FileInputStream(DoubleCheckFile));
        serializeMap.put("DoubleCheck",Pair.of(DoubleCheck.getInstance(),(Singleton) inputDoubleCheck.readObject()));

        ObjectOutputStream outputStaticInternalClass = new ObjectOutputStream(new FileOutputStream("StaticInternalClass"));
        outputStaticInternalClass.writeObject(StaticInternalClass.getInstance());
        File StaticInternalClassFile = new File("StaticInternalClass");
        ObjectInputStream inputStaticInternalClass = new ObjectInputStream(new FileInputStream(StaticInternalClassFile));
        serializeMap.put("StaticInternalClass",Pair.of(StaticInternalClass.getInstance(),(Singleton) inputStaticInternalClass.readObject()));

        ObjectOutputStream outputSynchronizationMethod = new ObjectOutputStream(new FileOutputStream("SynchronizationMethod"));
        outputSynchronizationMethod.writeObject(SynchronizationMethod.getInstance());
        File SynchronizationMethodFile = new File("SynchronizationMethod");
        ObjectInputStream inputSynchronizationMethod = new ObjectInputStream(new FileInputStream(SynchronizationMethodFile));
        serializeMap.put("SynchronizationMethod",Pair.of(SynchronizationMethod.getInstance(),(Singleton) inputSynchronizationMethod.readObject()));
    }

    private static void commonInit(){
        commonMap.put("StaticCodeBlock",Pair.of(StaticCodeBlock.getInstance(),StaticCodeBlock.getInstance()));
        commonMap.put("SingletonEnum",Pair.of(SingletonEnum.INSTANCE,SingletonEnum.INSTANCE));
        commonMap.put("StaticConst",Pair.of(StaticConst.getInstance(),StaticConst.getInstance()));
        commonMap.put("DoubleCheck",Pair.of(DoubleCheck.getInstance(),DoubleCheck.getInstance()));
        commonMap.put("StaticInternalClass",Pair.of(StaticInternalClass.getInstance(),StaticInternalClass.getInstance()));
        commonMap.put("SynchronizationMethod",Pair.of(SynchronizationMethod.getInstance(),SynchronizationMethod.getInstance()));
    }
}
