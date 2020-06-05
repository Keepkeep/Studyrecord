package com.study.jdk.studyreflect;

import com.study.jdk.entity.Student;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RefletTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //通过反射获取对象
        Class<?> aClass = Class.forName("com.study.jdk.entity.Student");
        Student student = (Student)aClass.newInstance();
        student.setName("张三");
        student.setAge(15);
        student.setId(1L);
        System.out.println("输出小学"+student);


        //获取所有的字段
        Field[] declaredFields = Student.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        //获取公有构造函数
        Constructor<?>[] constructors = Student.class.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }

        //获取所有构造函数 包括私有的和共有的
        Constructor<?>[] declaredConstructors = Student.class.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getName());
        }
        Method setName = Student.class.getMethod("setName", String.class);
        Student student1 = Student.class.newInstance();
        setName.setAccessible(true);
        Object stude = setName.invoke(student1, "王五");
        System.out.println("反射赋值"+student1);

        //
    }
}
