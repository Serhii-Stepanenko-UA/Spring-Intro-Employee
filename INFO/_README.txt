
КОНФІГУРАЦІЯ SPRING ПРОЕКТУ

Тут, застосована Java-based конфігурація.
https://docs.spring.io/spring-framework/reference/core/beans/java.html

Основою в Java-based конфігурації є класи з анотаціями @Configuration
та методи з анотаціями @Bean.

Анотація @Bean використовується, щоб вказати, що метод створює екземпляр,
налаштовує та ініціалізує новий об’єкт, яким керуватиме
Spring IoC (Inversion of Control) контейнер.

Анотація @Configuration вказує на те, що основне призначення класу —
джерело визначень компонентів.

Анотовані @Configuration класи дозволяють визначати залежності між
компонентами шляхом виклику інших методів @Bean у тому ж класі.

Spring Beans (bean-компоненти) - Java об'єкти, якими управляє
Spring IoC контейнер. Ці bean-компоненти створюються за допомогою метаданих
конфігурацій, які надаються контейнеру.

Spring IoC контейнер керує одним або декількома bean-компонентами.
Spring IoC контейнер відповідає за створення, налаштування та збирання
компонентів. Контейнер отримує інструкції про те, які об'єкти створювати,
налаштовувати та збирати, зчитуючи метадані конфігурації.

Активація Spring IoC контейнера, завантаження конфігураційного класу
здійснюється через Class AnnotationConfigApplicationContext, який виконує
кілька кроків для створення контексту програми:

(1) Сканування анотованих класів: коли створюється
Class AnnotationConfigApplicationContext, він сканує вказані пакети
на наявність класів, анотованих стереотипними анотаціями Spring,
такими як @Configuration, @Component, @Service та @Repository.
Ці анотації використовуються, щоб позначити класи як частину
Spring програми і вказати, що клас має бути зареєстрований
у контексті.

(2) Створення визначень bean-компонентів: після виявлення анотованих
класів, Class AnnotationConfigApplicationContext створює визначення
bean-компонентів для кожного з анотованих класів.
Визначення компонента — це метадані конфігурації, які описують,
як створити та налаштувати компонент, включаючи його клас, аргументи
конструктора, значення властивостей та інші метадані.

(3) Реєстрація визначень компонентів: після створення визначень компонентів,
Class AnnotationConfigApplicationContext реєструє їх у контексті програми.
Це дозволяє контексту керувати життєвим циклом компонентів, включаючи їх створення,
коли вони потрібні, і знищення, коли контекст закрито.

(4) З’єднання bean-компонентів разом: після реєстрації bean-компонентів
Class AnnotationConfigApplicationContext об’єднує їх разом, вирішуючи
залежності між ними. Це передбачає пошук інших компонентів у контексті
та введення їх у компоненти, яким вони потрібні.

(5) Ініціалізація контексту: Class AnnotationConfigApplicationContext
ініціалізує контекст, викликаючи будь-які методи @PostConstruct
на bean-компонентах і запускаючи будь-які контекстно пов’язані події,
які були зареєстровані. Це дозволяє компонентам виконувати будь-які додаткові
кроки ініціалізації, які необхідні перед їх використанням.

------------------------

@Component vs @Bean

@Component показує, що анотований клас є "компонентом".
Такі класи розглядаються як кандидати на автоматичне виявлення під час
використання конфігурації з урахуванням анотацій та сканування шляхів
до класів.

Spring сканує додаток на наявність класів, анотованих через @Component.
Створює їх екземпляри та впроваджує в них будь-які зазначені залежності.
Вставляє їх туди, де це потрібно.

@Bean є анотацією, яку Spring використовує для збору bean-компонентів
під час виконання, але вона не використовується на рівні класу.
Натомість @Bean анотуються методи, щоб Spring міг зберегти результат
методу у вигляді Spring bean-компоненту.

@Autowired
Autowiring (Автозв'язування/автопідключення) - автоматичне впровадження
залежностей у bean-компоненти без їх налаштування в клас конфігурації.
При автозв'язуванні Spring IoC контейнер динамічно виявляє та надає залежні
значення властивостям компонента без їхнього явного налаштування.
Spring @Autowired використовується для автоматичного використання
bean-компонента.

------------------------

JAVA ПРОЕКТ

Створюємо Maven-проект та додаємо відповідні залежності pom.xml.

Структуруємо відповідно пакети проекту та прописуємо їх контент.

------------------------

РЕСУРСИ

https://docs.spring.io/spring-framework/reference/core.html
https://docs.spring.io/spring-framework/reference/core/beans/introduction.html
https://docs.spring.io/spring-framework/reference/core/beans/basics.html
https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans
https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/AnnotationConfigApplicationContext.html
https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Bean.html
https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Configuration.html
https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Autowired.html
https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/ComponentScan.html
https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Component.html
https://docs.spring.io/spring-framework/reference/core/beans/annotation-config.html
https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring
https://www.baeldung.com/spring-application-context
https://www.baeldung.com/spring-component-scanning
https://www.baeldung.com/spring-component-annotation
https://www.baeldung.com/spring-autowire

