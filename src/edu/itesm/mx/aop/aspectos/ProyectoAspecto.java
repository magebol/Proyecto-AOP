package edu.itesm.mx.aop.aspectos;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ProyectoAspecto {
	  
	@Before("execution(public * edu.itesm.mx.aop.mvc.ProyectoController.abrirProyecto())")
	public void beforeAdvice1() {
		System.out.println("Advice Before Controller - Abriendo proyecto.jsp, Cargando temblores y guardando en CouchDB...");
	}
	@After("execution(public * edu.itesm.mx.aop.mvc.ProyectoController.abrirProyecto())")
	public void afterAdvice1() {
		System.out.println("Advice After Controller - Datos actualizados en CouchDB...");
	}

	@Before("execution(public * edu.itesm.mx.aop.mvc.ProyectoController.jsonpage())")
	public void beforeAdvice3() {
		System.out.println("Advice Before, Controller - Tomando datos de CouchdDB...");
	}
	@After("execution(public * edu.itesm.mx.aop.mvc.ProyectoController.jsonpage())")
	public void afterAdvice3() {
		System.out.println("Advice After, Controller - String Json entregado.");
	}
	
}