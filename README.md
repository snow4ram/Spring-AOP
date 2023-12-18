# AOP 이란

- 관점 지향 프로그래밍 **Aspect Oriented Programming 은 횡단 관심사의 분리 를 허용함으로써 모듈성을 증진 시킨다.**
- 관심사의 분리는 소프트웨어 설계 원칙 중 하나로, 시스템을 여러 부분으로 나누어 각 부분이 **특정 책임**과 **관심사**를 가지도록 하는 방법입니다. 이렇게 함으로써 코드는 단일 책임 원칙(Single Responsibility Principle)을 따르며, 각 모듈이 명확하게 정의된 역할을 수행할 수 있게 됩니다. 이는 유지보수성을 향상시키고 새로운 기능을 추가하거나 수정할 때 전체 시스템에 미치는 영향을 최소화하는 데 도움이 됩니다.

### **AOP Proxies**

- **AOP Proxies 은 기본적으로 JDK 동적 프록시 사용합니다, CGLIB 프록시도 사용할수있다.**

# AOP 용어

### Pointcut

- Advice에 적용할 JoinPoint 를 선별하는 작업
- @Around()에서 지정한 정보와 메소드의 이름이 일치해야 합니다.
- 

### Advice

- Traget 에게 제공할 부가능의 담은 구현체
- Advice 의 경우 타겟 오브젝트의 종속되지 않기 때문에 부가기능을 자유롭게 변경이 가능하다.

### Target

- 부가 기능을 부여할 대상을 지정.

### Aspect

- 에스펙트는 부가될 기능을 정의한 Advice 와 Advice를 어디에 적용할지를 결정하는 포인트컷을 할께 갖고 있습니다.

### @Aspect **를 어드바이저로 변환해서**

**1. 실행:** 스프링 애플리케이션 로딩 시점에 자동 프록시 생성기가 호출됩니다. 이 단계에서는 AOP를 활성화하고 어드바이저를 생성하는 기반이 마련됩니다.

**2. 모든 @Aspect 빈 조회:** 자동 프록시 생성기는 스프링 컨테이너에서 **`@Aspect`** 어노테이션이 붙은 모든 빈을 조회합니다. 이는 어드바이저로 등록될 후보들을 찾는 단계입니다.

**3. 어드바이저 생성:** **`@Aspect`** 어드바이저 빌더를 통해 **`@Aspect`** 어노테이션 정보를 기반으로 어드바이저를 생성합니다**. 여기서 어드바이저는 어드바이스와 포인트컷이 결합된 형태로 생성됩니다.**

```java
javaCopy code
@Aspect
public class LogAOP {
    // Aspect의 구현 내용
}

```

**4. @Aspect 기반 어드바이저 저장:** 생성된 어드바이저를 **`@Aspect`** 어드바이저 빌더 내부 저장소에 저장합니다. 이 단계에서는 어드바이저의 캐싱이 이루어져 중복 생성을 방지하고 성능을 향상시킵니다.

```java
public class LogAOPAdvisor extends AspectJExpressionPointcutAdvisor {
    public LogAOPAdvisor() {
        setAdvice(new LogAOP());
        setExpression(
				"execution(* sectional.springsectional.aop.PostServiceImp    l.*(..))");
    }
}

```

**@Aspect 어드바이저 빌더:**

- **`BeanFactoryAspectJAdvisorsBuilder`** 클래스가 이 역할을 수행합니다.
- **`@Aspect`**의 정보를 기반으로 포인트컷, 어드바이스, 어드바이저를 생성하고 보관합니다.
- **`@Aspect`**의 정보를 기반으로 어드바이저를 생성하고, **`@Aspect`** 어드바이저 빌더 내부 저장소에 캐시합니다.
- 캐시에 어드바이저가 이미 만들어져 있는 경우, 캐시에 저장된 어드바이저를 반환합니다.

이렇게 설정된 어드바이저는 **`@Aspect`** 어노테이션을 사용한 클래스의 어드바이스와 포인트컷을 조합하여 원하는 로직을 적용하게 됩니다. AspectJ 표현식인 "execution(* sectional.springsectional.aop.PostServiceImpl.*(..))"은 어떤 메소드에 어드바이스를 적용할지를 정의합니다.
