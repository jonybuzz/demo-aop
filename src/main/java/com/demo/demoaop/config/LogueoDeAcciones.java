package com.demo.demoaop.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

@Aspect
@Configuration
@Slf4j
public class LogueoDeAcciones {

    @Before("execution(* com.demo.demoaop.controller.rest.*.*(..))")
    public void loguearAntesDeConsultaRest(JoinPoint joinPoint) {
        ThreadContext.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
        log.info("[Consulta REST] Usuario: {}. Método: {}. Parámetros: {}",
                SecurityContextHolder.getContext().getAuthentication().getName(),
                joinPoint.getSignature().getName(),
                joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* com.demo.demoaop.controller.rest.*.*(..))", returning = "resultado")
    public void loguearAlFinalDeConsultaRest(JoinPoint joinPoint, Object resultado) {
        log.info("[Respuesta REST] Usuario: {}. Método: {}. Parámetros: {}. Resultado: {}",
                SecurityContextHolder.getContext().getAuthentication().getName(),
                joinPoint.getSignature().getName(),
                joinPoint.getArgs(),
                resultado);
    }

    @Before("execution(* com.demo.demoaop.dominio.*.*(..))")
    public void loguearAntesDeModificarUnaPersona(JoinPoint joinPoint) {
        ThreadContext.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
        log.info("[Modificación de persona] Usuario: {}. Método: {}. Parámetros: {}",
                SecurityContextHolder.getContext().getAuthentication().getName(),
                joinPoint.getSignature().getName(),
                joinPoint.getArgs());
    }

}
