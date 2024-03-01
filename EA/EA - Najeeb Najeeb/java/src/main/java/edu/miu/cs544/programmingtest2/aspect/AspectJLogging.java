package edu.miu.cs544.programmingtest2.aspect;

import edu.miu.cs544.programmingtest2.service.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJLogging {

    Logger logger;

    public AspectJLogging(Logger logger) {
        this.logger = logger;
    }

    @Pointcut("execution(* edu.miu.cs544.programmingtest2.service.EmailSystem.connectToMailServer(..))")
    public void emailSending(){}

    @Pointcut("execution(* edu.miu.cs544.programmingtest2.service.EmailSystem.sendEmail(..))")
    public void emailSend() {}

    @Pointcut("execution(* edu.miu.cs544.programmingtest2.service.StudentCRUD.create(..))")
    public void createSudent() {}

    @Pointcut("execution(* edu.miu.cs544.programmingtest2.service.StudentCRUD.delete(..))")
    public void deleteStudent(){}

    @After("emailSending() || createSudent() || deleteStudent()")
    public void after(JoinPoint joinPoint){
        logger.log("After "+joinPoint.getSignature().getDeclaringTypeName() + "-"+joinPoint.getSignature().getName());
    }

    @Before("emailSend()")
    public void before(JoinPoint joinPoint) {
        logger.log("Before "+joinPoint.getSignature().getDeclaringTypeName() + "-"+joinPoint.getSignature().getName());
    }
}
