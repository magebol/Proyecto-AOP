package edu.itesm.mx.aop.aspectos;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ProyectoAspecto {
	  
	@Before("execution(public * edu.itesm.mx.aop.mvc.ProyectoController.abrirProyecto())")
	public void beforeAdvice1() {
		System.out.println("Before Controller - Abriendo index.jsp. Cargando temblores...");
	}
	
	@Before("execution(public * edu.itesm.mx.aop.mvc.ProyectoController.jsonpage())")
	public void beforeAdvice2() {
		System.out.println("Advice Before, Controller - Pasando json a javascript...");
	}
	
	@After("execution(public * edu.itesm.mx.aop.mvc.ProyectoController.jsonpage())")
	public void beforeAdvice3() {
		System.out.println("Advice After, Controller - json entregado a d3 en app.js");
	}
	
}