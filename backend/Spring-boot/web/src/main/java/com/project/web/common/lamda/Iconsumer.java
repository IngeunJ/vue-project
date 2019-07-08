package com.project.web.common.lamda;

/**
 * Iconsumer
 */
//@FunctionalInterface ,public abstract void accept(Object o); 쓰면 
//자바 8를 쓰고 있는거고 함수형프로그래밍을 하고 있는것이다. 셋터같은 느낌
@FunctionalInterface
public interface Iconsumer {
    public abstract void accept(Object o);
    
}