package com.eistgeist.flightsystem.aspect;// src/main/java/com/yourpackage/aspect/ServiceInterceptorAspect.java

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

@Aspect
@Component
public class ServiceInterceptorAspect {
    @Around("execution(* com.eistgeist.flightsystem.service.*.*(..))")
    public Object interceptServiceMethods(ProceedingJoinPoint joinPoint) {
        // Get method signature and return type
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class<?> returnType = signature.getReturnType();

        try {
            // Check if the return type is a Collection
            if (Collection.class.isAssignableFrom(returnType)) {
                // Get the generic return type
                Type genericReturnType = signature.getMethod().getGenericReturnType();
                return handleCollectionReturnType(returnType, genericReturnType);
            } else if (returnType.isArray()) {
                // Handle array return types
                return handleArrayReturnType(returnType);
            } else {
                // Handle single object return types
                return returnType.getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            System.err.println("Exception in aspect: " + e.getMessage());
            return null;
        }
    }

    private Object handleCollectionReturnType(Class<?> collectionType, Type genericReturnType) throws Exception {
        if (genericReturnType instanceof ParameterizedType) {
            // Get the actual type arguments (e.g., List<AccountDataDTO> -> AccountDataDTO)
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            if (actualTypeArguments.length == 1) {
                // Instantiate the element type
                Class<?> elementType = (Class<?>) actualTypeArguments[0];
                Object elementInstance = elementType.getDeclaredConstructor().newInstance();

                // Create and populate the collection
                Collection<Object> collection = createCollectionInstance(collectionType);
                collection.add(elementInstance);
                return collection;
            }
        }

        // If we can't determine the element type, return an empty collection
        return createCollectionInstance(collectionType);
    }

    private Object handleArrayReturnType(Class<?> arrayType) throws Exception {
        // Get the component type (e.g., AccountDataDTO[])
        Class<?> componentType = arrayType.getComponentType();
        // Instantiate the element type
        Object elementInstance = componentType.getDeclaredConstructor().newInstance();
        // Create and populate the array
        Object array = Array.newInstance(componentType, 1);
        Array.set(array, 0, elementInstance);
        return array;
    }

    @SuppressWarnings("unchecked")
    private Collection<Object> createCollectionInstance(Class<?> collectionType) throws Exception {
        if (collectionType.isInterface()) {
            if (List.class.isAssignableFrom(collectionType)) {
                return new ArrayList<>();
            } else if (Set.class.isAssignableFrom(collectionType)) {
                return new HashSet<>();
            } else if (Queue.class.isAssignableFrom(collectionType)) {
                return new LinkedList<>();
            } else {
                // Default to ArrayList for other interfaces
                return new ArrayList<>();
            }
        } else {
            // Instantiate concrete collection class
            return (Collection<Object>) collectionType.getDeclaredConstructor().newInstance();
        }
    }
}