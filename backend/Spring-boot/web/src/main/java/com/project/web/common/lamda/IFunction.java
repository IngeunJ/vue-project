package com.project.web.common.lamda;

/**
 * IFunction
 */

 //result 타입 객체임
@FunctionalInterface //람다를 사용하겠다는 어노테이션
public interface IFunction {

    public abstract Object apply(Object o);
    
}